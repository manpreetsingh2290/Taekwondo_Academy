<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%@ taglib prefix = "s" uri = "/struts-tags"%>

<%@ include file="headerAndSideBar.jsp" %>
<%

String name =  (String)request.getAttribute("studentName");
String data =  (String)request.getAttribute("studentProgress");
%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	exportEnabled: true,
	theme: "light2",
	title: {
		text: "Student Rank Progress For <%out.print(name);%>"
	},
	axisX: {
		valueFormatString: "MMM",
		crosshair: {
			enabled: true,
			snapToDataPoint: true
		}
	},
	axisY: {
		title: "Rank Level",
		includeZero: false,
		
		crosshair: {
			enabled: true,
			snapToDataPoint: true,
			valueFormatString: "#",
		}
	},
	data: [{
		type: "area",
		xValueFormatString: "Date #",
		yValueFormatString: "Rank #",
		 indexLabel: "Belt : {Belt}",
		dataPoints: <%out.print(data);%> 
	}]
});
chart.render();
 
}
</script>
</head>
<body>
<%-- 
<Strong>Student Name</Strong>
<s:property value="studentProgress"/> --%>


<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<div align="right" style="margin-top:30px;">

                  
                
<a href="ViewAllStudents"><button  type="button" class="btn btn-info" >Done</button></a>

</div>

<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
<%@ include file="footer.jsp" %>
