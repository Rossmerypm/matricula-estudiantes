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
@Table(name="user_data")
public class User {
    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;
    @ManyToOne
    @JoinColumn(name="id_Student",nullable = false,foreignKey= @ForeignKey(name="FK_USER_STUDENT") )
    private Student student;
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Column(length =100, nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean enabled
            ;
}
