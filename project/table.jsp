<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>

<html>
   <head>
         <body>


<%
try
{
Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost/class_test";
    Connection con =DriverManager.getConnection(url,"root","root");
    

%>
<h1>Search Data</h1>
<table border="1">
<tr>
<td>Name</td>

<td>Price</td>
<td>Add to Cart</td>

</tr>
<%


Statement st =con.createStatement();

   

     String query="SELECT * FROM medicine ";
   
     ResultSet rs = st.executeQuery( query );

     while(rs.next()){
        %>
        <tr>
        <form action="add.jsp"></forn>
        <td><%=rs.getString("name") %></td>
        <td><%=rs.getString("price") %></td>
        
        <td><input type="submit"  value="Add to cart"></td>
        </form>
        </tr>
        <%
        }
        con.close();
        } catch (Exception e) {
        e.printStackTrace();
        }
        %>
    </table>


         </body>
  </head>
</html>