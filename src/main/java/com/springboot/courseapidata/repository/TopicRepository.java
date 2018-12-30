package com.springboot.courseapidata.repository;

import com.springboot.courseapidata.dto.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends  CrudRepository<Topic,String> {



}