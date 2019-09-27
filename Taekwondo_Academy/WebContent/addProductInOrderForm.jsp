<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>


        
       
        <s:form method="post" action="AddNewProductInOrder">       
        <div>
            <div class="row text-center">
                <h2>New Product in Order:<s:property value="tempOrderID"/></h2>
                 <s:hidden name="tempOrderID" value="%{tempOrderID}" />
            </div>
            <div>
            
            
                <!-- <div class="col-md-12">
                    <label for="productID" class="col-md-2">
                        Product ID:
                    </label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" name="productID" id="productID" placeholder="Product ID">
                    </div>
                   
                <div>-->
                <div class="col-md-12" style="margin-bottom:10px">
                <label for="productID" class="col-md-2">
                        Select Product:
                    </label>
	                <div class="col-md-3">
	                    <s:select  required="required"  list ="allProductsList" 
	                    headerValue="---Select---" headerKey="-1" 
	                    key="selectedProductID" listKey="productID" listValue="productName" class="form-control"/>
					 </div>
					 
					 <div class="col-md-1"></div>
					 <label for="productQuantity" class="col-md-2 text-right">
                        Quantity:
                    </label>
                    <div class="col-md-2">
                        <input type="number"    min="1" max="100" class="form-control" name="selectedProductQuantity" id="selectedProductQuantity">
                    </div>
            	</div>
            	<div>
            		<p>
            		
            		
            		</p>
            	</div>

           <!--  <div>
                <div class="col-md-12">
                    <label for="price" class="col-md-2">
                        Price:
                    </label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="price" id="price" placeholder="Price">                   
                    </div>
                </div>
            </div>
            -->
           
           

      <!-- <s:form method="post" action="mySubmitAction">
    <s:submit value="Submit"/>
    <s:submit value="Clear" action="myClearAction"/>
</s:form> -->


            
            <div class="col-md-12" style="margin-top:10px margin-bottom:10px">
                <div class="col-md-2"></div>
                <div class="col-md-2">
                  <s:submit class="btn btn-info" value="Add more" name="buttonName" action="AddNewProductInOrder"/>
                </div>
                
                <div class="col-md-3">
                   <s:submit class="btn btn-info" value="Finish" name="buttonName" action="AddFinalProductInOrder"/>
                   <!-- <button type="submit" value="Submit" name="buttonName">
<button type="submit" value="Clear" name="buttonName"> -->
                </div>
            </div>
            
            <div class="col-md-12" style="margin-top:10px">
            
             <table class="table table-light table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>Product ID</th>
                              <th>Product Name</th>
                            <th>Quantity</th>
                            <th>Unit Price</th>
                            <th>Total Amount</th> 
                        
                        </tr>
                    </thead>
                    <tbody>
                    
                    <s:iterator status="stat" value="purchaseProductsList">
                    <tr>
                            <td><s:property value="productID"/></td>
                            <td><s:property value="productName"/></td>
                            <td><s:property value="productQuantity"/> </td>
                            <td><s:property value="unitPrice"/> </td>
                            <td><s:property value="totalAmount"/></td>                           
                            </tr>
					</s:iterator>
                        
                    </tbody>
                </table>
            </div>
            
        </div>  
       </s:form>

<%@ include file="footer.jsp" %>
