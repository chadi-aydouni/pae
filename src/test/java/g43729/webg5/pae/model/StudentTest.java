package g43729.webg5.pae.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentTest {
    
    @Autowired
    private BeanValidationUtil<Student> validator;

    // Test de l'identifiant

    @Test
    public void idIsValid(){
        Student student = new Student(0, "Chadi", Gender.MALE, Section.GESTION, null);
        validator.assertIsValid(student);
    }


    // De toute façon géré par le générateur de valeur.
    @Test
    public void idIsNegative(){
        Student student = new Student(-1, "Chadi", Gender.MALE, Section.GESTION, null);
        validator.assertIsValid(student);
    }

    // Test du nom

    @Test
    public void nameIsValid(){
        Student student = new Student(0, "Chadi", Gender.MALE, Section.GESTION, null);
        validator.assertIsValid(student);
    }

    @Test
    public void nameIsEmpty(){
        Student student = new Student(0, "", Gender.MALE, Section.GESTION, null);
        validator.assertHasError(student, "name", NotBlank.class);
    }

    @Test
    public void nameIsNull(){
        Student student = new Student(0, null, Gender.MALE, Section.GESTION, null);
        validator.assertHasError(student, "name", NotBlank.class);
    }

    // Test du genre

    @Test
    public void genderIsValid(){
        Student student = new Student(0, "Chadi", Gender.MALE, Section.GESTION, null);
        validator.assertIsValid(student);
    }

    @Test
    public void genderIsNull(){
        Student student = new Student(0, "Chadi", null, Section.GESTION, null);
        validator.assertHasError(student, "gender", NotNull.class);
    }

    // Test de la section

    @Test
    public void sectionIsValid(){
        Student student = new Student(0, "Chadi", Gender.MALE, Section.GESTION, null);
        validator.assertIsValid(student);
    }

    @Test
    public void sectionIsNull(){
        Student student = new Student(0, "Chadi", Gender.MALE, null, null);
        validator.assertHasError(student, "section", NotNull.class);
    }

}
