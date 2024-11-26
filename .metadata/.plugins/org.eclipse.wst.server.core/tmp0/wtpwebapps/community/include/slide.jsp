<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="demo" class="carousel slide" data-bs-ride="carousel">

<!-- 이미지를 움직일때 클릭하는 점 -->
<div class="carousel-indicators">
	<button data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
	<button data-bs-target="#demo" data-bs-slide-to="1"></button>
	<button data-bs-target="#demo" data-bs-slide-to="2"></button>
</div>

<!-- 변동하는 이미지 -->
<div class="carousel-inner">
	<div class="carousel-item active">
		<img src="images/la.jpg" alt="Los Angeles" class="w-100">
	</div>
	<div class="carousel-item">
		<img src="images/chicago.jpg" alt="chicago" class="w-100">
	</div>
	<div class="carousel-item">
		<img src="images/ny.jpg" alt="New York" class="w-100">
	</div>
</div>


<!-- 왼쪽 오른쪽 화살표 -->
<button class="carousel-control-prev" data-bs-target="#demo" data-bs-slide="prev">
<span class="carousel-control-prev-icon"></span>
</button>
<button class="carousel-control-next" data-bs-target="#demo" data-bs-slide="next">
<span class="carousel-control-next-icon"></span>
</button>

</div>