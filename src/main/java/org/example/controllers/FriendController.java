package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.models.Friends;
import org.example.services.FriendService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("friends")
@AllArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Friends> findFriend(@PathVariable(name = "id") Long id) {
        return friendService.findFriend(id);
    }

    @PostMapping(path = "/create")
    public void saveFriend(@RequestBody Friends friends) {
        friendService.saveFriend(friends);
    }

    @DeleteMapping(path = "/delete")
    public void deleteCat(@RequestBody Friends friends) {
        friendService.deleteFriend(friends);
    }

    @PutMapping(path = "/put")
    public void updateCat(@RequestBody Friends friends) {
        friendService.updateFriend(friends);
    }

    @GetMapping(path = "/get_all")
    public List<Friends> findAllCats() {
        return friendService.findAllUsers();
    }
}
