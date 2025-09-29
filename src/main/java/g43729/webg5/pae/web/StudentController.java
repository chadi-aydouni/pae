package g43729.webg5.pae.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import g43729.webg5.pae.business.PAE;
import g43729.webg5.pae.model.Course;
import g43729.webg5.pae.model.Gender;
import g43729.webg5.pae.model.Section;
import g43729.webg5.pae.model.Student;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StudentController {

    @Autowired
    private PAE pae;
    
    // Affichage de tous les étudiants
    @GetMapping("/students")
    public String students(@RequestParam(required=false) String name, Model model){
        Iterable<Student> students;

        // Permet d'effectuer la recherche d'étudiants
        if(name == null){
            students = pae.allStudents();
        } else{
            students = pae.getStudentByName(name);
        }

        model.addAttribute("students", students);
        model.addAttribute("student", new Student(0,"",Gender.MALE,Section.GESTION, null));
        model.addAttribute("name", name);
        return "students";
    }

    // Ajout d'un étudiant
    @PostMapping("/students")
    public String add(Model model, @Valid Student student, Errors errors){

        if(errors.hasErrors()){
            log.error("Etudiant mal formaté : "+student);
            model.addAttribute("students", pae.allStudents());
            return "students";
        }

        pae.saveStudent(student);
        log.info("Etudiant correctement formaté : " + student); 
        return "redirect:/students";
    }

    // Affichage des détails d'un étudiant
    @GetMapping("/students/{id}/details")
    public String studentDetail(@PathVariable("id") int id, Model model){
        model.addAttribute("student", pae.getStudent(id));
        return "students_detail";
    }

    // Inscription d'un étudiant à un cours
    @PostMapping("/students/register/{id}")
    public String registerStudent(@PathVariable("id") int student_id, String course_id, Model model){
        Student student = pae.getStudent(student_id);
        Course course = pae.getCourse(course_id);

        // Il faudrait trouver comment afficher un message d'erreur quand on n'a pas de @Valid.

        // Etudiant inexistant
        if(course==null){
            log.error("Nom de cours inexistant");
            return "redirect:/students/"+student_id+"/details"; 
        }

        // Etudiant déjà inscrit
        if(student.getRegistered_courses().contains(course)){
            log.error("Cours déjà inscrit");
            return "redirect:/students/"+student_id+"/details"; 
        }

        pae.register(course, student);
        return "redirect:/students/"+student_id+"/details";
    }
    
}

