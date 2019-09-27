<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>

        
        <div>
            <div class="row text-center">
                <h2>STUDENT DETAILS</h2>
            </div>
            <!--  
            <div class="col-md-12" style="font-size: medium">
            <label class="col-md-2">
            Student ID: 
            </label>
            <div class="col-md-4">
            <p> <s:property value="student.studentID"/></p>
            </div>
            <label class="col-md-2">
            Class ID: 
            </label>
            <div class="col-md-4">
            <p> <s:property value="classTaken.classID"/></p>
            </div>
            <s:form action="ViewClassSchedule">
            <s:hidden name="tempClassID" value="%{classTaken.classID}" />
            <button type="submit" class="btn btn-info" value="ViewClassSchedule">
                        View Class Schedule
                    </button>
             </s:form>
            </div>
            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="firstName" class="col-md-2">
                        First Name:
                    </label>
                    <div class="col-md-2">
                        <s:property value="student.firstName"/>
                    </div>
                    
                    <label for="lastName" class="col-md-2 text-right">
                        Last Name:
                    </label>
                    <div class="col-md-2">
                        <s:property value="student.lastName"/>
                    </div>
                </div>
            </div>

            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="emailID" class="col-md-2">
                        Email address:
                    </label>
                    <div class="col-md-6">
                        <s:property value="student.emailID"/>
                    </div>
                </div>
            </div>

            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="dateOfBirth" class="col-md-2">
                        Date of Birth:
                    </label>
                    <div class="col-md-2">
                        <s:property value="student.dateOfBirth"/>
                    </div>
                    <label for="dateofjoining" class="col-md-2 text-right">
                        Date of Joining:
                    </label>
                    <div class="col-md-2">
                        <s:property value="student.dateOfJoining"/>
                    </div>
                </div>
            </div>
            

            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="phonenumber" class="col-md-2">
                        Contact Number:
                    </label>
                    <div class="col-md-2">
                        <s:property value="student.phoneNo"/>
                    </div>
                    <label for="phonenumber" class="col-md-2 text-right">
                        Emergency Contact Number:
                    </label>
                    <div class="col-md-2">
                        <s:property value="student.emergencyContact"/>
                    </div>
                </div>
            </div>

            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="Gender" class="col-md-2">
                        Gender:
                    </label>
                    <div class="col-md-3">
                        <s:property value="student.gender"/>
                    </div>
                </div>
            </div>
            
            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="address" class="col-md-2">
                        Address:
                    </label>
                    <div class="col-md-1">
                       <s:property value="student.houseNumber"/>&nbsp;
                        <s:property value="student.street"/>&nbsp;
                        <s:property value="student.city"/>&nbsp;
                        <s:property value="student.state"/>&nbsp; 
                        <s:property value="student.postalCode"/>&nbsp;
                    </div>
                </div>
            </div> -->
            
            <div class="col-md-12">
			<label class="col-md-2">
				Student ID
			</label>
			<div class="col-md-4">
				<s:property value="student.studentID"/>
			</div>
			<div class="col-md-4"></div>
			<div class="col-md-2">
			<s:form action="ViewClassSchedule">
            <s:hidden name="tempClassID" value="%{classTaken.classID}" />
            <button type="submit" class="btn btn-info" value="ViewClassSchedule">
                        View Class Schedule
                    </button>
             </s:form>
			</div>
		</div>		
		
		
		
		<div>
            <div class="col-md-12" style="margin-top:20px">
            
             <table class="table table-light table-hover">
                    <thead class="thead-dark">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email ID</th>
							<th>Date of Birth</th>
							<th>Date of Joining</th>
                            <th>Emergency Contact</th> 
                            <th>Phone No</th>
							<th>Address</th>
                            <th>Status</th>                       
                        </tr>
                    </thead>
                    <tbody>
                    
                    <tr>
                            <td><s:property value="student.firstName"/> </td>
                            <td><s:property value="student.lastName"/> </td>
                            <td><s:property value="student.emailID"/></td>
							<td><s:property value="trimmedDOB"/></td>
							<td><s:property value="trimmedDOJ"/></td>
                            <td><s:property value="student.emergencyContact"/></td>                            
                            <td><s:property value="student.phoneNo"/></td>
							<td><s:property value="student.houseNumber"/>&nbsp;
                        <s:property value="student.street"/>&nbsp;
                        <s:property value="student.city"/>&nbsp;
                        <s:property value="student.state"/>&nbsp; 
                        <s:property value="student.postalCode"/>&nbsp;</td>
                            <td><s:property value="student.status"/></td>                      
                        </tr>
					
                        
                    </tbody>
                </table>
            </div>
        </div>
            
        </div>
        
        <div class="row text-center">
                <h2>PARENT DETAILS</h2>
        </div>
        
        <!--
        <div>
            <div class="col-md-12" style="font-size: medium">
            <label class="col-md-2">
            Parent ID: 
            </label>
            <div class="col-md-4">
             <s:property value="parentID"/>
            </div>
            </div>
             <div class="col-md-12" style="font-size: medium">
            <label class="col-md-2">
            Relation with student 
            </label>
            <div class="col-md-4">
             <s:property value="relation"/>
            </div>
            </div>
            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="firstName" class="col-md-2">
                        First Name:
                    </label>
                    <div class="col-md-2">
                        <s:property value="firstName"/>
                    </div>
                    <label for="lastName" class="col-md-2 text-right">
                        Last Name:
                    </label>
                    <div class="col-md-3">
                        <s:property value="lastName"/>
                    </div>
                </div>
            </div>

            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="emailID" class="col-md-2">
                        Email address:
                    </label>
                    <div class="col-md-6">
                        <s:property value="emailID"/>
                    </div>
                </div>
            </div>

            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="dateOfBirth" class="col-md-2">
                        Date of Birth:
                    </label>
                    <div class="col-md-2">
                        <s:property value="dateOfBirth"/>
                    </div>                    
                </div>
            </div>
            

            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="phonenumber" class="col-md-2">
                        Contact Number:
                    </label>
                    <div class="col-md-3">
                        <s:property value="emailID"/>
                    </div>
                </div>
            </div>

            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="Gender" class="col-md-2">
                        Gender:
                    </label>
                    <div class="col-md-3">
                        <s:property value="gender"/>
                    </div>
                </div>
            </div>
            
            <div>
                <div class="col-md-12" style="font-size: medium">
                    <label for="address" class="col-md-2">
                        Address:
                    </label>
                    <div class="col-md-2">
                        <s:property value="houseNumber"/>&nbsp;
                        <s:property value="street"/>&nbsp;
                        <s:property value="city"/>&nbsp;
                        <s:property value="state"/>&nbsp; 
                        <s:property value="postalCode"/>&nbsp;
                    </div>
                </div>
            </div>
            
        </div>
        -->
        
        <div>
            <div class="col-md-12" style="margin-top:20px">
            
             <table class="table table-light table-hover">
                    <thead class="thead-dark">
                        <tr>
                        	<th>Parent ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email ID</th>
							<th>Date of Birth</th> 
                            <th>Phone No</th>
							<th>Address</th>
                            <th>Status</th>                       
                        </tr>
                    </thead>
                    <tbody>
                     <s:iterator status="stat" value="parentsList">
                    <tr>
                            <td><s:property value="parentID"/></td>
                            <td><s:property value="firstName"/> </td>
                            <td><s:property value="lastName"/> </td>
                            <td><s:property value="emailID"/></td>
							<td><s:property value="trimmedParentDOB"/></td>                            
                            <td><s:property value="phoneNo"/></td>
							<td><s:property value="houseNumber"/>&nbsp;
                        	<s:property value="street"/>&nbsp;
                        	<s:property value="city"/>&nbsp;
                        	<s:property value="state"/>&nbsp; 
                        	<s:property value="postalCode"/>&nbsp;</td>
                            <td><s:property value="student.status"/></td>                      
                        </tr>
					 </s:iterator>
                        
                    </tbody>
                </table>
            </div>
        </div> 
       

<%@ include file="footer.jsp" %>

