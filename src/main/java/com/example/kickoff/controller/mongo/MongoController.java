package com.example.kickoff.controller.mongo;

import com.example.kickoff.model.OrderLifeCycle;
import com.example.kickoff.service.MongoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    private final MongoService mongoService;

    public MongoController(MongoService mongoService){
        this.mongoService=mongoService;
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> addEvent(@PathVariable(value = "id") String orderId, @RequestBody OrderLifeCycle orderLifeCycle){
        mongoService.addEvent(orderId,orderLifeCycle);
        return ResponseEntity.ok("Event added");
    }
}
