package org.example.services;

import lombok.AllArgsConstructor;
import org.example.dao.CatRepository;
import org.example.models.Cats;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CatService {

    private final CatRepository catRepository;

    @Transactional
    public ResponseEntity<Cats> findCat(Long id) {
        Cats cat = catRepository.findById(id).orElse(null);
        if (cat != null) {
            return ResponseEntity.ok(cat);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    public void saveCat(Cats cat) {
        catRepository.save(cat);
    }

    @Transactional
    public void deleteCat(Cats cat) {
        catRepository.delete(cat);
    }

    @Transactional
    public void updateCat(Cats updated_cat) {
        Cats cat = catRepository.findById(updated_cat.getCat_id()).orElseThrow();

        cat.setCat_name(updated_cat.getCat_name());
        cat.setBreed(updated_cat.getBreed());
        cat.setColor(updated_cat.getColor());
        cat.setOwner_id(updated_cat.getOwner_id());
        catRepository.save(cat);
    }

    @Transactional
    public List<Cats> findAllCats() {
        return catRepository.findAll();
    }
}