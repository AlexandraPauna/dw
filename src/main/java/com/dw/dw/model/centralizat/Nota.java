package com.dw.dw.model.centralizat;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nota_id")
    private int id;

    @Column(name = "valoare")
    @NotNull(message = "*Introduceti valoarea notei!")
    @Min(value = 1, message = "Trebuie sa fie mai mare de 0!")
    @Max(value = 10, message = "Trebuie sa fie maxim 10!")
    private Integer valoare;

    @Column(name = "data")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "*Introduceti data la care a fost pusa nota!")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "elev_id", nullable = false)
    private Elev elev;

    @ManyToOne
    @JoinColumn(name = "curs_id", nullable = false)
    private Curs curs;
}
