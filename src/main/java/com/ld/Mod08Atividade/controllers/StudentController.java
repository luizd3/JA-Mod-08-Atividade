package com.ld.Mod08Atividade.controllers;

import com.ld.Mod08Atividade.entities.StudentEntity;
import com.ld.Mod08Atividade.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> findAll() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> findById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(studentRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentEntity student) {
        studentRepository.addStudent(student);
        String message = "Aluno cadastrado com sucesso.";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody StudentEntity student) {
        studentRepository.updateStudent(student);
        String message = "Aluno atualizado com sucesso.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") UUID id) {
        studentRepository.deleteStudent(id);
        String message = "Aluno deletado da base de dados.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
