<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="model.bean.Facility"%>
<%@page import="com.rimba.dao.FacilityDAO"%>
<%@page import="com.rimba.dao.FacilityDAOImpl"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ken Rimba</title>
    <link rel="icon" type="image/x-icon" href="/image/shoe.png">
    <link rel="stylesheet" href="css/bookSpecificFacilities.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  </head>
  <body>
      <%
          final FacilityDAO facilityDAO = new FacilityDAOImpl();
          Integer intFacilityID = (Integer) session.getAttribute("facilityID");
          int facilityID = intFacilityID.intValue();
          Facility facility = facilityDAO.getFacilityByID(facilityID);
      %>
    <nav class="sidebar">
      <img src="images/Screenshot__235_-removebg-preview.png" class="logo" alt="#">

      <div class="menu-content">
        <ul class="menu-items">

          <li class="item">
            <a href="updateProfile.jsp">UPDATE PROFILE</a>
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
    

    <main class="main" style="height: 100vh;background-color: #E7FEED;">
      <section class="form">
        <h2 style="background-color: #1E3706; color: white; padding-left: 20px;">FACILITY BOOKING</h2>
        <form action="booking.do" method="post" name="reservationForm" style="padding-left: 20px;" onsubmit="return validateForm()">
            
          <div class="lot"><%= facility.getFacilityType()%>
            <i class="fas fa-university"></i>
          </div><br>
          
          <h4>Reservation Details</h4>
          
          <br>
          
          <table>
            
            <tr class="input-container">
              <td style="text-align: left;"><label for="Date" class="inputLabel">Date:-</label></td>
              <td><input type="date" id="Date" name="Date" class="textInput" required></td>
            </tr>
            <tr class="input-container">
              <td style="text-align: left;"><label for="StartTime" class="inputLabel">Start Time:-</label></td>
              <td><input type="time" id="StartTime" name="StartTime" class="textInput" required></td>
            </tr>
            <tr class="input-container">
              <td style="text-align: left;"><label for="EndTime" class="inputLabel">End Time:-</label></td>
              <td><input type="time" id="EndTime" name="EndTime" class="textInput" required></td>
            </tr>
          </table>
          
          <div class="button-container">
            <a href="bookfacilities.jsp" id="rcorners1">BACK</a>
            <input type="hidden" name="action" value="bookFacility">
            <input type="hidden" name="facility" value="<%= facility.getFacilityID()%>">
            <input type="submit" value="BOOK FACILITIES" id="rcorners2" >
          </div>
          <h5 style="color: green;">${message1}</h5>
          <h5 style="color: red;">${message2}</h5>
            
        </form>
      </section>
      <section>
        <img src="images/Screenshot__235_-removebg-preview.png" alt="">
      </section>
      
    </main>
    
    <script src="js/script.js"></script>
  </body>
</html>