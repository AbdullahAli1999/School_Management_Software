package com.example.school_management_software.Service;

import com.example.school_management_software.Model.Student;
import com.example.school_management_software.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    //GET
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    //ADD

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    //UPDATE
    public void updateStudent(Integer id, Student updatedStudent) {
        Student oldStudent = studentRepository.findStudentById(id);
        if (oldStudent == null) {
            return;
        }
        oldStudent.setName(updatedStudent.getName());
        oldStudent.setAge(updatedStudent.getAge());
        oldStudent.setMajor(updatedStudent.getMajor());

    }

    //DELETE
    public void deleteStudent(Integer id) {
        Student delStudent = studentRepository.findStudentById(id);
        if (delStudent == null) {
            return;
        }
        studentRepository.delete(delStudent);
    }

    //CHANGE MAJOR
    public void changeStudentMajor(Integer studentId, String major) {
        Student student = studentRepository.findStudentById(studentId);
        if (student == null) {
            return;
        }
        student.setMajor(major);
        student.getCourses().clear();
        studentRepository.save(student);
    }

    //GET STUDENT BY COURSE
    public List<Student> getStudentsByCourseId(Integer courseId) {
        return studentRepository.findStudentByCourseId(courseId);
    }


    }
