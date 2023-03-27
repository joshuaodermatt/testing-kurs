package ch.css.testing.adapter.post;


import ch.css.testing.adapter.user.UserEntity;
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
public class PostEntity {

    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String message;

    @Column
    Long timestamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;

    @OneToMany(mappedBy = "post")
    List<VoteEntity> votes;
}
