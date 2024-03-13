package com.aptcoders.apt.constants;

public enum UserRoles {
  STUDENT("student"),
  TEACHER("teacher"),
  COURSE_CREATOR("course-creator");
  private String role;

  UserRoles(String role){
    this.role = role;
  }
}
