package com.ajfqogram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajfqogram.user.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,@RequestParam("name") String name
			,@RequestParam("email") String email) 
	{
		int count = userService.addUser(loginId, password, name, email);
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	// id 중복확인 API
	@GetMapping("/user/dup-id")
	public Map<String, Boolean> isDupId(@RequestParam("loginId") String loginId) {
		boolean isDup = userService.isDupId(loginId);
		Map<String, Boolean> resultMap = new HashMap<>();
//		if(isDup) {
//			resultMap.put("isDupId", true);
//		} else {
//			resultMap.put("isDupId", false);
//		}
		resultMap.put("isDupId", isDup);
		return resultMap;
	}
	
	
}
