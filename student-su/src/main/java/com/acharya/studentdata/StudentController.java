package com.acharya.studentdata;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo repo;

    @PostMapping("/createData")
    public String createStudent(@RequestBody Student student) {
        try {
            repo.save(student);
            return "Data added successfully.";
        } catch (Exception e) {
            return "Error adding data: " + e.getMessage();
        }
    }

    @GetMapping("/fetchData")
    public List<Student> fetch() {
        return repo.findAll();
    }

    @GetMapping("/fetchData/{id}")
    public Student fetchById(@PathVariable int id) {
        Optional<Student> student = repo.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    @PutMapping("/updateData/{id}")
    public String update(@PathVariable int id, @RequestBody Student student) {
        try {
            Optional<Student> existingStudent = repo.findById(id);
            if (existingStudent.isPresent()) {
                student.setId(id); // Ensure the ID remains the same
                repo.save(student);
                return "Data updated successfully.";
            } else {
                return "Student not found with id: " + id;
            }
        } catch (Exception e) {
            return "Error updating data: " + e.getMessage();
        }
    }

    @DeleteMapping("/removeData/{id}")
    public String delete(@PathVariable int id) {
        try {
            repo.deleteById(id);
            return "Document deleted successfully";
        } catch (Exception e) {
            return "Error deleting data: " + e.getMessage();
        }
    }
}