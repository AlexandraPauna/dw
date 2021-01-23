package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "REGIUNE")
public class Regiune {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "regiune_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti numele regiunii!")
    private String nume;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regiune")
    private Set<Subregiune> subregiuni = new HashSet<Subregiune>();
}
