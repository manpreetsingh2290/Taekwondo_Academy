<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>


        <s:form action="AddFee">
        <div>
        <s:hidden name="studentID" value="%{studentID}" />
        <s:hidden name="classID" value="%{classID}" />
        <s:hidden name="feeAmount" value="%{classFee}" />
            <div class="row text-center">
                <h2>Fee Submission</h2>
            </div>
            <div claa="container" style="font-size:medium">
            <div class="col-md-12">
            	<label for="studentID" class="col-md-2">
            		Student ID: 
            	</label>
                <div class="col-md-6">
                    <s:property value="studentID"/>
                </div>
                                       
            </div>
                    
            <div class="col-md-12">
                <label for="studentName" class="col-md-2">
                      Student Name: 
                </label>
				<div class="col-md-4">
					<s:property value="studentName"/>
                </div>
            </div>
                    
                    
            <div class="col-md-12">
                <label for="classID" class="col-md-2">
                       Class ID: 
                </label>
				<div class="col-md-4">
					<s:property value="classID"/>
                </div>
            </div>
                    
            <div class="col-md-12">
                <label for="className" class="col-md-2">
                       Class Description: 
                </label>
				<div class="col-md-4">
					<s:property value="className"/>
				</div>	
            </div>
                    
            <div class="col-md-12">
                <label for="feeAmount" class="col-md-2">
                       Fee Amount: 
                </label>
                <div class="col-md-2">
					<s:property value="classFee"/> CAD
				</div>
            </div>
                    
                    
            <div class="col-md-12">
                <label for="paymentDate" class="col-md-2">
                    Payment Date:
                </label>
                <div class="col-md-3">
                    <input type="date" required="required" class="form-control" name="paymentDate" id="paymentDate">
                </div>
            </div>
            
            </div>
        </div>

        <div class="col-md-12">
            <div class="col-md-2"></div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-info" value="next" style="margin-top:20px">
                    Next
                </button>
            </div>
		</div>  
       </s:form>

<%@ include file="footer.jsp" %>
