package com.ajfqogram.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajfqogram.user.domain.User;
import com.ajfqogram.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	// 회원가입 API
	@PostMapping("/join")
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
	@GetMapping("/dup-id")
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
	
	// 로그인 API
	@PostMapping("/login")
	public Map<String, String> login(
			@RequestParam("loginId") String loginId
			,@RequestParam("password") String password
			,HttpServletRequest request
			)
	{
		User user = userService.getUser(loginId, password);
		Map<String, String> resultMap = new HashMap<>();
		if(user != null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			
			resultMap.put("result", "success");
		} else  {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
}
