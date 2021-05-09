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
@Table(name = "SUBREGIUNE")
public class Subregiune {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subregiune_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti numele subregiunii!")
    private String nume;

    @ManyToOne
    @JoinColumn(name="regiune_id")
    private Regiune regiune;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subregiune")
    private Set<Judet> judete = new HashSet<Judet>();
}
