package com.ld.Mod08Atividade.entities;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StudentEntity {

    private UUID id;
    private String name;
    private String course;
    private Integer admissionYear;

    public StudentEntity() {
    }

    public StudentEntity(UUID id, String name, String course, Integer admissionYear) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.admissionYear = admissionYear;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }
}
