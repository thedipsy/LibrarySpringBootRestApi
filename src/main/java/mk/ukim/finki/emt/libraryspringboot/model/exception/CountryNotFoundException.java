package mk.ukim.finki.emt.libraryspringboot.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException(Long id){
        super(String.format("Category with id %d was not found.", id));
    }

}