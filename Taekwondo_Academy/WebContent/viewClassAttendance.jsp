<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>

        <div class="text-center" style="padding:10px; padding-bottom:20px;">
            <h2>Attendance Details for Class: <s:property value="classID"/>
            &nbsp;Date:<s:property value="trimmedAttendanceDate"/>
            </h2>
            
        </div>
        <div>
            <div class="col-md-12" style="margin-top:20px">
            
             
           <b align="center">  Class ID:<s:property value="classID"/> &nbsp;&nbsp;
	         Date:<s:property value="trimmedAttendanceDate"/>
	        </b> 
	        <div class="col-md-12" style="margin-top:20px">
	        </div>  
             <table id="tableFilterAndSort" class="display" style="width:100%">
                    <thead class="thead-dark">                   
                        <tr>
                            <th>Student Id</th>                            
                            <th>First Name</th>  
                            <th>Last Name</th>   
                            <th>Attendance Status</th>                        
                        </tr>
                    </thead>
                    <tbody>
                    <s:hidden name="classID" value="%{classID}" />
                    <s:iterator status="stat" value="list">
                    <tr>
                            <td><s:property value="studentID"/></td>
                            <td><s:property value="studentFirstName"/> </td>
                             <td><s:property value="studentLastName"/> </td>
                           <td><s:property value="status"/> </td>
                        </tr>                       
					</s:iterator>                       
                    </tbody>
                    
                    <tfoot>                   
                        <tr>
                             <th>Student Id</th>                            
                            <th>First Name</th>  
                            <th>Last Name</th>   
                            <th>Attendance Status</th> 
                        </tr>
                    </tfoot>
                    
                </table>
               
            </div>
        </div>

<%@ include file="footer.jsp" %>

<%@ include file="tableFilterAndSort.jsp" %>
