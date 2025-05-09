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
        User joao = new User(null, "João Silva", "joao@gmail.com");
        User lucas = new User(null, "Lucas Oliveira", "lucas@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob, joao, lucas));

        // Posts
        Post post1 = new Post(null, sdf.parse("20/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDto(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDto(maria));
        Post post3 = new Post(null, sdf.parse("25/03/2018"), "Nova Aventura", "Fui para a praia hoje, que dia incrível!", new AuthorDto(joao));
        Post post4 = new Post(null, sdf.parse("28/03/2018"), "Trabalho", "Estou trabalhando em um projeto novo. Vamos lá!", new AuthorDto(lucas));

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        joao.getPosts().add(post3);
        lucas.getPosts().add(post4);

        userRepository.saveAll(Arrays.asList(maria, joao, lucas));

        // Comentários
        CommentDto comment1 = new CommentDto("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDto(alex));
        CommentDto comment2 = new CommentDto("Aproveite!", sdf.parse("22/03/2018"), new AuthorDto(bob));
        CommentDto comment3 = new CommentDto("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDto(alex));
        CommentDto comment4 = new CommentDto("Que legal, aproveite a praia!", sdf.parse("26/03/2018"), new AuthorDto(lucas));
        CommentDto comment5 = new CommentDto("Bom trabalho! Sucesso!", sdf.parse("29/03/2018"), new AuthorDto(bob));

        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);
        post3.getComments().add(comment4);
        post4.getComments().add(comment5);

        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));
    }

}
