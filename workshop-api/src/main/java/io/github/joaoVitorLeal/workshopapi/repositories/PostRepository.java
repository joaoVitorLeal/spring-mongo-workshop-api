package io.github.joaoVitorLeal.workshopapi.repositories;

import io.github.joaoVitorLeal.workshopapi.domain.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String title);

    @Query(" { 'title': { $regex: ?0, $options: 'i' } } ") // Realiza a mesma operação que o méto-do acima findByTitleContainingIgnoreCase()
    List<Post> searchByTitleContainingIgnoreCase(String title);
}
