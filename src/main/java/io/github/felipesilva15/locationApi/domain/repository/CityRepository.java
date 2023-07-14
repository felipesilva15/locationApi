package io.github.felipesilva15.locationApi.domain.repository;

import io.github.felipesilva15.locationApi.domain.entity.City;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    // Busca pelo nome da cidade exato
    @Query(nativeQuery = true, value = "SELECT c.* FROM city c WHERE c.name = :name")
    List<City> findByNameSqlNativo(String name);

    List<City> findByName(String name);

    List<City> findByName(String name, Sort sort);

    // Busca pelo nome da cidade começando com o parâmetro informado
    List<City> findByNameStartingWith(String name);

    // Busca pelo nome da cidade terminando com o parâmetro informado
    List<City> findByNameEndingWith(String name);

    // Busca pelo nome da cidade contendo o parâmetro informado
    List<City> findByNameContaining(String name);

    // Busca pelo nome da cidade contendo o parâmetro informado
    List<City> findByNameLike(String name);

    List<City> findByPopulation(Long population);

    List<City> findByPopulationLessThan(Long population);

    List<City> findByPopulationGreaterThan(Long population);

    List<City> findByPopulationLessThanEqual(Long population);

    List<City> findByPopulationLessThanEqualAndNameLike(Long population, String name);
}
