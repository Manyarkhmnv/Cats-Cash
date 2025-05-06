package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.models.Cats;
import org.example.services.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cats")
@AllArgsConstructor
public class CatController {
    private final CatService catService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cats> findCat(@PathVariable(name = "id") Long id) {
        return catService.findCat(id);
    }

    @PostMapping(path = "/create")
    public void saveCat(@RequestBody Cats cat) {
        catService.saveCat(cat);
    }

    @DeleteMapping(path = "/delete")
    public void deleteCat(@RequestBody Cats cat) {
        catService.deleteCat(cat);
    }

    @PutMapping(path = "/put")
    public void updateCat(@RequestBody Cats updated_cat) {
        catService.updateCat(updated_cat);
    }

    @GetMapping(path = "/get_all")
    public List<Cats> findAllCats() {
        return catService.findAllCats();
    }
}
