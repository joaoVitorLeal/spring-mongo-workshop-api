package io.github.joaoVitorLeal.workshopapi.config;

import io.github.joaoVitorLeal.workshopapi.domain.entities.Post;
import io.github.joaoVitorLeal.workshopapi.domain.entities.User;
import io.github.joaoVitorLeal.workshopapi.dtos.AuthorDto;
import io.github.joaoVitorLeal.workshopapi.dtos.CommentDto;
import io.github.joaoVitorLeal.workshopapi.repositories.PostRepository;
import io.github.joaoVitorLeal.workshopapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class InstantiationConfiguration implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));


        Post post1 = new Post(null, sdf.parse("20/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

        CommentDto comment1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(alex));
        CommentDto comment2 = new CommentDto("Aproveite!", sdf.parse("22/03/2018"), new AuthorDto(bob));
        CommentDto comment3 = new CommentDto("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDto(alex));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
