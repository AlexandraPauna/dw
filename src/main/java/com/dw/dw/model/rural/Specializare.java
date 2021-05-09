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
@Table(name = "Specializare")
public class Specializare {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specializare_id")
    private int id;

    @Column(name = "denumire", unique=true)
    @NotEmpty(message = "*Introduceti denumirea specializarii!")
    private String denumire;

    @ManyToOne
    @JoinColumn(name = "profil_id", nullable=false)
    private Profil profil;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specializare")
    private Set<ClasaRural> clase = new HashSet<ClasaRural>();
}
