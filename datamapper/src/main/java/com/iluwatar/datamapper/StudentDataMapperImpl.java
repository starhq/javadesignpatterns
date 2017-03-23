package com.iluwatar.datamapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by starhq on 2017/3/23.
 */
public class StudentDataMapperImpl implements StudentDataMapper {

    private List<Student> students = new ArrayList<>();

    @Override
    public Optional<Student> find(int studentId) {
        for (final Student student : getStudents()) {
            if (student.getStudentId() == studentId) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    @Override
    public void insert(Student student) throws DataMapperException {
        if (!getStudents().contains(student)) {
            getStudents().add(student);
        } else {
            throw new DataMapperException("Student already [" + student.getName() + "] exists");
        }
    }

    @Override
    public void update(Student student) throws DataMapperException {
        if (getStudents().contains(student)) {
            final int index = getStudents().indexOf(student);
            getStudents().set(index, student);
        } else {
            throw new DataMapperException("Student [" + student.getName() + "] is not found");
        }
    }

    @Override
    public void delete(Student student) throws DataMapperException {
        if (this.getStudents().contains(student)) {
            this.getStudents().remove(student);

        } else {
            throw new DataMapperException("Student [" + student.getName() + "] is not found");
        }
    }

    public List<Student> getStudents() {
        return this.students;
    }
}
