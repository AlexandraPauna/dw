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
@Table(name = "REGIUNE")
public class Regiune {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "regiune_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti numele regiunii!")
    private String nume;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regiune")
    private Set<Subregiune> subregiuni = new HashSet<Subregiune>();
}
