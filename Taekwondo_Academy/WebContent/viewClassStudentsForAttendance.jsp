<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>

        <div class="text-center" style="padding:10px; padding-bottom:20px;">
            <h2>Mark Attendance for Class: <s:property value="classID"/></h2>
            
        </div>
        <div>
            <div class="col-md-12" style="margin-top:20px">
             <s:form action="MarkAttendance">
             <!-- <table class="table table-light table-hover"> -->
             <table id="tableFilterAndSort" class="display" style="width:100%">
                    <thead class="thead-dark">
                    <tr> 
                      <th></th>
                      <th></th>
                      <th></th>
	                    <th> 	                    		
                        Date
	                    <input type="date" class="form-control" name="attendanceDate" id="attendanceDate">                
	                    </th>
	                    <th></th>
	                    <th></th>
	                    <th></th>
	                </tr>
                        <tr>
                            <th>Student Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Contact number</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <s:hidden name="classID" value="%{classID}" />
                    <s:iterator status="stat" value="list">
                    <tr>
                            <td><s:property value="studentID"/></td>
                            <td><s:property value="firstName"/> </td>
                            <td><s:property value="lastName"/> </td>
                            <td><s:property value="emailID"/></td>
                            <td><s:property value="phoneNo"/></td>
                            <td><s:property value="status"/></td>
                            <td>
                            <!--<s:hidden name="studentID" value='<s:property value="studentID"/>'></s:hidden>
                            <input type="checkbox" name="attendanceStatus" value="<s:property value="studentID"/>" />
                            </td>
                            
                            <s:checkbox name="attendanceStatus" fieldValue="true" label=""/> -->
                            <s:hidden name="studentIDs" value="%{studentID}" />
                            <s:checkbox name="checkboxes[%{#stat.index}]"  />
                            </td>
                        </tr>                       
					</s:iterator>
                        <tr> 
	                        <td colspan="7">
	                            <button type="submit" class="btn btn-info" value="next">Submit
                      </button>
	                        </td> 
                        </tr>
                    </tbody>
                    
                    <tfoot>                   
                        <tr>
                            <th>Student Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                            <th>Contact number</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                    </tfoot>
                    
                </table>
                </s:form>
            </div>
        </div>

<%@ include file="footer.jsp" %>

<%@ include file="tableFilterAndSort.jsp" %>
