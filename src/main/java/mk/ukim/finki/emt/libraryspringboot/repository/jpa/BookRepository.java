package mk.ukim.finki.emt.libraryspringboot.repository.jpa;

import mk.ukim.finki.emt.libraryspringboot.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByName(String searchText);
    void deleteByName(String name);

}
