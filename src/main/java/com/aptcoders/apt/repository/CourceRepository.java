package com.aptcoders.apt.repository;

import com.aptcoders.apt.entity.Cource;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@EnableRedisRepositories
public interface CourceRepository extends CrudRepository<Cource, Long> {}

