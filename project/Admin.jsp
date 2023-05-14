<%@page session="false" %>

<% HttpSession session =request.getSession(false);


    if(session==null)
    {
      response.sendRedirect("search.html");
    }
    else if(session!= null)
    {
        String type = (String) session.getAttribute("user_type");

        if(!type.equals("admin"))
        {
          response.sendRedirect("search.html");
        }


    }

%>

<html>

<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" href="adminstyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
  </head>


  <body>
    
    <nav>
      <input type="checkbox" id="check">
      <label for="check" class="checkbtn">
        <i class="fas fa-bars"></i>
      </label>
      <label class="logo">Beyond Health Pharmacy</label>

      <div style="display: flex; justify-content: center"  margin-top="600px">
        
        <a href="add.jsp" class="mar">
            add medicine      
        </a>
        &nbsp;
        &nbsp;
          <a href="delete.jsp"class="mar" >
            delete medicine
        </a>
        <br>
        &nbsp;
        &nbsp;
        <a href="update.jsp" class="mar">
            upate medicine
        </a>
        &nbsp;
        &nbsp;
        <br>
         <br>
        <a href="find.jsp" class="mar">
          Find medicine
      </a>
</div>
    </nav>

    <h3> Welcome, <%= session.getAttribute("name") %>  </h3>
    <h3><a href="logout"> logout</a></h3>

    <section></section>
  </body>
</html>