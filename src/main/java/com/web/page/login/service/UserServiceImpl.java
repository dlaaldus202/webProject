package com.web.page.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.page.login.domin.UserVo;
import com.web.page.login.persistence.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserVo getUser(UserVo user) {
		Optional<UserVo> findUser = userRepository.findById(user.getId());
		if(findUser.isPresent()) {
			return findUser.get();
		} 
		return null;
	}

}
