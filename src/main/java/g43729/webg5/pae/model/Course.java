package g43729.webg5.pae.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Représente un cours pouvant être sélectionné dans le PAE.
 * On y retrouve un identifiant, un nom et un nombre de crédits associé.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    // Identifiant du cours
    @NotBlank(message="Le sigle ne peut être vide.")
    @Id
    private String id;

    // Libellé du cours
    @NotBlank(message="Le titre ne peut être vide.")
    private String title;

    // Nombre de crédits du cours
    @Positive(message="Le nombre de crédits doit être supérieur à 0.")
    private int credits;

    // Liste des étudiants inscrits à ce cours.
    @ManyToMany
    @ToString.Exclude // Ne sera pas affiché
    @JsonManagedReference // Permet de ne pas retraduire et réafficher quelque chose de déjà traduit
    // @JsonIgnore /Jackson ignorera la traduction de ce paramètre
    private List<Student> registered_students;
}
