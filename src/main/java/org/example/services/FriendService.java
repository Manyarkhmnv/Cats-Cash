package org.example.services;

import lombok.AllArgsConstructor;
import org.example.dao.FriendRepository;
import org.example.models.Cats;
import org.example.models.Friends;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@AllArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;

    @Transactional
    public ResponseEntity<Friends> findFriend(Long id) {
        Friends friends = friendRepository.findById(id).orElse(null);
        if (friends != null) {
            return ResponseEntity.ok(friends);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    public void saveFriend(Friends friend) {
        friendRepository.save(friend);
    }

    @Transactional
    public void deleteFriend(Friends friend) {
        friendRepository.delete(friend);
    }

    @Transactional
    public void updateFriend(Friends updated_friend) {
        Friends friends = friendRepository.findById(updated_friend.getRelation_id()).orElseThrow();

        friends.setFriend1(updated_friend.getFriend1());
        friends.setFriend2(updated_friend.getFriend2());
        friendRepository.save(friends);
    }

    @Transactional
    public List<Friends> findAllUsers() {
        return friendRepository.findAll();
    }
}