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
    <script src="js/scriptMainPage2.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  </head>
  <body>
      <%
          String houseNumber = request.getParameter("houseNumber");
          if(houseNumber == null){
            houseNumber = (String) request.getAttribute("houseNumber");
          }
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
        <h2 style="background-color: #1E3706; color: white; padding-left: 20px;">MANAGE PROPERTY</h2>
        
        <form action="manage_tenant.do" method="post" name="updateForm" style="padding-left: 20px;" onsubmit="return registerForm()">
            
          <div class="lot"><%=houseNumber%>
            
              <i class="fa fa-home"></i>
            </div><br>
              <h4>Tenant Details</h4>
              
              <br>
              
              <table>
                <tr class="input-container">
                  <td style="text-align: left;"><label for="icNum" class="inputLabel" >Tenant IC Number:-</label></td>
                  <td><input type="text" id="icNum" name="icNum" class="textInput" placeholder="123456789012" pattern="\d{12}" required></td>
                </tr>
                <tr class="input-container">
                  <td style="text-align: left;"><label for="fullName" class="inputLabel" >Tenant Full Name:-</label></td>
                  <td><input type="text" id="fullName" name="fullName" class="textInput" placeholder="Full Name" required></td>
                </tr>
                <tr class="input-container">
                  <td style="text-align: left;"><label for="tenantUsername" class="inputLabel">Tenant Username:-</label></td>
                  <td><input type="text" id="tenantUsername" name="tenantUsername"  class="textInput" placeholder="Username" required></td>
                </tr>
                <tr class="input-container">
                  <td style="text-align: left;"><label for="tenantPassword" class="inputLabel">Tenant Password:-</label></td>
                  <td><input type="password" id="tenantPassword" name="residentNewPassword" class="textInput" placeholder="*******" required></td>
                </tr>
                <tr class="input-container">
                  <td style="text-align: left;"><label for="tenantConfirmPassword" class="inputLabel">Tenant Confirm Password:-</label></td>
                  <td><input type="password" id="tenantConfirmPassword" name="residentConfirmPassword" class="textInput" placeholder="*******" required></td>
                </tr>
              </table>
                 
                <h4>Password Verification</h4>
              
                  <table>
                <tr class="input-container">
                  <td><label for="tenantPassword" class="inputLabel">Your Password:-</label></td>
                  <td><input type="password" id="tenantPassword" name="yourPassword" class="textInput"></td>
                </tr>
                
              </table>
              
              <div class="button-container">
                <a href="manageProperty.jsp" id="rcorners1">BACK</a>
                <input type="hidden" name="houseNumber" value="<%=houseNumber%>">
                <input type="hidden" name="action" value="registerTenant">
                <input type="submit" value="REGISTER TENANT" id="rcorners2" >
              </div>
                <h5 style="color: red;">${message}</h5>
            
        </form>
      </section>
      <section>
        <img src="images/Screenshot__235_-removebg-preview.png" alt="">
      </section>
      
    </main>
    
    <script src="js/script.js"></script>
  </body>
</html>