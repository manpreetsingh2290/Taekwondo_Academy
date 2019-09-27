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
                        	<th>Student ID</th>
                        	<th>Student Name</th>
                            <th>Class ID</th>
                            <th>Class Description</th>
                            <th>Fee Amount</th>
                            <th>Payment Date</th>                                                                                                
                             
                        </tr>
                    </thead>
                    <tbody>
                    
                    <s:iterator status="stat" value="list">
                    <tr>
							<td><s:property value="studentID"/></td>
							<td><s:property value="studentName"/></td>
                            <td><s:property value="classID"/></td>
                            <td><s:property value="className"/></td>
                            <td><s:property value="feeAmount"/> </td>
                            <td><s:property value="paymentDate"/> </td>
                             
                        </tr>
					</s:iterator>
                        
                    </tbody>
                    <tfoot>
                        <tr>
                        	<th>Student ID</th>
                        	<th>Student Name</th>
                            <th>Class ID</th>
                            <th>Class Description</th>
                            <th>Fee Amount</th>
                            <th>Payment Date</th>                                                                                                
                             
                        </tr>
                    </tfoot>
                </table>
            </div>
            
        </div>

<%@ include file="footer.jsp" %>

<%@ include file="tableFilterAndSort.jsp" %>
