package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Profil")
public class Profil {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "profil_id")
    private int id;

    @Column(name = "denumire", unique=true)
    @NotEmpty(message = "*Introduceti denumirea profilului!")
    private String denumire;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profil")
    private Set<Specializare> specializari = new HashSet<Specializare>();
}
