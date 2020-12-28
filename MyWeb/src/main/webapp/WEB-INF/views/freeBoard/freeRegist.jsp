<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <section>
       <div class="container">
            <div class="row">
                <div class="col-xs-12 content-wrap">
                    <div class="titlebox">
                        <p>자유게시판</p>
                    </div>
                    
                    <form action="registForm" method="post" name="registForm">
                    <table class="table">
                        <tbody class="t-control">
                            <tr>
                                <td class="t-title">NAME</td>
                                <td><input class="form-control input-sm" name="writer" value="${sessionScope.userVO.userId }" readonly><span id="msgId"></span></td>
                            </tr>
                            <tr>
                                <td class="t-title">TITLE</td>
                                <td><input class="form-control input-sm" name="title"><span id="msgTitle"></span> </td>
                                
                            </tr>
                            <tr>
                                <td class="t-title">COMMNET</td>
                                <td>
                                <textarea class="form-control" rows="7" name="content"></textarea>
                                </td>                 
                            </tr>
                        </tbody>
                    </table>
                    <div class="titlefoot">
                        <button class="btn" type="button" onclick="regist()">등록</button>
                        <button class="btn" type="button" onclick="location.href='freeList' ">목록</button>
                    </div>
                    </form>
                </div>
            </div>    
       </div>
    </section>

    <script>
    	//form태그는 이름으로 접근
		function regist() {
    		if(document.registForm.writer.value === '') {
    			document.getElementById("msgId").innerHTML = "아이디는 필수 입니다";
    			document.registForm.writer.focus();
    			return;
    		} else if(document.registForm.title.value === '') {
    			document.getElementById("msgTitle").innerHTML = "제목은 필수 입니다";
    			document.registForm.title.focus();
    			return;
    		} else {
    			document.registForm.submit(); //서브밋
    		}
			 		
		}    
    </script>
    
    
    
    
    
    
    