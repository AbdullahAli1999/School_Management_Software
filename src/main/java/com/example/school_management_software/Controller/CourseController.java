package com.example.school_management_software.Controller;

import com.example.school_management_software.Api.ApiResponse;
import com.example.school_management_software.Model.Course;
import com.example.school_management_software.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getAllCourse(){
        return ResponseEntity.status(200).body(courseService.getAllCourse());
    }
    //add
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Added"));
    }

    //update
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@RequestBody @Valid Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("Updated"));
    }
    //delete
    @DeleteMapping("/del/{id}")
    public ResponseEntity delCourse(@PathVariable Integer id){
        courseService.delCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Deleted"));
    }

    //with Teacher
    @PostMapping("addWithTeacher/{id}")
    public ResponseEntity withTeacher(@PathVariable Integer id,@RequestBody @Valid Course course){
        courseService.addWithTeacher(course,id);
        return ResponseEntity.status(200).body(new ApiResponse("Added "));
    }

    //Assign with Teacher
    @PutMapping("/assign/{courseId}/{teacherId}")
    public ResponseEntity assignCourseToTeacher(@PathVariable Integer courseId,@PathVariable Integer teacherId){
        courseService.assignCourseToTeacher(courseId, teacherId);
        return ResponseEntity.status(200).body(new ApiResponse("Assigned"));
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getCourseDetailsById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(courseService.getCourseDetailsById(id));
    }
}
