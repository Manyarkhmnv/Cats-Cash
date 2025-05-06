package org.example.dao;

import org.example.models.Cats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cats, Long> {
}
