package com.dw.dw.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "INSTITUTIE_INVATAMANT")
public class InstitutieInvatamant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "institutie_id")
    private int id;

    @Column(name = "nume")
    @NotEmpty(message = "*Introduceti denumirea institutiei!")
    private String nume;

    @ManyToOne
    @JoinColumn(name = "tipinstitutie_id")
    private TipInstitutie tipInstitutie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresa_id")
    private Adresa adresa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institutie")
    private Set<Clasa> clase = new HashSet<Clasa>();

//    @ManyToMany(mappedBy = "institutii", cascade = CascadeType.ALL)
//    private Set<Profesor> profesori = new HashSet<Profesor>();
}
