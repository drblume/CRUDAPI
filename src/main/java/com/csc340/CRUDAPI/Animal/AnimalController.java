package com.csc340.CRUDAPI.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Student object.
 */
@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animal/all
     *
     * @return a list of Animals objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animal/2
     *
     * @param animalId the unique Id for a Animal.
     * @return One Animal object.
     */

    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    /**
     * Create a new Animal entry.
     * http://localhost:8080/animal/new --data '{ "aniamlId": 4, "name": "sample4", "scientificName": null,
     * "species": "", "habitat":"Rainforest", description":null}'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animal/update/{animalID} --data '{ "aniamlId": 4, "name": "sample4", "scientificName": null,
     * "species": "", "habitat":"Rainforest", description":null}
     *
     * @param animalId the unique Animal Id.
     * @param animal  the new update Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    /**
     * Delete a Animal object.
     * http://localhost:8080/animal/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }

    /**
     * Get a list of animals by their species.
     * http://localhost:8080/animal/species/bird
     *
     * @param species
     * @return list of animals with corresponding species.
     */

    @GetMapping("/species/{species}")
    public List<Animal> getAnimalsBySpecies(@PathVariable String species) {
        return service.getAnimalBySpecies(species);
    }

    /**
     * Get a list of animals with corresponding substring that was searched for.\
     *
     * @param name
     * @return list of animals with same substring
     */

    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam String name) {
        return service.searchAnimalByName(name);
    }
}