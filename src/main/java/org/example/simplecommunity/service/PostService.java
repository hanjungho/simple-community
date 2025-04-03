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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        try {
            posts.setNickname(nickname);
            posts.setPassword(password);
            posts.setTitle(title);
            posts.setContents(contents);
            entityManager.persist(posts);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
