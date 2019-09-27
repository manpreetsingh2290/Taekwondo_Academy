<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>


        <s:form action="AddStudentInClass">
        <div>
            <div class="row text-center">
                <h2>Add Student In class:<s:property value="classID"/></h2>
                 <s:hidden name="tempClassID" value="%{classID}" />
            </div>
            <div class="col-md-12" style="margin-bottom:10px">
                    <label for="classDescription" class="col-md-2">
                       Student:
                    </label>
                    <div class="col-md-4">
                       <!--  <input type="text" class="form-control" name="classDay" id="classDay" placeholder="Day"> -->
                       <s:select  required="required" list ="list" 
	                    headerValue="---Select---" headerKey="" 
	                    key="selectedStudentID" listKey="studentID" listValue="%{firstName+' '+ lastName +' ('+ studentID+')'}" class="form-control"/>
					 </div>
					 <!-- "%{name + ' : ' +  price + ' $/month'}" -->
					<div class="col-md-1"></div>
                    <label for="dateofjoining" class="col-md-2 text-right">
                        Begin Date:
                    </label>
                    <div class="col-md-2">
                        <input type="date"  required="required"  class="form-control" id="beginDate" name="beginDate" />
                    </div>
            </div>
            
            <div class="col-md-12" style="margin-top:10px">
                <div class="col-md-2">
                </div>
                <div class="col-md-4">
                    <button type="submit" class="btn btn-info" value="next">
                        Add
                    </button>
                </div>
            </div>
        </div>  
       </s:form>

<%@ include file="footer.jsp" %>
