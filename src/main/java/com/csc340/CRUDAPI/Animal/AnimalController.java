package com.csc340.CRUDAPI.Animal;

import org.apache.tomcat.util.modeler.BaseAttributeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Student object.
 */
@Controller
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
    public String getAllAnimals(Model model) {
        model.addAttribute("animalList", service.getAllAnimals());
        model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animal/2
     *
     * @param animalId the unique Id for a Animal.
     * @return One Animal object.
     */

    @GetMapping("/{animalId}")
    public String getOneAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title", animalId);
        return "animal-details";
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
    public String addNewAnimal(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animal/all";
    }

    @PostMapping("/update")
    public String updateAnimal(Animal animal) {
        service.addNewAnimal(animal);
        return "redirect:/animal/" + animal.getAnimalId();
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animal/update/{animalID} --data '{ "aniamlId": 4, "name": "sample4", "scientificName": null,
     * "species": "", "habitat":"Rainforest", description":null}
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new update Animal details.
     * @return the updated Animal object.
     */
    @GetMapping("/update/{animalId}")
    public String updateAnimal(@PathVariable int animalId, Model model) {
        model.addAttribute("animal", service.getAnimalById(animalId));
        return "animal-update";
    }

    @GetMapping("/create")
    public String createAnimalForm(){
        return "animal-create";
    }

    /**
     * Delete a Animal object.
     * http://localhost:8080/animal/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @GetMapping("/delete/{animalId}")
    public String deleteAnimalById(int animalId) {
        service.deleteAnimalById(animalId);
        return "redirect:/animal/all";
    }

    /**
     * Get a list of animals by their species.
     * http://localhost:8080/animal/species/bird
     *
     * @param species
     * @return list of animals with corresponding species.
     */

    @GetMapping("/species/{species}")
    public String getAnimalsBySpecies(@RequestParam(name = "species", defaultValue = "unknown") String species, Model model) {
        model.addAttribute("animalList", service.getAnimalBySpecies(species));
        model.addAttribute("title", "Animal Species: "+species);
        return "student-list";
    }

    /**
     * Get a list of animals with corresponding substring that was searched for.\
     *
     * @param name
     * @return list of animals with same substring
     */

    @GetMapping("/search")
    public String searchAnimalsByName(@RequestParam(name = "name", defaultValue = "Blue Whale") String name, Model model) {
        model.addAttribute("studentList", service.searchAnimalByName(name));
        model.addAttribute("title", "Search Result: "+name);
        return "student-list";
    }
}