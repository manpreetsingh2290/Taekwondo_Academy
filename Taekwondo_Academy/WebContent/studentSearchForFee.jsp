<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>


        <s:form action="searchStudentForFee">
        <div>
            <div class="row text-center">
                <h2>Search Student</h2>
            </div>
            <div claa="container">
            <div class="col-md-12">
                <div class="col-md-2">
                    <label for="studentID" >
                       Student ID:
                    </label>
                    </div>
                    <div class="col-md-4">
                        <input type="number" class="form-control" name="studentID" id="studentID" placeholder="studentID">
                    </div>
                    
                    </div>
                
            </div>
                </div>
            

            
        
            

            <div class="col-md-12">
                <div class="col-md-2">
                </div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-info" value="next" style="margin-top:20px">
                        Next
                    </button>
                </div>
            </div>
        </div>  
       </s:form>

<%@ include file="footer.jsp" %>
