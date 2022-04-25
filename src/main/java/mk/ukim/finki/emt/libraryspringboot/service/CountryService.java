package mk.ukim.finki.emt.libraryspringboot.service;

import mk.ukim.finki.emt.libraryspringboot.model.Country;
import mk.ukim.finki.emt.libraryspringboot.model.dto.CountryDto;

import java.util.List;

public interface CountryService {

    Country save(CountryDto countryDto);

    Country update(String name, String continent);

    void deleteById(Long id);

    List<Country> findAll();

}
