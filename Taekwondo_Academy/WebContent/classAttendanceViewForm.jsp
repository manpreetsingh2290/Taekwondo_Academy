<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>


        <s:form action="ViewClassAttendance">
        <div>
            <div class="row text-center">
                <h2>Class ID: <s:property value="classID"/></h2>
                 <s:hidden name="classID" value="%{classID}" />
            </div>
            
            <div class="col-md-12" style="font-size:medium margin-bottom:10px">              
				<div class="col-md-1"></div>
				<label for="dateofjoining" class="col-md-2 text-right">
                        Attendance Date:
                </label>
                <div class="col-md-2">
                    <input type="date"  required="required"  class="form-control" id="attendanceDate" name="attendanceDate" />
                </div>
            </div>
			
            <div class="col-md-12" style="margin-top:20px">
                <div class="col-md-2"></div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-info" value="next">
                        View
                    </button>
                </div>
            </div>
        </div>  
       </s:form>

<%@ include file="footer.jsp" %>
