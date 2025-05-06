package io.github.joaoVitorLeal.workshopapi.domain.entities;

import io.github.joaoVitorLeal.workshopapi.dtos.AuthorDto;
import io.github.joaoVitorLeal.workshopapi.dtos.CommentDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class Post implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private Date date;
    private String title;
    private String body;
    private AuthorDto author;
    private List<CommentDto> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, AuthorDto author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
