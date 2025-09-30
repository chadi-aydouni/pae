package g43729.webg5.pae.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import g43729.webg5.pae.business.PAE;
import g43729.webg5.pae.model.Course;
import g43729.webg5.pae.model.Student;

@Controller
public class CourseController {

    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private PAE pae;

    // Page de tous les cours
    @GetMapping("/courses")
    public String courses(Model model) {
        model.addAttribute("courses", pae.allCourses());
        model.addAttribute("course", new Course());
        return "courses";
    }

    // Ajout d'un cours
    @PostMapping("/courses")
    public String add(Model model, @Valid Course course, Errors errors) {
        if (errors.hasErrors()) {
            log.error("Cours mal formaté : " + course);
            model.addAttribute("courses", pae.allCourses());
            return "courses";
        }

        pae.saveCourse(course);
        log.info("Cours correctement formaté : " + course);
        return "redirect:/courses";
    }

    // Affichage des détails d'un cours
    @GetMapping("/courses/{id}/details")
    public String coursesDetail(@PathVariable("id") String id, Model model) {
        model.addAttribute("course", pae.getCourse(id));
        return "courses_detail";
    }

    // Inscription d'un étudiant à un cours
    @PostMapping("/courses/register/{id}")
    public String registerCourse(@PathVariable("id") String course_id, int student_id, Model model) {
        Course course = pae.getCourse(course_id);
        Student student = pae.getStudent(student_id);

        // Etudiant inexistant
        if (student == null) {
            log.error("Numéro d'étudiant inexistant");
            return "redirect:/courses/" + course_id + "/details";
        }

        // Etudiant déjà inscrit
        if (course.getRegisteredStudents().contains(student)) {
            log.error("Etudiant déjà inscrit");
            return "redirect:/courses/" + course_id + "/details";
        }

        pae.register(course, student);
        log.info("Inscription réussie : étudiant " + student.getName() + " au cours " + course.getTitle());
        return "redirect:/courses/" + course_id + "/details";
    }

    // Affichage en VUEJS
    @GetMapping("/courses_vuejs")
    public String coursesVueJS(Model model) {
        model.addAttribute("courses", pae.allCourses());
        return "courses_vuejs";
    }
}
