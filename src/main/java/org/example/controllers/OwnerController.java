package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.models.Friends;
import org.example.models.Owners;
import org.example.services.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
@AllArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Owners> findOwner(@PathVariable(name = "id") Long id) {
        return ownerService.findOwner(id);
    }

    @PostMapping(path = "/create")
    public void saveFriend(@RequestBody Owners owner) {
        ownerService.saveOwner(owner);
    }

    @DeleteMapping(path = "/delete")
    public void deleteCat(@RequestBody Owners owner) {
        ownerService.deleteOwner(owner);
    }

    @PutMapping(path = "/put")
    public void updateCat(@RequestBody Owners owner) {
        ownerService.updateOwner(owner);
    }

    @GetMapping(path = "/get_all")
    public List<Owners> findAllCats() {
        return ownerService.findAllOwners();
    }
}
