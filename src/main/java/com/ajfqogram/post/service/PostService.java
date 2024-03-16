package com.ajfqogram.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ajfqogram.common.FileManager;
import com.ajfqogram.post.domain.Post;
import com.ajfqogram.post.dto.PostDetail;
import com.ajfqogram.post.repository.PostRepository;
import com.ajfqogram.user.domain.User;
import com.ajfqogram.user.service.UserService;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired 
	private UserService userService;	
	
	public Post addPost(int userId, String contents, MultipartFile file) {
		
		String filePath = FileManager.saveFile(userId, file);
		
		Post post = Post.builder()
						.userId(userId)
						.contents(contents)
						.imagePath(filePath)
						.build();
		
		return postRepository.save(post);
	}
	
	// 등록 내림 차순으로 조회된 결과 돌려주는 기능
		public List<PostDetail> getPostList() {
			List<Post> postList = postRepository.findAllByOrderByIdDesc();
			
			List<PostDetail> postDetailList = new ArrayList<>();
			
			for(Post post:postList) {
				
				int userId = post.getUserId();
				User user = userService.getUserById(userId);
			
				PostDetail postDetail = PostDetail.builder()
											.postId(post.getId())
											.userId(userId)
											.userLoginId(user.getLoginId())
											.contents(post.getContents())
											.imagePath(post.getImagePath())
											.build();
				
				postDetailList.add(postDetail);
			}
			
			return postDetailList;
			
			
		
		
	}
	
	
}
