package nfq.formacion.mdm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MdmConfig {
    @Value("${mdm.protocol}")
    private String protocol;
    @Value("${mdm.orsId}")
    private String orsId;
    @Value("${mdm.url}")
    private String url;
    @Value("${mdm.username}")
    private String username;
    @Value("${mdm.password}")
    private String password;

    @Bean
    public SoapSiperianClient getSiperianClient() { //FIXME comprobar si es necesario
        Properties properties = new Properties();
        properties.setProperty(SiperianClient.SIPERIANCLIENT_PROTOCOL, protocol);
        properties.setProperty(SiperianClient.PROPERTY_ORS_ID, orsId);
        properties.setProperty("soap.call.url", url);
        properties.setProperty(SiperianClient.PROPERTY_USERNAME, username);
        properties.setProperty(SiperianClient.PROPERTY_PASSWORD, password);

        return new SoapSiperianClient(properties);

    }
}
