<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.bean.Resident" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ken Rimba</title>
    <link rel="icon" type="image/x-icon" href="/image/shoe.png">
    <link rel="stylesheet" href="css/styleUpdateProfile.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  </head>
  <body>
    <jsp:useBean id="account" class="model.bean.Resident" scope="session" />
    <jsp:setProperty name="account" property="*"/>
    
    <nav class="sidebar">
      <img src="images/Screenshot__235_-removebg-preview.png" class="logo" alt="#">

      <div class="menu-content">
        <ul class="menu-items">

          <li class="item">
            <a href="#">UPDATE PROFILE</a>
          </li>
          <li class="item">
            <a href="manageProperty.jsp">MANAGE PROPERTY</a>
          </li>
          <li class="item">
            <a href="bookfacilities.jsp">FACILITY BOOKING</a>
          </li>
          <li class="item">
            <a href="mainHome.html">LOG OUT</a>
          </li>
        </ul>
      </div>
    </nav>

    <nav class="navbar">
      <i class="fa fa-close sidebar-close" ></i>
      <h3 style="width: 400px;">RESIDENT</h3>
    </nav>

    <main class="main" style="background-color: #E7FEED;">
      <section class="form">
        <h2 style="background-color: #1E3706; color: white; padding-left: 20px;">Update Profile</h2>
        <form action="update_profile.do" style="padding-left: 20px;" name="updateForm" onsubmit="return validateForm()">
          
            <input type="hidden" name="residentICNumber" 
                 value="<jsp:getProperty name="account" property="residentICNumber"/>"
                 >
            <input type="hidden" name="action" value="updateProfile">
            
          <p style="font-weight: bold;">Owner</p>
          Full Name:-<br>
          <input type="text" name="residentName" placeholder="Name" 
                 value="<jsp:getProperty name="account" property="residentName"/>"
                 required><br>
          Email:-<br>
          <input type="email" name="residentEmail" placeholder="example@gmail.com" 
                 value="<jsp:getProperty name="account" property="residentEmail"/>"
                 required><br>
          Phone Number:-<br>
          <input type="text" name="residentPhoneNumber" placeholder="012-3456789" 
                 value="<jsp:getProperty name="account" property="residentPhoneNumber"/>"
                 required><br>
          
          <br>
          <p style="font-weight: bold;">Account Credential</p>
          Account Username:-<br>
          <input type="text" name="residentUsername" placeholder="Username"  
                 value="<jsp:getProperty name="account" property="residentUsername"/>"
                 required><br>
          New Password:-<br>
          <input type="password" name="residentNewPassword" placeholder="********"  
                 value="<jsp:getProperty name="account" property="residentPassword"/>"
                 required><br>
          Confirm Password:-<br>
          <input type="password" name="residentConfirmPassword" placeholder="********"  
                 value="<jsp:getProperty name="account" property="residentPassword"/>"
                 required><br>
          
          <br>
          <p style="font-weight: bold;">Family Member</p>
          Name:-<br>
          <input type="text" name="familyName" placeholder="Name" 
                 value="<jsp:getProperty name="account" property="residentFamilyMemberName"/>"
                 required><br>
          Phone Number:-<br>
          <input type="text" name="familyPhoneNumber" placeholder="012-3456789" 
                 value="<jsp:getProperty name="account" property="residentFamilyMemberPhoneNumber"/>"
                 required><br>
          <p style="font-weight: bold;">Verification</p>
          Password:-<br>
          <input type="password" name="validatePassword" placeholder="********" required><br>
          
            <input type="submit" value="Update" class= "button submit"> <br>

            <a href="residentMainPage.jsp" class= "button cancel">Back</a>
            
            <h5 style="color: green;" >${message1}</h5>
            <h5 style="color: red;" id="alertMessage">${message2}</h5>
          <br><br><br>
        </form>
      </section>
      <section>
        <img src="images/Screenshot__235_-removebg-preview.png" alt="">
      </section>
      
    </main>
    
    <script src="js/scriptMainPage2.js"></script>
  </body>
</html>