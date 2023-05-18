package com.mitocode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mitocode.model.Student;
import com.mitocode.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InscriptionDTO {

    private Integer idInscription;
    @NotNull
    private StudentDTO student;
    @NotNull
    private CourseDTO course;
    @NotNull
    private LocalDateTime dateInscription;
    @NotNull
    private boolean enabled;
    @NotNull
    @JsonManagedReference
    private List<DetailInscriptionDTO> details;
}
