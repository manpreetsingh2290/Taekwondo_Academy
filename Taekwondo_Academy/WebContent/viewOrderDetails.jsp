<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>

        <div class="text-center" style="padding:10px; padding-bottom:20px;">
            <h2>Order Details</h2>
        </div>
        <div>
            <div class="col-md-12" style="margin-bottom:10px">
				<h3 class="col-md-6" style="color:black"> Student ID: <s:property value="orderDetails.orderID"/></h3>
				<h3 class="col-md-6" style="color:black">Purchase Date: <s:property value="orderDetails.purchaseDate"/> </h3>
			</div>
			<div>
             <table class="table table-light table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>Order ID</th>
                            <th>Product ID</th>
                             <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Unit Price</th> 
                            <th>Total Amount</th> 
                           
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <s:iterator status="stat" value="purchaseProductsList">
                    <tr>
                    		<td><s:property value="orderID"/></td>
                            <td><s:property value="productID"/></td>
                            <td><s:property value="productName"/></td>
                            <td><s:property value="productQuantity"/> </td>
                            <td><s:property value="unitPrice"/> </td>
                            <td><s:property value="totalAmount"/></td>                           
                            </tr>
					</s:iterator>
                        <tr>
                        <th colspan="6">Total Invoice Amount: <s:property value="totalInvoiceAmount"/></th>
                        
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

<%@ include file="footer.jsp" %>

<%@ include file="tableFilterAndSort.jsp" %>
