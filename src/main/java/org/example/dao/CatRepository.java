package org.example.dao;

import org.example.models.Cats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CatRepository extends JpaRepository<Cats, Long>, JpaSpecificationExecutor<Cats> {
}
