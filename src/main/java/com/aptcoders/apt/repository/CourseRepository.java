package com.aptcoders.apt.repository;

import com.aptcoders.apt.entity.Course;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@EnableRedisRepositories
public interface CourseRepository extends CrudRepository<Course, Long> {}

