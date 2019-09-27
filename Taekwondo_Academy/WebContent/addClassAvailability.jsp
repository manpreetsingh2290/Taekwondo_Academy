<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>


        <s:form action="AddClassAvailability">
        <div>
            <div class="row text-center">
                <h2>Class Availability Details for Class:<s:property value="classID"/></h2>
                 <s:hidden name="tempClassID" value="%{classID}" />
            </div>
            <div>
            <div class="col-md-12" style="margin-bottom:10px">
                <label for="classDescription" class="col-md-3">
                    Class Day:
                </label>
                <div class="col-md-6">
                       <!--  <input type="text" class="form-control" name="classDay" id="classDay" placeholder="Day"> -->
                        <select name="classDay"  required="required" class="form-control">
						  <option value="Sunday">Sunday</option>
						  <option value="Monday">Monday</option>
						  <option value="Tuesday">Tuesday</option>
						  <option value="Wednesday">Wednesday</option>
						  <option value="Thursday">Thursday</option>
						   <option value="Friday">Friday</option>
						   <option value="Saturday">Saturday</option>
						</select>
                </div>
            </div>
            <div class="col-md-12" style="margin-bottom:10px">
                <label for="classFee" class="col-md-3">
                    Start time(HH:MM AM/PM)
                </label>
                <div class="col-md-6">
                    <input type="time" required="required" class="form-control" name="startTime" id="startTime" placeholder="Start Time">
                </div>
            </div>
                    
            <div class="col-md-12" style="margin-bottom:10px">
                <label for="instructorID" class="col-md-3">
                    End time(HH:MM AM/PM)
                </label>
                <div class="col-md-6">
                    <input type="time" required="required" class="form-control" name="endTime" id="endTime" placeholder="End Time">
                </div>
            </div>
        </div>

        <div class="col-md-12" style="margin-top:10px">
            <div class="col-md-3">
            </div>
            <div class="col-md-4">
                <button type="submit" class="btn btn-info" value="next">
                    Save
                </button>
            </div>
        </div>
    </div>  
       </s:form>

<%@ include file="footer.jsp" %>
