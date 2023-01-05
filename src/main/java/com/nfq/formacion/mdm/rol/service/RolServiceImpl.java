package com.nfq.formacion.mdm.rol.service;

import com.nfq.formacion.mdm.cliente.domain.Cliente;
import com.nfq.formacion.mdm.cliente.infraestructure.repository.IClienteRepository;
import com.nfq.formacion.mdm.poliza.domain.Poliza;
import com.nfq.formacion.mdm.poliza.infraestructure.repository.IPolizaRepository;
import com.nfq.formacion.mdm.rol.domain.Rol;
import com.nfq.formacion.mdm.rol.infraestructure.repository.IRolRepository;
import com.nfq.formacion.mdm.utils.exception.NoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.nfq.formacion.mdm.utils.Constantes.NO_EXISTE_CLIENTE;
import static com.nfq.formacion.mdm.utils.Constantes.NO_EXISTE_POLIZA;

@Service
public class RolServiceImpl implements IRolService {
    private final IRolRepository repository;
    private final IClienteRepository clienteRepository;

    private final IPolizaRepository polizaRepository;

    @Autowired
    public RolServiceImpl(IRolRepository repository, IClienteRepository clienteRepository,
                          IPolizaRepository polizaRepository) {
        this.repository = repository;
        this.clienteRepository = clienteRepository;
        this.polizaRepository = polizaRepository;
    }

    @Override
    public Rol altaRol(Rol rol) {
        int idBusqueda = rol.getCliente().getRowidObject();
        int idCliente = idBusqueda;
        Cliente cliente = clienteRepository.findById(idBusqueda)
                .orElseThrow(() -> new NoEncontrado(NO_EXISTE_CLIENTE + idCliente));

        idBusqueda = rol.getPoliza().getRowidObject();
        int idPoliza = idBusqueda;
        Poliza poliza = polizaRepository.findById(idBusqueda)
                .orElseThrow(() -> new NoEncontrado(NO_EXISTE_POLIZA + idPoliza));

        rol.setCliente(cliente);
        rol.setPoliza(poliza);
        return repository.save(rol);
    }

    @Override
    public Rol verRol(int rowidObject) {
        return repository.findById(rowidObject).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe rol con id:" + rowidObject));
    }

}
