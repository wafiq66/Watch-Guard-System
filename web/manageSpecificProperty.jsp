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
    <title>Ken Rimba</title>
    <link rel="icon" type="image/x-icon" href="/image/shoe.png">
    <link rel="stylesheet" href="css/manageSpecificProperty.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="js/scriptMainPage2.js"></script>
  </head>
  <body>
      <%
          String houseNumber = request.getParameter("houseNumber");
          
      %>
      <sql:setDataSource driver="org.apache.derby.jdbc.ClientDriver" 
                           url="jdbc:derby://localhost:1527/RimbaWatchGuard" 
                           user="abc" 
                           password="123" 
                           var="conn"/>
      <sql:query var="result1" dataSource="${conn}">
                SELECT * FROM TENANTANDRENTING
                WHERE HOUSENUMBER =?
                <sql:param value="<%=houseNumber%>"/>
        </sql:query>
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
        <h2 style="background-color: #1E3706; color: white; padding-left: 20px;">MANAGE PROPERTY</h2>
        
        
            
          <div class="lot"><%=houseNumber%>
          </div><br>
          
          <h4>Tenant Details</h4>
          
          <br>
          
          <table style="border-collapse: separate; border-spacing: 10px;">
              <tr class="input-container">
                <td style="text-align: left;"><label>Tenant IC Number:</label></td>
                <td>${result1.rows[0].TENANT_IC}</td>
              </tr>
              <tr class="input-container">
                <td style="text-align: left;"><label>Tenant Full Name:</label></td>
                <td>${result1.rows[0].TENANT_NAME}</td>
              </tr>
              <tr class="input-container">
                  <td style="text-align: left;"><label>Tenant Status:</label></td>
                  <td>
                    <c:choose>
                      <c:when test="${result1.rows[0].RENTINGSTATUS}">
                        RENTING
                      </c:when>
                      <c:otherwise>
                        NOT RENTING
                      </c:otherwise>
                    </c:choose>
                  </td>
                </tr>
              
              
            </table>

            
        <form action="manage_tenant.do" method="post" name="reservationForm" style="padding-left: 20px;" onsubmit="return removeTenant()">
            <div class="button-container">
              <a href="manageProperty.jsp" id="rcorners1">BACK</a>
              <input type="hidden" name="tenantIC" value="${result1.rows[0].TENANT_IC}">
              <input type="hidden" name="houseNumber" value="<%=houseNumber%>">
              <input type="hidden" name="action" value="removeTenant">
              <input type="submit" value="REMOVE TENANT" id="rcorners3" >
            </div>
        </form>
      </section>
      <section>
        <img src="images/Screenshot__235_-removebg-preview.png" alt="">
      </section>
      
    </main>
    
    <script src="js/script.js"></script>
    <script>
        function removeTenant() {
    if (confirm("Are you sure you want to remove this tenant?")) {
        return true;
    } else {
        return false;
    }
}
    </script>
  </body>
</html>