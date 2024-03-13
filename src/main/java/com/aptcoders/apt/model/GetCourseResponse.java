package com.aptcoders.apt.model;

import com.aptcoders.apt.constants.CourseType;
import com.aptcoders.apt.constants.UserRoles;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetCourseResponse implements Serializable {

  private static final long serialVersionUID = 2366700067530224853L;

  private Long id;
  private String courseName;
  private String subject;
  private int chapters;
  private int noOfClasses;
  private CourseType type;
  private String learnMode;
  private UserRoles role;
}
