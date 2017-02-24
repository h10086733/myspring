<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width">
<title>神奇指标</title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript">
	function subs(){
		if(!$("#jjdm").val()){
			alert("基金代码必填！");
			return ;
		}
		if(!$("#jjmc").val()){
			alert("基金名称必填！");
			return ;
		}
		if(!$("#gmcb").val()){
			alert("基金成本必填！");
			return ;
		}
	    if(!$("#date").val()){
			alert("购买时间必填！");
			return ;
		}
		$("#form").submit();
	}
</script>

</head>

<body>
	<form id="form" action="insertBuy" method="post">
		购买基金代码:<input id="jjdm" name="jjdm"/><br>
		购买基金名称:<input id="jjmc" name="jjmc"/><br>
		购买成本:<input id="gmcb" name="gmcb"/><br>
		购买时间:<input id="date" type="date" name="bugDate"/><br>
		<input type="button" onclick="subs()"  value="新增购买记录"/>
	</form>
	
</body>
</html>