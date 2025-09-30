package g43729.webg5.pae.model;

import java.util.ArrayList;
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

@Entity

public class Student {

    // Matricule de l'étudiant
    @Id
    @GeneratedValue(generator = "student_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen", sequenceName = "student_sequence", allocationSize = 50)
    private int id;

    // Nom de l'étudiant
    @NotBlank(message = "Le nom ne peut être vide.")
    private String name;

    // Sexe de l'étudiant
    @NotNull
    private Gender gender;

    // Section de l'étudiant
    @NotNull
    private Section section;

    // Cours auxquels est inscrit l'étudiant
    @ManyToMany(mappedBy = "registeredStudents")
    @JsonBackReference // Permet de ne pas retraduire et réafficher quelque chose de déjà traduit
    private List<Course> registeredCourses = new ArrayList<>();

    // ==================== Constructeurs ====================

    /** Constructeur vide nécessaire pour JPA */
    public Student() {
    }

    /** Constructeur avec les informations principales */
    public Student(int id, String name, Gender gender, Section section) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.section = section;
    }

    /** Constructeur complet avec les cours */
    public Student(int id, String name, Gender gender, Section section, List<Course> registeredCourses) {
        this(id, name, gender, section);
        this.registeredCourses = registeredCourses != null ? registeredCourses : new ArrayList<>();
    }

    // ==================== Getters / Setters ====================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Course> registeredCourses) {
        this.registeredCourses = registeredCourses != null ? registeredCourses : new ArrayList<>();
    }

    // ==================== toString ====================

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", section=" + section +
                '}';
    }
}
