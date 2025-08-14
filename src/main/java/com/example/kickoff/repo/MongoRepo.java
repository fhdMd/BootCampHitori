package com.example.kickoff.repo;

import com.example.kickoff.model.OrderLifeCycle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepo extends MongoRepository<OrderLifeCycle,String> {

}
