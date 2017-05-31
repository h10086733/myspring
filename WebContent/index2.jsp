<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>神奇指标10分</title>
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="echarts.js"></script>
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?4d5a0f0d6229d3359dd4a8b7103a429f";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
<script type="text/javascript">
	var key=['jg','ydyl','xnc','cycz','swdc'];
	var map={"jg":"中证军工","zzhb":"中证环保","zzzz":"中证转债","swysjs":"申万有色金属","ydyl":"一带一路", "zzmt":"中证煤炭", "swdz":"申万电子", "gy4.0":"工业4.0", "swgt":"申万高铁", "gangtie":"申万钢铁", "ydhl":"移动互联", "swzq":"申万证券", "zzcm":"中证传媒", "zzbj":"中证白酒", "xnc":"新能车",  "cycz":"创业成长","dqsb":"电器设备","rgzn":"人工智能","yysw":"医药生物","znjj":"智能家居","swdc":"申万地产"};
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
			$("#"+type).append("<div>"+map[type]+":"+result+"</div>");		
 		}
	}
 	setInterval("a()",1000*60*10);//1000为1秒钟
 	
 	function upxs(){
 		var s=$("#req").val();
 		if(s){
 			key=s.split(",");
 			alert("修改成功等待更新数据！！！");
 		}
 	}
</script>

</head>

<body onload="">
"jg":"中证军工","swysjs":"申万有色金属","ydyl":"一带一路", "zzmt":"中证煤炭", "swdz":"申万电子", "gy4.0":"工业4.0", "swgt":"申万高铁", "gangtie":"申万钢铁", "ydhl":"移动互联", "swzq":"申万证券", "zzcm":"中证传媒", "zzbj":"中证白酒", "xnc":"新能车",  "cycz":"创业成长","dqsb":"电器设备","rgzn":"人工智能","yysw":"医药生物","znjj":"智能家居","swdc":"申万地产"
	<input id="req" value="" />修改需要查询的系数,多个逗号隔开(例：jg,swysjs)<button onclick="upxs()">提交</button>

</body>
</html>