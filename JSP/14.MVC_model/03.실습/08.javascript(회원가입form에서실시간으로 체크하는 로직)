<script>

//자바 스크립트를 시작하는 표시 $
$(function(){
  // 자바 스크립트는 다 var로 시작 
  // 정규 표현식 힣이 한글 마지막이다. 
	var getIdCheck= RegExp(/^[a-zA-Z0-9]{4,14}$/);
	var getPwCheck= RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
	var getName= RegExp(/^[가-힣]+$/);
	var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
	var chk1 = false, chk2 = false, chk3 = false, chk4 = false, chk5 = false;
	
	//회원가입 검증~~
	//ID 입력값 검증.
  // #이 태그의 아이디속성을 가리킨다. user_id라는 태그에 접근해라. 
  // 103번째 줄 id입력창, 이 태그에 어떤 기능? 한글자쓸때마다 keyup function을 작동시켜라
  // if공백이다. 핑크색으로 바껴라. #빨간색 글씨로 아이디는 필수 정보에요!를 뿌려라 
	$('#user_id').on('keyup', function() {
		if($("#user_id").val() == ""){
			$('#user_id').css("background-color", "pink");
			$('#idChk').html('<b style="font-size:16px;color:red;">[아이디는 필수 정보에요!]</b>');
			chk1 = false;
		}
		
		//아이디 유효성검사
    // 아이디 형식이 맞는지 검사 
		else if(!getIdCheck.test($("#user_id").val())){
			$('#user_id').css("background-color", "pink");
			$('#idChk').html('<b style="font-size:16px;color:red;">[영문자,숫자 4-14자로 입력하라구~]</b>');	  
			chk1 = false;
		} 
		//ID 중복확인 비동기 처리
    //한글자 칠때마다 실시간 검사를 하겠다는 것. 
		else {
      //$.ajax 비동기 post로 지속적으로 통신해라. 
			$.ajax({
				type: "POST",
				url: "/izone/users/confirm_id.jsp",
				data: {
          // user_id가 요청 파라미터로 넘어간다. 
					"user_id": $('#user_id').val()
				},
				success: function(data) {
          //공백제거
					if($.trim(data) == "YES") {
						$('#user_id').css("background-color", "aqua");
						$('#idChk').html('<b style="font-size:16px;color:green;">[ID 사용 가능!]</b>');
						chk1 = true;
					} else {
						$('#user_id').css("background-color", "pink");
						$('#idChk').html('<b style="font-size:16px;color:red;">[중복된 ID입니다!]</b>');
						chk1 = false;
					}
				}
			});
		}
	});
	
	//패스워드 입력값 검증.
	$('#password').on('keyup', function() {
		//비밀번호 공백 확인
		if($("#password").val() == ""){
		    $('#password').css("background-color", "pink");
			$('#pwChk').html('<b style="font-size:16px;color:red;">[패스워드는 필수정보에요!]</b>');
			chk2 = false;
		}		         
		//비밀번호 유효성검사
		else if(!getPwCheck.test($("#password").val()) || $("#password").val().length < 8){
		    $('#password').css("background-color", "pink");
			$('#pwChk').html('<b style="font-size:16px;color:red;">[특수문자 포함 8자이상으루다가~]</b>');
			chk2 = false;
		} else {
			$('#password').css("background-color", "aqua");
			$('#pwChk').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk2 = true;
		}
		
	});
	
	//패스워드 확인란 입력값 검증.
	$('#password_check').on('keyup', function() {
		//비밀번호 확인란 공백 확인
		if($("#password_check").val() == ""){
		    $('#password_check').css("background-color", "pink");
			$('#pwChk2').html('<b style="font-size:16px;color:red;">[패스워드확인은 필수정보에요!]</b>');
			chk3 = false;
		}		         
		//비밀번호 확인란 유효성검사
		else if($("#password").val() != $("#password_check").val()){
		    $('#password_check').css("background-color", "pink");
			$('#pwChk2').html('<b style="font-size:16px;color:red;">[위에랑 똑같이 제대로 써!!]</b>');
			chk3 = false;
		} else {
			$('#password_check').css("background-color", "aqua");
			$('#pwChk2').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk3 = true;
		}
		
	});
	
	//이름 입력값 검증.
	$('#user_name').on('keyup', function() {
		//이름값 공백 확인
		if($("#user_name").val() == ""){
		    $('#user_name').css("background-color", "pink");
			$('#nameChk').html('<b style="font-size:16px;color:red;">[이름은 필수정보에요!]</b>');
			chk4 = false;
		}		         
		//이름값 유효성검사
		else if(!getName.test($("#user_name").val())){
		    $('#user_name').css("background-color", "pink");
			$('#nameChk').html('<b style="font-size:16px;color:red;">[이름은 한글로 쓰세용~]</b>');
			chk4 = false;
		} else {
			$('#user_name').css("background-color", "aqua");
			$('#nameChk').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk4 = true;
		}
		
	});
	
	//이메일 입력값 검증.
	$('#user_email').on('keyup', function() {
		//이메일값 공백 확인
		if($("#user_email").val() == ""){
		    $('#user_email').css("background-color", "pink");
			$('#emailChk').html('<b style="font-size:16px;color:red;">[이메일은 필수정보에요!]</b>');
			chk5 = false;
		}		         
		//이메일값 유효성검사
		else if(!getMail.test($("#user_email").val())){
		    $('#user_email').css("background-color", "pink");
			$('#emailChk').html('<b style="font-size:16px;color:red;">[이메일 형식 몰라?]</b>');
			chk5 = false;
		} else {
			$('#user_email').css("background-color", "aqua");
			$('#emailChk').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk5 = true;
		}
		
	});
	
	$('#signup-btn').click(function(e) {
		if(chk1 && chk2 && chk3 && chk4 && chk5) {
			var answer = confirm('회원가입을 완료하시겠습니까?');
			if(answer) {
				e.preventDefault();
				$('#signUpForm').submit();
			} 
		} else {
			alert('입력정보를 다시 확인하세요.');			
		}
	});
	
	///////////////////////////////////////////////////////////////////////////////////////////
	
	//로그인 검증~~
	//ID 입력값 검증.
	$('#signInId').on('keyup', function() {
		if($("#signInId").val() == ""){
			$('#signInId').css("background-color", "pink");
			$('#idCheck').html('<b style="font-size:16px;color:red;">[아이디는 필수 정보에요!]</b>');
			chk1 = false;
		}		
		
		//아이디 유효성검사
		else if(!getIdCheck.test($("#signInId").val())){
			$('#signInId').css("background-color", "pink");
			$('#idCheck').html('<b style="font-size:16px;color:red;">[영문자,숫자 4-14자로 입력하라구~]</b>');	  
			chk1 = false;
		} else {
			$('#signInId').css("background-color", "aqua");
			$('#idCheck').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk1 = true;
		}
	});
	
	//패스워드 입력값 검증.
	$('#signInPw').on('keyup', function() {
		//비밀번호 공백 확인
		if($("#signInPw").val() == ""){
		    $('#signInPw').css("background-color", "pink");
			$('#pwCheck').html('<b style="font-size:16px;color:red;">[패스워드는 필수정보에요!]</b>');
			chk2 = false;
		}		         
		//비밀번호 유효성검사
		else if(!getPwCheck.test($("#signInPw").val()) || $("#signInPw").val().length < 8){
		    $('#signInPw').css("background-color", "pink");
			$('#pwCheck').html('<b style="font-size:16px;color:red;">[특수문자 포함 8자이상으루다가~]</b>');
			chk2 = false;
		} else {
			$('#signInPw').css("background-color", "aqua");
			$('#pwCheck').html('<b style="font-size:16px;color:green;">[참 잘했어요~♡]</b>');
			chk2 = true;
		}
		
	});
	
	$('#signIn-btn').click(function(e) {
		if(chk1 && chk2) {							
			$.ajax({
				type: "POST",
				url: "/izone/users/check_login.jsp",
				data: {
					"user_id": $('#signInId').val(),
					"user_pw": $('#signInPw').val()
				},
				success: function(data) {
					
					if($.trim(data) == "NOT_ID") {
						$('#signInId').css("background-color", "pink");
						$('#idCheck').html('<b style="font-size:16px;color:red;">[회원가입 먼저~~]</b>');
						$('#signInPw').val("");
						$('#signInId').focus();
						chk2 = false;
				    } else if($.trim(data) == "NOT_PW") {
						$('#signInPw').css("background-color", "pink");
						$('#signInPw').val("");
						$('#signInPw').focus();
						$('#pwCheck').html('<b style="font-size:16px;color:red;">[비밀번호가 틀렸습니다ㅠㅠ]</b>');
						chk2 = false;
					} else if($.trim(data) == "LOGIN_OK") {
						location.href="/izone";
					}
				}
			});			
		} else {
			alert('입력정보를 다시 확인하세요.');			
		}
	});
	
});


</script>
