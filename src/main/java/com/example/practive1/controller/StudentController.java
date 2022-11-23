package com.example.practive1.controller;

import com.example.practive1.entity.Student;
import com.example.practive1.request.CreateStudentRequest;
import com.example.practive1.request.UpdateStudentRequest;
import com.example.practive1.response.StudentResponse;
import com.example.practive1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v2/api/student/")
public class StudentController {

    @Autowired
    StudentService studentService;
//    @Value("${app.name: AYE}")
//    private String app;

    @GetMapping("getAll")
    public List<StudentResponse> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();

        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();

        studentList.stream().forEach(studentA -> {
            studentResponseList.add(new StudentResponse(studentA));
        });
        return studentResponseList;
    }

    @PostMapping("create")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        Student student = studentService.creatStudent(createStudentRequest);
        return new StudentResponse(student);
    }

    @PutMapping("update")
    public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        Student student = studentService.updateStudent(updateStudentRequest);
        return new StudentResponse(student);
    }
}
