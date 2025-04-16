package com.example.school_management_software.Controller;

import com.example.school_management_software.Api.ApiResponse;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    //Get
    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
        return ResponseEntity.status(200).body(teacherService.getAllTeacher());
    }
    //ADD
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Added"));
    }
    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody @Valid Teacher teacher){
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("Updated"));
    }
    //Delete
    @DeleteMapping("/del/{id}")
    public ResponseEntity delTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted"));
    }
}
