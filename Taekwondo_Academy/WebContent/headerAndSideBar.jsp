<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Dark Admin</title>

    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="css/local.css" />

    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css" />
    <link id="gridcss" rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/dark-bootstrap/all.min.css" />

    <script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
    <script type="text/javascript" src="http://www.prepbootstrap.com/Content/js/gridData.js"></script>
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
                <a class="navbar-brand" href="index.html">Admin Panel</a>
            </div>
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul id="active" class="nav navbar-nav side-nav">
                    <li><a href="dashboard"><i class="fa fa-home"></i> Dashboard</a></li>
                    <li><a href="student"><i class="fa fa-user"></i> Student</a></li>
                    <li><a href="class"><i class="fa fa-cogs"></i> Classes</a></li>
                    <li><a href="inventory"><i class="fa fa-search"></i> Inventory</a></li>
                    <li><a href="order"><i class="fa fa-shopping-cart"></i> Orders</a></li>
                    <li><a href="attendance"><i class="fa fa-list-ul"></i> Attendance</a></li>
                    <li><a href="rank"><i class="fa fa-trophy"></i> Rank</a></li>
                    <li><a href="fee"><i class="fa fa-money"></i> Fee</a></li>
                    <li><a href="ViewAllStudents"><i class="fa fa-line-chart" aria-hidden="true"></i> Student Progress</a></li>
                    <!--<li><a href="check"><i class="fa fa-line-chart" aria-hidden="true"></i> Check</a></li>
                    <li><a href="check2"><i class="fa fa-line-chart" aria-hidden="true"></i> Revenue</a></li>
                   -->
                    <!-- <li><a href="upcoming-events.html"><i class="fa fa-calendar-o"></i> Upcoming events</a></li> -->
                </ul>
                <ul class="nav navbar-nav navbar-right navbar-user">
                   <!-- <li class="dropdown messages-dropdown">
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
                    </li> -->
                    <li class="dropdown user-dropdown">
                    
                   
                    
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-user">
                        </i> 
                        <s:property value="#session.USER.firstName"/>
                        &nbsp;
                        <s:property value="#session.USER.LastName"/>
                        <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="fa fa-user"></i> Profile</a></li>
                            <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                            <li class="divider"></li>
                            <li><a href="logout"><i class="fa fa-power-off"></i> Log Out</a></li>

                        </ul>
                    </li>
                    <li class="divider-vertical"></li>
                    <li>
                        <form class="navbar-search">
                            <input type="text" placeholder="Search" class="form-control">
                        </form>
                    </li>
                </ul>
            </div>
        </nav>
 <div id="page-wrapper">
            