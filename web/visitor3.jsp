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
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  </head>
  <style>

* {
    margin:0;
    padding:0;
    box-sizing: border-box;
    font-family: "Roboto Condensed", sans-serif;
 }

 .navbarr {
  overflow: hidden;
  background-color: rgb(153, 169, 143);
}

.head-left{
  float: left;
}


.navbarr a {
  position: relative;
  display: inline-block;
  left: 90px;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  
}

h3 {
    text-align: left;
    margin-left: 23px;
    position: relative;
    top: 34px;
    font-style: oblique;
    font-size: larger;
}

.navbarr a:hover{
  background-color: #5e6f4f;
}

.logo{
    position: relative;
    float: inline-end;
    height: auto;
    display: block;
    bottom: 25px;
}


.wrapper {
  position: relative;
  max-width: 500px;
  width: 100%;
  border-radius: 12px;
  padding: 20px
    30px
    40px;
  background: #5e6f4f;
  box-shadow: 0
    5px
    10px
    rgba(
      0,
      0,
      0,
      0.1
    );
  overflow: hidden;
  margin-left: 40px;
  margin-top: 30px;
}
.form.login {
  position: absolute;
  left: 50%;
  bottom: -86%;
  transform: translateX(
    -50%
  );
  width: calc(
    100% +
      220px
  );
  padding: 20px
    140px;
  border-radius: 50%;
  height: 100%;
  background: #fff;
  transition: all
    0.6s
    ease;
}
.wrapper.active
  .form.login {
  bottom: -15%;
  border-radius: 35%;
  box-shadow: 0 -5px
    10px rgba(0, 0, 0, 0.1);
}
.form
  header {
  font-size: 30px;
  text-align: center;
  color: #fff;
  font-weight: 600;
}
.form.login
  header {
  color: #333;
  opacity: 0.6;
}
.wrapper.active
  .form.login
  header {
  opacity: 1;
}
.wrapper.active
  .signup
  header {
  opacity: 0.6;
}
.wrapper
  form {
  display: flex;
  flex-direction: column;
  gap: 20px;
  margin-top: 40px;
}
form
  input {
  height: 60px;
  outline: none;
  border: none;
  padding: 0px 200px 0px 10px;
  width: 100;
  font-size: 16px;
  font-weight: 400;
  color: #333;
  border-radius: 8px;
  background: #fff;
}

form select {
  height: 60px;
  outline: none;
  border: 2px solid #ccc;
  padding: 0 20px;
  width: 100%;
  font-size: 16px;
  font-weight: 400;
  color: #333;
  border-radius: 8px;
  background: #fff;
  transition: border-color 0.3s ease, box-shadow 0.3s ease;
  appearance: none; /* Removes default arrow */
  -webkit-appearance: none; /* Removes default arrow in Safari */
  -moz-appearance: none; /* Removes default arrow in Firefox */
  background-image: url('data:image/svg+xml;charset=US-ASCII,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 4.094 2.441"><path fill="%23333" d="M2.046 2.441L0 0h4.094z"/></svg>');
  background-repeat: no-repeat;
  background-position: right 10px center;
  background-size: 12px;
}

form select:focus {
  border-color: #66afe9;
  box-shadow: 0 0 8px rgba(102, 175, 233, 0.6);
}

form select:hover {
  border-color: #aaa;
}


.cancel {

margin-top: 15px;
padding: 20px 200px 20px 200px;
float: center;
font-size: 18px;
font-weight: 500;
cursor: pointer;
background: rgb(153, 169, 143);
color: black;
border: none;
border-radius: 8px;
text-decoration: none;

}
  </style>
  <body>
      <!--Connection-->
        <sql:setDataSource driver="org.apache.derby.jdbc.ClientDriver" 
                           url="jdbc:derby://localhost:1527/RimbaWatchGuard" 
                           user="abc" 
                           password="123" 
                           var="conn"/>
        <sql:query var="currentTimestampResult" dataSource="${conn}">
            SELECT CURRENT_TIMESTAMP FROM SYSIBM.SYSDUMMY1
        </sql:query>
        <c:set var="currentTimestamp">
            <c:forEach var="row" items="${currentTimestampResult.rows}">
                ${row.CURRENT_TIMESTAMP}
            </c:forEach>
        </c:set>
            
        <jsp:useBean id="visit" class="model.bean.Visit">
            <jsp:setProperty name="visit" property="houseNumber" value="${param.houseNumber}" />
            <jsp:setProperty name="visit" property="visitorICNumber" value="${param.nricVisitor}" />
            <jsp:setProperty name="visit" property="visitPurpose" value="${param.visitPurpose}" />
            <jsp:setProperty name="visit" property="visitTimeStamp" value="<fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' value='${currentTimestamp}' />" />
            <jsp:setProperty name="visit" property="visitorVechileNumber" value="${param.vechileNumber}" />
        </jsp:useBean>
        

        
            <%
                        String control = "";
                    %>
        
    
<div class="navbarr">
    <h3>VISIT</h3>
    <div class="head-left">
    <a href="mainHome.html">Home</a>
    </div>
</div>
    <div class="logo">
        <a><img src="images/Screenshot__235_-removebg-preview.png" class="logo" alt="#"></a>
        </div>

        <section class="wrapper">
            <div class="form signup">
              <header>Visitor Registration</header>
              <form action="visitor3.jsp">
                <p style="color: #fff;">Vehicle Number</p>
                <input type="text" placeholder="Vehicle Number" name="vechileNumber" required />
                <p style="color: #fff;">House Number</p>
                <select name="houseNumber">
                <sql:query var="result" dataSource="${conn}">
                    SELECT HOUSENUMBER FROM ABC.PROPERTYWITHOWNER
                </sql:query>
                <c:forEach var="row" items="${result.rowsByIndex}">
                <c:forEach var="column" items="${row}">
                    <option><c:out value="${column}"/></option>
                </c:forEach>
                </c:forEach>
                </select>
                <p style="color: #fff;">Purpose Of Visit</p>
                <select name="visitPurpose" id="visitPurpose">
                    <option value="For Fun">For Fun</option>
                    <option value="Visiting Family/Friends">Visiting Family/Friends</option>
                    <option value="Delivery">Delivery</option>
                    <option value="Service/Maintenance">Service/Maintenance</option>
                    <option value="Official Business">Official Business</option>
                    <option value="Emergency">Emergency</option>
                    <option value="Real Estate Viewing">Real Estate Viewing</option>
                    <option value="Event">Event</option>
                    <option value="Medical Appointment">Medical Appointment</option>
                    <option value="Household Help">Household Help</option>
                    <option value="Inspection">Inspection</option>
                    <option value="Pet Sitting/Walking">Pet Sitting/Walking</option>
                    <option value="Community Meeting">Community Meeting</option>
                    <option value="Volunteering">Volunteering</option>
                    <option value="Home Renovation">Home Renovation</option>
                    <option value="Party">Party</option>
                    <option value="Work/Remote Office">Work/Remote Office</option>
                    <option value="School Drop-off/Pick-up">School Drop-off/Pick-up</option>
                    <option value="Shopping">Shopping</option>
                    <option value="Fitness/Exercise">Fitness/Exercise</option>
                    <option value="Tourism">Tourism</option>
                    <option value="Cultural/Religious Activity">Cultural/Religious Activity</option>
                    <option value="Other">Other</option>
                </select>

                <c:if test="${not empty visit.houseNumber and not empty visit.visitorICNumber and not empty visit.visitPurpose and not empty visit.visitorVechileNumber}">
                    <!-- Your function call or code that should run if properties are not null -->

                    <p style="color: #1eff00;">Visitor Successfully Registered!</p>
                    <%
                        control = "disabled";
                    %>
                    <!-- Place the code or function calls that should run when all properties are not null here -->
                    <sql:update var="result" dataSource="${conn}">
                        INSERT INTO VISIT (HOUSENUMBER, VISITORICNUMBER,VISITPURPOSE,VISITTIMESTAMP,VISITORVECHILENUMBER)
                        VALUES (?,?,?,CURRENT_TIMESTAMP,?)
                        <sql:param value="${visit.houseNumber}" />
                        <sql:param value="${visit.visitorICNumber}" />
                        <sql:param value="${visit.visitPurpose}" />
                        <sql:param value="${visit.visitorVechileNumber}" />
                    </sql:update>
                </c:if>
                <input type="hidden" name="nricVisitor" value="${param.nric}">
                <input type="submit" class="cancel" value="Submit" <%=control%> >  <!--WILL BE CHANGE LATER WHEN DATABASE ARE IMPLEMENTED-->
                <a href="visitor.html" class="cancel">Cancel</a> <!--WILL BE CHANGE LATER WHEN DATABASE ARE IMPLEMENTED-->
              </form>
            </div>
            <script>
              const wrapper = document.querySelector(".wrapper"),
                loginHeader = document.querySelector(".login header");
              loginHeader.addEventListener("click", () => {
                wrapper.classList.add("active");
              });
            </script>
          </section>
  </body>
</html>