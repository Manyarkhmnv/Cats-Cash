package org.example.models;

import lombok.Getter;
import lombok.Setter;
import org.example.services.FriendService;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cats")
public class Cats {
    static long ID = 0;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cat_id;
    @Column (name = "name")
    private String cat_name;
    @Column (name = "breed")
    private String breed;

    @Column (name = "color")
    private String color;

    @Column (name = "owner_id")
    private Long owner_id;

//    @OneToMany
//    private List<Friends> my_friends;

    public Cats() {
    }

    public Cats(long id, String name, String breed, String color, Owners owner) {
        this.breed = breed;
        this.color = color;
        this.cat_name = name;
        this.owner_id = owner.getOwner_id();
        this.cat_id = id;
    }

    public void addFriend(Cats cat, long id) {
        Friends friends = new Friends(id, this.cat_id, cat.cat_id);
        FriendService friendService = new FriendService();
        friendService.saveFriend(friends);

    }
    public void deleteFriend(Long id) {
        FriendService friendService = new FriendService();
        friendService.deleteFriend(friendService.findFriend(id));
    }

    public void setOwner(Owners owner) {
        this.owner_id = owner.getOwner_id();
    }

    @Override
    public String toString() {
        return color + " " + breed;
    }
}