package com.iluwatar.datamapper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by starhq on 2017/3/23.
 */
public class DataMapperTest {

    @Test
    public void testFirstDataMapper() {

    /* Create new data mapper of first type */
        final StudentDataMapper mapper = new StudentDataMapperImpl();

    /* Create new student */
        Student student = new Student(1, "Adam", 'A');

    /* Add student in respectibe db */
        mapper.insert(student);

    /* Check if student is added in db */
        assertEquals(student.getStudentId(), mapper.find(student.getStudentId()).get().getStudentId());

    /* Update existing student object */
        student = new Student(student.getStudentId(), "AdamUpdated", 'A');

    /* Update student in respectibe db */
        mapper.update(student);

    /* Check if student is updated in db */
        assertEquals(mapper.find(student.getStudentId()).get().getName(), "AdamUpdated");

    /* Delete student in db */
        mapper.delete(student);

    /* Result should be false */
        assertEquals(false, mapper.find(student.getStudentId()).isPresent());
    }
}
