package ch.css.testing.adapter.vote;


import ch.css.testing.adapter.post.PostEntity;
import ch.css.testing.adapter.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteEntity {
    @Id
    @Column(name = "vote_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    VoteEnum vote;

    @ManyToOne
    @JoinColumn(name = "post_id")
    PostEntity post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity user;
}
