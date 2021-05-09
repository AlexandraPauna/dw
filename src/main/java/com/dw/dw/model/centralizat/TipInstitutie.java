package com.dw.dw.model.centralizat;

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
@Table(name = "tip_institutie_invatamant")
public class TipInstitutie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_institutie_id")
    private int id;

    @Column(name = "denumire", unique=true)
    @NotEmpty(message = "*Introduceti denumirea!")
    private String denumire;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipInstitutie")
    private Set<InstitutieInvatamant> institutii = new HashSet<InstitutieInvatamant>();

}
