package com.aptcoders.apt.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Student")
@Data
//@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cource {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String subject;
    private int chapters;
    private CourseType type; // Using enum type instead of String
    private String learnMode;

    // Constructors, getters, and setters
}

 enum CourseType {
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

//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//public class User {
//    @Id
//    @GeneratedValue
//    private Integer id;
//    private String name;
//    private Integer age;
//    private String address;
//
//
//}
