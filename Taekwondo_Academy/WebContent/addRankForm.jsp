<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="headerAndSideBar.jsp" %>


        <s:form action="AddNewRank">
        <div>
            <div class="row text-center">
                <h2>New Belt Rank</h2>
            </div>
            
             <div class="col-md-12" style="margin-bottom:10px">
                    <label for="beltColor" class="col-md-2">
                       Belt Color:
                    </label>
                    <div class="col-md-4">
                        <input type="text"  required="required"  class="form-control" name="beltColor" id="beltColor" placeholder="Belt Color">
                    </div>            
                    <label for="rankLevel" class="col-md-2 text-right">
                       Rank Level:
                    </label>
                    <div class="col-md-4">
                        <input type="text"  required="required"  class="form-control" name="rankLevel" id="rankLevel" placeholder="Rank Level">
                    </div>
            </div>
            
            <div class="col-md-12" style="margin-top:10px">
                <div class="col-md-2">
                </div>
                <div class="col-md-10">
                    <button type="submit" class="btn btn-info" value="next">
                        Next
                    </button>
                </div>
            </div>
        </div>  
       </s:form>

<%@ include file="footer.jsp" %>
