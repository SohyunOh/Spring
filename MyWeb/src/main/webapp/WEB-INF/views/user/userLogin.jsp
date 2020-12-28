<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7 col-xs-10 login-form">
                    <div class="titlebox">
                        	로그인
                    </div>
                    <form action="login" method="post" id="loginForm" >
                        <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" id="userId" name="userId" placeholder="아이디" required>
                         </div>
                         <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">비밀번호</label>
                            <input type="password" class="form-control" id="userPw" name="userPw" placeholder="비밀번호" required>
                            </div>
                         <div class="form-group">
                            <button type="submit" class="btn btn-info btn-block" id="loginBtn" >로그인</button>
                            <button type="button" class="btn btn-primary btn-block" onclick="locaion.href=userJoin">회원가입</button>
                         </div>
                    </form>   
                    <span>${msg }</span>
                </div>
            </div>
        </div>
    </section>

    
    <script>
    	var msg = "${msg}";
    	if(msg != "") {
    		alert(msg);
    	}
    	
    	
/*     	$("#loginBtn").click(function() {
    	      if( $("#id").val() === "" || $("#pw").val() === "" ){
    	         alert("아이디와 비밀번호를 입력하세요")
    	      }else{
    	         $("#loginForm").submit();
    	      }
    	   }) */
    	
    	
    	
    </script>
    
    
    
    
    
    
    
    
    
    
    