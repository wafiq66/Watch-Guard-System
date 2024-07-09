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
      <jsp:useBean id="account" scope="session" class="model.bean.Administrator" />
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
            <a href="#">BOOKING DETAILS</a>
          </li>
          <li class="item">
            <a href="ownerDetails.jsp">OWNER INFORMATION</a>
          </li>
          <li class="item">
            <a href="visitorHistory.jsp">VISITOR HISTORY</a>
          </li>
          <li class="item">
            <a href="mainHome.html">LOG OUT</a>
          </li>
        </ul>
      </div>
    </nav>

    <nav class="navbar">
      <i class="fa fa-close sidebar-close" ></i>
      <h3 style="width: 400px;">ADMINISTRATOR</h3>
    </nav>

    <main class="main" style="height: 100vh;background-color: #E7FEED;">
      <section class="form">
        <h2 style="background-color: #1E3706; color: white; padding-left: 20px;">Booking Details</h2>
        <table border="1">
            <tr>
              <th>No</th>
              <th>Facilities</th>
              <th>Name</th>
              <th>Date</th>
              <th>Start Time</th>
              <th>End Time</th>
            </tr>
            <sql:query var="result" dataSource="${conn}">
                    SELECT * FROM UPCOMINGRESERVATION
                    WHERE ADMIN_ID = ?
                    <sql:param>
                        <jsp:getProperty name="account" property="administratorID"/>
                    </sql:param>
            </sql:query>
            <%
              int i=0;         
            %>
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    
                    <td><%=++i%></td>
                    <td>${row.FACILITY_TYPE}</td>
                    <td>${row.RESIDENT_NAME}</td>
                    <td>${row.BOOKING_DATE}</td>
                    <td>${row.START_TIME}</td>
                    <td>${row.END_TIME}</td>
                </tr>
            </c:forEach>
        </table>
      </section>
      
    </main>
    
    <script src="js/script.js"></script>
  </body>
</html>