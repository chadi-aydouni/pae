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
public class StudentControllerTest {
    
    @Autowired
    private MockMvc mockMVC;

    @Test
    public void showStudents() throws Exception {
        mockMVC.perform(get("/students"))
        .andExpect(status().isOk())
        .andExpect(view().name("students"));
    }

    @Test
    public void showStudentDetail() throws Exception {
        mockMVC.perform(get("/students/25/details"))
        .andExpect(status().isOk())
        .andExpect(view().name("students_detail"))
        .andExpect(content().string(Matchers.containsString("Pikachu")));
    }

}
