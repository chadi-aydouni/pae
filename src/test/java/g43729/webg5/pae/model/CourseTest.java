package g43729.webg5.pae.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseTest {
    
    @Autowired
    private BeanValidationUtil<Course> validator;


    // Test de l'identifiant

    @Test
    public void idIsValid(){
        Course course = new Course("INT1", "Introduction 1", 10, null);
        validator.assertIsValid(course);
    }

    @Test
    public void idIsEmpty(){
        Course course = new Course("", "Introduction 1", 10, null);
        validator.assertHasError(course, "id", NotBlank.class);
    }

    @Test
    public void idIsNull(){
        Course course = new Course(null, "Introduction 1", 10, null);
        validator.assertHasError(course, "id", NotBlank.class);
    }

    // Test du titre

    @Test
    public void titleIsValid(){
        Course course = new Course("INT1", "Introduction 1", 10, null);
        validator.assertIsValid(course);
    }

    @Test
    public void titleIsEmpty(){
        Course course = new Course("INT1", "", 10, null);
        validator.assertHasError(course, "title", NotBlank.class);
    }

    @Test
    public void titleIsNull(){
        Course course = new Course("INT1", null, 10, null);
        validator.assertHasError(course, "title", NotBlank.class);
    }

    // Tests du nombre de crédits

    @Test
    public void creditsIsValid(){
        Course course = new Course("INT1", "Introduction 1", 5, null);
        validator.assertIsValid(course);
    }

    @Test
    public void creditsIsNegative(){
        Course course = new Course("INT1", "Introduction 1", -5, null);
        validator.assertHasError(course, "credits", Positive.class);
    }

    @Test
    public void creditsIsZero(){
        Course course = new Course("INT1", "Introduction 1", 0, null);
        validator.assertHasError(course, "credits", Positive.class);
    }

}
