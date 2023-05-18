package com.mitocode.controller;

import com.mitocode.dto.StudentDTO;
import com.mitocode.model.Student;
import com.mitocode.service.IStudentService;
import jakarta.validation.Valid;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;
    @Qualifier("studentMapper")
    private final ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> list = service.readAll().stream()
                .map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id )throws Exception{
        StudentDTO dto = this.convertToDto(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto)throws Exception{
        Student obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id,@Valid @RequestBody StudentDTO dto)throws Exception{
        dto.setIdStudent(id);
        Student obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id )throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    ///////////queries////////////
    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<StudentDTO>> findByName(@PathVariable("name") String name){
        List<StudentDTO> lst = service.findByName(name).stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
    @GetMapping("/get/name/surname")
    public ResponseEntity<List<StudentDTO>> getByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) throws Exception{
        List<StudentDTO> lst = service.getByNameAndSurname(name, surname).stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
    @GetMapping("/get/name/surname3")
    public ResponseEntity<List<StudentDTO>> getByNameAndSurname() throws Exception{
        List<StudentDTO> lst = service.getByNameAndSurname3().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
    ////paginacion/////
    @GetMapping("/pagination")
    public ResponseEntity<Page<Student>> findPage(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
            ){
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Student> pageResponse = service.findPage(pageRequest);

        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @GetMapping("/pagination2")
    public ResponseEntity<Page<Student>> findPage(Pageable pageable){
        Page<Student> pageResponse = service.findPage(pageable);

        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }
    ///order desc de age
    @GetMapping("/order")
    public ResponseEntity<List<StudentDTO>> findAllOrder(
            @RequestParam(name = "param", defaultValue = "DESC") String param
    ){
        List<StudentDTO> lst = service.finAllOrder(param).stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }


    /////////////////
    private StudentDTO convertToDto(Student obj){
        return mapper.map(obj, StudentDTO.class);
    }
    private Student convertToEntity(StudentDTO dto){
        return mapper.map(dto, Student.class);
    }
}
