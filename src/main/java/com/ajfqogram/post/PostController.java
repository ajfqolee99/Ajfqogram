package com.ajfqogram.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
	
	@GetMapping("/post/timeline-view")
	public String postList() {
		return "post/timeline";
	}
	
	
}
