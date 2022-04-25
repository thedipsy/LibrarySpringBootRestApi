package mk.ukim.finki.emt.libraryspringboot.service.impl;

import mk.ukim.finki.emt.libraryspringboot.model.Author;
import mk.ukim.finki.emt.libraryspringboot.model.Book;
import mk.ukim.finki.emt.libraryspringboot.model.dto.BookDto;
import mk.ukim.finki.emt.libraryspringboot.model.exception.AuthorNotFoundException;
import mk.ukim.finki.emt.libraryspringboot.model.exception.BookNotFoundException;
import mk.ukim.finki.emt.libraryspringboot.model.exception.NoAvailableCopiesException;
import mk.ukim.finki.emt.libraryspringboot.repository.jpa.AuthorRepository;
import mk.ukim.finki.emt.libraryspringboot.repository.jpa.BookRepository;
import mk.ukim.finki.emt.libraryspringboot.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }


    @Override
    public Optional<Book> save(BookDto bookDto) {

        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));

        Book book = new Book(bookDto.getName(),
                bookDto.getCategory(),
                author,
                bookDto.getAvailableCopies());
        bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setCategory(bookDto.getCategory());
        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        book.setAuthor(author);

        bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        int availableCopies = book.getAvailableCopies();
        if(availableCopies == 0){
            throw new NoAvailableCopiesException();
        }
        book.setAvailableCopies(--availableCopies);
        bookRepository.save(book);

        return Optional.of(book);
    }

}
