package com.iluwatar.datamapper;

import java.io.Serializable;

/**
 * Created by starhq on 2017/3/23.
 */
public final class Student implements Serializable {

    private static final long serialVersionUID = 5204386340173568778L;
    private int studentId;
    private String name;
    private char grade;

    public Student(int studentId, String name, char grade) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(final Object inputObject) {

        boolean isEqual = false;

    /* Check if both objects are same */
        if (this == inputObject) {

            isEqual = true;
        } else if (inputObject != null && getClass() == inputObject.getClass()) {

            final Student inputStudent = (Student) inputObject;

      /* If student id matched */
            if (this.getStudentId() == inputStudent.getStudentId()) {

                isEqual = true;
            }
        }

        return isEqual;
    }

    /**
     *
     */
    @Override
    public int hashCode() {

    /* Student id is assumed to be unique */
        return this.getStudentId();
    }

    /**
     *
     */
    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", name=" + name + ", grade=" + grade + "]";
    }
}
