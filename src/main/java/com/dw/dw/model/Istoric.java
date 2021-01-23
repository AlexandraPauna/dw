package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity(name = "Istoric")
public class Istoric {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "istoric_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "elev_id", nullable = false)
    private Elev elev;

    @Column(name = "nivel")
    @NotEmpty(message = "*Introduceti nivelul!")
    private Integer nivel;

    @Column(name = "medie")
    @Min(value = 1, message = "Trebuie sa fie mai mare de 0!")
    @Max(value = 10, message = "Trebuie sa fie maxim 10!")
    @NotNull(message = "*Introduceti valoarea mediei!")
    private Integer medie;

    @Column(name = "an")
    @NotNull(message = "*Introduceti anul!")
    private Integer an;
}
