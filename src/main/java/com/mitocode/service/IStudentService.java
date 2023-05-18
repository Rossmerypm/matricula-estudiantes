package com.mitocode.service;


import com.mitocode.model.Inscription;
import com.mitocode.model.Student;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer>{

      List<Student> findByName(String name);

      List<Student> getByNameAndSurname(String name, String surname);

     List<Student>getByNameAndSurname3();

     //paginacion
     Page<Student> findPage(Pageable pageable);
     //ORDER
     List<Student> finAllOrder(String param);
     //



}
