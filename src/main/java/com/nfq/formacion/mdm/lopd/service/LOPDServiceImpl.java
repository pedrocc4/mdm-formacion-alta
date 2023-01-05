package com.nfq.formacion.mdm.lopd.service;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
import com.nfq.formacion.mdm.cliente.infraestructure.repository.IClienteRepository;
import com.nfq.formacion.mdm.lopd.domain.LOPD;
import com.nfq.formacion.mdm.lopd.infraestructure.repository.ILOPDRepository;
import com.nfq.formacion.mdm.utils.exception.NoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.nfq.formacion.mdm.utils.Constantes.NO_EXISTE_CLIENTE;

@Service
public class LOPDServiceImpl implements ILOPDService {
    private final ILOPDRepository repository;
    private final IClienteRepository clienteRepository;

    @Autowired
    public LOPDServiceImpl(ILOPDRepository repository, IClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public LOPD altaLOPD(LOPD lopd) {
        int idBusqueda = lopd.getCliente().getRowidObject();
        Cliente cliente = clienteRepository.findById(idBusqueda)
                .orElseThrow(() -> new NoEncontrado(NO_EXISTE_CLIENTE + idBusqueda));

        lopd.setCliente(cliente);
        return repository.save(lopd);
    }

    @Override
    public LOPD verLOPD(int rowidObject) {
        return repository.findById(rowidObject).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No existe indicador lopd con id:" + rowidObject));
    }

}
