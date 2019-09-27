<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>

        <div class="text-center" style="padding:10px; padding-bottom:20px;">
            <h2>All Products</h2>
        </div>
        <div>
            <div class="col-md-12" style="margin-top:20px">
            
             <!-- <table class="table table-light table-hover"> -->
             <table id="tableFilterAndSort" class="display" style="width:100%">
             
                    <thead class="thead-dark">
                        <tr>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Product Description</th>
                            <th>Cost Price</th> 
                            <th>Selling Price</th> 
                            <!-- <th>Creation Time</th> -->
                        </tr>
                    </thead>
                    <tbody>
                    
                    <s:iterator status="stat" value="list">
                    <tr>
                            <td><s:property value="productID"/></td>
                            <td><s:property value="productName"/> </td>
                            <td><s:property value="productDescription"/> </td>
                            <td><s:property value="costPrice"/></td>
                            <td><s:property value="sellingPrice"/></td>                            
                           <%--  <td><s:property value="creationTime"/></td> --%>
                            </tr>
					</s:iterator>
                        
                    </tbody>
                    <tfoot>
                        <tr>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Product Description</th>
                            <th>Cost Price</th> 
                            <th>Selling Price</th> 
                            <!-- <th>Creation Time</th> -->
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>

<%@ include file="footer.jsp" %>

<%@ include file="tableFilterAndSort.jsp" %>
