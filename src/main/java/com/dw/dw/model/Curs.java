package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "CURS")
public class Curs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "curs_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti numele cursului!")
    private String nume;

    @OneToMany(mappedBy = "curs", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClasaCursProfesor> clasaCursProfesorSet = new HashSet<ClasaCursProfesor>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curs")
    private Set<Nota> note = new HashSet<Nota>();
}
