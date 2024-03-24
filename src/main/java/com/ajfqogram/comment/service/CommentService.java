package com.ajfqogram.comment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajfqogram.comment.domain.Comment;
import com.ajfqogram.comment.dto.CommentDetail;
import com.ajfqogram.comment.repository.CommentRepository;
import com.ajfqogram.user.domain.User;
import com.ajfqogram.user.service.UserService;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserService userService;
	
	public Comment addComment(int userId, int postId, String contents) {
		
		Comment comment = Comment.builder()
								.userId(userId)
								.postId(postId)
								.contents(contents)
								.build();
		
		
		return commentRepository.save(comment);
	}
	
	public List<CommentDetail> getCommentList(int postId) {
		
		List<Comment> commentList = commentRepository.findByPostIdOrderByIdDesc(postId);
		
		List<CommentDetail> commentDetailList = new ArrayList<>();
		for(Comment comment:commentList) {
			
			User user = userService.getUserById(comment.getUserId());
			
			CommentDetail commentDetail = CommentDetail.builder()
												.commentId(comment.getId())
												.postId(comment.getPostId())
												.userId(comment.getUserId())
												.contents(comment.getContents())
												.userLoginId(user.getLoginId())
												.build();
			
			commentDetailList.add(commentDetail);
		}
		
		return commentDetailList;
	}
	
	public void deleteCommentByPostId(int postId) {
		commentRepository.deleteByPostId(postId);
	}
	

}