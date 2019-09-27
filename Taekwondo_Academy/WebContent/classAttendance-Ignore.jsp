<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>

        <div class="text-center" style="padding:10px; padding-bottom:20px;">
            <h2>All STUDENTS</h2>
        </div>
        <div>
            <div class="col-md-12" style="margin-top:20px">
            
             <table class="table table-light table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>Student ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email ID</th> 
                            <th>Emergency Contact</th> 
                            <th>Phone No</th>
                            <th>Status</th>                       
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <s:iterator status="stat" value="list">
                    <tr>
                            <td><s:property value="studentID"/></td>
                            <td><s:property value="firstName"/> </td>
                            <td><s:property value="lastName"/> </td>
                            <td><s:property value="emailID"/></td>
                            <td><s:property value="emergencyContact"/></td>                            
                            <td><s:property value="phoneNo"/></td>
                            <td><s:property value="status"/></td>
                            <td>
                            Absent
                            	<input type="radio" name="attendanceStatus" id="attendanceStatus" value="A">
                            </td>
                            <td>
                            Present
                            	<input type="radio" name="attendanceStatus" id="attendanceStatus" value="P">
                            </td>                      
                        </tr>
					</s:iterator>
                        
                    </tbody>
                </table>
            </div>
        </div>

<%@ include file="footer.jsp" %>

