package mk.ukim.finki.emt.libraryspringboot.service.impl;

import mk.ukim.finki.emt.libraryspringboot.model.Country;
import mk.ukim.finki.emt.libraryspringboot.model.dto.CountryDto;
import mk.ukim.finki.emt.libraryspringboot.repository.jpa.CountryRepository;
import mk.ukim.finki.emt.libraryspringboot.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(CountryDto countryDto) {
        if(countryDto.getName() == null || countryDto.getName().isEmpty()){
            throw new IllegalArgumentException();
        }

        Country country = new Country(countryDto.getName(), countryDto.getContinent());
        return countryRepository.save(country);
    }

    @Override
    public Country update(String name, String continent) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }

        Country country = new Country(name, continent);
        return countryRepository.save(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }


}
