package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.models.Cats;
import org.example.services.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void saveCat(@RequestBody Cats cat) {
        catService.saveCat(cat);
    }

    @DeleteMapping(path = "/delete")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void deleteCat(@RequestBody Cats cat) {
        catService.deleteCat(cat);
    }

    @PutMapping(path = "/update")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void updateCat(@RequestBody Cats updated_cat) {
        catService.updateCat(updated_cat);
    }

//    @GetMapping(path = "/get_all")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    public List<Cats> findAllCats() {
//        return catService.findMyCats();
//    }

    @GetMapping(path = "/get_my")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Cats> findMyCat() {
        return catService.findMyCats();
    }

    @GetMapping(path = "/get_all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Cats> findAllCat() {
        return catService.findAllCats();
    }
}
