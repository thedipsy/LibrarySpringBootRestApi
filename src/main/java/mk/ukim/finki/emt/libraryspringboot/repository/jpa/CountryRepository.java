package mk.ukim.finki.emt.libraryspringboot.repository.jpa;

import mk.ukim.finki.emt.libraryspringboot.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
