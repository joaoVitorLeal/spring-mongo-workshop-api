package io.github.joaoVitorLeal.workshopapi.repository;

import io.github.joaoVitorLeal.workshopapi.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
