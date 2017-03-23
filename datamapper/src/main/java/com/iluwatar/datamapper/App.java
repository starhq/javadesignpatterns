package com.iluwatar.datamapper;

import org.apache.log4j.Logger;

import java.util.Optional;

/**
 * Hello world!
 */
public class App {

    private static Logger log = Logger.getLogger(App.class);

    public static void main(String[] args) {
         /* Create new data mapper for type 'first' */
        final StudentDataMapper mapper = new StudentDataMapperImpl();

    /* Create new student */
        Student student = new Student(1, "Adam", 'A');

    /* Add student in respectibe store */
        mapper.insert(student);

        log.debug("App.main(), student : " + student + ", is inserted");

    /* Find this student */
        final Optional<Student> studentToBeFound = mapper.find(student.getStudentId());

        log.debug("App.main(), student : " + studentToBeFound + ", is searched");

    /* Update existing student object */
        student = new Student(student.getStudentId(), "AdamUpdated", 'A');

    /* Update student in respectibe db */
        mapper.update(student);

        log.debug("App.main(), student : " + student + ", is updated");
        log.debug("App.main(), student : " + student + ", is going to be deleted");

    /* Delete student in db */
        mapper.delete(student);
    }
}
