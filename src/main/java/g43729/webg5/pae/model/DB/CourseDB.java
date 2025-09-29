package g43729.webg5.pae.model.DB;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import g43729.webg5.pae.model.Course;

public interface CourseDB extends CrudRepository<Course, String> {

    // Trouver les cours avec un nombre de crédits >= au paramètre.
    List<Course> findByCreditsGreaterThanEqual(int credits);

    // Trouver les cours dont le libellé contient str.
    List<Course> findByTitleContaining(String str);
}
