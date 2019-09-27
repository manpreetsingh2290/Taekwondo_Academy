<%@ page language = "java" contentType = "text/html; charset = ISO-8859-1"
   pageEncoding = "ISO-8859-1"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
   <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Registration</title>

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>   

      <style>

        div {
            padding-bottom:20px;
        }

    </style>
</head>
<body>

    <div id="wrapper">
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Back to Admin</a>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li><a href="index.html"><i class="fa fa-home"></i> Dashboard</a></li>
                    <li class="selected"><a href="student.html"><i class="fa fa-user"></i> Student</a></li>
                    <li><a href="class.html"><i class="fa fa-cogs"></i> Classes</a></li>
                    <li><a href="inventory.html"><i class="fa fa-search"></i> Inventory</a></li>
                    <li><a href="orders.html"><i class="fa fa-shopping-cart"></i> Orders</a></li>
                    <li><a href="attendance.html"><i class="fa fa-list-ul"></i> Attendance</a></li>
                    <li><a href="upcoming-events.html"><i class="fa fa-calendar-o"></i> Upcoming events</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right navbar-user">
                    <li class="dropdown messages-dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> Messages <span class="badge">2</span> <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-header">2 New Messages</li>
                            <li class="message-preview">
                                <a href="#">
                                    <span class="avatar"><i class="fa fa-bell"></i></span>
                                    <span class="message">Security alert</span>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li class="message-preview">
                                <a href="#">
                                    <span class="avatar"><i class="fa fa-bell"></i></span>
                                    <span class="message">Security alert</span>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="#">Go to Inbox <span class="badge">2</span></a></li>
                        </ul>
                    </li>
                     <li class="dropdown user-dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Steve Miller<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                            <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                            <li class="divider"></li>
                            <li><a href="#"><i class="fa fa-power-off"></i> Log Out</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>

  <s:form action="StudentRegister">
        <div>
            <div class="row text-center">
                <h2>New Registration</h2>
            </div>
            <div>
                <div class="col-md-12">
                    <label for="firstName" class="col-md-2">
                        First Name:
                    </label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Enter First Name">
                    </div>
                    <div class="col-md-2"></div>
                    <label for="lastName" class="col-md-2 text-right">
                        Last Name:
                    </label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Enter Last Name">
                    </div>
                </div>
            </div>

            <div>
                <div class="col-md-12">
                    <label for="emailID" class="col-md-2">
                        Email address:
                    </label>
                    <div class="col-md-6">
                        <input type="email" class="form-control" name="emailID" id="emailID" placeholder="Enter email address">
                        <p class="help-block">
                            Example: yourname@domain.com
                        </p>
                    </div>
                </div>
            </div>

            <div>
                <div class="col-md-12">
                    <label for="dateOfBirth" class="col-md-2">
                        Date of Birth:
                    </label>
                    <div class="col-md-2">
                        <input type="date" class="form-control" name="dateOfBirth" id="dateOfBirth">
                    </div>
                    <div class="col-md-1"></div>
                    <label for="dateofjoining" class="col-md-2 text-right">
                        Date of Joining:
                    </label>
                    <div class="col-md-2">
                        <input type="date" class="form-control" id="doj" />
                    </div>
                </div>
            </div>
            

            <div>
                <div class="col-md-12">
                    <label for="phonenumber" class="col-md-2">
                        Contact Number:
                    </label>
                    <div class="col-md-3">
                        <input type="number" class="form-control" id="phonenumber" placeholder="Enter contact number">
                    </div>
                </div>
            </div>

            <div>
                <div class="col-md-12">
                    <label for="Gender" class="col-md-2">
                        Gender:
                    </label>
                    <div class="col-md-5">
                        <label class="radio">
                            <input type="radio" name="Gender" id="Gender" value="male">
                            Male
                        </label>
                    </div>
                    <div class="col-md-5">
                        <label class="radio">
                            <input type="radio" name="sex" id="sex" value="female">
                            Female
                        </label>
                    </div>
                </div>
            </div>
            
            <div>
                <div class="col-md-12">
                    <label for="address" class="col-md-2">
                        Address:
                    </label>
                    <div class="col-md-2">
                        <input type="text" class="form-control" name="houseNumber" id="houseNumber" placeholder="Unit Number">
                    </div>
                    <div class="col-md-2">
                        <input type="text" class="form-control" name="street" id="street" placeholder="Street name">
                    </div>
                    <div class="col-md-2">
                        <input type="text" class="form-control" name="city" id="city" placeholder="City">
                    </div>
                    <div class="col-md-2">
                        <input type="text" class="form-control" name="state"  id="state" placeholder="State">
                    </div>
                    <div class="col-md-2">
                        <input type="text" class="form-control" name="postalCode" id="postalCode" placeholder="Postal code">
                    </div>
                </div>
            </div>
            

            <div>
                <div class="col-md-12">
                    <label for="status" class="col-md-2">
                        Status:
                    </label>
                    <div class="col-md-5">
                        <label class="radio">
                            <input type="radio" name="status" id="status" value="1">
                            Active
                        </label>
                    </div>
                    <div class="col-md-5">
                        <label class="radio">
                            <input type="radio" name="status" id="status" value="0">
                            Inactive
                        </label>
                    </div>
                </div>
            </div>

            <div>
               <!--  <div class="col-md-12">
                    <label for="rank" class="col-md-2">
                        Rank
                    </label>
                    <div class="col-md-5">
                        <select class="form-control" id="rank" name="rank">
                            <option>White belt</option>
                            <option>Yellow belt</option>
                            <option>Orange belt</option>
                            <option>Green belt</option>
                            <option>Blue belt</option>
                            <option>Purple belt</option>
                            <option>Brown belt</option>
                            <option>Black belt</option>
                        </select>
                    </div>
                </div> -->
            </div>

            <div class="row">
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
    </div>
    

</body>
</html>
