package com.team404.user.service;

import com.team404.command.UserVO;

public interface UserService {
	
	public int idCheck(UserVO vo);
	public int join(UserVO vo);
//	public UserVO login(String id, String pw);
	public UserVO login(UserVO vo);
	public UserVO getInfo(String userId);

	
}
