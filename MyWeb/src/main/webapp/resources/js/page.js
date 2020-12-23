
		//$("#replyModal").modal("show");//모달창 보이게
		//$("#modalDelBtn").click(function(){
		//$("#replyModal").modal("hide");
		//})		
			//1. 제이쿼리 라이브러리 확인
			//2. 로딩이 끝난 직후 ready함수 안에 작성
			$(document).ready(function() {
				
				$("#replyRegist").click(add);
				
				
				//등록함수
				function add() {
					
					var bno = "${vo.bno}"; //문자열의 형태로 화면에서 넘어온 bno번호
					var reply = $("#reply").val(); //내용
					var replyId = $("#replyId").val(); //아이디
					var replyPw = $("#replyPw").val(); //비밀번호
					
					if(reply === '' || replyId === '' || replyPw === '') {
						alert("이름, 비밀번호, 내용을 입력하세요");
						return; //함수종료.
					}
					
					$.ajax({
						type: "POST", //요청방식
						url: "../reply/replyRegist", //요청주소
						data: JSON.stringify({"bno": bno, "reply": reply, "replyId": replyId, "replyPw": replyPw}) ,
						contentType: "application/json; charset=utf-8",
						success: function(data) {
							
							if(data === 1) { //등록성공
								$("#reply").val("");
								$("#replyId").val("");
								$("#replyPw").val("");
								alert("댓글 등록에 성공했습니다");
								getList(1, true); //목록요청 호출
							} else { //등록실패
								alert("등록에 실패했습니다. 잠시후에 다시 시도하세요");
							}
							
						},
						error: function(error) { //에러발생시 실행시킬 콜백함수
							alert(error, "등록실패 입니다. 관리자에게 문의하세요");
						}
					});
					
					
				} //end regist
				
				//============================
					//더보기 버튼 핸들러
					$("#moreList").click(function () {
						getList(++pageNum,false);
					});
				
				//페이비 넘버 맴버변수 선언
				var pageNum = 1; //누적할 변수
				var strAdd = ""; //화면에 그려넣을 태그를 문자열의 형태로 추가(누적)
							
				
				//목록 요청
				getList(1); //상세화면 진입시에 리스트 목록을 가져옵니다.
				function getList(page, reset) { //(페이지번호, strAdd 초기화 여부)
					
					//select구문에서 필요한 값은? bno
					var bno = "${vo.bno}";
					
					// $.ajax() vs $.getJSON 
					// $.ajax() - get, post, put, delete공용적으로 처리하는 제이쿼리기능.
					// $.getJSON(요청주소, 콜백함수) - 단순히 get방식의 데이터만 얻어올 때 사용하는 기능.
					$.getJSON(
						"../reply/getList/" + bno +"/"+page ,
						function(data) {
							console.log(data);
							
							var total = data.total;
							var data = data.list; //list를 ㄲㅓ내서 data에 저장
							
							//초기화
							if(reset == true){//맴버 변수를 초기화 해서 새론게 데이터를 가져옴
								var pageNum = 1; 
								var strAdd = ""; 
							}
							
							
							if(pageNum *20 >= total){ //페이지 번호 *데이터수가 전체글보다 크면 더보기 비활성화
								$("#moreList").css("display","none");
							}
							
							
							if(data.length <= 0) { //댓글이 없는 경우 함수종료 
								return; //함수종료
							}
							
							
					
							for(var i = 0; i < data.length; i++) {
								
		                        strAdd += "<div class='reply-wrap'>";
	                            strAdd += "<div class='reply-image'>";
	                            strAdd += "<img src='../resources/img/profile.png'>";
	                            strAdd += "</div>";
	                            
	                            strAdd += "<div class='reply-content'>";
	                            strAdd += "<div class='reply-group'>";
	                            strAdd += "<strong class='left'>"+ data[i].replyId +"</strong>"; 
	                            strAdd += "<small class='left'>"+timeStamp(data[i].replydate)+"</small>";
	                            strAdd += "<a href='"+ data[i].rno +"' class='right replyModify'><span class='glyphicon glyphicon-pencil'></span>수정</a>";
	                            strAdd += "<a href='"+ data[i].rno +"' class='right replyDelete'><span class='glyphicon glyphicon-remove'></span>삭제</a>";
	                            strAdd += "</div>";
	                            strAdd += "<p class='clearfix'>"+ data[i].reply +"</p>";
	                            strAdd += "</div>";
	                        	strAdd += "</div>";
							}
							$("#replyList").html(strAdd); //replyList자식으로 추가
						}
					);
					
				} //end getList
				
				//수정상제 모달창 핸들러
				/*
				에이잭스가 순서를 보장하지 않기 때문에, 실제 이벤트 선언이 먼저 실행이 됩니다.
				그렇다면 화면에 댓글관련 창은 아무것도 없는 형태이므로, 일반클릭이벤트는 동작하지 않습니다.
				이때, 이미존재하는 태그 replyList(부모)에 이벤트를 등록하고 이벤트를 전파시켜서 사용하는 위임방식을 반드시 써야됩니다.
				*/
					/* $("#replyList a").click(function(){
						alert("1")
					}) */
				$("#replyList").on("click","a", function(){
					event.preventDefault(); //고유이벤트 중단
					//1. 수정버튼 vs 삭제버튼인지 확인
					//현재 클릭한 a태그 href 안에 있는 rno 번호르 -> 모달창의hidden 태그로 옴겨보세요
					// 제이쿼리 hasClass() 함수를 이용해서 처리...
					
					//제이쿼리 this 가 JS 의 event.target와 유사
					var rno = $(this).attr("href");
					$("#modalRno").val(rno)
	                	//console.log(event.target)
	                	//console.log($(this))
					
					
	                if($(this).hasClass("replyModify") ){//event.target.classList.contains("replyModify")
	                	//수정을 클릭시 삭제창 형식으로 변경
	                	$(".modal-title").html("댓글수정");
	                	$("#modalReply").css("display", "inline");//textarea 보이게
						$("#modalModBtn").css("display", "inline");//수정버튼 보이게
						$("#modalDelBtn").css("display", "none");//삭제버튼숨김
	                	$("#replyModal").modal("show");
	                	
					}else{
						//삭제를 틀릭 시 삭제형식으로 변경
						$(".modal-title").html("댓글삭제");
						$("#modalReply").css("display", "none");//textarea 숨김
						$("#modalModBtn").css("display", "none");//수정버튼숨김
						$("#modalDelBtn").css("display", "inline");//삭제버튼보이게
						
						
						
						$("#replyModal").modal("show");
						
					}
				});
				
				//수정이벤트
				$("#modalModBtn").click(function(){
					/* 
					1. 모달창 rno, reply, replyPw 값을 얻습니다
					2. ajax함수를 이용해서 POST 방식으로  reply/update 요청. 필요한 값은 JSON 형식으로 처리
					3. 서버에서는 요청을 받아서 비밀번호를 확인, 비밀번호가 맞다면 업데이트를 진행
					4. 만약 비밀번호가 틀렸다면  0을 반환 해서 비밀번호가 틀렸습니다 경고창을 띄워주세요
					5. 업데이트가 성공적으로 진행되었다면 modal  창  값을 공백으로 초기화시키세요.
					
					*/
					
					var rno= $("#modalRno").val();
					var reply = $("#modalReply").val();
					var replyPw = $("#modalPw").val();
					
					//console.log(rno,Reply,modalPw)
					
					if(reply === '' || reply === '' || replyPw === '') {
						alert("내용, 비밀번호을 입력하세요");
						return; //함수종료.
					}
					$.ajax({
						type: "POST", //요청방식
						url: "../reply/update", //요청주소
						data: JSON.stringify({"rno": rno, "reply": reply, "replyPw": replyPw}) ,
						contentType: "application/json; charset=utf-8",
						success: function(data) {
							console.log("돌아오는 값"+ data)
								if(data == 1){ //업데이트성공
									$("#modalReply").val("");// 수정창 비우기
									$("#modalPw").val("");// 비번 창 비우기
									$("#replyModal").modal("hide");//모달창 내리기
									alert("수정 성공했습니다");
									
									getList(1, true); //목록요청 호출 //페이지 번호화 초기화 여부 
									
								}else{ //업데이트 실패
									alert("비밀번호가 틀렸습니다");
									$("#modalPw").val(""); //비밀번호 창 비우기
								}
						},
						error: function (status, error) { }
					});

				})//end update
				
				
				//삭제 이벤트
				$("#modalDelBtn").click(function(){
					/* 
					1. 모달창에 rno, replyPw값을 얻습니다.
					2. ajax함수를 이용해서 POST 방식으로 reply/delete 요청, 필요한 값은 JSON 형식으로 처리
					3. 서버에서는 요청을 받아서 비밀번호를 확인하고, 비밀번호가 일치한다면 삭제를 진행하면 됩니다.
					4. 비밀번호가 틀렸다면 , 0을 반환해서 "경고창을 띄우면 됩니다"
					*/
					
					var rno= $("#modalRno").val();
					var replyPw = $("#modalPw").val();
					
					if(replyPw === "") {
						alert("비밀번호을 입력하세요");
						return; //함수종료.
					}
					$.ajax({
						type: "POST", //요청방식
						url: "../reply/delete", //요청주소
						data: JSON.stringify({"rno": rno, "replyPw": replyPw}) ,
						contentType: "application/json; charset=utf-8",
						success: function(data) {
							console.log("돌아오는 값"+ data)
								if(data === 1){ //삭제성공
									alert("게시글이 삭제 되었습니다");
									$("#modalPw").val(""); //비밀번호 창 비우기
									$("#replyModal").modal("hide");//모달창 내리기
									getList(1, true); //목록요청 호출
								}else if (data === 0 ) {  //삭제 실패
									alert("삭제시 에러 발생, 관리자에게 문의하세요");
								}else { //pw에러
									alert("비밀번호가 틀렸습니다");
									$("#modalPw").val(""); //비밀번호 창 비우기
									
								}
						},
						error: function (status, error) { }
					});

				})//end delete
				
				
				//javascript에서 날짜 포맷팅
				//timeStamp(1608553872000);
				/* function timeStamp(millis) {
					// 1시간 기준으로 방금전 or xx시간 or 1일 기준으로 날짜출력
					  
		            var now = new Date();//현재시간
					var gap = now.getTime()- millis; // 현재시간밀리포 -작성일밀리초 
					//colsole.log(gep);
					
					var time; //리턴할 문자
		           if(gap < 1000 *60 *60* 24){ //1일 미만
		        	   
		        	   if(gap < 1000 * 60 * 60 ){//1시간 미만인 경우
		        		   time = "방금전" ; 
		        	   }else{//1시간 ~1일 미만
		        		   time = parseInt( gap / (1000 *60 *60 ))+ "시간전";
		        	   }
		           
		           }else {//1일 이상인 경우
		        	   var day = new Date(millis); //밀리초기준의 날짜
		        	   var year = date.getFullYear();//년
		        	   var month = date.getMonth()+1;//월
		        	   var day = date.getDate();//일
		        	   var hour = date.getHours();//시
		        	   var minute = date.getMinutes();//분
		        	   var second = date.getSeconds();//초
		        	   
		        	   time = year + "년"+ month + "월"+day +"일"+
			        	   (hour < 10 ? "0" + hour : hour) + "시"+
			        	   (minute < 10 ? "0" + minute : minute) + "분"+
			        	   (second < 10 ? "0" + second : second) + "초";
		        	   
		           }
		        	   
		        	   //colsole.log(time);
		        	   return time;
		           
		    
					
				}
				
				
				
				
			});
				 */
				 
					//javascript에서 밀리초를 전달받는 함수
					function timeStamp(millis) {
						//1기준 분으로 방금전 or xx시간
						//1일 기준으로 날짜출력
						var date = new Date(); //오늘날짜
						var gap = date.getTime() - millis;
						var str = "";

						if(gap < 1000 * 60 * 60 * 24){ //1일 이하인 경우
				            if(gap < 1000 * 60 * 60){ //1시간 이하인 경우
				                str = "방금 전";
				            }else { //1시간 이상인 경우
				            	str = parseInt( gap / (1000 * 60 * 60) ) + "시간 전"; //xx시간 전
				            }

				        }else{ //1일 이상인 경우

				            var now = new Date(millis); //밀리초를 통한 날짜
				            var year = now.getFullYear(); //해당 년
				            var month = now.getMonth() + 1; //해당 월
				            var day = now.getDate(); //해당 일
				            var hour = now.getHours(); // 해당시간
				            var miniute = now.getMinutes(); //해당 분
				            var second = now.getSeconds(); //해당 초
				            
				            var time = (hour < 10 ? "0" + hour : hour) + ":" + 
		                    (miniute < 10 ? "0" + miniute : miniute) + ":" +
		                    (second < 10 ? "0" + second : second);

				            str = year + "-" + month + "-" + day + " " + time;

				        }
						return str;
					}
					
					
					
				});
				 
		