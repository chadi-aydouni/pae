package g43729.webg5.pae.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import g43729.webg5.pae.model.DB.CourseDB;
import g43729.webg5.pae.model.DB.StudentDB;
import lombok.extern.slf4j.Slf4j;

/*
@Slf4j
@Component
public class Start implements CommandLineRunner{

    @Autowired
    private CourseDB courseDB;

    @Autowired
    private StudentDB studentDB;
    
    // Permet de tester requête avancées 
    @Override
    public void run(String... args){

    log.info("Cours avec crédits + grand que 5 : " + courseDB.findByCreditsGreaterThanEqual(5).toString());
    log.info("Cours contenant le mot Développement : " + courseDB.findByTitleContaining("Développement").toString());

    log.info("Nom des étudiants : " + studentDB.findStudentsNames().toString()); 

    log.info("ID et nom des étudiants en une seule requête : ");

        for(Object[] items : studentDB.findIdAndStudentsNames()){
            log.info(items[0] + " - " + items[1]);
        }

    log.info("Noms des étudiants et nombre total de crédits du programme: ");

        for(Object[] items : studentDB.findStudentsNamesAndTotalCredits()){
            log.info(items[0] + " - " + items[1]);
        }

    log.info("Noms des étudiants qui ont un nombre de crédits dans leur programme supérieur à 10 : " + studentDB.findStudentsTotalCreditsGreaterThan(
            (long) 10).toString());

    }
}
*/