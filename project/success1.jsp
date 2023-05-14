
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

String v = (String)request.getAttribute("key");
String a = (String)request.getAttribute("n");
String b = (String)request.getAttribute("i");
String c = (String)request.getAttribute("p");

%>

<h1><%=v %></h1>
<h3>Name = <%=a %></h3>
<h3>Id = <%=b %></h3>
<h3> Price = <%=c %></h3>
        </body>

    </center>
    
</html> 