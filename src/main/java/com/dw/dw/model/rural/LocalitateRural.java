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
@Table(name = "LOCALITATE_Rural")
public class LocalitateRural {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "localitate_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti numele!")
    private String nume;

    @ManyToOne
    @JoinColumn(name = "tipzona_id")
    private TipZona tipZona;

    @ManyToOne
    @JoinColumn(name = "judet_id")
    private Judet judet;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localitate")
    private Set<AdresaRural> adrese = new HashSet<AdresaRural>();
}

