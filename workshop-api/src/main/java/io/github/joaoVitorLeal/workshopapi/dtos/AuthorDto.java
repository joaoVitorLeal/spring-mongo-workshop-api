package io.github.joaoVitorLeal.workshopapi.dtos;

import io.github.joaoVitorLeal.workshopapi.domain.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDto (User user) {
        this.id = user.getId();
        this.name  = user.getName();
    }
}
