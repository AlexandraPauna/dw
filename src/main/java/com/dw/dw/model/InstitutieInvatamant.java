package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "INSTITUTIE_INVATAMANT")
public class InstitutieInvatamant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "institutie_id")
    private int id;

    @Column(name = "nume")
    @NotEmpty(message = "*Introduceti denumirea institutiei!")
    private String nume;

    @ManyToOne
    @JoinColumn(name = "tipinstitutie_id")
    private TipInstitutie tipInstitutie;

    @OneToOne
    @JoinColumn(name = "adresa_id")
    private Adresa adresa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institutie")
    private Set<Clasa> clase = new HashSet<Clasa>();

//    @ManyToMany(mappedBy = "institutii", cascade = CascadeType.ALL)
//    private Set<Profesor> profesori = new HashSet<Profesor>();
}
