package io.github.felipesilva15.locationApi.service;

import io.github.felipesilva15.locationApi.domain.entity.City;
import io.github.felipesilva15.locationApi.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository repository;

    @Transactional
    public City save(City city) {
        return repository.save(city);
    }

    @Transactional(readOnly = true)
    public List<City> find(City filter) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);

        return repository.findAll(example);
    }

    @Transactional(readOnly = true)
    public List<City> find(City filter, Sort sortBy) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);

        return repository.findAll(example, sortBy);
    }

    @Transactional(readOnly = true)
    public Page<City> find(City filter, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filter, matcher);

        return repository.findAll(example, pageable);
    }
}
