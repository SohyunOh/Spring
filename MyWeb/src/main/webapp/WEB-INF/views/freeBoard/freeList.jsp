<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

    <section>
        <div class="container-fluid">
            <div class="row">
                <!--lg에서 9그리드, xs에서 전체그리드-->   
                <div class="col-lg-9 col-xs-12 board-table">
                    <div class="titlebox">
                        <p>자유게시판</p>
                    </div>
                    <hr>
                    
                    <!--form select를 가져온다 -->
                    <form>
		    <div class="search-wrap">
                       <button type="button" class="btn btn-info search-btn">검색</button>
                       <input type="text" class="form-control search-input">
                       <select class="form-control search-select">
                            <option>제목</option>
                            <option>내용</option>
                            <option>작성자</option>
                            <option>제목+내용</option>
                       </select>
                    </div>
		    </form>
                   
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th class="board-title">제목</th>
                                <th>작성자</th>
                                <th>등록일</th>
                                <th>수정일</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="vo" items="${list }">
                            <tr>
                                <td>${vo.bno }</td>
                                <td><a href="freeDetail?bno=${vo.bno }">${vo.title }</a></td>
                                <td>${vo.writer }</td>
                                <td>
                                <fmt:formatDate value="${vo.regdate }" pattern="yyy년 MM월 dd일  hh시 mm분 ss초"/> 
                                </td>
                                <td>
                                <fmt:formatDate value="${vo.updatedate }" pattern="yyy년 MM월 dd일  hh시 mm분 "/>
                                </td>
                            </tr>
                            </c:forEach>
                           
                        </tbody>
                        
                    </table>


                    <!--페이지 네이션을 가져옴-->
		    <form>
                    <div class="text-center">
                    <hr>
                    <ul class="pagination pagination-sm">
                        <li><a href="#">이전</a></li>
                        <li  class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">다음</a></li>
                    </ul>
                    <button type="button" class="btn btn-info" onclick="location.href='freeRegist'">글쓰기</button>
                    </div>
		    </form>

                </div>
            </div>
        </div>
	</section>

<script type="text/javascript">
	window.onload = function () {
		//state 현재 브라우저의 상태값
		if(history.state === '') return;
		
		var msg = "${msg}";// 컨트롤러레서 넘어온 메시지
		if(msg != ''){			
		alert(msg);
		//replaceState 페이지를 갈라끼움
		//브라우저의 기록을 새롭게 변경(데이터, 페이지 제목, 변경할 주소(url))
		//이렇게 변경된 기록정보는  replaceState 객체를 통해서 확인이 가능합니다.
		history.replaceState('', null, null );
		
		}
		
		
	}
</script>
