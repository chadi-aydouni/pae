package g43729.webg5.pae.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g43729.webg5.pae.model.Course;
import g43729.webg5.pae.model.Student;

/**
 * Représente le service de programme annuel de l'étudiant.
 */
@Service
public class PAE {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    /**
     * Renvoie l'ensemble des cours de la BDD.
     * 
     * @return l'ensemble des cours de la BDD.
     */
    public Iterable<Course> allCourses() {
        return courseService.allCourses();
    }

    /**
     * Renvoie le cours de l'ID donné.
     * 
     * @param id l'identifiant du cours.
     * @return Le cours relatif à l'identifiant donné, null sinon.
     */
    public Course getCourse(String id) {
        return courseService.getCourse(id);
    }

    /**
     * Sauvegarde le cours donné.
     * 
     * @param course un cours.
     */
    public void saveCourse(Course course) {
        courseService.saveCourse(course);
    }

    /**
     * Renvoie l'ensemble des étudiants de la BDD.
     * 
     * @return l'ensemble des étudiants de la BDD.
     */
    public Iterable<Student> allStudents() {
        return studentService.allStudents();
    }

    /**
     * Renvoie l'étudiant à l'id donné.
     * 
     * @param id l'identifiant de l'étudiant.
     * @return L'étudiant relatif à l'identifiant donné, null sinon.
     */
    public Student getStudent(int id) {
        return studentService.getStudent(id);
    }

    /**
     * Renvoie la liste d'étudiants dont le nom contient la chaîne donnée en
     * paramètre.
     * 
     * @param str la chaîne de caractère recherchée.
     * @return Les étudiants dont la chaîne figure dans leur nom, null sinon.
     */
    public Iterable<Student> getStudentByName(String str) {
        return studentService.getStudentByName(str);
    }

    /**
     * Sauvegarde l'étudiant donné.
     * 
     * @param student un étudiant
     */
    public void saveStudent(Student student) {
        studentService.saveStudent(student);
    }

    /**
     * Inscrit l'étudiant au cours donné.
     * 
     * @param course  un cours.
     * @param student un étudiant.
     */
    public void register(Course course, Student student) {
        course.getRegisteredStudents().add(student);
        student.getRegisteredCourses().add(course);
        courseService.saveCourse(course);
    }
}
