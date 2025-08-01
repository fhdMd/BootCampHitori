package com.example.kickoff.repo;

import com.example.kickoff.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {
}
