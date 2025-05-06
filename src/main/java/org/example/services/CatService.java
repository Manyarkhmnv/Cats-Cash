package org.example.services;

import com.sun.security.auth.UserPrincipal;
import lombok.AllArgsConstructor;
import org.example.dao.CatRepository;
import org.example.dao.UserRepository;
import org.example.models.Cats;
import org.example.models.Users;
import org.example.specifications.CatSpecifications;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CatService {

    private final CatRepository catRepository;
    private final UserRepository userRepository;

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
    public List<Cats> findMyCats() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Long id = ((MyUserDetails) auth.getPrincipal()).getOwnerId();
            List<Cats> myCats = catRepository.findAll(CatSpecifications.hasOwnerId(id));
            return myCats;
    }
    @Transactional
    public List<Cats> findAllCats() {
        return catRepository.findAll();
    }
}