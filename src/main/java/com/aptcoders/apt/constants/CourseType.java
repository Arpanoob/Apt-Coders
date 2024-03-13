package com.aptcoders.apt.constants;

public enum CourseType {
  PERSONALISED("Personalised"),
  GROUP("Group");

  private final String label;

  CourseType(String label) {
    this.label = label;
  }

  public String getLabel() {
    return label;
  }
}

