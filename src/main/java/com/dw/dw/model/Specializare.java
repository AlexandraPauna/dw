package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Specializare")
public class Specializare {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "specializare_id")
    private int id;

    @Column(name = "denumire", unique=true)
    @NotEmpty(message = "*Introduceti denumirea specializarii!")
    private String denumire;

    @ManyToOne
    @JoinColumn(name = "profil_id", nullable=false)
    private Profil profil;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specializare")
    private Set<Clasa> clase = new HashSet<Clasa>();
}
