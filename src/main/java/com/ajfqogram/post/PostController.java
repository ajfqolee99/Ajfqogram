package com.ajfqogram.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ajfqogram.post.dto.PostDetail;
import com.ajfqogram.post.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/post/timeline-view")
	public String postList(Model model) {
		
		List<PostDetail> postList = postService.getPostList();
		model.addAttribute("postList", postList);
		return "post/timeline";
	}
	
	
}
