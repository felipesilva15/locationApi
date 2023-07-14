package io.github.felipesilva15.locationApi.api.controller;

import io.github.felipesilva15.locationApi.domain.entity.City;
import io.github.felipesilva15.locationApi.domain.repository.CityRepository;
import io.github.felipesilva15.locationApi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public City save(@RequestBody City city) {
        return service.save(city);
    }

    @GetMapping
    public List<City> find(City filter, String sortBy) {
        if (sortBy == null || sortBy.isEmpty()) {
            return service.find(filter);
        }

        return service.find(filter, Sort.by(sortBy));
    }
}
