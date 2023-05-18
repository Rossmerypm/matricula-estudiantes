package com.mitocode.repo;

import com.mitocode.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepo extends IGenericRepo<Student, Integer> {
    List<Student> findByNameLike(String name);
    //List<Student> findByNameContains(String name);
    //List<Student> findByNameAndEnabled(String name, boolean enabled);
    //List<Student> findByNameOrEnabled(String name, boolean enabled);
    @Query("FROM Student s WHERE s.name = ?1 AND s.surname LIKE %?2%")
    List<Student> getNameAndSurname1(String name, String surname);

    @Query("FROM Student s WHERE s.name = :name AND s.surname LIKE %:surname%")
    List<Student> getNameAndSurname2(@Param ("name")String name,@Param("surname") String surname);

   @Query("SELECT new Student(s.idStudent, s.name, s.surname) FROM Student s")
    List<Student> getByNameAndSurname3();

}
