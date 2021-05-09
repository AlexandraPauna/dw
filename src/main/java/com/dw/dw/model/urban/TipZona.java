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
@Table(name = "TIP_ZONA_URBAN")
public class TipZona {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipzona_id")
    private int id;

    @Column(name = "denumire", unique=true)
    @NotEmpty(message = "*Introduceti denumirea!")
    private String nume;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipZona")
    private Set<LocalitateUrban> localitati = new HashSet<LocalitateUrban>();
}
