package com.nfq.formacion.mdm.cliente.service;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
import com.nfq.formacion.mdm.cliente.infraestructure.controller.dto.input.ClienteInputDTO;
import com.nfq.formacion.mdm.cliente.infraestructure.controller.dto.output.ClienteOutputDTO;
import com.nfq.formacion.mdm.cliente.infraestructure.controller.mapper.IClienteMapper;
import com.nfq.formacion.mdm.cliente.infraestructure.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements IClienteService {
    private final IClienteRepository repository;

    @Autowired
    public ClienteServiceImpl(IClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Cliente altaCliente(Cliente cliente) {
        return repository.save(cliente);
    }
}
