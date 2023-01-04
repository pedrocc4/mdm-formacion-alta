package com.nfq.formacion.mdm.poliza.service;

import com.nfq.formacion.mdm.poliza.domain.Poliza;
import com.nfq.formacion.mdm.poliza.infraestructure.repository.IPolizaRepository;
import org.springframework.stereotype.Service;

@Service
public class PolizaServiceImpl implements IPolizaService {
    private final IPolizaRepository repository;

    public PolizaServiceImpl(IPolizaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Poliza altaPoliza(Poliza poliza) {
        return repository.save(poliza);
    }
}
