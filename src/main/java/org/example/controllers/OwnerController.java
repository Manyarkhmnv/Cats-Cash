package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.models.Friends;
import org.example.models.Owners;
import org.example.services.OwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
@AllArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Owners> findOwner(@PathVariable(name = "id") Long id) {
        return ownerService.findOwner(id);
    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void saveFriend(@RequestBody Owners owner) {
        ownerService.saveOwner(owner);
    }

    @DeleteMapping(path = "/delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteCat(@RequestBody Owners owner) {
        ownerService.deleteOwner(owner);
    }

    @PutMapping(path = "/put")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void updateCat(@RequestBody Owners owner) {
        ownerService.updateOwner(owner);
    }

    @GetMapping(path = "/get_all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Owners> findAllCats() {
        return ownerService.findAllOwners();
    }
}
