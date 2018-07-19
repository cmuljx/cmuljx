<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>新页面1</title>
<link href="/Jxcdc/source/CSS/jqueryui.css" rel="stylesheet"
	type="text/css" />
<link href="/Jxcdc/source/CSS/vjpublic.css" rel="stylesheet"
	type="text/css" />
<link href="/Jxcdc/source/CSS/vjpage.css" rel="stylesheet"
	type="text/css" />
<link href="/Jxcdc/source/CSS/login.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="/Jxcdc/source/js/public.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/Jxcdc/source/js/jquery-ui.min.js"></script>

<script type="text/javascript">
	$(function() {

		$("#login_loginbtn").click(function(){
			$("#login_jHtmlForm1").attr("action","loginAction");
			$("#login_jHtmlForm1").submit();		
		});
	})
</script>

</head>
<body class="body_style1"
	style="background-image: url(/Jxcdc/source/images/jloginbg01.gif); background-repeat: repeat-x;">
	<div id="login_jPanel1" class="Panel Panel_Null">
		<div id="login_jPanel2" class="Panel Panel_Null">
			<div id="login_jHtmlForm1_form">
				<form id="login_jHtmlForm1" name="login_jHtmlForm1" method="post"
					action="">
					<div id="login_jLabel1" class="text">用户名：</div>
					<input type="text" class="Edit Edit_style1" id="login_username"
						name="username" />
					<div id="login_jLabel2" class="text">密 码：</div>
					<input type="password" class="Edit Edit_style4" id="login_passname"
						name="password" />
					<div id="login_loginbtn"
						class="vjbutton border_radius_3 vjbutton_c_style4">
						<div class="vjbutton_txtR">
							<span class="btniconcum1"> <img
								src="/Jxcdc/source/images/jPngButtonOk.png" width="16"
								height="16" />
							</span> <span class="btniconcum2"> <img
								src="/Jxcdc/source/images/jPngButtonOk.png" width="16"
								height="16" />
							</span> <span class="btntxt">登录</span>
						</div>
					</div>
					<div id="login_jButton2"
						class="vjbutton border_radius_3 vjbutton_c_style4">
						<div class="vjbutton_txtR">
							<span class="btniconcum1"> <img
								src="/Jxcdc/source/images/juser.png" width="16" height="16" />
							</span> <span class="btniconcum2"> <img
								src="/Jxcdc/source/images/juser.png" width="16" height="16" />
							</span> <span class="btntxt">注册</span>
						</div>
					</div>
				</form>
			</div>

			<div id="login_jLabel4" class="text">信息系统</div>
			<div id="login_jLabel3" class="text">江西疾控中心疾检所</div>
			<div id="login_jImages2" class="Timage Timage_style1 Timage_auto">
				<img src="/Jxcdc/source/images/jlogosmall.png"
					alt="/Jxcdc/source/images/jlogosmall.png" title="" />
			</div>
			<map name="login_jImages2_map" id="login_jImages2_map"></map>
			<div id="login_jLabel5" class="text">用户登录</div>
			<div id="login_jLabel6" class="text">LOGIN IN</div>
		</div>
	</div>

</body>
<script type="text/javascript" src="js/Timage.js"></script>
</html>
