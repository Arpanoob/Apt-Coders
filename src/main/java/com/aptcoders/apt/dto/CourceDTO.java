package com.aptcoders.apt.dto;

import com.aptcoders.apt.constants.CourseType;
import lombok.Data;

@Data
public class CourceDTO {
    private String name;
    private String subject;
    private int chapters;
    private CourseType type; // Using enum type instead of String
    private String learnMode;
}

//enum CourseType {
//    PERSONALISED("Personalised"),
//    GROUP("Group");
//
//    private final String label;
//
//    CourseType(String label) {
//        this.label = label;
//    }
//
//    public String getLabel() {
//        return label;
//    }
//}
