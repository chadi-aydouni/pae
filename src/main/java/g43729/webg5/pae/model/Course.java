package g43729.webg5.pae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Représente un cours pouvant être sélectionné dans le PAE.
 * On y retrouve un identifiant, un nom et un nombre de crédits associé.
 */
@Entity
public class Course {

    // Identifiant du cours
    @NotBlank(message = "Le sigle ne peut être vide.")
    @Id
    private String id;

    // Libellé du cours
    @NotBlank(message = "Le titre ne peut être vide.")
    private String title;

    // Nombre de crédits du cours
    @Positive(message = "Le nombre de crédits doit être supérieur à 0.")
    private int credits;

    // Liste des étudiants inscrits à ce cours.
    @ManyToMany
    @JsonManagedReference // Permet de ne pas retraduire et réafficher quelque chose de déjà traduit
    private List<Student> registeredStudents = new ArrayList<>();

    // ==================== Constructeurs ====================

    /** Constructeur vide nécessaire pour JPA */
    public Course() {
    }

    /** Constructeur avec les informations principales */
    public Course(String id, String title, int credits) {
        this.id = id;
        this.title = title;
        this.credits = credits;
    }

    /** Constructeur complet avec la liste des étudiants */
    public Course(String id, String title, int credits, List<Student> registeredStudents) {
        this(id, title, credits);
        this.registeredStudents = registeredStudents != null ? registeredStudents : new ArrayList<>();
    }

    // ==================== Getters / Setters ====================

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(List<Student> registeredStudents) {
        this.registeredStudents = registeredStudents != null ? registeredStudents : new ArrayList<>();
    }

    // ==================== toString ====================

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                '}';
    }
}
