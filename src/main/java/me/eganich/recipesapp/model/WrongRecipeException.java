package me.eganich.recipesapp.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongRecipeException extends RuntimeException{

    public WrongRecipeException(String message) {
        super(message);
    }
}
