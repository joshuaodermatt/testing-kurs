package ch.css.testing.adapter.user;


import ch.css.testing.adapter.post.PostEntity;
import ch.css.testing.adapter.vote.VoteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String surName;

    @Column
    String firstName;

    @Column
    int age;

    @ManyToMany()
    List<UserEntity> friends;

    @OneToMany(mappedBy = "user")
    List<PostEntity> posts;

    @OneToMany(mappedBy = "user")
    List<VoteEntity> votes;
}
