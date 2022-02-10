<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>



      <div class="container">
        <h4 class="mb-3">회원가입</h4>
        <form class="needs-validation" action="/joinGo" method="post">
            <div class="col-sm-6">
              <label for="firstName" class="form-label">이름</label>
              <input type="text" class="form-control" id="name" name="mi_name" placeholder="" value="${loginMember.mi_name }" required>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>

            <div class="col-sm-6">
              <label for="lastName" class="form-label">생년월일</label>
              <input type="text" class="form-control" id="birthday" name="mi_birthday" placeholder="" value="${loginMember.mi_birthday}" required>
              <div class="invalid-feedback">
                Valid last name is required.
              </div>
            </div>

          <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="username" class="form-label">아이디</label>
                        <div class="input-group has-validation">
                         
                            <input type="text" class="form-control" name="mi_id" id="username" placeholder="아이디" value="${loginMember.mi_id }">
                          </div>
                        </div>
                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">중복체크</label>
                            <button class="w-100 btn btn-primary btn-lg" id="checkID" type="button">중복체크</button>
                        </div>
                    </div>
            
                  <div class="col-12">
	              <label for="username" class="form-label">비밀번호</label>
		              <div class="input-group has-validation">		          
			                <input type="password" class="form-control" id="pw" name="mi_pw" placeholder="Password" value="${loginMember.mi_pw }" required>
			              <div class="invalid-feedback">
			                  Your username is required.
		                </div>
	              </div>
            </div>

            <div class="col-12">
	              <label for="email" class="form-label">이메일 <span class="text-muted"></span></label>
	              <input type="email" class="form-control" id="email" name="mi_email" placeholder="abc@naver.com" value="${loginMember.mi_email }">
	              <div class="invalid-feedback">
	                Please enter a valid email address for shipping updates.
	              </div>
            </div>

            <div class="col-12">
	              <label for="address" class="form-label">휴대폰번호</label>
	              <input type="text" class="form-control" id="mobile" name="mi_mobile" placeholder="01033334444" value="${loginMember.mi_mobile}"  required>
	              <div class="invalid-feedback">
	                Please enter your shipping address.
	              </div>
            </div>

            <div class="col-12">
	              <label for="address2" class="form-label">유선전화<span class="text-muted">(Optional)</span></label>
	              <input type="text" class="form-control" id="tell" name="mi_tell" placeholder="028889999" value="${loginMember.mi_tell }">
            </div>
			<div class="col-12">
              	<label for="addr" class="form-label">주소</label>
				<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
              	<input type="text" name="postCode"class="form-control" id="sample4_postcode" placeholder="우편번호" value="${addr1[2]}">
				<input type="text" name="addr"class="form-control" id="sample4_roadAddress" placeholder="도로명주소" value="${addr1[1] }">
				<span id="guide" style="color:#999;display:none"></span>
				<input type="text" name="detailAddr" class="form-control" id="sample4_detailAddress" placeholder="상세주소" value="${addr1[0] }">
            </div>
 			<button class="w-100 btn btn-primary btn-lg" type="submit">회원가입</button>
        </form>
        
      </div>
      

      <script>
      function sample4_execDaumPostcode() {
    	    new daum.Postcode({
    	        oncomplete: function(data) {
    	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

    	            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
    	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
    	            var roadAddr = data.roadAddress; // 도로명 주소 변수
    	            var extraRoadAddr = ''; // 참고 항목 변수
    	            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
    	            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
    	            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
    	                extraRoadAddr += data.bname;
    	            }
    	            // 건물명이 있고, 공동주택일 경우 추가한다.
    	            if(data.buildingName !== '' && data.apartment === 'Y'){
    	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
    	            }
    	            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
    	            if(extraRoadAddr !== ''){
    	                extraRoadAddr = ' (' + extraRoadAddr + ')';
    	            }

    	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
    	            document.getElementById('sample4_postcode').value = data.zonecode;
    	            document.getElementById("sample4_roadAddress").value = roadAddr;
    	            
    	            var guideTextBox = document.getElementById("guide");
    	            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
    	            if(data.autoRoadAddress) {
    	                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
    	                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
    	                guideTextBox.style.display = 'block';

    	            } else {
    	                guideTextBox.innerHTML = '';
    	                guideTextBox.style.display = 'none';
    	            }
    	        }
    	    }).open();
    	}
      
      
      //ajax 문법
      //$ >> 제이쿼리의 시작
      //.ajax >> jquery 라이브러리안에 function ajax가 있는데 그걸 쓰겠다는 말.
      //type : GET, POST, PUT, DELETE 
      //url : 어느 url로 요청 보낼꺼냐
      //data : 요청보낼때 무슨 데이터를 껴서 같이 보낼거냐(파라미터) >> 배열
      //error, success, complete : ajax 콜백함수
      //error: 에러났을때, success:잘 실행됐을때, complete:에러, success상관없이 맨 마지막에 무조건 실행되는 함수
      
      //jquery를 쓰려면 하나의 약속된 문법이 필요
      $(document).ready(function(){
    	  
    	  //# : id
    	  // . : class
    	  
    	  
    	  
    	  $("#checkID").click(function(){
    		  let id = $("#username").val();
    		  checkID(id);
    	  })
    	  
      });
      
      
      
      function checkID(id){
      $.ajax({
    	    type : 'POST',
    	    url : "/checkID",
    	    data : {"mi_id" : id},
    	    error : function(error) {
    	        alert("Error!");
    	    },
    	    success : function(data) {
				if(data == 'Y'){
					alert("중복된아이디입니다.");
				}else{
					alert("사용가능한아이디입니다.")
				}
    	    	
    	    },
 
    	});
 	  
      }
      //Ajax >> 제이쿼리
      //js = xmlhttprequest   //비동기통신
      //
</script>



