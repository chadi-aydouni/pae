package g43729.webg5.pae.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import g43729.webg5.pae.model.DB.CourseDB;
import g43729.webg5.pae.model.DB.StudentDB;

/**
 * Classe de démarrage pour tester des requêtes avancées sur la base de données
 */
// @Component
// public class Start implements CommandLineRunner {

// private static final Logger log = LoggerFactory.getLogger(Start.class);

// @Autowired
// private CourseDB courseDB;

// @Autowired
// private StudentDB studentDB;

// @Override
// public void run(String... args) {
// // Cours avec crédits >= 5
// log.info("Cours avec crédits >= 5 : " +
// courseDB.findByCreditsGreaterThanEqual(5).toString());

// // Cours contenant le mot "Développement"
// log.info(
// "Cours contenant le mot Développement : " +
// courseDB.findByTitleContaining("Développement").toString());

// // Nom des étudiants
// log.info("Nom des étudiants : " + studentDB.findStudentsNames().toString());

// // ID et nom des étudiants
// log.info("ID et nom des étudiants en une seule requête :");
// for (Object[] items : studentDB.findIdAndStudentsNames()) {
// log.info(items[0] + " - " + items[1]);
// }

// // Noms des étudiants et nombre total de crédits du programme
// log.info("Noms des étudiants et nombre total de crédits du programme :");
// for (Object[] items : studentDB.findStudentsNamesAndTotalCredits()) {
// log.info(items[0] + " - " + items[1]);
// }

// // Étudiants avec total crédits > 10
// log.info("Noms des étudiants avec total crédits > 10 : " +
// studentDB.findStudentsTotalCreditsGreaterThan(10L).toString());
// }
// }
