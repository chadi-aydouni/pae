package g43729.webg5.pae.model.DB;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import g43729.webg5.pae.model.Course;

@DataJpaTest
@ActiveProfiles("test")
public class CourseDBTest {
    
    @Autowired
    private CourseDB courseDB;

    // Recherche de crédits
    @Test
    public void findByCreditsGreaterThanEqualWhenFound(){

        Course course1 = new Course("A", "A", 11, null);
        Course course2 = new Course("B", "B", 15, null);
        courseDB.save(course1);
        courseDB.save(course2);

        List<Course> input = new ArrayList<Course>();

        input.add(course1);
        input.add(course2);

        List<Course> found = courseDB.findByCreditsGreaterThanEqual(10);
        assertEquals(input, found);
    }

    @Test
    public void findByCreditsGreaterThanEqualWhenEquals(){

        Course course1 = new Course("A", "A", 10, null);
        courseDB.save(course1);

        List<Course> input = new ArrayList<Course>();

        input.add(course1);

        List<Course> found = courseDB.findByCreditsGreaterThanEqual(10);
        assertEquals(input, found);
    }

    @Test
    public void findByCreditsGreaterThanEqualWhenNone(){

        Course course1 = new Course("A", "A", 9, null);
        Course course2 = new Course("B", "B", 8, null);
        courseDB.save(course1);
        courseDB.save(course2);

        List<Course> input = new ArrayList<Course>();

        List<Course> found = courseDB.findByCreditsGreaterThanEqual(10);
        assertEquals(input, found);
    }

    // Recherche de titre
    @Test
    public void findByTitleContainingWhenContains(){
        Course course1 = new Course("A", "Arithmétique", 9, null);
        Course course2 = new Course("B", "Ariel", 8, null);
        courseDB.save(course1);
        courseDB.save(course2);

        List<Course> input = new ArrayList<Course>();

        input.add(course1);
        input.add(course2);

        List<Course> found = courseDB.findByTitleContaining("Ari");
        assertEquals(input, found);
    }

    @Test
    public void findByTitleContainingWhenOnlyOneContains(){
        Course course1 = new Course("A", "Arithmétique", 9, null);
        Course course2 = new Course("B", "Bleuet", 8, null);
        courseDB.save(course1);
        courseDB.save(course2);

        List<Course> input = new ArrayList<Course>();

        input.add(course1);

        List<Course> found = courseDB.findByTitleContaining("Ari");
        assertEquals(input, found);
    }

    @Test
    public void findByTitleContainingWhenContainsNone(){
        Course course1 = new Course("A", "Mirage", 9, null);
        Course course2 = new Course("B", "Vitamine", 8, null);
        courseDB.save(course1);
        courseDB.save(course2);

        List<Course> input = new ArrayList<Course>();

        List<Course> found = courseDB.findByTitleContaining("Ari");
        assertEquals(input, found);
    }

}
