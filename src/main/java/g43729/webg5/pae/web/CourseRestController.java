package g43729.webg5.pae.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import g43729.webg5.pae.business.PAE;
import g43729.webg5.pae.model.Course;

@RestController
@RequestMapping(path="/api/courses")
public class CourseRestController {

    @Autowired
    PAE pae;

    // Renvoie l'ensemble de la liste des courses
    @GetMapping
    public Iterable<Course> courses(){
        return pae.allCourses();
    }
    
    // Renvoie les données relatives au cours à l'ID donné
    @GetMapping(path="{id}")
    public ResponseEntity<Course> course(@PathVariable("id") String id){
        Course course = pae.getCourse(id);

        if(course == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(course, HttpStatus.OK);
    }
}
