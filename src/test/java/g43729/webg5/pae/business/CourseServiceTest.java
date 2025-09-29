package g43729.webg5.pae.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import g43729.webg5.pae.model.Course;
import g43729.webg5.pae.model.DB.CourseDB;

@SpringBootTest
public class CourseServiceTest {
    
    @Autowired 
    CourseService courseService;

    @MockBean
    CourseDB courseDB;

    // getCourse(String id)

    @Test
    public void getCourse(){
        String id = "INT1";
        Course course = new Course (id, "Introduction", 5, null);
        Optional<Course> courseOptional = Optional.of(course);

        Mockito.when(courseDB.findById(id)).thenReturn(courseOptional);

        Course found = courseService.getCourse(id);
        assertEquals(found.getId(), id);
    }

    @Test
    public void getCourseWhenDoesNotExist(){
        String id = "XXX";
        Optional<Course> courseOptional = Optional.empty();

        Mockito.when(courseDB.findById(id)).thenReturn(courseOptional);

        Course found = courseService.getCourse(id);
        assertNull(found);
    }

}
