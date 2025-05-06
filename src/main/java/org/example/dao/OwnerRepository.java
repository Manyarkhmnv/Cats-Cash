package org.example.dao;

import org.example.models.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owners, Long> {
}
