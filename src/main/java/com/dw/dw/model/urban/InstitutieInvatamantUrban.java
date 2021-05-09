package com.dw.dw.model.urban;

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
@Table(name = "INSTITUTIE_INVATAMANT_URBAN")
public class InstitutieInvatamantUrban {
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
    private AdresaUrban adresa;

    //TO DO DE DECOMENTAT DUPA CE SE ADAUGA SI RESTUL TABELELOR REPLICATE!!!
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "institutie")
//    private Set<Clasa> clase = new HashSet<Clasa>();

}
