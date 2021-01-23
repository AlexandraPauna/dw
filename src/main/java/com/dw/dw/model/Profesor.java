package com.dw.dw.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "profesor_id")
    private int id;

    @Column(name = "nume")
    @NotEmpty(message = "*Introduceti numele profesorului!")
    private String nume;

    @Column(name = "prenume")
    @NotEmpty(message = "*Introduceti prenumele profesorului!")
    private String prenume;

    @Column(name = "data_nasterii")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNasterii;

    @Column(name = "grad_didactic")
    private Integer gradDidactic;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "Profesor_Specializare", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "specializare_id"))
    private Set<SpecializareDidactica> specializari = new HashSet<SpecializareDidactica>();

//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinTable(name = "Institutie_Profesor", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "institutie_id"))
//    private Set<InstitutieInvatamant> institutii = new HashSet<InstitutieInvatamant>();

    @OneToMany(mappedBy = "profesor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ClasaCursProfesor> clasaCursProfesorSet = new HashSet<ClasaCursProfesor>();
}
