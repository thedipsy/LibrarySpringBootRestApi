package mk.ukim.finki.emt.libraryspringboot.service;

import mk.ukim.finki.emt.libraryspringboot.model.Author;
import mk.ukim.finki.emt.libraryspringboot.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> findById(Long id);

    List<Author> findAll();

    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> edit(Long id, AuthorDto authorDto);

    void deleteById(Long id);

}
