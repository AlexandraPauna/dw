package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity(name = "ADRESA")
public class Adresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "adresa_id")
    private int id;

    @Column(name = "strada")
    @NotEmpty(message = "*Introduceti strada!")
    private String strada;

    @Column(name = "numar")
    @NotEmpty(message = "*Introduceti strada!")
    private int numar;

    @Column(name = "cod_postal")
    private String codPostal;

    @ManyToOne
    @JoinColumn(name = "localitate_id", nullable=false)
    private Localitate localitate;
}
