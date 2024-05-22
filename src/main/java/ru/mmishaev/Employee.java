package ru.mmishaev;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Employee {
    public long id;
    public String firstName;
    public String lastName; public String country;
    public int age;


    public Employee() { // Пустой конструктор
        //
    }

    public Employee(long id, String firstName, String lastName, String country, int age)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }



    @Override
    public String toString(){
        return "\nID: " + this.id +
                "\nFirstName: " + this.firstName +
                "\nLastName: " + this.lastName +
                "\nCountry: " + this.country +
                "\nAge: " + this.age;
    }
}
