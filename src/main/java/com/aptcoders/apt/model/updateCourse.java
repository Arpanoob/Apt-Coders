package com.aptcoders.apt.model;

import com.aptcoders.apt.constants.CourseType;
import lombok.Data;

@Data
public class updateCourse {
    private String name;
    private String subject;
    private int chapters;
    private CourseType type; // Using enum type instead of String
    private String learnMode;
}

