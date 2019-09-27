<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>

        <div class="text-center" style="padding:10px; padding-bottom:20px;">
            <h2>All RANKS</h2>
        </div>
        
        <div class="container">
        <div class="row">
            <div class="col-md-12" style="margin-top:20px">
            
             <!-- <table class="table table-light table-hover"> -->
             <table id="tableFilterAndSort" class="display" style="width:100%">
             
                    <thead class="thead-dark">
                        <tr>
                            <th>Rank Level</th>
                            <th>Belt Color</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    
                    <s:iterator status="stat" value="list">
                    <tr>
                            
                            <td><s:property value="rankLevel"/> </td>
                            <td><s:property value="beltColor"/></td>
                            <td><a  style="color:blue" href="StudentsForRank.action?rankID=<s:property value="rankID" />">View Students</a></td>                    
                        </tr>
					</s:iterator>
                        
                    </tbody>
                     <tfoot>
                        <tr>
                            <th>Rank Level</th>
                            <th>Belt Color</th>
                            <th></th>
                        </tr>
                    </tfoot>
                </table>
            </div>
            </div>
        </div>

<%@ include file="footer.jsp" %>

<%@ include file="tableFilterAndSort.jsp" %>
