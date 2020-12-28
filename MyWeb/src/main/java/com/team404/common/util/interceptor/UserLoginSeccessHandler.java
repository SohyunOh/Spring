package com.team404.common.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.team404.command.UserVO;

public class UserLoginSeccessHandler extends HandlerInterceptorAdapter{
	//로그인 이후에 실행되는 핸들러 (postHandle) 오버라이딩
	//1. login 요청으로 들어올 때 실행되도록 등록
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//인터셉터클래스에 등록 설정하기
		//login맵핑 컨트롤러에서는  modelAndView 를 반환합니다 - 뷰와 모델을 같이 반환하는 방법
		//modelAndView 객체에 있는 모델데이터가 map 의 형식으로 반환
		//반환은 void 형
		ModelMap mv = modelAndView.getModelMap();//ModelMap() 타입으로 가져옴
		UserVO userVO = (UserVO) mv.get("login"); //model에 담겨있는 userVO 를 꺼냅니다 - login이 성공실패값을 가짐 
//		String msg = (String)mv.get("msg"); //로그인 실패시

		
		if(userVO != null) {//로그인성공
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			
			//홈으로 경로 응답
			response.sendRedirect(request.getContextPath());
			
		}
		
	}

	
}
