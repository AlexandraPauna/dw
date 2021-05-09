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
@Table(name = "Profil")
public class Profil {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profil_id")
    private int id;

    @Column(name = "denumire", unique=true)
    @NotEmpty(message = "*Introduceti denumirea profilului!")
    private String denumire;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profil")
    private Set<Specializare> specializari = new HashSet<Specializare>();
}
