package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "JUDET")
public class Judet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "judet_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti numele judetului!")
    private String nume;

    @ManyToOne
    @JoinColumn(name="subregiune_id")
    private Subregiune subregiune;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "judet")
    private Set<Localitate> localitati = new HashSet<Localitate>();
}
