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
             <s:form action="ViewAllRanks">
             <table class="table table-light table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>StudentId</th>
                            <th>Firstname</th>
                            <th>Lastname</th>
                            <th>Email</th>
                            <th>Emergency Contact</th>
                            <th>Contact number</th>
                            <th>Status</th>
                            
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
                            <td><s:property value="emergencyContact"/></td>                            
                            <td><s:property value="phoneNo"/></td>
                            <td><s:property value="status"/></td>
                           
                           
                            
                        </tr>                       
					</s:iterator>
                        <tr> 
	                        <td colspan="7">
	                            <button type="submit" class="btn btn-info" value="next">Next
                      </button>
	                        </td> 
                        </tr>
                    </tbody>
                </table>
                </s:form>
            </div>
        </div>

<%@ include file="footer.jsp" %>

