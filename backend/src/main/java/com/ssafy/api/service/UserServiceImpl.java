package com.ssafy.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.db.entity.Users;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.UserRepositorySupport;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRepositorySupport userRepositorySupport;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Users createUsers(UserRegisterPostReq userRegisterInfo) {
		Users user = new Users();
		user.setUserId(userRegisterInfo.getEmail());
		// 보안을 위해서 유저 패스워드 암호화 하여 디비에 저장.
		user.setPassword(passwordEncoder.encode(userRegisterInfo.getPassword()));
		user.setGrade("GENERAL");
		user.setNickname(userRegisterInfo.getNickname());
		return userRepository.save(user);
	}

	@Override
	public Users getUsersByUserId(String userId) {
		// 디비에 유저 정보 조회 (userId 를 통한 조회).
		Users user = userRepositorySupport.findUserByUserId(userId).get();
		return user;
	}
}
