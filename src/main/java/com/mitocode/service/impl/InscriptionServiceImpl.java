package com.mitocode.service.impl;

import com.mitocode.dto.IProcedureDTO;
import com.mitocode.dto.ProcedureDTO;
import com.mitocode.model.Inscription;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IInscriptionRepo;
import com.mitocode.service.IInscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InscriptionServiceImpl extends CRUDImpl <Inscription, Integer> implements IInscriptionService {

    private final IInscriptionRepo repo;
    @Override
    protected IGenericRepo<Inscription, Integer> getRepo() {
        return repo;
    }

//////procedure//////
    @Override
    public List<ProcedureDTO> callProcedure() {
        List<ProcedureDTO> list = new ArrayList<>();
        repo.callProcedure().forEach(e -> {
            ProcedureDTO dto = new ProcedureDTO();
            dto.setQuantityfn((Integer) e [0]);
            dto.setDateInscriptionfn((String) e [1]);
            list.add(dto);
        });
        return list;
    }
    @Override
    public List<IProcedureDTO> callProcedure2() {
        return repo.callProcedure2();
    }
}
