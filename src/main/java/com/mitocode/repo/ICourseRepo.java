package com.mitocode.repo;

import com.mitocode.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepo extends IGenericRepo<Course, Integer> {
}
