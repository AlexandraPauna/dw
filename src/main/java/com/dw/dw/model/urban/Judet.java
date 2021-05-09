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
@Entity(name = "JUDET")
public class Judet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "judet_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti numele judetului!")
    private String nume;

    @ManyToOne
    @JoinColumn(name="subregiune_id")
    private Subregiune subregiune;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "judet")
    private Set<LocalitateUrban> localitati = new HashSet<LocalitateUrban>();
}
