package com.ankurpathak.spring5datatest;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@Document(collection = "#{T(com.ankurpathak.spring5datatest.Name).randomCollectionName()}")
public class Name {

    @Id
    private String id;

    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public static int i = 0;

    public static int alternateInts[] = {0, 1};


    public static String randomCollectionName(){
        return "names" + alternateInts[i];
    }

    @Override
    public String toString() {
        return "Name{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
