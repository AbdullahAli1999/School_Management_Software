package com.example.school_management_software.Controller;

import com.example.school_management_software.Api.ApiResponse;
import com.example.school_management_software.Model.Student;
import com.example.school_management_software.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    //ADD
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student student) {
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id, @RequestBody @Valid Student student) {
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    //DELETE
    @DeleteMapping("/de/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }

    //CHANGE MAJOR
    @PutMapping("/change-major/{studentId}/{major}")
    public ResponseEntity changeStudentMajor(@PathVariable Integer studentId, @PathVariable String major) {
        studentService.changeStudentMajor(studentId, major);
        return ResponseEntity.status(200).body(new ApiResponse("Major changed"));
    }

    //GET STUDENT BY COURSE
    @GetMapping("/get-student-byCourse/{id}")
    public ResponseEntity<List<Student>> getStudentsByCourseId(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(studentService.getStudentsByCourseId(id));
    }
}
