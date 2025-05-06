package io.github.joaoVitorLeal.workshopapi.repository;

import io.github.joaoVitorLeal.workshopapi.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
