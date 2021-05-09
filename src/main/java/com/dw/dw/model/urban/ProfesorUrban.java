package com.dw.dw.model.urban;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Profesor_Urban")
public class ProfesorUrban {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private int id;

    @Column(name = "nume")
    @NotEmpty(message = "*Introduceti numele profesorului!")
    private String nume;

    @Column(name = "prenume")
    @NotEmpty(message = "*Introduceti prenumele profesorului!")
    private String prenume;

    @Column(name = "grad_didactic")
    private Integer gradDidactic;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Profesor_Specializare", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "specializare_id"))
    private Set<SpecializareDidactica> specializari = new HashSet<SpecializareDidactica>();


    @OneToMany(mappedBy = "profesor", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClasaCursProfesorUrban> clasaCursProfesorSet = new HashSet<ClasaCursProfesorUrban>();
}
