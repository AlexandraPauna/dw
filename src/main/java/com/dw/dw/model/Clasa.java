package com.dw.dw.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Clasa")
public class Clasa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "clasa_id")
    private int id;

    @Column(name = "nume")
    @NotEmpty(message = "*Introduceti numele clasei!")
    private String nume;

    @Column(name = "nivel")
    @NotEmpty(message = "*Introduceti nivelul clasei!")
    private Integer nivel;

    @Column(name = "an")
    @NotEmpty(message = "*Introduceti anul curent al clasei!")
    private Integer an;

    @ManyToOne
    @JoinColumn(name = "specializare_id", nullable=false)
    private Specializare specializare;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clasa")
    private Set<Elev> elevi = new HashSet<Elev>();

    @OneToMany(mappedBy = "clasa", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClasaCursProfesor> clasaCursProfesorSet = new HashSet<ClasaCursProfesor>();

    @ManyToOne
    @JoinColumn(name = "institutie_id", nullable=false)
    private InstitutieInvatamant institutie;
}
