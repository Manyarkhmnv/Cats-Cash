package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cats")
public class Cats {
    static long ID = 0;
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cat_id;
    @Column(name = "name")
    private String cat_name;
    @Column (name = "breed")
    private String breed;

    @Column (name = "color")
    private String color;

    @Column (name = "owner_id")
    private Long owner_id;

    @OneToMany
    private List<Friends> my_friends;

    public void setOwner(Owners owner) {
        this.owner_id = owner.getOwner_id();
    }

    @Override
    public String toString() {
        return color + " " + breed;
    }
}