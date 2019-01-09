package com.ned.demo.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "students")
public class Student {
    private String id;

    private String name;

    private Integer willToLive;

    public Student() {
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(
            name = "id",
            nullable = false,
            unique = true,
            updatable = false
    )
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column()
    public Integer getWillToLive() {
        return this.willToLive;
    }

    public void setWillToLive(Integer willToLive) {
        this.willToLive = willToLive;
    }

    public String extractStudentAsString() {
        return String.format("[%s]. %s - [%d]", this.getId(), this.getName(), this.getWillToLive());
    }

}
