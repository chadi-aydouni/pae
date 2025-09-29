package g43729.webg5.pae.model.DB;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import g43729.webg5.pae.model.Student;

public interface StudentDB extends CrudRepository<Student, Integer> {

    // Donne le nom des étudiants
    @Query("SELECT s.name FROM Student s")
    List<String> findStudentsNames();

    // Donne l'id et le nom des étudiants
    @Query("SELECT s.id, s.name FROM Student s")
    List<Object[]> findIdAndStudentsNames();

    // Donne le nom des étudiants et le nombre total de crédits de leur programme

    @Query("SELECT s.name, SUM(c.credits) FROM Student s JOIN s.registered_courses c GROUP BY s")
    List<Object[]> findStudentsNamesAndTotalCredits();

    // Donne les étudiants qui ont + de crédits dans leur programme qu'une valeur en paramètre
    @Query("SELECT s FROM Student s JOIN s.registered_courses c GROUP BY s HAVING SUM(c.credits) > :low")
    List<Student> findStudentsTotalCreditsGreaterThan(Long low);

    // Donne les étudiants dont la chaîne de caractère en paramètre apparait dans le nom
    List<Student> findByNameContaining(String str);


}
