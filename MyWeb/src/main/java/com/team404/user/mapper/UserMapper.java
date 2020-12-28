package com.team404.user.mapper;

import org.apache.ibatis.annotations.Param;

import com.team404.command.UserVO;

public interface UserMapper {

	public int idCheck(UserVO vo);
	public int join(UserVO vo);
//	public UserVO login(@Param("id") String id, @Param("pw") String pw);
	public UserVO login(UserVO vo);
	public UserVO getInfo(String userId);
}
