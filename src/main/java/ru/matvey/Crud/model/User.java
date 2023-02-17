package ru.matvey.Crud.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name = "users1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2,max=20,message = "name should be between 2 and 20 characters")
    private String name;
    @Column(name = "age")
    @Min(value = 1,message = "Age should be greater than 1")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Enter correct email")
    private String email;

    public User() {
    }

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && name.equals(user.name) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int cos = 17;
        return cos * 31 + Objects.hash(name, age, email);
    }
}

