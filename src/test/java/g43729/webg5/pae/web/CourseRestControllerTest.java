package g43729.webg5.pae.web;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import g43729.webg5.pae.business.CourseService;
import g43729.webg5.pae.model.Course;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseRestControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CourseService courseService;
    
    @Test
    public void getCourseById() throws Exception{
        String id = "INT1";
        Course course = new Course (id, "Introduction", 5, null);

        Mockito.when(courseService.getCourse(id)).thenReturn(course);
        mvc.perform(get("/api/courses/INT1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    public void getCourseByIdWhenDoesNotExist() throws Exception{
        String id = "INT2";

        Mockito.when(courseService.getCourse(id)).thenReturn(null);
        mvc.perform(get("/api/courses/INT2"))
            .andExpect(status().isNotFound());
    }

}
