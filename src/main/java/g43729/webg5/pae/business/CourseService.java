package g43729.webg5.pae.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import g43729.webg5.pae.model.Course;
import g43729.webg5.pae.model.DB.CourseDB;

@Service
public class CourseService {

    @Autowired
    private CourseDB courseDB;

    /**
     * Renvoie l'ensemble des cours de la BDD.
     * @return l'ensemble des cours de la BDD.
     */
    public Iterable<Course> allCourses(){
        return courseDB.findAll();
    }
    
    /**
     * Renvoie le cours de l'ID donné.
     * @param id l'identifiant du cours.
     * @return Le cours relatif à l'identifiant donné, null sinon.
     */
    public Course getCourse(String id){
        Optional<Course> course = courseDB.findById(id);

        if(!course.isEmpty()){
            return course.get();
        }
        return null;
    }

    /**
     * Sauvegarde le cours donné.
     * @param course un cours.
     */
    public void saveCourse(Course course){
        courseDB.save(course);
    }
    
}
