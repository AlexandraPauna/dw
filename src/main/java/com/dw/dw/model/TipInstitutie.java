package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "tip_institutie_invatamant")
public class TipInstitutie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tipInstitutie_id")
    private int id;

    @Column(name = "denumire", unique=true)
    @NotEmpty(message = "*Introduceti denumirea!")
    private String denumire;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipInstitutie")
    private Set<InstitutieInvatamant> institutii = new HashSet<InstitutieInvatamant>();
}
