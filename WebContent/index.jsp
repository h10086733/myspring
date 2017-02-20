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
	var mapCount={'zzbj':'16','swgt':'39','zzcm':'50','xnc':'78','jg':'66','gangtie':'35','cycz':'100','zzmt':'29','swysjs':'109','swzq':'26','ydyl':'78','gy4.0':'48','ydhl':'100','swdz':'92'};
	var key=['jg','swysjs','gangtie','zzmt','swzq','zzbj','swgt','gy4.0','cycz','swdz','ydhl','zzcm','xnc','ydyl'];
	var map={"jg":"中证军工","swysjs":"申万有色金属","ydyl":"一带一路", "zzmt":"中证煤炭", "swdz":"申万电子", "gy4.0":"工业4.0", "swgt":"申万高铁", "gangtie":"申万钢铁", "ydhl":"移动互联", "swzq":"申万证券", "zzcm":"中证传媒", "zzbj":"中证白酒", "xnc":"新能车",  "cycz":"创业成长"};
	function a(x){
		$("#content").html("");
		var sumHtml="";
		var dd="<table border ><tr><td></td>";
 		for(var i=0;i<key.length;i++){
			var type=key[i];
			var htmlobj=$.ajax({url:"./getsqzbAllAVG?bankuaiDaima="+type,async:false});
			var result=eval("("+htmlobj.responseText+")");
			result=result.slice(0,2);
			var hh="<tr><td>"+map[type]+"(瞎猫"+mapCount[type]+")</td>";
			for(var j=result.length-1;j>=0;j--){
				if(i==0){
					dd+="<td>"+result[j].c_date+"</td>";
				}
				var value=result[j].c_value;
				if(x=='avg'){
					value=result[j].getcvalue;
				}
				var color="green";
				if(value>0){
					color="red";
				}
				hh+="<td style='color:"+color+"'><b>"+value+"</b></td>"
			}
			if(i==0){
				sumHtml+=dd+"</tr>";
			}
			sumHtml+=hh+"</tr>";
 		}
 		$("#content").html(sumHtml+"</table>");
	}
</script>

</head>

<body onload="a('x')">
	<div style="height:30px"></div>
	<button id="xsButton" hidden onclick="a('x')">九齿钉耙指标</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button id="xsButton1" hidden onclick="a('avg')">金箍棒指标 </button>
	<div style="height:30px"></div>
	<div id="content" >
	</div>
</body>
</html>