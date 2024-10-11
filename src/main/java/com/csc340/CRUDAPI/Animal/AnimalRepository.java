package com.csc340.CRUDAPI.Animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> getAnimalsBySpecies(String species);

    @Query(value = "select * from animal a where a.name like %?1%", nativeQuery = true)
    List<Animal> findByNameContaining(String name);
}
