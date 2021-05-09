package com.dw.dw.model.rural;

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
@Entity(name = "Profesor_Rural")
public class ProfesorRural {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    private int id;

    @Column(name = "data_nasterii")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNasterii;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Profesor_Specializare", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "specializare_id"))
    private Set<SpecializareDidactica> specializari = new HashSet<SpecializareDidactica>();

    @OneToMany(mappedBy = "profesor", cascade = {CascadeType.ALL, CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClasaCursProfesorRural> clasaCursProfesorSet = new HashSet<ClasaCursProfesorRural>();

    @Column(name = "salariu")
    private Integer salariu;
}
