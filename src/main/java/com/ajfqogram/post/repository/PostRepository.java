package com.ajfqogram.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajfqogram.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	// Order by `id` desc
	public List<Post> findAllByOrderByIdDesc();
	
}
