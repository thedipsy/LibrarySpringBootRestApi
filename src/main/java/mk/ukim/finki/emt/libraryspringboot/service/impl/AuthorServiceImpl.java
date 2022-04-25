package mk.ukim.finki.emt.libraryspringboot.service.impl;

import mk.ukim.finki.emt.libraryspringboot.model.Author;
import mk.ukim.finki.emt.libraryspringboot.model.Country;
import mk.ukim.finki.emt.libraryspringboot.model.dto.AuthorDto;
import mk.ukim.finki.emt.libraryspringboot.model.exception.AuthorNotFoundException;
import mk.ukim.finki.emt.libraryspringboot.repository.jpa.AuthorRepository;
import mk.ukim.finki.emt.libraryspringboot.repository.jpa.CountryRepository;
import mk.ukim.finki.emt.libraryspringboot.service.AuthorService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepositor) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepositor;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country = countryRepository.getById(authorDto.getCountry());
        Author author = new Author(
                authorDto.getName(),
                authorDto.getSurname(),
                country
                );

        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDto authorDto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));

        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        Country country = countryRepository.getById(authorDto.getCountry());
        author.setCountry(country);

        authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

}
