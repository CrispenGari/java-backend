package com.rest.rest.user;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public  Users(){} // Default constructor required
    // the reason i did not include the ID in here is because it will be generated by the database

    public Users(Long id, String name, String email, LocalDate dob){
        this.name = name;
        this.id = id;
        this.email = email;
        this.dob = dob;
    }
    public Users(String name, String email, LocalDate dob){
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    // Setters
    public void setEmail(String email) {
        this.email = email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    // Getters
    public LocalDate getDob() {
        return dob;
    }
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
