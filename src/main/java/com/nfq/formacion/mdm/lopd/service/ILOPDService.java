package com.nfq.formacion.mdm.lopd.service;

import com.nfq.formacion.mdm.lopd.domain.LOPD;

public interface ILOPDService {
    LOPD altaLOPD(LOPD rol);

    LOPD verLOPD(int rowidObject);
}

