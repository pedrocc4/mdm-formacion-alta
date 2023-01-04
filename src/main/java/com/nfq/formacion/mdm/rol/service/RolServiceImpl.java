package com.nfq.formacion.mdm.rol.service;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
import com.nfq.formacion.mdm.cliente.infraestructure.repository.IClienteRepository;
import com.nfq.formacion.mdm.rol.domain.Rol;
import com.nfq.formacion.mdm.rol.infraestructure.repository.IRolRepository;
import com.nfq.formacion.mdm.utils.exception.NoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RolServiceImpl implements IRolService {
    private final IRolRepository repository;
    private final IClienteRepository clienteRepository;

    @Autowired
    public RolServiceImpl(IRolRepository repository, IClienteRepository clienteRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Rol altaRol(Rol rol) {
        Cliente cliente = clienteRepository.findById(rol.getCliente().getRowidObject())
                .orElseThrow(() ->
                        new NoEncontrado("No existe el cliente con id: " + rol.getCliente().getRowidObject()));
        rol.setCliente(cliente);
        return repository.save(rol);
    }

    @Override
    public Rol verRol(int rowidObject) {
        return repository.findById(rowidObject).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe rol con id:" + rowidObject));
    }

}
