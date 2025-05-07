package io.github.joaoVitorLeal.workshopapi.services;

import io.github.joaoVitorLeal.workshopapi.domain.entities.Post;
import io.github.joaoVitorLeal.workshopapi.exceptions.ObjectNotFoundException;
import io.github.joaoVitorLeal.workshopapi.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post not found with id " + id));
    }

    public List<Post> findByTitle(String title) {
        return postRepository.searchByTitleContainingIgnoreCase(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // adicionando mais 24h
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
