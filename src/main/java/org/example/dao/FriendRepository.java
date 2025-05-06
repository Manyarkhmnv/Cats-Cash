package org.example.dao;

import org.example.models.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<Friends, Long> {
}
