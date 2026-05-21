
package com.GuruFruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.GuruFruit.entity.Fruits;
import com.GuruFruit.repository.FruitRepository;

@RestController
@RequestMapping("/api/fruits")
@CrossOrigin("*")
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;

    // GET ALL FRUITS

    @GetMapping
    public List<Fruits> getAllFruits() {

        return fruitRepository.findAll();
    }


    // ADD NEW FRUIT

    @PostMapping
    public Fruits addFruit(
            @RequestBody Fruits fruit
    ) {

        return fruitRepository.save(fruit);
    }


    // UPDATE FRUIT

    @PutMapping("/{id}")
    public Fruits updateFruit(

            @PathVariable Long id,

            @RequestBody Fruits updatedFruit
    ) {

        Fruits existingFruit = fruitRepository
                .findById(id)

                .orElseThrow(() ->
                        new RuntimeException(
                                "Fruit Not Found With ID : " + id
                        )
                );

        existingFruit.setName(updatedFruit.getName());

        existingFruit.setPrice(updatedFruit.getPrice());

        existingFruit.setUnit(updatedFruit.getUnit());

        existingFruit.setStock(updatedFruit.getStock());
        existingFruit.setDescription(
                updatedFruit.getDescription()
        );

        existingFruit.setQuality(
                updatedFruit.getQuality()
        );

        existingFruit.setBenefits(
                updatedFruit.getBenefits()
        );

        existingFruit.setSeasonTag(
                updatedFruit.getSeasonTag()
        );

        existingFruit.setDeliveryInfo(
                updatedFruit.getDeliveryInfo()
        );
        existingFruit.setCategory(
                updatedFruit.getCategory()
        );
        // IMPORTANT 🔥
        existingFruit.setImageUrl(
                updatedFruit.getImageUrl()
        );

        return fruitRepository.save(existingFruit);
    }


    // DELETE FRUIT

    @DeleteMapping("/{id}")
    public String deleteFruit(
            @PathVariable Long id
    ) {

        fruitRepository.deleteById(id);

        return "Fruit Deleted Successfully";
    }
    
    @GetMapping("/{id}")
    public Fruits getFruitById(
            @PathVariable Long id
    ) {

        return fruitRepository.findById(id)

                .orElseThrow(() ->
                        new RuntimeException(
                                "Fruit Not Found"
                        )
                );
    }

}