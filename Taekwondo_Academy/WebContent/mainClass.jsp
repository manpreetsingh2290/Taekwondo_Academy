<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">


<%@ include file="headerAndSideBar.jsp" %>

        <div class="container">
            <div class="row">
                <div class="text-center">
                    <h1 style="padding:20px">Classes</h1>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="well">
                            <a href="AddNewClassForm" title="New Class"><img class="thumbnail img-responsive" alt="New Class" src="images/add_class.png" width="300" height="300" /></a>                            
                            <a href="AddNewClassForm">New Class</a>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="well">
                            <a href="ViewAllClasses" title="View All Classes"><img class="thumbnail img-responsive" alt="View All Classes" src="images\view_classes.jpg" width="300" height="300" /></a>
                            <a href="ViewAllClasses">View All Classes</a>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
 <%@ include file="footer.jsp" %>
<style>
        img {
            filter: gray; /* IE6-9 */
            -webkit-filter: grayscale(1); /* Google Chrome, Safari 6+ & Opera 15+ */
            -webkit-box-shadow: 0px 2px 6px 2px rgba(0,0,0,0.75);
            -moz-box-shadow: 0px 2px 6px 2px rgba(0,0,0,0.75);
            box-shadow: 0px 2px 6px 2px rgba(0,0,0,0.75);
            margin-bottom: 20px;
        }

            img:hover {
                filter: none; /* IE6-9 */
                -webkit-filter: grayscale(0); /* Google Chrome, Safari 6+ & Opera 15+ */
            }
    </style>
