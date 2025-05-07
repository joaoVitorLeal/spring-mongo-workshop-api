package io.github.joaoVitorLeal.workshopapi.controllers;

import io.github.joaoVitorLeal.workshopapi.controllers.util.UriDecoder;
import io.github.joaoVitorLeal.workshopapi.domain.entities.Post;
import io.github.joaoVitorLeal.workshopapi.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/title-search")
    public ResponseEntity<List<Post>> searchByTitle(@RequestParam(value = "text", defaultValue = "") String title) {
        title = UriDecoder.decode(title); // Desnecessário geralmente, pois o Spring já decodifica parâmetros de query automaticamente via @RequestParam
        return ResponseEntity.ok().body(service.findByTitle(title));
    }

    @GetMapping("/full-search")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
        ) {
        text = UriDecoder.decode(text);
        Date min = UriDecoder.convertDate(minDate, new Date(0L));
        Date max = UriDecoder.convertDate(maxDate, new Date());

        return ResponseEntity.ok().body(service.fullSearch(text, min, max));
    }
}
