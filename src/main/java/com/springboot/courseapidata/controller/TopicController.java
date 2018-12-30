package com.springboot.courseapidata.controller;


import com.springboot.courseapidata.dto.Topic;
import com.springboot.courseapidata.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();

    }

    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);

    }
    @RequestMapping(method = RequestMethod.POST, value="/topics1")
    public ResponseEntity addTopicReponsEntity(@RequestBody Topic topic){
        topicService.addTopic(topic);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("response-header-key","response-header-value");
        httpHeaders.setBearerAuth("zxdsafjsgsfgstusrtatggjytu465gjkd56hghdfgh");
        return ResponseEntity.status(HttpStatus.CREATED).headers(httpHeaders).body(topic);

    }


    @RequestMapping(method = RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id,topic);

    }

    @RequestMapping(method= RequestMethod.DELETE,value="/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }


}
