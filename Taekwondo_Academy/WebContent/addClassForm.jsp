<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>


        <s:form action="AddNewClass">
        <div>
            <div class="row text-center">
                <h2>New Class</h2>
            </div>
            <div>
            <div class="col-md-12" style="margin-bottom:10px">
                <label for="classDescription" class="col-md-2">
                    Class Description:
                </label>
                <div class="col-md-6">
                    <input type="text" required="required" class="form-control" name="classDescription" id="classDescription" placeholder="classDescription">
                </div>
            </div>
			
            <div class="col-md-12" style="margin-bottom:10px">
                <label for="classFee" class="col-md-2">
                    Class Fee:
                </label>
                <div class="col-md-3">
					<input type="number" required="required" class="form-control" name="classFee" id="classFee" placeholder="Class Fee">
                </div>
				<label class="col-md-2 text-left">
                    CAD
                </label>
            </div>
                    
            <div class="col-md-12" style="margin-bottom:10px">
				<label for="instructorID" class="col-md-2">
                    Instructor ID:
                </label>
                <div class="col-md-3">
                   <!--  <input type="number" required="required" class="form-control" name="instructorID" id="instructorID" placeholder="instructorID">
                     -->
                    <s:select  required="required"  list ="allInstructorList" 
	                    headerValue="---Select---" headerKey="" 
	                    key="instructorID" listKey="instructorID" listValue="%{firstName+' '+ lastName}" class="form-control"/>					 
                    
                </div>
            </div>
			</div>
            <div class="col-md-12" style="margin-top:10px">
                <div class="col-md-2">
                </div>
                <div class="col-md-4">
                    <button type="submit" class="btn btn-info" value="next">
                        Next
                    </button>
                </div>
            </div>
        </div>  
       </s:form>

<%@ include file="footer.jsp" %>
