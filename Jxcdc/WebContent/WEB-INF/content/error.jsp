<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>出错提示</title>
</head>
<body>
	<div class="container">
		<div class="panel panel-danger text-center">
			<div class="panel-heading">
				<h4>系统处理过程中发生了一个错误，信息如下：</h4>
			</div>
			<p>&nbsp;</p>
			<s:property value="exception.message" />
		</div>
	</div>
</body>
</html>

