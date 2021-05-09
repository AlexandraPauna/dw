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
@Table(name = "CURS")
public class Curs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curs_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti numele cursului!")
    private String nume;

    @OneToMany(mappedBy = "curs", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClasaCursProfesor> clasaCursProfesorSet = new HashSet<ClasaCursProfesor>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curs")
    private Set<Nota> note = new HashSet<Nota>();
}
