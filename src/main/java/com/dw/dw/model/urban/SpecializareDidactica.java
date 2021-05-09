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
@Entity(name = "Specializare_Didactica")
public class SpecializareDidactica {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specializare_id")
    private int id;

    @Column(name = "nume", unique=true)
    @NotEmpty(message = "*Introduceti denumirea specializarii!")
    private String nume;

    @ManyToMany(mappedBy = "specializari", cascade = CascadeType.ALL)
    private Set<ProfesorUrban> profesori = new HashSet<ProfesorUrban>();
}
