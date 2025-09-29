package g43729.webg5.pae.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g43729.webg5.pae.model.Student;
import g43729.webg5.pae.model.DB.StudentDB;

@Service
public class StudentService {
    
    @Autowired
    private StudentDB studentDB;

    /**
     * Renvoie l'ensemble des étudiants de la BDD.
     * @return l'ensemble des étudiants de la BDD.
     */
    public Iterable<Student> allStudents(){
        return studentDB.findAll();
    }
    
    /**
     * Renvoie l'étudiant à l'id donné.
     * @param id l'identifiant de l'étudiant.
     * @return L'étudiant relatif à l'identifiant donné, null sinon.
     */
    public Student getStudent(int id){
        Optional<Student> student = studentDB.findById(id);

        if(!student.isEmpty()){
            return student.get();
        }
        return null;
    }

    /**
     * Renvoie la liste d'étudiants dont le nom contient la chaîne donnée en paramètre.
     * @param str la chaîne de caractère recherchée.
     * @return Les étudiants dont la chaîne figure dans leur nom, null sinon.
     */
    public Iterable<Student> getStudentByName(String str){  
        return studentDB.findByNameContaining(str);
    }

    /**
     * Sauvegarde l'étudiant donné.
     * @param student un étudiant
     */
    public void saveStudent(Student student){
        studentDB.save(student);
    }
}
