package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Elev")
public class Elev {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "elev_id")
    private int id;

    @Column(name = "nume")
    @NotEmpty(message = "*Introduceti numele elevului!")
    private String nume;

    @Column(name = "prenume")
    @NotEmpty(message = "*Introduceti prenumele elevului!")
    private String prenume;

    @Column(name = "data_nasterii")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNasterii;

    @Column(name = "gen")
    private String gen;

    @ManyToOne
    @JoinColumn(name = "clasa_id", nullable = false)
    private Clasa clasa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elev")
    private Set<Nota> note = new HashSet<Nota>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "elev")
    private Set<Istoric> istoric = new HashSet<Istoric>();
}
