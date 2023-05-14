<%@ page isErrorPage="true" %>

<html>
    <head>
        <link rel="stylesheet" href="style.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:wght@300&display=swap"
      rel="stylesheet"
/>
</head>
        <body>
            <center>
<%

String v = (String)request.getAttribute("k");

%>

<h1><%=v %></h1>
        </body>

    </center>
   
</html> 