package com.ajfqogram.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajfqogram.common.EncryptUtils;
import com.ajfqogram.user.domain.User;
import com.ajfqogram.user.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int addUser(String loginId, String password, String name, String email) {
		
		// 암호화
		String encryptPassword = EncryptUtils.md5(password);
		
		return userRepository.insertUser(loginId, encryptPassword, name, email);
	}
	
	// 전달받은 loginId 값이 중복되었는지 알려주는 기능
	public boolean isDupId(String loginId) {
		int count = userRepository.selectCountByLoginId(loginId);
		if(count >= 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public User getUser(String loginId, String password) {
		
		String encryptPassword = EncryptUtils.md5(password);
		return userRepository.selectUser(loginId, encryptPassword);
	}
	
	
	public User getUserById(int id) {
		return userRepository.selectUserById(id);
	}
	
}
