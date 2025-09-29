package g43729.webg5.pae.model.DB;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import g43729.webg5.pae.model.Course;
import g43729.webg5.pae.model.Gender;
import g43729.webg5.pae.model.Section;
import g43729.webg5.pae.model.Student;

@DataJpaTest
@ActiveProfiles("test")
public class StudentDBTest {

    @Autowired
    private StudentDB studentDB;

    @Autowired
    private CourseDB courseDB;

    // Nom des étudiants

    @Test
    public void findStudentsNames(){
        Student student1 = new Student(0, "Chadi", Gender.MALE, Section.GESTION, null);
        Student student2 = new Student(0, "Laurent", Gender.MALE, Section.GESTION, null);
        Student student3 = new Student(0, "Nicolas", Gender.MALE, Section.GESTION, null);

        studentDB.save(student1);
        studentDB.save(student2);
        studentDB.save(student3);

        List<String> input = new ArrayList<String>();

        input.add(student1.getName());
        input.add(student2.getName());
        input.add(student3.getName());

        List<String> found = studentDB.findStudentsNames();
        assertEquals(input, found);
    }

    // Id et nom des étudiants

    @Test
    public void findIdAndStudentsNames(){
        Student student1 = new Student(0, "Chadi", Gender.MALE, Section.GESTION, null);
        Student student2 = new Student(0, "Laurent", Gender.MALE, Section.GESTION, null);
        Student student3 = new Student(0, "Nicolas", Gender.MALE, Section.GESTION, null);

        studentDB.save(student1);
        studentDB.save(student2);
        studentDB.save(student3);

        List<Object[]> input = new ArrayList<Object[]>();

        Object[] std1 = {student1.getId(), student1.getName()};
        Object[] std2 = {student2.getId(), student2.getName()};
        Object[] std3 = {student3.getId(), student3.getName()};

        input.add(std1);
        input.add(std2);
        input.add(std3);

        List<Object[]>  found = studentDB.findIdAndStudentsNames();

        boolean sameContent = Arrays.deepEquals(input.toArray(), found.toArray());
        assertTrue(sameContent);
    }

    // Nom des étudiants et nombre total de crédits du programme

    @Test
    public void findStudentsNamesAndTotalCredits(){
        Student student1 = new Student(0, "Chadi", Gender.MALE, Section.GESTION, new ArrayList<Course>());
        Student student2 = new Student(0, "Laurent", Gender.MALE, Section.GESTION, new ArrayList<Course>());

        studentDB.save(student1);
        studentDB.save(student2);

        Course course1 = new Course("A", "A", 10, new ArrayList<Student>());
        Course course2 = new Course("B", "A", 20, new ArrayList<Student>());
        Course course3 = new Course("C", "A", 5, new ArrayList<Student>());

        courseDB.save(course1);
        courseDB.save(course2);
        courseDB.save(course3);

        course1.getRegistered_students().add(student1);
        student1.getRegistered_courses().add(course1);
        courseDB.save(course1);

        course2.getRegistered_students().add(student2);
        student2.getRegistered_courses().add(course2);
        courseDB.save(course2);

        course3.getRegistered_students().add(student1);
        student1.getRegistered_courses().add(course3);
        courseDB.save(course3);

        List<Object[]> input = new ArrayList<Object[]>();

        Object[] std1 = {student1.getName(), (long) 15};
        Object[] std2 = {student2.getName(), (long) 20};

        input.add(std1);
        input.add(std2);

        List<Object[]>  found = studentDB.findStudentsNamesAndTotalCredits();

        boolean sameContent = Arrays.deepEquals(input.toArray(), found.toArray());
        assertTrue(sameContent);
    }

    // Etudiants qui ont + de crédits dans leur programme qu'une valeur en paramètre

    @Test
    public void findStudentsTotalCreditsGreaterThan(){
        Student student1 = new Student(0, "Chadi", Gender.MALE, Section.GESTION, new ArrayList<Course>());
        Student student2 = new Student(0, "Laurent", Gender.MALE, Section.GESTION, new ArrayList<Course>());

        studentDB.save(student1);
        studentDB.save(student2);

        Course course1 = new Course("A", "A", 10, new ArrayList<Student>());
        Course course2 = new Course("B", "A", 20, new ArrayList<Student>());
        Course course3 = new Course("C", "A", 5, new ArrayList<Student>());

        courseDB.save(course1);
        courseDB.save(course2);
        courseDB.save(course3);

        course1.getRegistered_students().add(student1);
        student1.getRegistered_courses().add(course1);
        courseDB.save(course1);

        course2.getRegistered_students().add(student2);
        student2.getRegistered_courses().add(course2);
        courseDB.save(course2);

        course3.getRegistered_students().add(student1);
        student1.getRegistered_courses().add(course3);
        courseDB.save(course3);

        List<Student> input = new ArrayList<Student>();
        input.add(student2);

        List<Student> found = studentDB.findStudentsTotalCreditsGreaterThan((long) 18);

        boolean sameContent = Arrays.deepEquals(input.toArray(), found.toArray());
        assertTrue(sameContent);
    }

    // Etudiant dont la chaîne de caractère en paramètre apparait dans le nom

    @Test
    public void findByNameContaining(){
        Student student1 = new Student(0, "Chadi", Gender.MALE, Section.GESTION, new ArrayList<Course>());
        Student student2 = new Student(0, "Laurent", Gender.MALE, Section.GESTION, new ArrayList<Course>());
        Student student3 = new Student(0, "Laurine", Gender.FEMALE, Section.GESTION, new ArrayList<Course>());

        studentDB.save(student1);
        studentDB.save(student2);
        studentDB.save(student3);

        List<Student> input = new ArrayList<Student>();
        input.add(student2);
        input.add(student3);

        List<Student> found = studentDB.findByNameContaining("Lau");

        boolean sameContent = Arrays.deepEquals(input.toArray(), found.toArray());
        assertTrue(sameContent);
    }
    
}
