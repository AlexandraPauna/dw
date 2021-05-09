package com.dw.dw.model.rural;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Clasa_Rural")
public class ClasaRural {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clasa_id")
    private int id;

    @Column(name = "nume")
    @NotEmpty(message = "*Introduceti numele clasei!")
    private String nume;

    @Column(name = "nivel")
    @NotNull(message = "*Introduceti nivelul clasei!")
    private Integer nivel;

    @Column(name = "an")
    @NotNull(message = "*Introduceti anul curent al clasei!")
    private Integer an;

    @ManyToOne
    @JoinColumn(name = "specializare_id", nullable=false)
    private Specializare specializare;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clasa")
    private Set<ElevRural> elevi = new HashSet<ElevRural>();

    @OneToMany(mappedBy = "clasa", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClasaCursProfesorRural> clasaCursProfesorSet = new HashSet<ClasaCursProfesorRural>();

    @ManyToOne
    @JoinColumn(name = "institutie_id", nullable=false)
    private InstitutieInvatamantRural institutie;
}
