package com.team404.user.service;

import com.team404.command.UserVO;

public interface UserService {
	
	public int idCheck(UserVO vo);
	public int join(UserVO vo);
	public int login(UserVO vo);

	
}
