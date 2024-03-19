package com.ajfqogram.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ajfqogram.post.dto.PostDetail;
import com.ajfqogram.post.service.PostService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/post/timeline-view")
	public String timeline(
			HttpSession session
			, Model model) {
		
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<PostDetail> postList = postService.getPostList(userId);
		
		model.addAttribute("postList", postList);
		
		return "post/timeline";
	}

}