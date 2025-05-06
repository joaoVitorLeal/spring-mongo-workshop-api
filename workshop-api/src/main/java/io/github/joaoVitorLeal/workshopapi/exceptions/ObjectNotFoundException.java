package io.github.joaoVitorLeal.workshopapi.exceptions;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException (String message) {
        super(message);
    }
}
