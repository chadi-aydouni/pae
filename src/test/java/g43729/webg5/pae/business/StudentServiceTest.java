package g43729.webg5.pae.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import g43729.webg5.pae.model.Gender;
import g43729.webg5.pae.model.Section;
import g43729.webg5.pae.model.Student;
import g43729.webg5.pae.model.DB.StudentDB;

@SpringBootTest
public class StudentServiceTest {
    
    @Autowired
    private StudentService studentService;

    @MockBean
    private StudentDB studentDB;

    // getStudent(int id)

    @Test
    public void getStudent(){
        int id = 0;
        Student student = new Student(id, "X", Gender.MALE, Section.GESTION, null);
        Optional<Student> studentOptional = Optional.of(student);

        Mockito.when(studentDB.findById(id)).thenReturn(studentOptional);

        Student found = studentService.getStudent(id);
        assertEquals(found.getId(), id);
    }

    @Test
    public void getStudentWhenDoesNotExist(){
        int id = 100;
        Optional<Student> studentOptional = Optional.empty();

        Mockito.when(studentDB.findById(id)).thenReturn(studentOptional);

        Student found = studentService.getStudent(id);
        assertNull(found);
    }
}
