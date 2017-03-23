package com.iluwatar.datamapper;

import java.util.Optional;

/**
 * Created by starhq on 2017/3/23.
 */
public interface StudentDataMapper {

    Optional<Student> find(int studentId);

    void insert(Student student) throws DataMapperException;

    void update(Student student) throws DataMapperException;

    void delete(Student student) throws DataMapperException;
}
