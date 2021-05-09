package com.dw.dw.model.rural;

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
@Table(name = "INSTITUTIE_INVATAMANT_Rural")
public class InstitutieInvatamantRural {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private AdresaRural adresa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institutie")
    private Set<ClasaRural> clase = new HashSet<ClasaRural>();

}
