package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class DetailInscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer IdDetailInscription;
    @ManyToOne
    @JoinColumn(name="id_inscription", nullable=false,foreignKey= @ForeignKey(name="FK_DETAIL_INSCRIPTION"))
    private Inscription inscription;
    @ManyToOne
    @JoinColumn(name="id_course", nullable=false,foreignKey= @ForeignKey(name="FK_DETAIL_COURSE"))
    private Course course;
    @Column(nullable = false, length = 50)
    private String classRoom;


}
