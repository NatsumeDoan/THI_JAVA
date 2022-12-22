<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>The Coffee House Dilivery</title>
<style>
*, *:before, *:after {
	box-sizing: border-box;
}

* {
	margin: 0;
	padding: 0;
	font: inherit;
}

img, picture, svg, video {
	display: block;
	max-width: 100%;
}

body {
	background-color: #f5f5f5;
	font-size: 14px;
	min-height: 100vh;
	font-family: Arial, Helvetica, sans-serif;
	background-color: #f5f5f5;
}

.header {
	width: 100%;
	height: 80px;
	background-image: linear-gradient(to right, #ffab3a, #fb8d17);
	position: fixed;
	z-index: 99;
	top: 0;
	left: 0;
	right: 0;
}

.header .header_controller {
	display: flex;
	align-items: center;
	margin: 0 2.5%;
	height: 100%;
	justify-content: space-between;
}

.logo {
	margin-right: 3rem;
}

.header_controller img {
	width: 170px;
	height: 14px;
}

.nav .list_nav {
	list-style: none;
	display: flex;
	align-items: center;
}

.nav .list_nav a {
	display: block;
	text-decoration: none;
	height: 35px;
	line-height: 35px;
	font-weight: bold;
	color: #fff;
	margin: 0 7px;
	transition: .35s;
	text-align: center;
}

.nav .list_nav a:hover {
	border-bottom: 1px solid #fff;
}

.header .header_controller .cal {
	width: 500px;
	display: flex;
	justify-content: flex-end;
	align-items: center;
}

.cal_ctn {
	display: flex;
}

.cal_ctn .btn {
	background-color: transparent;
	color: #fff;
	padding: 6px;
	margin-left: 1rem;
	width: 40px;
	height: 40px;
	border-radius: 50%;
	border: 2px solid #fff;
	cursor: pointer;
}

.cal_ctn .btn i {
	font-size: 1.1rem;
}

.sub_login {
	width: 120px;
	height: 120px;
	border-radius: 13px;
	background-color: #fff;
	position: absolute;
	right: 120px;
	top: 53px;
	display: none;
}

.open {
	display: block;
}

.sub_login a {
	text-decoration: none;
	color: #000;
	display: block;
	padding: 10px 24px;
}

.container {
	margin-top: 100px;
	width: 100%;
	min-height: 100vh;
}

.container_cf {
	margin: 0 2.5%;
}

.container_cf h1 {
	font-size: 30px;
	font-weight: bold;
	text-align: center;
	padding: 1em 0 0.5em 0;
}

.header_ctn {
	width: 100%;
	margin-bottom: 4rem;
}

.list_loai {
	display: flex;
	justify-content: space-evenly;
	align-items: center;
}

.list_loai .loai {
	width: 120px;
	height: 130px;
	cursor: pointer;
	transition: .35s;
}

.list_loai .loai:hover {
	transform: scale(1.2);
}

.img-cf {
	background-color: #fff0d1;
	border-radius: 50%;
	height: 110px;
	margin-bottom: 4px;
}

.list_loai .loai img {
	padding: 32px 20px;
}

.list_loai .loai h5 {
	font-size: 12px;
	text-align: center;
	color: #b2b2b2;
}

.footer {
	color: #fff;
	background-color: #000;
	width: 100%;
	min-height: 20vh;
	line-height: 2;
}

.list_cf {
	display: flex;
	align-items: center;
	flex-wrap: wrap;
}

.list_cf .sanpham {
	width: 170px;
	height: 276px;
	border-radius: 8px;
	margin: 0 15px 15px 15px;
	padding: 10px;
	box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.1);
	cursor: pointer;
}

.sanpham .img_cf {
	height: 150px;
	width: 150px;
}

.sanpham .img_cf img {
	width: 150px;
	height: 150px;
}

.in4 h2 {
	padding-top: 12px;
	height: 72px;
}

.in4 .gia {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.product {
	width: 410px;
}

.gia i {
	font-size: 32px;
	color: #fb8d17;
}

.container_cfct {
	padding: 20px 0px 20px 0px;
	box-shadow: 0 10px 20px rgb(0 0 0/ 10%);
	box-sizing: border-box;
	color: #262626;
	display: flex;
	font-size: 1rem;
	font-weight: 400;
	justify-content: space-between;
	width: 900px;
	margin: 80px 205px 80px 205px;
	box-shadow: 0 10px 20px rgb(0 0 0/ 10%);
}

.img-cfct {
	width: 400px;
	height: 400px;
}

.left-cols {
	float: left;
	max-width: 400px;
	padding: 0px 20px 0px 20px;
}

.right-cols {
	float: right;
	max-width: 410px;
	padding: 0px 20px 0px 20px;
}

.option {
	box-shadow: 0 10px 20px rgb(0 0 0/ 10%);
	box-sizing: border-box;
	border: 1px solid #ededed;
	border-radius: 15px;
}
/* Scrollbar */
::-webkit-scrollbar {
	width: 8px;
	height: 16px;
}

::-webkit-scrollbar-thumb {
	background-color: #fb901b;
}
/* endScroll */
</style>

</head>
<body>
	<div class="header">
		<div class="header_controller">
			<div class="logo">
				<img src="./img/logo-coffee.png" alt="" class="anh_logo">
			</div>
			<div class="nav">
				<ul class="list_nav">
					<li><a href="sanphamcontroller">Trang chủ</a></li>
					<li><a href="lichsucontroller?tendn=${DangNhap }&act=null">Lịch
							sử mua hàng</a></li>
				</ul>
			</div>
			<div class="cal">
				<div class="cal_ctn">
					<button class="btn login js-login">
						<i class="fa-regular fa-user"></i>
					</button>
					<button class="btn cart"
						onclick="location.href='giohangcontroller?tendn=${DangNhap}&act=null'">
						<i class="fa-sharp fa-solid fa-cart-shopping"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="sub_login js-sub">
			<div class="sub_ctn">
				<div class="btn_huy js-close"
					style="text-align: right; margin: 4px 8px 0 0; cursor: pointer;">
					<i class="fa-solid fa-xmark"></i>
				</div>
				<c:if test="${DangNhap==null }">
					<div class="log">
						<a href="logincontroller">Đăng nhập</a>
					</div>
					<div class="sign">
						<a href="">Đăng ký</a>
					</div>
				</c:if>
				<c:if test="${DangNhap!=null }">
					<div class="log">
						<a href=""> ${DangNhap }</a>
					</div>
					<div class="sign">
						<a href="logoutcontroller">Đăng xuất</a>
					</div>
				</c:if>

			</div>
		</div>
	</div>
	<div class="container">
		<div class="container_cfct">
			<div class="left-cols">
				<div class="img-cfct">
					<img src="${sp.getAnhsp() }" alt="" style="border-radius: 30px;">
				</div>
				<h5 style="padding: 17px 0px 0px 35px; font-family: cursive;">${sp.getMota() }</h5>

			</div>
			<div class="right-cols">
				<div class="product">
					<h5
						style="font-size: xx-large; font-weight: 700; padding: 15px 0px 14px 0px;">${sp.getTensp() }</h5>
				</div>

				<h5 style="padding: 10px 0px 15px 0px;">${sp.getGia() }đ</h5>


				<form action="giohangcontroller">
					Số lương: <input type="number" name="txtsl" value="1"
						required="required" style="margin: 9px 0px 14px 0px; width: 50px;"><br>
					<input type="hidden" name="msp" value="${sp.getMasp() }"> <input
						type="hidden" name="gia" value="${sp.getGia() }"> <input
						type="hidden" name="tendn" value="${DangNhap }">
					<div class="option">
						<div class="option-size">
							<p
								style="background-color: hsla(0, 0%, 76.9%, 0.3); padding: 13px 0px 13px 30px; border-radius: 15px;">CHỌN
								SIZE (BẮT BUỘC)</p>
							<div style="display: flex; padding: 13px 0px 13px 10px;">
								<input type="radio" id="size-nho" name="size" value="Nhỏ"
									required="required"> <label for="size-nho"
									style="padding: 0px 10px 0px 10px;">Nhỏ +0đ</label><br> <input
									type="radio" id="size-vua" name="size" value="Vừa"> <label
									for="size-vua" style="padding: 0px 10px 0px 10px;">Vừa
									+6000đ</label><br> <input type="radio" id="size-lon" name="size"
									value="Lớn"> <label for="size-lon"
									style="padding: 0px 10px 0px 10px;">Lớn +10000đ</label>
							</div>
						</div>

					</div>
					<input type="hidden" name="act" value="add"> <input
						type="submit" value="Thêm vào giỏ hàng"
						style="padding: 10px 80px 10px 81px; border-radius: 25px; margin: 35px 0px 0px 35px; border: 1px solid #000; background-image: linear-gradient(to right, #ffab3a, #fb8d17);">
				</form>

			</div>



		</div>
	</div>
</body>

<script>
	const btnLogin = document.querySelector('.js-login');
	const subLogin = document.querySelector('.js-sub');
	const subClose = document.querySelector('.js-close');
	function showSub() {
		subLogin.classList.add('open');
	}
	function hideSub() {
		subLogin.classList.remove('open');
	}
	btnLogin.addEventListener('click', showSub);
	subClose.addEventListener('click', hideSub);
</script>
</html>