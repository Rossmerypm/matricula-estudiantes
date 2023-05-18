package com.mitocode.config;

import com.mitocode.dto.CourseDTO;
import com.mitocode.dto.StudentDTO;
import com.mitocode.dto.UserDTO;
import com.mitocode.model.Course;
import com.mitocode.model.Student;
import com.mitocode.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean("studentMapper")
    public ModelMapper studentMapper(){
        ModelMapper mapper=new ModelMapper();
        TypeMap<StudentDTO, Student> typeMap1 = mapper.createTypeMap(StudentDTO.class, Student.class);
        TypeMap<Student, StudentDTO> typeMap2 = mapper.createTypeMap(Student.class, StudentDTO.class);
        typeMap1.addMapping(StudentDTO::getNameStudent, (dest, v) -> dest.setName((String) v));
        typeMap2.addMapping(Student::getName, (dest, v) -> dest.setNameStudent((String) v));
        return mapper;
    }
    @Bean("courseMapper")
    public ModelMapper courseMapper(){
        ModelMapper mapper=new ModelMapper();
        TypeMap<CourseDTO, Course> typeMap1 = mapper.createTypeMap(CourseDTO.class, Course.class);
        TypeMap<Course, CourseDTO> typeMap2 = mapper.createTypeMap(Course.class, CourseDTO.class);
        typeMap1.addMapping(CourseDTO::getNameCourse, (dest, v) -> dest.setName((String) v));
        typeMap2.addMapping(Course::getName, (dest, v) -> dest.setNameCourse((String) v));
        return mapper;
    }

    @Bean("userMapper")
    public ModelMapper userMapper(){
        ModelMapper mapper=new ModelMapper();
        TypeMap<UserDTO, User> typeMap1 = mapper.createTypeMap(UserDTO.class, User.class);
        TypeMap<User, UserDTO> typeMap2 = mapper.createTypeMap(User.class, UserDTO.class);
        typeMap1.addMapping(UserDTO::getUsername, (dest, v) -> dest.setUsername((String) v));
        typeMap2.addMapping(User::getUsername, (dest, v) -> dest.setUsername((String) v));
        return mapper;
    }

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }
}

