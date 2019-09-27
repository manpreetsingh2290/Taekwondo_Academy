<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
 <%@ taglib prefix = "s" uri = "/struts-tags"%>
<%
String revenueData =  (String)request.getAttribute("revenue");
%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chartRevenue = new CanvasJS.Chart("chartContainerRevenue", {
	
	exportEnabled: true,
	title: {
		text: "Month Wise Revenue Report"
	},
	axisY: {
		title: "Amount",
		includeZero: true,
		
	},
	data: [{
		type: "area",
		markerSize: 0,
		xValueFormatString: "Date #",
		yValueFormatString: "#",
		dataPoints: <%out.print(revenueData);%>
	}]
});
chartRevenue.render();
 
}
</script>
</head>
<body>
<s:property value="revenue"/>
<div id="chartContainerRevenue" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>