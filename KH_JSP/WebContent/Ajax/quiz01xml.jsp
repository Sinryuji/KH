<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기통신</title>
</head>
<body>
Request:<input type="text" id="input"><br>
<div id="data">여기에 데이터 표시</div>
<a id="link" href="ajaxtest.txt">데이터 불러오기</a>
<script src="../resource/jquery-2.2.4.js"></script>
<script>
	window.onload = function(){
		var link = document.getElementById("link");
		link.onclick=function(e){
			e.preventDefault();
			asyncSend();
		}
	}
	
	function getXHR(){
		var req;
		try{
			req = new XMLHttpRequest();
		}catch(e){
			try{
				req = new ActiveXObject("Msxm12.XMLHTTP");
			}catch(e){
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		return req;
	}
	
	function asyncSend(){
		var req = getXHR();
		
		var input = $("#input").val();
		
		req.onreadystatechange = function(){
			var data = document.getElementById("data");
			if(req.readyState == 4){
				if(req.status == 200){
					xmlData = req.responseXML;
					alert(xmlData);
					txt = '';
					x = xmlData.getElementsByTagName(input);
					for(i = 0 ; i < x.length ; i++) {
						txt = txt + x[i].childNodes[0].nodeValue + "<br>";
					}
					data.innerHTML = txt;
				}else{
					data.innerHTML = "Server Error!";
				}
			}else{
				data.innerHTML = "Loading...";
			}
		}
		
		req.open('GET', 'cd_catalog.xml');
		req.send(null);		
	}
</script>
</body>
</html>