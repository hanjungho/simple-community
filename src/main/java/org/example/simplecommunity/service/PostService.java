package org.example.simplecommunity.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.simplecommunity.model.dto.CommunityPosts;

public class PostService {
    CommunityPosts posts;

    public PostService() {
        this.posts = new CommunityPosts();
    }

    public void post(String nickname, String password, String title, String contents) {
        //EntityManagerFactory 생성
        EntityManager entityManager;
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit")) {
            //EntityManager 생성
            entityManager = emf.createEntityManager();
        }
        //EntityTransaction 생성
        EntityTransaction tx = entityManager.getTransaction();
        //트랜잭션 시작
        tx.begin();

        try {
            posts.setNickname(nickname);
            posts.setPassword(password);
            posts.setTitle(title);
            posts.setContents(contents);
            entityManager.persist(posts);
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            tx.commit();
        }
    }
}
