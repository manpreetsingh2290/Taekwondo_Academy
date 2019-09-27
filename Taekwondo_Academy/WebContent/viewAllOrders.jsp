<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>

        <div class="text-center" style="padding:10px; padding-bottom:20px;">
            <h2>All Orders</h2>
        </div>
        
        <div class="container">
        <div class="row">
            <div class="col-md-11">
            
             <!-- <table class="table table-light table-hover"> -->
             <table id="tableFilterAndSort" class="display" style="width:100%">
             
                    <thead class="thead-dark">
                        <tr>
                            <th>Order ID</th>
                            <th>Student ID</th>
                            <th>Student Name</th>
                            <th>Purchase Date</th>   
                            <th></th>                        
                        </tr>
                    </thead>
                    <tbody>
                    
                    <s:iterator status="stat" value="list">
                    <tr>
                            <td><s:property value="orderID"/></td>
                            <td><s:property value="studentID"/> </td>
                             <td><s:property value="studentName"/> </td>
                            <td><s:property value="purchaseDate"/> </td>
                            <td><a  style="color:blue" href="ViewOrderDetails.action?orderID=<s:property value="orderID" />">Order Details</a></td>
                        </tr>
					</s:iterator>
                        
                    </tbody>
                    
                    <tfoot>
                        <tr>
                            <th>Order ID</th>
                            <th>Student ID</th>
                            <th>Student Name</th>
                            <th>Purchase Date</th>  
                              <th></th>                          
                        </tr>
                    </tfoot>
                </table>
            </div>
            </div>
        </div>

<%@ include file="footer.jsp" %>

<%@ include file="tableFilterAndSort.jsp" %>

