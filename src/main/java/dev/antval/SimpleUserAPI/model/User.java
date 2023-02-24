package dev.antval.SimpleUserAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String lastName;
    private int age;
    private String position;
    private String seniority;
}