package com.nfq.formacion.mdm.rol.service;

import com.nfq.formacion.mdm.rol.domain.Rol;

public interface IRolService {
    Rol altaRol(Rol rol);

    Rol verRol(int rowidObject);
}

