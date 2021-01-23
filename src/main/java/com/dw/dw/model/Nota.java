package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@Entity(name = "Nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nota_id")
    private int id;

    @Column(name = "valoare")
    @NotEmpty(message = "*Introduceti valoarea notei!")
    @Min(value = 1, message = "Trebuie sa fie mai mare de 0!")
    @Max(value = 10, message = "Trebuie sa fie maxim 10!")
    private Integer valoare;

    @Column(name = "data")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotEmpty(message = "*Introduceti data la care a fost pusa nota!")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "elev_id", nullable = false)
    private Elev elev;

    @ManyToOne
    @JoinColumn(name = "curs_id", nullable = false)
    private Curs curs;
}
