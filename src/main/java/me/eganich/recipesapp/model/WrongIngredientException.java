package me.eganich.recipesapp.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class WrongIngredientException extends RuntimeException{
    public WrongIngredientException(String message) {
        super(message);
    }
}
