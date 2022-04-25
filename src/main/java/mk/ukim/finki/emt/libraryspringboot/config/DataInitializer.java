package mk.ukim.finki.emt.libraryspringboot.config;

import mk.ukim.finki.emt.libraryspringboot.model.dto.AuthorDto;
import mk.ukim.finki.emt.libraryspringboot.model.dto.CountryDto;
import mk.ukim.finki.emt.libraryspringboot.service.AuthorService;
import mk.ukim.finki.emt.libraryspringboot.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer  {

    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void init(){
        //countries
        countryService.save(new CountryDto("Macedonia","Europe"));

        //authors
        authorService.save(new AuthorDto("Angela", "Milosheska", 1L));
        authorService.save(new AuthorDto("Bojan", "Taleski", 1L));
        authorService.save(new AuthorDto("Ane", "Milosheska", 1L));
    }
}
