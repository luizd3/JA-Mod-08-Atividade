package com.ld.Mod08Atividade.repositories;

import com.ld.Mod08Atividade.entities.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepository {

    List<StudentEntity> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
        // Alunos pré-cadastrados:
        addStudent(new StudentEntity(UUID.fromString("8d6942fd-8c04-4efb-a63c-76bbbe81eda1"), "José", "Ciência da Computação", 2020));
        addStudent(new StudentEntity(UUID.fromString("f67deda1-bfc5-4507-a572-e89034a664f4"), "Paulo", "Engenharia Elétrica", 2021));
        addStudent(new StudentEntity(UUID.fromString("e82d5a05-9242-40f2-9d49-fbee35c43097"), "Felipe", "Matemática", 2022));
    }

    public List<StudentEntity> findAll() {
        return students;
    }

    public StudentEntity findById(UUID id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst().get();
    }

    public void addStudent(StudentEntity student) {
        if (student.getId() != null) {
            students.add(student);
        } else {
            student.setId(UUID.randomUUID());
            students.add(student);
        }
    }

    public void updateStudent(StudentEntity student) {
        StudentEntity studentToUpdate = students.stream()
                .filter(std -> std.getId().equals(student.getId()))
                .findFirst().get();
        studentToUpdate.setName(student.getName());
        studentToUpdate.setCourse(student.getCourse());
        studentToUpdate.setAdmissionYear(student.getAdmissionYear());
    }

    public void deleteStudent(UUID id) {
        StudentEntity studentToRemove = students.stream()
                .filter(std -> std.getId().equals(id))
                .findFirst().get();
        students.remove(studentToRemove);
    }

}
