package com.iluwatar.dao;

/**
 * Created by starhq on 2017/3/22.
 */
public interface CustomerSchemaSql {

    String CREATE_SCHEMA_SQL = "CREATE TABLE CUSTOMERS (ID NUMBER, FNAME VARCHAR(100), "
            + "LNAME VARCHAR(100))";

    String DELETE_SCHEMA_SQL = "DROP TABLE CUSTOMERS";
}
