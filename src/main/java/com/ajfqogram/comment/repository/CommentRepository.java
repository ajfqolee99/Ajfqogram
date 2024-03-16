package com.ajfqogram.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajfqogram.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
