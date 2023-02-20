package com.nfq.formacion.mdm.clientesif;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nfq.formacion.mdm.clientesif.dto.BaseDTO;
import com.nfq.formacion.mdm.poliza.infraestructure.controller.dto.output.PolizaOutputDTO;
import com.nfq.formacion.mdm.utils.response.ResponseAPI;
import com.nfq.formacion.mdm.utils.response.ResponseConsulta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class MDMSaaSController {

    private final ObjectMapper mapper;

    public MDMSaaSController(ObjectMapper mapper) {
        this.mapper = mapper;
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @PostMapping("auth")
    public Mono<ResponseEntity<ResponseAPI>> authentication(@RequestBody Authentication authentication) {
        log.info(authentication.toString());
        WebClient webClient = WebClient.create("https://dmp-us.informaticacloud.com/saas/public/core/v3/login");
        Mono<String> response = webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(authentication)
                .retrieve().bodyToMono(String.class)
                .map(jsonString -> {
                    JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
                    return json.get("userInfo").getAsJsonObject().get("sessionId").getAsString();
                });
        return response.map(res -> new ResponseEntity<>(new ResponseAPI(res), HttpStatus.OK));
    }

    @PostMapping("consulta")
    public Mono<ResponseEntity<ResponseAPI>> getPerson(@RequestBody Consulta consulta) {
        log.info(consulta.toString());
        WebClient webClient = WebClient.create("https://usw1-mdm.dmp-us.informaticacloud.com/search/public/api/v1/search?_showContentMeta=false");
        return webClient.post()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(consulta)
                .header("IDS-SESSION-ID", "8Wp0U1mqGlOdxqKhjiP9Aw")
                .retrieve()
                .bodyToMono(String.class)
                .map(s -> {
                    List<PolizaOutputDTO> polizas = new ArrayList<>();
                    int totalRecords;
                    try {
                        JsonNode jsonNode = mapper.readTree(s);
                        JsonNode recordsNode = jsonNode.get("searchResult").get("records");
                        JsonNode totalRecordsNode = jsonNode.get("searchResult").get("hits");
                        totalRecords = mapper.readValue(totalRecordsNode.toString(), Integer.class);
                        for (JsonNode node : recordsNode) {
                            PolizaOutputDTO poliza = mapper.treeToValue(node, PolizaOutputDTO.class);
                            String rowidObject = node.get("_meta").get("id").asText();
                            poliza.setRowidObject(rowidObject);
                            polizas.add(poliza);
                        }
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e); //TODO change exception
                    }
                    ResponseConsulta responseConsulta =
                            new ResponseConsulta(totalRecords, (List<BaseDTO>) (List<?>) polizas);

                    if (polizas.isEmpty()) {
                        responseConsulta.setMensaje("No se encontraron registros.");
                        return new ResponseEntity<>(responseConsulta, HttpStatus.BAD_REQUEST);
                    }
                    return new ResponseEntity<>(responseConsulta, HttpStatus.OK);
                });
    }
}
