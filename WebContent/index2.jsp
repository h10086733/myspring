<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神奇指标</title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="echarts.js"></script>
<script type="text/javascript">
	var key=['jg','swysjs','gangtie','zzmt','zzbj','swdz','ydyl'];
	var map={"jg":"中证军工","swysjs":"申万有色金属","ydyl":"一带一路", "zzmt":"中证煤炭", "swdz":"申万电子", "gy4.0":"工业4.0", "swgt":"申万高铁", "gangtie":"申万钢铁", "ydhl":"移动互联", "swzq":"申万证券", "zzcm":"中证传媒", "zzbj":"中证白酒", "xnc":"新能车",  "cycz":"创业成长"};
	function a(){
 		for(var i=0;i<key.length;i++){
			var type=key[i];
			if($("#"+type).textContent==undefined){
				 var parentdiv=$('<div></div>');
				 parentdiv.attr('id',type);
				 var p=$("<div style='height:50px;'></div>");
				 $(document.body).append(p);
				 $(document.body).append(parentdiv);
			}
			var htmlobj=$.ajax({url:"./dingshiGetXs?type="+type,async:false});
			var result=htmlobj.responseText;
			$("#"+type).append(map[type]+":"+result+"\n");		
 		}
	}
	setInterval("a()",1000*60*30);//1000为1秒钟
	
</script>

</head>

<body onload="">
</body>
</html>