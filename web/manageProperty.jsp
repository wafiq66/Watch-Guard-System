<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="model.bean.Resident" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Rimba Watchguards</title>
    <link rel="icon" type="image/x-icon" href="/image/shoe.png">
    <link rel="stylesheet" href="css/managetenant.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  </head>
  <body>
      
      <!--Connection-->
        <sql:setDataSource driver="org.apache.derby.jdbc.ClientDriver" 
                           url="jdbc:derby://localhost:1527/RimbaWatchGuard" 
                           user="abc" 
                           password="123" 
                           var="conn"/>
        <jsp:useBean id="account" class="model.bean.Resident" scope="session" />
        <jsp:setProperty name="account" property="*"/>
      
    <nav class="sidebar">
      <img src="images/Screenshot__235_-removebg-preview.png" class="logo" alt="#">

      <div class="menu-content">
        <ul class="menu-items">

          <li class="item">
            <a href="updateProfile.jsp">UPDATE PROFILE</a>
          </li>
          <li class="item">
            <a href="#">MANAGE PROPERTY</a>
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
      <section class="form" style="width:900px;">
        <h2 style="background-color: #1E3706; color: white; padding-left: 20px;">Manage Property</h2>
        <br>
        <div class="container">
            
            <sql:query var="result1" dataSource="${conn}">
                SELECT * FROM ABC.PROPERTYRENTINGSTATUS
                WHERE OWNERICNUMBER =? 
                <sql:param value="${account.residentICNumber}"/>
            </sql:query>
            <sql:query var="result2" dataSource="${conn}">
                SELECT * FROM TENANTANDRENTING
                WHERE TENANT_IC =?
                <sql:param value="${account.residentICNumber}"/>
            </sql:query>
            <c:choose>
                <c:when test="${not empty result1.rows}">
                    <c:forEach var="row" items="${result1.rows}">
                        <div class="property">
                            <h2>${row.HOUSENUMBER}</h2>
                            <p>Rent Status: ${row.RENTING_STATUS}</p>
                            <c:choose>
                                <c:when test="${row.RENTING_STATUS eq 'Not Rented'}">
                                    <form action="registerSpecificProperty.jsp" method="post">
                                        <input type="hidden" name="houseNumber" value="${row.HOUSENUMBER}">
                                        <input type="submit" class="button button1" value="Add Tenant">
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="manageSpecificProperty.jsp" method="post">
                                        <input type="hidden" name="houseNumber" value="${row.HOUSENUMBER}">
                                        <input type="submit" class="button button1" value="Manage Tenant">
                                    </form>
                                </c:otherwise>
                            </c:choose>

                     
                        </div>
                    </c:forEach>
                </c:when>
                <c:when test="${not empty result2.rows}">
                    <c:forEach var="row" items="${result2.rows}">
                        <form class="property">
                            <h2>${row.HOUSENUMBER}</h2>
                            <p>Owner: ${row.OWNER_NAME}</p>
                            <p>Rent Status: Renting</p>

                        </form>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <!-- no results in either query -->
                </c:otherwise>
            </c:choose>
            
          </div>
      </section>
    
         
    
      <section>
        <img src="images/Screenshot__235_-removebg-preview.png" alt="">
      </section>
      
    </main>
    
    <script src="js/scriptMainPage2.js"></script>
  </body>
</html>