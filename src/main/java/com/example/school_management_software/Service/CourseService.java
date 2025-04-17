package com.example.school_management_software.Service;

import com.example.school_management_software.Api.ApiException;
import com.example.school_management_software.Model.Course;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Repository.CourseRepository;
import com.example.school_management_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    //GET
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    //Add
    public void addCourse(Course course){
        courseRepository.save(course);
    }

    //update
    public void updateCourse(Integer id,Course course){
        Course oldCourse = courseRepository.findCourseById(id);
        if(oldCourse == null){
            throw new ApiException("Course not found");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    //Delete
    public void delCourse(Integer id){
        Course delCourse = courseRepository.findCourseById(id);
        if (delCourse == null){
            throw new ApiException("Course not found");
        }
        courseRepository.delete(delCourse);
    }


    //Add course with teacher
    public void addWithTeacher(Course course, Integer teacherId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        if(teacher == null){
            throw new ApiException("Teacher not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    //Assign course to teacher
    public void assignCourseToTeacher(Integer courseId,Integer teacherId){
        Teacher teacher = teacherRepository.findTeacherById(teacherId);
        Course course = courseRepository.findCourseById(courseId);
        if(teacher == null){
            throw new ApiException("Teacher not found");
        }
        if (course == null){
            throw new ApiException("Course not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    //get course details by id
    public Course getCourseDetailsById(Integer id){
        Course course = courseRepository.findCourseById(id);
        if(course == null){
            throw new ApiException("Not found");
        }
        return course;
    }

}
