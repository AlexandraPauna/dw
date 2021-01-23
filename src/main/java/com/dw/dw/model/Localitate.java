package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "LOCALITATE")
public class Localitate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "localitate_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti numele!")
    private String nume;

    @ManyToOne
    @JoinColumn(name = "tipzona_id")
    private TipZona tipZona;

    @ManyToOne
    @JoinColumn(name = "judet_id")
    private Judet judet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localitate")
    private Set<Adresa> adrese = new HashSet<Adresa>();
}
