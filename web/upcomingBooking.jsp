<%-- 
    Document   : bookingDetails
    Created on : Jun 1, 2024, 11:40:39 PM
    Author     : user
--%>
<%@page import="model.bean.Administrator" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Daisy Kemboja</title>
    <link rel="icon" type="image/x-icon" href="/image/shoe.png">
    <link rel="stylesheet" href="css/tableInformation.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  </head>
  <body>
      <!--Access Account Class Data-->
      <jsp:useBean id="account" scope="session" class="model.bean.Resident" />
    <!--Connection-->
        <sql:setDataSource driver="org.apache.derby.jdbc.ClientDriver" 
                           url="jdbc:derby://localhost:1527/RimbaWatchGuard" 
                           user="abc" 
                           password="123" 
                           var="conn"/>
        
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
        <h2 style="background-color: #1E3706; color: white; padding-left: 20px;">Booking Details</h2>
        <a class="button button1" href="bookfacilities.jsp">Back</a><br><br>
        <table border="1">
            <tr>
              <th>No</th>
              <th>Facilities</th>
              <th>Date</th>
              <th>Start Time</th>
              <th>End Time</th>
              <th>Cancel Booking</th>
            </tr>
            <sql:query var="result" dataSource="${conn}">
                SELECT * FROM UPCOMINGBOOKING
                WHERE RESIDENT_ICNUMBER = ?
                AND (
                    BOOKING_DATE > CURRENT_DATE
                    OR (BOOKING_DATE = CURRENT_DATE AND END_TIME > CURRENT_TIME)
                )
                ORDER BY BOOKING_DATE ASC
                <sql:param value="${account.residentICNumber}" />
            </sql:query>


            <c:if test="${not empty result.rows}">
                <%
                  int i=0;         
                %>
                <c:forEach var="row" items="${result.rows}">
                    <form action="booking.do" method="post">
                        <tr>
                            <input type="hidden" name="bookingID" value="${row.BOOKING_ID}">
                            <input type="hidden" name="action" value="deleteBooking">
                            <td><%=++i%></td>
                            <td>${row.FACILITY_TYPE}</td>
                            <td>${row.BOOKING_DATE}</td>
                            <td>${row.START_TIME}</td>
                            <td>${row.END_TIME}</td>
                            <td><input type="submit" value="Cancel" class="button button2" onclick="return confirmDelete()"></td>
                        </tr>
                    </form>
                </c:forEach>
            </c:if>
            <c:if test="${empty result.rows}">
                <tr>
                    <td colspan="6">No booking records found.</td>
                </tr>
            </c:if>
        </table>
      </section>
      
    </main>
    
    <script src="js/script.js"></script>
  </body>
</html>