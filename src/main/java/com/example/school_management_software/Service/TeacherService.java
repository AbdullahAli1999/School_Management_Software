package com.example.school_management_software.Service;

import com.example.school_management_software.Api.ApiException;
import com.example.school_management_software.Model.Teacher;
import com.example.school_management_software.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    //GET
    public List<Teacher> getAllTeacher(){
        return teacherRepository.findAll();
    }

    //ADD
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    //Update
    public void updateTeacher(Integer id, Teacher teacher){
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if(oldTeacher == null){
            throw new ApiException("Teacher not found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        teacherRepository.save(oldTeacher);
    }
    //Delete
    public void deleteTeacher(Integer id){
        Teacher delTeacher = teacherRepository.findTeacherById(id);
        if(delTeacher == null){
            throw new ApiException("Teacher not found");
        }
        teacherRepository.delete(delTeacher);
    }

    // GET all teacher details from id
    public Teacher getTeacherById(Integer id){
        Teacher teacherId = teacherRepository.findTeacherById(id);
        if(teacherId == null){
            throw new ApiException("Not found");
        }
        return teacherId;
    }

}
