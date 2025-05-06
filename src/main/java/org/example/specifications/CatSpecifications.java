package org.example.specifications;

import org.example.models.Cats;
import org.springframework.data.jpa.domain.Specification;

public class CatSpecifications {
    public static Specification<Cats> hasOwnerId(Long ownerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner_id"), ownerId);
    }
}