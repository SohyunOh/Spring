<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    <section>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-9 write-wrap">
                        <div class="titlebox">
                            <p>수정하기</p>
                        </div>
                        
                        <form action="freeUpdate" method="post" name="freeUpdate">
                            <div>
                                <label>DATE</label>
                                <p><fmt:formatDate value="${vo.regdate }" pattern="yyyy년MM월dd일"/></p>
                            </div>   
                            <div class="form-group">
                                <label>번호</label>
                                <input class="form-control" name='bno' value="${vo.bno }" readonly>
                            </div>
                            <div class="form-group">
                                <label>작성자</label>
                                <input class="form-control" name='writer' value="${vo.writer }" readonly>
                            </div>    
                            <div class="form-group">
                                <label>제목</label>
                                <input class="form-control" name='title' value="${vo.title }">
                            </div>

                            <div class="form-group">
                                <label>내용</label>
                                <textarea class="form-control" rows="10" name='content'>${vo.content }</textarea>
                            </div>

                            <button type="button" class="btn btn-dark" id="listBtn">목록</button>    
                            <button type="button" class="btn btn-primary" id="updateBtn">변경</button>
                            <button type="button" class="btn btn-info" id="deleteBtn">삭제</button>
                    </form>
                </div>
            </div>
        </div>
   </section>

   <script>
   		var listBtn = document.getElementById("listBtn");
   		listBtn.onclick = function() {
   			location.href = 'freeList'; //리스트화면으로
   		}
   		
   		var updateBtn = document.getElementById("updateBtn");
   		updateBtn.onclick = function() {
   			/*
   			1. null을 허용하지 않는 태그의 공백값을 확인하고, 공백이 없으면 freeUpdate요청으로 데이터를 전송.
   			2. int update()메서드를 이용해서 글정보를 수정해주세요.
   			3. 컨트롤러에서는 업데이트 성공시 리스트 화면에 msg를 이용해서 "게시글이 수정되었습니다 or 실패했습니다" 정보를 보내주세요.
   			*/
   			if(document.freeUpdate.writer.value === '') {
   				alert("작성자는 필수 입니다");
   				document.freeUpdate.writer.focus();
   				return;
   			} else if(document.freeUpdate.title.value === '') {
   				alert("제목은 필수 입니다");
   				document.freeUpdate.title.focus();
   				return;
   			} else {
   				document.freeUpdate.action = "freeUpdate"; //폼값의 action을 지정
   				document.freeUpdate.submit(); //서브밋
   			}
   		}
   		
   		var deleteBtn = document.getElementById("deleteBtn");
   		deleteBtn.onclick = function() {
   			
   			document.freeUpdate.action = "freeDelete"; //폼값의 action을 지정
   			document.freeUpdate.submit(); //서브밋
   		}
   		
   		
   </script>
   
   
   
   