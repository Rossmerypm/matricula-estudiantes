package com.mitocode.service.impl;

import com.mitocode.model.Inscription;
import com.mitocode.model.Student;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IStudentRepo;
import com.mitocode.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student,Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> findByName(String name) {
        return repo.findByNameLike("%" + name + "%");
    }

    @Override
    public List<Student> getByNameAndSurname(String name, String surname) {
        return repo.getNameAndSurname2(name, surname);
    }

    @Override
    public List<Student> getByNameAndSurname3() {
        return repo.getByNameAndSurname3();
    }
////paginacion
    @Override
    public Page<Student> findPage(Pageable pageable) {
        return repo.findAll(pageable);
    }
///order
    @Override
    public List<Student> finAllOrder(String param) {
        Sort.Direction direction = param.equalsIgnoreCase("DESC") ? Sort.Direction.DESC : Sort.Direction.ASC;
        return repo.findAll(Sort.by(direction, "age"));
    }

    /* @Override
    public Student save(Student student) throws Exception {
        return repo.save(student);
    }

    @Override
    public Student update(Student student) throws Exception {
        return repo.save(student);
    }

    @Override
    public List<Student> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Student readById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Student());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }*/
}
