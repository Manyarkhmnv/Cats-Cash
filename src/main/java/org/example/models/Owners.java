package org.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "owners")
public class Owners {
    static long ID = 0;
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_sequence")
    //@SequenceGenerator(name = "owner_sequence", sequenceName = "OWNER_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long owner_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;

    @OneToMany
    private List<Cats> cats;

    public Owners() {
    }

    public Owners(long id, String name, String last_name) {
        this.owner_id = id;
        this.first_name = name;
        this.last_name = last_name;
        cats = new ArrayList<>();
    }

    public void addCat(Cats cat) {
        cat.setOwner(this);
        cats.add(cat);
    }

    public void removeAuto(Cats cat) {
        cats.remove(cat);
    }

    @Override
    public String toString() {
        return "org.example.models.User{" +
                "id=" + owner_id +
                ", name='" + first_name + '\'' +
                ", age=" + last_name +
                '}';
    }
}