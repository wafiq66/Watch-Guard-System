<%-- 
    Document   : newjsp
    Created on : Jun 16, 2024, 1:11:02 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    top: 33px;
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
    20px;
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
  margin: 10px 20px 30px;
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
  
  outline: none;
  border: none;
  padding: 20px 200px 20px 10px;
  width: 100;
  font-size: 16px;
  font-weight: 400;
  color: #333;
  border-radius: 8px;
  background: #fff;
}


form #forgotPass {
  color: #aaa;
  text-decoration: none;
}
form
  #forgotPass:hover {
  text-decoration: underline;
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
#message{
    color: rgb(170, 12, 12);
    font-weight: bold;
  }
  </style>
  <body>
    
<div class="navbarr">
    <h3>LOGIN</h3>
    <div class="head-left">
    <a href="mainHome.html">Home</a>
    </div>
</div>
    <div class="logo">
        <a><img src="images/Screenshot__235_-removebg-preview.png" class="logo" alt="#"></a>
    </div>

        <section class="wrapper">
            <div class="form signup">
              <header>Administrator Login</header>
              <form action="login.do" method="post">
                <p style="color: #fff;">ID</p>
                <input name="adminID" type="text" placeholder="ID" required />
                <p style="color: #fff;">Password</p>
                <input name="adminPassword" type="password" placeholder="Password" required />
                <p id="message">${message}</p>
                <input type="hidden" name="action" value="loginAdmin">
                <input type="submit" class="cancel" value="Login" />  <!--WILL BE CHANGE LATER WHEN DATABASE ARE IMPLEMENTED-->
                <a href="mainHome.html" class="cancel">Cancel</a> <!--WILL BE CHANGE LATER WHEN DATABASE ARE IMPLEMENTED-->
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