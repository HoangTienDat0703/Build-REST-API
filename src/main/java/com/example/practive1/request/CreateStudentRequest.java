package com.example.practive1.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateStudentRequest {
    @JsonProperty("first_name")
    @NotBlank(message = "first name is reqired")
    private String firstName;

    private String lastName;

    private String email;
}
