package com.ahmet.controller;

import com.ahmet.repository.criteriaquery.PostRepository;
import com.ahmet.repository.entity.Post;
import com.ahmet.repository.utility.HibernateUtility;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PostController {

    public static void main(String[] args) {

//        createPost();
        PostRepository postRepository = new PostRepository();
        postRepository.postCountOfEachUser();
        System.out.println("-----");
        postRepository.postCountOfEachUserGreaterThan3();

    }//MAIN ENDS HERE ----

    public static void createPost() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Post post = Post.builder()
                .content("içerik1")
                .userid(1L)
                .build();
        Post post2 = Post.builder()
                .content("içerik2")
                .userid(2L)
                .build();
        Post post3 = Post.builder()
                .content("içerik3")
                .userid(3L)
                .build();
        Post post4 = Post.builder()
                .content("içerik4")
                .userid(4L)
                .build();
        Post post5 = Post.builder()
                .content("içerik5")
                .userid(5L)
                .build();
        Post post6 = Post.builder()
                .content("içerik6")
                .userid(4L)
                .build();
        Post post7 = Post.builder()
                .content("içerik7")
                .userid(4L)
                .build();
        Post post8 = Post.builder()
                .content("içerik8")
                .userid(4L)
                .build();
        Post post9 = Post.builder()
                .content("içerik9")
                .userid(5L)
                .build();
        Post post10 = Post.builder()
                .content("içerik10")
                .userid(5L)
                .build();
        Post post11 = Post.builder()
                .content("içerik11")
                .userid(5L)
                .build();
        Post post12 = Post.builder()
                .content("içerik12")
                .userid(1L)
                .build();

        session.save(post);
        session.save(post2);
        session.save(post3);
        session.save(post4);
        session.save(post5);
        session.save(post6);
        session.save(post7);
        session.save(post8);
        session.save(post9);
        session.save(post10);
        session.save(post11);
        session.save(post12);

        transaction.commit();
        session.close();
    }

}//CLASS ENDS HERE ----
