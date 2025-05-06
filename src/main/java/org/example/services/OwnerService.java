package org.example.services;

import lombok.AllArgsConstructor;
import org.example.dao.OwnerRepository;
import org.example.models.Cats;
import org.example.models.Owners;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    @Transactional
    public ResponseEntity<Owners> findOwner(Long id) {
        Owners owner = ownerRepository.findById(id).orElse(null);
        if (owner != null) {
            return ResponseEntity.ok(owner);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    public void saveOwner(Owners owner) {
        ownerRepository.save(owner);
    }

    @Transactional
    public void deleteOwner(Owners owner) {
        ownerRepository.delete(owner);
    }

    @Transactional
    public void updateOwner(Owners updated_owner) {
        Owners owner = ownerRepository.findById(updated_owner.getOwner_id()).orElseThrow();

        owner.setFirst_name(updated_owner.getFirst_name());
        owner.setLast_name(updated_owner.getLast_name());
        owner.setCats(updated_owner.getCats());
        ownerRepository.save(owner);
    }

    @Transactional
    public List<Owners> findAllOwners() {
        return ownerRepository.findAll();
    }
}