package ch.css.testing.adapter;


import ch.css.testing.adapter.post.PostEntity;
import ch.css.testing.adapter.user.UserEntity;
import ch.css.testing.adapter.vote.VoteEntity;
import ch.css.testing.adapter.vote.VoteEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
@Transactional()
public class DatabaseInitializer {

    @PersistenceContext
    EntityManager em;

    Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        logger.info("Starting DB initialization");
        try {
            fill();
        } catch (Exception e) {
            logger.error("DB initialisation failed: " + e.getMessage());
        }


    }

    @Transactional
    void fill() {

        UserEntity joshua = new UserEntity(null, "Odermatt", "Joshua", 18, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());

        UserEntity noah = new UserEntity( null , "Buchs", "Noah", 18, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());

        UserEntity dawid = new UserEntity(null, "Kapka", "David", 18, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());

        UserEntity leonie = new UserEntity(null, "Roth", "Leonie", 18, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());

        em.persist(joshua);

        em.persist(noah);

        em.persist(dawid);

        em.persist(leonie);



        PostEntity post01 = new PostEntity(null, "Hallo Welt!", new Date().getTime(), joshua, Collections.emptyList());

        PostEntity post02 = new PostEntity(null, "Ich mag AI", new Date().getTime(), noah, Collections.emptyList());

        em.persist(post01);

        em.persist(post02);

        VoteEntity vote01 = new VoteEntity(null, VoteEnum.UPVOTE, post02, noah);

        VoteEntity vote02 = new VoteEntity(null, VoteEnum.UPVOTE, post02, dawid);

        VoteEntity vote03 = new VoteEntity(null, VoteEnum.UPVOTE, post01, leonie);

        VoteEntity vote04 = new VoteEntity(null, VoteEnum.UPVOTE, post02, noah);

        leonie.setFriends(List.of(joshua, noah, dawid));

        noah.setFriends(List.of(joshua, dawid, leonie));

        dawid.setFriends(List.of(noah, leonie));


        em.persist((joshua));
        em.persist((noah));
        em.persist((dawid));
        em.persist((leonie));



    }
}
