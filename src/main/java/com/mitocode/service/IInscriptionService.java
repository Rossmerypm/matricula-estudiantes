package com.mitocode.service;

import com.mitocode.dto.IProcedureDTO;
import com.mitocode.dto.ProcedureDTO;
import com.mitocode.model.Inscription;

import java.util.List;

public interface IInscriptionService extends ICRUD<Inscription, Integer>{

    List<ProcedureDTO> callProcedure();
    List<IProcedureDTO> callProcedure2();
}
