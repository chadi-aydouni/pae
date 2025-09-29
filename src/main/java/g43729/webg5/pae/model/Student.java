package g43729.webg5.pae.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
    // Matricule de l'étudiant
    @Id 
    @GeneratedValue(generator = "student_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen", sequenceName = "student_sequence", allocationSize = 50)
    private int id;

    // Nom de l'étudiant
    @NotBlank(message="Le nom ne peut être vide.")
    private String name;

    // Sexe de l'étudiant
    @NotNull
    private Gender gender;

    // Section de l'étudiant
    @NotNull
    private Section section;

    // Cours auxquels est inscrit l'étudiant
    @ManyToMany(mappedBy = "registered_students")
    @ToString.Exclude // Ne sera pas affiché
    @JsonBackReference // Permet de ne pas retraduire et réafficher quelque chose de déjà traduit
    // @JsonIgnore - Jackson ignorera la traduction de ce paramètre
    private List<Course> registered_courses;
}
