package com.springboot.courseapidata.service;

import com.springboot.courseapidata.dto.Topic;
import com.springboot.courseapidata.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "spring framework", "vdvdda"),
            new Topic("java", "java framework", "vdvdda"),
            new Topic("javascript", "javascript framework", "vdvdda")
    ));

    public List<Topic> getAllTopics() {
        List<Topic> topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return  topics;
    }

    public Optional<Topic> getTopic(String id) {
        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);

        }


    public void deleteTopic(String id){
        topicRepository.deleteById(id);
        }

    }



