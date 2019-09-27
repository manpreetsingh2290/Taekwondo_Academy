<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>

        <div class="text-center" style="padding:10px; padding-bottom:20px;">
            <h2>All CLASSES</h2>
        </div>
        
        <div>
        
            <div class="col-md-12" style="margin-top:20px">
            
             <!-- <table class="table table-light table-hover"> -->
             <table id="tableFilterAndSort" class="display" style="width:100%">
             
                    <thead class="thead-dark">
                        <tr>
                            <th>Class ID</th>
                            <th>Class description</th>
                            <th>Class Fee</th>
                            <th>Instructor ID</th>       
                            <th>Instructor Name</th>                                                                                         
                            <th>View Class Students</th>
                            <th>Add Students</th>
                            <th>Add Schedule</th> 
                            <th>View Schedule</th> 
                        </tr>
                    </thead>
                    <tbody>
                    
                    <s:iterator status="stat" value="list">
                    <tr>
                            <td><s:property value="classID"/></td>
                            <td><s:property value="classDescription"/> </td>
                            <td><s:property value="classFee"/> </td>
                            <td><s:property value="instructorID"/></td>
                            <td><s:property value="instructorName"/></td>
                            <!-- ADD view class student bellow -->
                            <td><a style="color:blue" href="ViewClassStudents.action?classID=<s:property value="classID" />">View Students</a></td>
                            <td><a style="color:blue"  href="AddStudentInClassFormSetup.action?classID=<s:property value="classID" />">Add Students</a></td>
                            <td><a style="color:blue"  href="AddClassAvailabilityFormSetup.action?classID=<s:property value="classID" />">Add Schedule</a></td>
                            <td><a style="color:blue"  href="ViewClassSchedule.action?tempClassID=<s:property value="classID" />">View Schedule</a></td>
                            
                        </tr>
					</s:iterator>
                        
                    </tbody>
                    <tfoot>
                        <tr>
                            <th>Class ID</th>
                            <th>Class description</th>
                            <th>Class Fee</th>
                            <th>Instructor ID</th>
                            <th>Instructor Name</th>                                                                                            
                            <th>View Class Students</th>
                            <th>Add Students</th>
                            <th>Add Schedule</th> 
                            <th>View Schedule</th> 
                        </tr>
                    </tfoot>
                </table>
            </div>
            
        </div>

<%@ include file="footer.jsp" %>

<%@ include file="tableFilterAndSort.jsp" %>
