package g43729.webg5.pae.web;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CourseControllerTest {
    
    @Autowired
    private MockMvc mockMVC;

    @Test
    public void showCourses() throws Exception {
        mockMVC.perform(get("/courses"))
        .andExpect(status().isOk())
        .andExpect(view().name("courses"));
    }

    @Test
    public void showCourseDetail() throws Exception {
        mockMVC.perform(get("/courses/INT1/details"))
        .andExpect(status().isOk())
        .andExpect(view().name("courses_detail"))
        .andExpect(content().string(Matchers.containsString("INT1 - Introduction")));
    }

    @Test
    public void showVueJs() throws Exception {
        mockMVC.perform(get("/courses_vuejs"))
        .andExpect(status().isOk())
        .andExpect(view().name("courses_vuejs"));
    }

}
