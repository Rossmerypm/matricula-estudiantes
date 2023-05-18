package com.mitocode.repo;

import com.mitocode.dto.IProcedureDTO;
import com.mitocode.dto.ProcedureDTO;
import com.mitocode.model.Inscription;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IInscriptionRepo extends IGenericRepo<Inscription, Integer>{
    @Query(value = "select * from fn_inscriptions()", nativeQuery = true)
    List<Object[]> callProcedure();
    @Query(value = "select * from fn_inscriptions()", nativeQuery = true)
    List<IProcedureDTO> callProcedure2();
}
