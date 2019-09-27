<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>

        <div class="text-center" style="padding:10px; padding-bottom:20px;">
            <h2>Classes for attendance</h2>
        </div>
        <div>
            <div class="col-md-12">
           
             <table id="tableFilterAndSort" class="display" style="width:100%">
                    <thead class="thead-dark">
                        <tr>
                            <th>Class ID</th>
                            <th>Class description</th>
                            <th>Instructor Name</th>
                           
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <s:iterator status="stat" value="list">
                        <tr>
                            <td><s:property value="classID"/></td>
                            <td><s:property value="classDescription"/> </td>
                            <td><s:property value="instructorName"/> </td>
                            <td><a  style="color:blue"  href="ClassStudentsForAttendance.action?classID=<s:property value="classID" />">Mark Attendance</a></td>
                            <td><a  style="color:blue"  href="ViewClassAttendanceFormSetup.action?classID=<s:property value="classID" />">View Class Attendance</a></td>
                        </tr>
					</s:iterator>
                        
                    </tbody>
                    <tfoot >
                        <tr>
                            <th>Class ID</th>
                            <th>Class description</th>
                            <th>Instructor Name</th>
                           
                            <th></th>
                            <th></th>
                        </tr>
                    </tfoot>
                </table>
                
            </div>
        </div>

<%@ include file="footer.jsp" %>

<%@ include file="tableFilterAndSort.jsp" %>
