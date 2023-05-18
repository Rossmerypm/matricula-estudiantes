package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {
    @EqualsAndHashCode.Include
    private Integer idCourse;
    @NotNull
    @NotEmpty
    @Size(min = 3, max =50)
    //@JsonProperty(value = "name_course")
    private String nameCourse;
    @NotNull
    @NotEmpty
    @Size(min = 2,max =50)
    private String acronymCourse;
    @NotNull
    private boolean enabledCourse;
}
