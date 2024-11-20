package com.example.Readerly.Repositories;

import com.example.Readerly.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}