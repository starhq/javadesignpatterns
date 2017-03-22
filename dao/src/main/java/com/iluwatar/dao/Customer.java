package com.iluwatar.dao;

/**
 * Created by starhq on 2017/3/22.
 */
public class Customer {

    private int id;
    private String firstName;
    private String lastName;

    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + getId() + ", firstName='" + getFirstName() + '\'' + ", lastName='"
                + getLastName() + '\'' + '}';
    }

    @Override
    public boolean equals(final Object that) {
        boolean isEqual = false;
        if (this == that) {
            isEqual = true;
        } else if (that != null && getClass() == that.getClass()) {
            final Customer customer = (Customer) that;
            if (getId() == customer.getId()) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
