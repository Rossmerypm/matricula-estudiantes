package com.mitocode.controller;

import com.mitocode.dto.IProcedureDTO;
import com.mitocode.dto.InscriptionDTO;
import com.mitocode.dto.ProcedureDTO;
import com.mitocode.model.Inscription;
import com.mitocode.service.IInscriptionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inscriptions")
@RequiredArgsConstructor
public class InscriptionController {

    private final IInscriptionService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<InscriptionDTO>> readAll() throws Exception{
        List<InscriptionDTO> list = service.readAll().stream()
                .map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<InscriptionDTO> readById(@PathVariable("id") Integer id )throws Exception{
        InscriptionDTO dto = this.convertToDto(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<InscriptionDTO> create(@Valid @RequestBody InscriptionDTO dto)throws Exception{
        Inscription obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<InscriptionDTO> update(@PathVariable("id") Integer id,@Valid @RequestBody InscriptionDTO dto)throws Exception{
        dto.setIdInscription(id);
        Inscription obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id )throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    ////////procedures/////////
    @GetMapping("/resumen")
    public ResponseEntity<List<ProcedureDTO>> getInscriptionResumen(){
        return new ResponseEntity<>(service.callProcedure(), HttpStatus.OK);
    }

    @GetMapping("/resumen2")
    public ResponseEntity<List<IProcedureDTO>> getInscriptionResumen2(){
        return new ResponseEntity<>(service.callProcedure2(), HttpStatus.OK);
    }

    /////////////////
    private InscriptionDTO convertToDto(Inscription obj){
        return mapper.map(obj, InscriptionDTO.class);
    }
    private Inscription convertToEntity(InscriptionDTO dto){
        return mapper.map(dto, Inscription.class);
    }
}
