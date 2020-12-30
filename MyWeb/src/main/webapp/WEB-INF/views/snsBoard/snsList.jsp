<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	section {
		margin-top: 70px;
	}
	
	</style>
	
</head>
<body>

	<section>
		<div class="container">
			<div class="row">
				<aside class="col-sm-2">
					<div class="aside-inner">
						<div class="menu1">
							<p>
								<img src="../resources/img/profile.png">오소현
							</p>
							<ul>
								<li>내정보</li>
								<li>내쿠폰</li>
								<li>내좋아요게시물</li>
							</ul>
						</div>
						<div class="menu2">
							<p>둘러보기</p>
							<ul>
								<li>기부 캠페인</li>
								<li>페이지</li>
								<li>그룹</li>
								<li>이벤트</li>
								<li>친구리스트</li>
							</ul>
						</div>
					</div>
				</aside>
				<div class="col-xs-12 col-sm-8 section-inner">
					<h4>게시물 만들기</h4>
					<!-- 파일 업로드 폼입니다 -->
					<div class="fileDiv">
								<img id="fileImg" src="../resources/img/img_ready.png">
							</div>
							<div class="reply-content">
								<textarea class="form-control" rows="3" name="content"
									id="content" placeholder="무슨 생각을 하고 계신가요?"></textarea>
								<div class="reply-group">
									<div class="filebox pull-left">
										<label for="file">이미지업로드</label> 
										<input type="file" name="file" id="file">
									</div>
									<button type="button" class="right btn btn-info" id="uploadBtn">등록하기</button>
								</div>
							</div>
		
		
							<!-- 파일 업로드 폼 끝 -->
							<div id="contentDiv">
							
							
						<!-- 	<div class="title-inner">
								<div class="profile">
									<img src="../resources/img/profile.png">
								</div>
								<div class="title">
									<p>테스트</p>
									<small>21시간</small>
								</div>
							</div>
							<div class="content-inner">
							
								<p>삶이 우리를 끝없이 시험하기에 고어텍스는 한계를 테스트합니다</p>
							</div>
							<div class="image-inner">
						
								<img src="../resources/img/facebook.jpg">
								
							</div>
							<div class="like-inner">
						
								<img src="../resources/img/icon.jpg"> <span>522</span>
							</div>
							<div class="link-inner">
								<a href="##"><i class="glyphicon glyphicon-thumbs-up"></i>좋아요</a>
								<a href="##"><i class="glyphicon glyphicon-comment"></i>댓글달기</a> 
								<a href="##"><i class="glyphicon glyphicon-remove"></i>삭제하기</a>
							</div> -->
							
							
					</div>
				</div>
				<!--우측 어사이드-->
				<aside class="col-sm-2">
					<div class="aside-inner">
						<div class="menu1">
							<p>목록</p>
							<ul>
								<li>목록1</li>
								<li>목록2</li>
								<li>목록3</li>
								<li>목록4</li>
								<li>목록5</li>
							</ul>
						</div>
					</div>
				</aside>
			</div>
		</div>
	</section>

	<!-- 모달 -->
	<div class="modal fade" id="snsModal" role="dialog">
			<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-body row">
					<div class="modal-img col-sm-8 col-xs-6" >
						<img src="../resources/img/img_ready.png" id="snsImg" width="100%">
					</div>
					<div class="modal-con col-sm-4 col-xs-6">
						<div class="modal-inner">
						<div class="profile">
							<img src="../resources/img/profile.png">
						</div>
						<div class="title">
							<p id="snsWriter">테스트</p>
							<small id="snsRegdate">21시간전</small>
						</div>
						<div class="content-inner">
							<p id="snsContent">삶이 우리를 끝없이 시험하기에 고어텍스는 한계를 테스트합니다</p>
						</div>
						<div class="link-inner">
							<a href="##"><i class="glyphicon glyphicon-thumbs-up"></i>좋아요</a>
							<a href="##"><i class="glyphicon glyphicon-comment"></i>댓글달기</a> 
							<a href="##"><i class="glyphicon glyphicon-share-alt"></i>공유하기</a>
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<!-- 비동기 파일 업로드 -->
<script>

$(document).ready(function () {
	$("#uploadBtn").click(regist);

	function regist() {
		//회원만 등록 가능하도록 처리
		var writer = "${sessionScope.userVO.userId}";
		var file = $("#file").val();
		
		
		//파일 확장자체크
		file = file.substring(file.lastIndexOf('.')+1,file.length).toLowerCase();
		console.log(file);
		
		if(file != "jpg" && file != "png" && file != "jpeg"){
			alert("이미지(jpg,png,jpeg)만 등록이 가능합니다")
			return;
		} else if(writer == ''){ //세션이 없다면
			alert("로그인 필요한 서비스입니다")
			return;
		}

		//파일비동기 전송시 반드시 필요한  FormData()객체 생성
		var data = $("#file")
		console.log(data[0]);
		console.log(data[0].files);//파일 태그에 담긴 파일을 확인하는 키값
		console.log(data[0].files[0]); //전손해야되는 파일데이터의 정보
		
		var content = $("#content").val();
		var formData = new FormData();
		formData.append("file",data[0].files[0]); //file이름으로 file저장
		formData.append("content", content);
		
		$.ajax({
			type: "POST",
			url: "upload",
			processData: false, //폼형식이  &변수= 값의 현태로 변경되는것을 막는다.
			contentType: false, //false로 지정하면 기본적으로 "multipart/form-data"으로 선언됨
			data: formData, //폼데이터객체
			success: function (result) {
				if(result === 'success'){
					$("#file").val("");// 데이터 초기화
					$("#content").val("")//content 초기화
					$(".fileDiv").css("display", "none"); //미리보기 숨기기
					getList();//호출 목록
				}else {
					alert("업로드 실패, 관리자에게 문의하세요");
				}
			},
			error:function(status,error){}

		})
	}; //등록 end
	
	//리스트 작업
	getList(); //호출
	function getList() {
		
		$.getJSON("getList", function(list) {
			//서버에서 비동기 요청을 받아서 getList()를 이용해서 데이터를 전부 조회
			//화면에 그리는 작업을 처리.
			
			var str = "";
			for(var i = 0; i < list.length; i++) {
				str += '<div class="title-inner">';
				str += '<div class="profile">';
				str += '<img src="../resources/img/profile.png">';
				str += '</div>';
				str += '<div class="title">';
				str += '<p>'+ list[i].writer +'</p>';
				str += '<small>'+ list[i].regdate +'</small>';
				//파일 다운로드
				str += '<a href="download/'+ list[i].fileLoca + "/"+ list[i].fileName +'">이미지다운로드</a>';
				//파일 다운로드 끝
				str += '</div>';
				str += '</div>';
				str += '<div class="content-inner">';
				str += '<p>'+ (list[i].content == null ? '': list[i].content ) +'</p>';
				str += '</div>';
				str += '<div class="image-inner">';
				str += '<img src="display/'+ list[i].fileLoca +"/"+ list[i].fileName +'">';
				str += '</div>';
				str += '<div class="like-inner">';
				str += '<img src="../resources/img/icon.jpg"> <span>522</span>';
				str += '</div>';
				str += '<div class="link-inner">';
				str += '<a href="##"><i class="glyphicon glyphicon-thumbs-up"></i>좋아요</a>';
				str += '<a href="##"><i class="glyphicon glyphicon-comment"></i>댓글달기</a>'; 
				str += '<a href="##"><i class="glyphicon glyphicon-remove"></i>삭제하기</a>';
				str += '</div>';						
			} //end for
			$("#contentDiv").html(str);
			
			
		});
		
		
		
	}
	
	
	
});
</script>



	<script>
		//자바 스크립트 파일 미리보기 기능
		function readURL(input) {
        	if (input.files && input.files[0]) {
        		
            	var reader = new FileReader(); //비동기처리를 위한 파읽을 읽는 자바스크립트 객체
            	//readAsDataURL 메서드는 컨텐츠를 특정 Blob 이나 File에서 읽어 오는 역할 (MDN참조)
	        	reader.readAsDataURL(input.files[0]); 
            	//파일업로드시 화면에 숨겨져있는 클래스fileDiv를 보이게한다
	            $(".fileDiv").css("display", "block");
            	
            	reader.onload = function(event) { //읽기 동작이 성공적으로 완료 되었을 때 실행되는 익명함수
                	$('#fileImg').attr("src", event.target.result); 
                	console.log(event.target);//event.target은 이벤트로 선택된 요소를 의미
	        	}
        	}
		}
		$("#file").change(function() {
	        readURL(this); //this는 #file자신 태그를 의미
	        
	    });
	</script>
	
	