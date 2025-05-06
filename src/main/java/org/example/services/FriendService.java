package org.example.services;

import org.example.dao.FriendDao;
import org.example.models.Friends;


import java.util.List;

public class FriendService {

    private FriendDao friendsDao = new FriendDao();

    public FriendService() {
    }

    public Friends findFriend(Long id) {
        return friendsDao.findById(id);
    }

    public void saveFriend(Friends friend) {
        friendsDao.save(friend);
    }

    public void deleteFriend(Friends friend) {
        friendsDao.delete(friend);
    }

    public void updateFriend(Friends friend) {
        friendsDao.update(friend);
    }

    public List<Friends> findAllUsers() {
        return friendsDao.findAll();
    }

    public Friends findFriendById(Long id) {
        return friendsDao.findFriendById(id);
    }


}