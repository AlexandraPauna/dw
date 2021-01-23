package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Specializare_Didactica")
public class SpecializareDidactica {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "specializare_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti denumirea specializarii!")
    private String nume;

    @ManyToMany(mappedBy = "specializari", cascade = CascadeType.ALL)
    private Set<Profesor> profesori = new HashSet<Profesor>();
}
