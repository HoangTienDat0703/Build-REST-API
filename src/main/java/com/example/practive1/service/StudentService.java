package com.example.practive1.service;

import com.example.practive1.entity.Student;
import com.example.practive1.repository.StudentRepository;
import com.example.practive1.request.CreateStudentRequest;
import com.example.practive1.request.UpdateStudentRequest;
import com.example.practive1.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public  Student creatStudent (CreateStudentRequest createStudentRequest){
        Student student = new Student(createStudentRequest);
        return studentRepository.save(student);
    }

    public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
        Student student = studentRepository.findById(updateStudentRequest.getId()).get();

        if(updateStudentRequest.getFirstName() != null &&
            !updateStudentRequest.getFirstName().isEmpty()){
            student.setFirstName(updateStudentRequest.getFirstName());
        }
        student = studentRepository.save(student);
        return student;
    }
}
