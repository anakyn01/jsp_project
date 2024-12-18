<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>

<div class="container">
<div class="row">
<div class="col-md-12">
<!-- 1)form 으로 랩핑 -->
<form method="post" action="joinAction.jsp" class="was-validated">
<h1 class="my-5">Join</h1>

<div class="input-group my-3">
	<label class="form-label w-25">id</label>
	<input 
	type="text" 
	class="form-control w-75" 
	placeholder="enter your id" 
	name="userID" 

	/>
</div>

<div class="input-group my-3">
	<label class="form-label w-25">
	pw
	</label>
	<input
	type="password"
	class="form-control w-75"
	name="userPassword"
	placeholder="enter your password"

	/>
</div>

<div class="input-group my-3">
	<label class="form-label w-25">
	name
	</label>
	<input
	type="text"
	class="form-control"
	placeholder="enter your name"
	name="userName"
	
	/>
</div>

<div class="input-group my-3">
	<label class="form-label w-25">
	gender
	</label>
	<div class="btn-group w-75"><!--btn-group 버튼끼리 그룹화 할때 쓰는 클래스  -->
		<label class="btn btn-outline-primary">
			<input type="radio" name="userGender" value="남자" checked/>
			<span class="ml-2">남자</span>
		</label>
		<label class="btn btn-outline-primary">
			<input type="radio" name="userGender" value="여자"/>
			<span class="ml-2">여자</span>
		</label>	
	</div>
</div>

<div class="input-group my-3">
	<label class="form-label w-25">
	email
	</label>
	<input
	type="email"
	class="form-control w-75"
	placeholder="enter your email"
	name="userEmail"
	/>
</div>
<!-- 
- input에서 name을 쓰는 이유 -
웹페이지에서 사용자가 입력한 테이터를 서버로 전송하면
입력필드에 이름과 값이 함께 전송된다
서버는 이러한 이름 값을 쌍으로 처리하기 때문에 필요하다
 -->
<div class="d-flex justify-content-end my-5">
<input type="submit" value="회원가입" class="btn btn-outline-primary px-5"/>
</div>

</form>
</div>
</div>
</div>

<%@ include file="include/footer.jsp" %>