package org.example.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "friends")
public class Friends {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long relation_id;

    @Column(name = "friend1")
    private Long friend1;
    @Column(name = "friend2")
    private Long friend2;

    public Friends() {
    }

    public Friends(Long id, Long id1, Long id2) {
        this.relation_id = id;
        this.friend1 = id1;
        this.friend2 = id2;
    }

    @Override
    public String toString() {
        return friend1 + " " + friend2;
    }
}