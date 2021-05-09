package com.dw.dw.model.urban;

import com.dw.dw.model.centralizat.InstitutieInvatamant;
import com.dw.dw.model.centralizat.Localitate;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ADRESA_URBAN")
public class AdresaUrban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adresa_id")
    private int id;

    @Column(name = "strada")
    @NotEmpty(message = "*Introduceti strada!")
    private String strada;

    @Column(name = "numar")
    @NotNull(message = "*Introduceti numarul!")
    private int numar;

    @Column(name = "cod_postal")
    private String codPostal;

    @ManyToOne
    @JoinColumn(name = "localitate_id", nullable=false)
    private LocalitateUrban localitate;

    @OneToOne(mappedBy = "adresa")
    private InstitutieInvatamantUrban institutieInvatamant;
}

