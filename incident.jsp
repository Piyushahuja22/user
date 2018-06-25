<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  


<title>Incidents</title>

 
    <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/dashboard_new.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style_new.css" rel="stylesheet" />
    	<%@ page import="com.instainsurance.insuranceappl.models.*" %> 
   	<%@ page import="javax.servlet.http.HttpSession" %> 
    
</head>
<body>

	<%
	
	HttpSession s=request.getSession(false);
	Customer customer=null;
	if(s !=null){
		System.out.println("session ok");
		
	customer =(Customer)s.getAttribute("name");
	
	}
	
	%>


 <section id="container">
        <header class="header black-bg">
            <a href="#" class="logo">
                <b>INSTA
                    <span style="color:#444c57">INSURANCE</span>
                </b>
            </a>
            <!--logo end-->
            <div class="top-menu">
                <ul class="nav pull-right top-menu">
                    <li>
                        <a class="logout" href="ApplicationForm.html">Edit Profile</a>
                    </li>
                    
                    <li>
                        <a class="logout" href="removeSession">Logout</a>
                    </li>
                </ul>
            </div>
        </header>
        <!--header end-->

        <!--sidebar start-->
       <aside>
            <div id="sidebar" class="nav-collapse ">
                <!-- sidebar menu start-->
                <ul class="sidebar-menu" id="nav-accordion">
                    <p class="centered">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/images/sethkelley.jpg" class="img-circle" width="100">
                        </a>
                    </p>
                    <h5 class="centered"> <%= customer.getCustomerFirstName() + " " + customer.getCustomerLastName() %></h5>
                    <br>


                    <li class="sub-menu">
                        <a href="homeDashBoard"> <i class="fa fa-desktop" ></i>
                            <span>Home</span>
                        </a>
                     

                    </li>

                    <li class="sub-menu">
                        <a href="application">
                            <i class="fa fa-cogs"></i>
                            <span>Application Form</span>
                        </a>
                    </li>
                    
                      <li class="sub-menu">
                        <a href="incident">
                            <i class="fa fa-tasks"></i>
                            <span>Incident Form</span>
                        </a>
                    </li>
                    
                       <li class="sub-menu">
                        <a href="contact">
                            <i class="fa fa-tasks"></i>
                            <span>Contact Us</span>
                        </a>
                    </li>
                    
                       <li class="sub-menu">
                        <a href="payment">
                            <i class="fa fa-tasks"></i>
                            <span>Payment Form</span>
                        </a>
                    </li>
                    
                    <li class="sub-menu">
                        <a href="#">
                            <i class="fa fa-book"></i>
                            <span>Quotes</span>
                        </a>
                    </li>
                  
                    <li class="sub-menu">
                        <a href="#">
                            <i class="fa fa-tasks"></i>
                            <span>Receipt</span>
                        </a>
                    </li>
                 
                 
                    <li class="sub-menu">
                        <a href="#">
                            <i class="fa fa-tasks"></i>
                            <span>News Feed</span>
                        </a>
                    </li>
                </ul>
                <!-- sidebar menu end-->
            </div>
        </aside>
        <!--sidebar end-->

        <!--main content start-->
        <section id="main-content">
            <section class="wrapper">
                <form id = "myform" name ="myform" method="GET" action="insertIncident" onsubmit="return regvalidate()">
                    <div class="container">
                        <div class="form-style-6" id="flip">
                            <h1 >INCIDENT DETAILS</h1>
                            <div class="col-md-12 form-style-1">
                                <label>Incident Type </label>
                                <div class="col-md-12">

                                    <div class="col-md-3">
                                        <input type="radio" id="major" name="incidentType"/>&nbsp;&nbsp;&nbsp;Major
                                    </div>
                                    <div class="col-md-3">
                                        <input type="radio" id="minor" name="incidentType"/>&nbsp;&nbsp;&nbsp;Minor
                                    </div>
                                    <div class="col-md-3">
                                        <input type="radio" id="fatal" name="incidentType"/>&nbsp;&nbsp;&nbsp;Fatal
                                    </div>
                                    <div class="col-md-3">
                                        <input type="radio" id="others" name="incidentType"/>&nbsp;&nbsp;&nbsp;Others
                                    </div>
                                </div>
                            </div>

                            <div class="col-md-12 form-style-1">
                                <div class="col-md-6 col-md-offset-3">
                                <label>Incident Date </label>
                                <input type="date" id="incidentDate" name="incidentDate" class="field-divided"  placeholder="Date Of Incident" />
                                </div>
                             </div>
                             
                             
                	
                             <div class="col-md-12 form-style-1">
                                    <div class="col-md-6 col-md-offset-3">
                                        <label>Incident Description </label>
                                        <textarea  id="description" name="incidentDescription" class="field-divided"  placeholder="Enter description here."></textarea>
                                        <br><span class="error"  id="errorname1"></span>
                                    </div>
                            </div>
                            
                            
                            
                            <div class="col-md-12 form-style-1">
                                    <div class="col-md-6 col-md-offset-3">
                                        <label>Upload Image </label>
                                       <center> <input type="file" class="field-divided" name="incidentImageURL" accept="image/*"></center>
                                        <br><span class="error"  id="errorname1"></span>
                                    </div>
                            </div>
                          
                        </div>
                    </div>

                    <div class="conatiner">
                        <center><input class="btn " value="Submit" type="submit" onclick="alert('your form has been succesfully submitted for approval by the Surveyor')"></center>
                    </div>

                </form>
            </section>
        </section>

</body>
</html>