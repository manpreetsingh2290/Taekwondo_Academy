<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>


        <s:form action="AddStudentRank">
        <div>
            <div class="row text-center">
                <h2>Add Rank for Student ID: <s:property value="studentID"/></h2>
                 <s:hidden name="tempStudentID" value="%{studentID}" />
            </div>
            
            <div class="col-md-12" style="font-size:medium margin-bottom:10px">
                
                <label for="classDescription" class="col-md-2">
                       Belt:  
                </label>                
                <div class="col-md-2">
                    <!--  <input type="text" class="form-control" name="classDay" id="classDay" placeholder="Day"> -->
                    <s:select list ="list"  required="required" 
	                headerValue="---Select---" headerKey="" 
	                key="selectedBeltRank" listKey="rankID" listValue="beltColor" class="form-control"/>
				</div>
				<div class="col-md-1"></div>
				<label for="dateofjoining" class="col-md-2 text-right">
                        Rank Attain Date:
                </label>
                <div class="col-md-2">
                    <input type="date"  required="required"  class="form-control" id="rankAttainDate" name="rankAttainDate" />
                </div>
            </div>
			
            <div class="col-md-12" style="margin-top:20px">
                <div class="col-md-2"></div>
                <div class="col-md-3">
                    <button type="submit" class="btn btn-info" value="next">
                        Add
                    </button>
                </div>
            </div>
        </div>  
       </s:form>

<%@ include file="footer.jsp" %>
