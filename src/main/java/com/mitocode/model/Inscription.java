package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idInscription;
    @Column(nullable = false)
    private LocalDateTime dateInscription;
    @ManyToOne
    @JoinColumn(name="id_student", nullable=false,foreignKey= @ForeignKey(name="FK_INSCRIPTION_STUDENT"))
    private Student student;
    @ManyToOne
    @JoinColumn(name="id_course", nullable=false,foreignKey= @ForeignKey(name="FK_INSCRIPTION_COURSE"))
    private Course course;

    @Column(nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "inscription",cascade = CascadeType.ALL)
    private List<DetailInscription> details;

}
