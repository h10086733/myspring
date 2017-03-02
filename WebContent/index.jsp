<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width">
<title>启明星</title>
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
	var mapCount={'zzbj':'16','swgt':'39','zzcm':'50','xnc':'78','jg':'66','gangtie':'35','cycz':'100','zzmt':'29','swysjs':'109','swzq':'26','ydyl':'78','gy4.0':'48','ydhl':'100','swdz':'92','hs300':'300','zz500':'500'};
	var key=['jg','swysjs','gangtie','zzmt','swzq','zzbj','swgt','gy4.0','cycz','swdz','ydhl','zzcm','xnc','ydyl','hs300','zz500'];
	var map={"jg":"中证军工","swysjs":"申万有色金属","ydyl":"一带一路", "zzmt":"中证煤炭", "swdz":"申万电子", "gy4.0":"工业4.0", "swgt":"申万高铁", "gangtie":"申万钢铁", "ydhl":"移动互联", "swzq":"申万证券", "zzcm":"中证传媒", "zzbj":"中证白酒", "xnc":"新能车",  "cycz":"创业成长","hs300":"沪深300","zz500":"中证500"};
	var flush=true;
	var v="";
	function a(x){
		$("#content").html("");
		var sumHtml="";
		var showCount=6;
		var dd="<table border ><tr><td></td>";
		var rq="";
 		for(var i=0;i<key.length;i++){
			var type=key[i];
			var htmlobj=$.ajax({url:"./getsqzbAllAVG?bankuaiDaima="+type,async:false});
			var result=eval("("+htmlobj.responseText+")");
			result=result.slice(0,showCount);
			var hh="<tr><td>"+map[type]+"</td>";
			var hh2="";
			for(var j=result.length-1;j>=0;j--){
				if(i==0){
					if(j==0){
						rq=result[j].c_date;
					}
					dd+="<td>"+result[j].c_date+"</td>";
				}else if(j==0){
					if(rq!=result[j].c_date){
						flush=false;
						v+=map[type]+",";
					}
				}
				if(result.length<showCount&&j==0){
					for(var xx=0;xx<showCount-result.length;xx++){
						hh=hh+"<td></td>";
					}
				}
				var value=result[j].c_value;
				if(x=='avg'){
					value=result[j].getcvalue;
				}
				var color="green";
				if(value>0){
					color="red";
				}
				value=value/mapCount[type]*100;
				
				hh2+="<td style='color:"+color+"'><b>"+value.toFixed(2)+"</b></td>";
			}
			if(i==0){
				sumHtml+=dd+"</tr>";
			}
			sumHtml+=hh+hh2+"</tr>";
 		}
 		$("#content").html(sumHtml+"</table>");
 		if(!flush){
 			$("#gxztsb").html(v+"未更新完毕");
 		}
 		
 		buyLog();
	}
	function buyLog(){
		var htmlobj=$.ajax({url:"./queryBuyFund",async:false});
		var result=eval("("+htmlobj.responseText+")");
		var html="<tr><td>基金名称</td><td>基金代码</td><td>购买日期</td><td>购买成本</td><td>当前价格</td><td>盈利</td><td>售出日期</td><td>售出价格</td><td>当前状态</td>";
		for(var j=result.length-1;j>=0;j--){
			var hprice="";
			var cha="";
			var sytype="";
			if(result[j].gmStatus=="1"){
				result[j].gmStatus="持股";
				result[j].saleDate="未售出";
				result[j].yldw="未售出";
				cha=result[j].currentPrice-result[j].gmcb;
				sytype="(浮)";
			}
			else{
				 result[j].gmStatus="持币";
				 cha=result[j].yldw-result[j].gmcb;
				 sytype="(固)";
			}
			var yjylPrice=cha/result[j].gmcb*100;
			if(yjylPrice>0){
				hprice="</td><td style='color:red'>"+sytype+yjylPrice.toFixed(2)+"%";
			}else{
				hprice="</td><td style='color:green'>"+sytype+yjylPrice.toFixed(2)+"%";
			}
			html+="<tr><td>"+result[j].jjmc+"</td><td>"+result[j].jjdm
			+"</td><td>"+result[j].bugDate+"</td><td>"+result[j].gmcb+"</td><td>"+result[j].currentPrice
			+hprice+"</td><td>"+result[j].saleDate+"</td><td>"+result[j].yldw+"</td><td>"+result[j].gmStatus+"</td></tr>";
		}
		
		$("#gmjl").append("<table border>"+html+"</table>");
	}
	Date.prototype.Format = function (fmt) { //author: meizz 
	    var o = {
	        "M+": this.getMonth() + 1, //月份 
	        "d+": this.getDate(), //日 
	        "h+": this.getHours(), //小时 
	        "m+": this.getMinutes(), //分 
	        "s+": this.getSeconds(), //秒 
	        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
	        "S": this.getMilliseconds() //毫秒 
	    };
	    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	    for (var k in o)
	    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	    return fmt;
	}
</script>

</head>

<body onload="a('x')">
<!-- <div style="height:30px"></div>
	<button id="xsButton" hidden onclick="a('x')">九齿钉耙指标</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button id="xsButton1" hidden onclick="a('avg')">金箍棒指标 </button>
	<div style="height:30px"></div> -->	
	<div id="gmjl" >
		交易记录<br>
	</div>
	<div id="gxztsb" style="color:red"></div>
	<div id="content">
	</div>
	
</body>
</html>