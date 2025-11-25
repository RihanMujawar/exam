package com.acharya.studentdata;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class StudentController {
@Autowired
public StudentRepo repo;
@PostMapping("/createData")
public String createStudent(@RequestBody Student student){
repo.save(student);
return "Data added successfully.";
}
@GetMapping("/fetchData")
public List<Student> fetch(){
return repo.findAll();
}
@DeleteMapping("removeData/{id}")
public String delete(@PathVariable int id) {
repo.deleteById(id);
return "Document deleted successfully";
}
}
