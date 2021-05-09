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
@Table(name = "CURS")
public class Curs {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curs_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti numele cursului!")
    private String nume;

    @OneToMany(mappedBy = "curs", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClasaCursProfesorUrban> clasaCursProfesorSet = new HashSet<ClasaCursProfesorUrban>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curs")
    private Set<NotaUrban> note = new HashSet<NotaUrban>();
}
