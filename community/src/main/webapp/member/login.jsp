<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="container">
<div class="row">
<div class="col-md-12">

<!-- 로그인 창이 들어감 -->
<div class="card o-hidden border-0 shadow-lg my-5">

<div class="card-body p-0">

<div class="row">

<!-- 백그라운드 이미지 -->
<div class="col-lg-5 d-none d-lg-block bg-register-image">
</div>

<!-- 로그인 창 -->
<div class="col-lg-7">
<div class="p-5">
<div class="text-center">
<h1 class="h4 text-grey-900 mb-4">
Welcome Back!
</h1>
<form class="user was-validated" method="post" id="join_form" action="loginAction.jsp">
<!-- 중간매개체 역활을 하는 loginAction을 만들어야 합니다 -->
<div class="form-group mb-3"><!-- 3 16px * 3 3rem -->
<input
type="text"
class="form-control form-control-user"
placeholder="enter your id"
name="userID"
id="userID"
required="required"
/>
</div>

<div class="form-group mb-3">
<input
type="password"
class="form-control form-control-user"
placeholder="enter your pw"
name="userPassword"
id="userPassword"
required="required"
/>
</div>

<!-- 폼에서 내용을 전송할때는 input type="submit" -->
<p class="my-5">
<input
type="submit"
value="로그인"
class="btn btn-outline-primary btn-user btn-block"
/>
</p>
</form>
</div>
</div>
</div>

</div>

</div>

</div>


</div>
</div>
</div>

<%@ include file="../include/footer.jsp"%>