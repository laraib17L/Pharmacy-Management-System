import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Update extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    PrintWriter out = response.getWriter();
    String key="Medicine Price has been updated!!!";
    String k="Medicine Price not updated !!!";
    request.setAttribute("key", key);
    request.setAttribute("k", k);
	HttpSession session = request.getSession(false);
	String Type= (String)session.getAttribute("user_type");
	if(Type.equals("admin"))
{

	String name =request.getParameter("name");
    String price =request.getParameter("price");


    try{
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost/class_test";
    Connection con =DriverManager.getConnection(url,"root","root");
    Statement st =con.createStatement();
    
    String sql = "UPDATE medicine SET price = ? WHERE name = ?";
      PreparedStatement statement = con.prepareStatement(sql);
      statement.setString(1, price);
      statement.setString(2, name);

      // Execute the SQL statement
      int result = statement.executeUpdate();
      if (result > 0) {
        // The update was successful, redirect the user to a success page
        RequestDispatcher r = request.getRequestDispatcher("Success.jsp");
      r.include(request,response);

      } else {
        // The update was not successful, redirect the user to an error page
        RequestDispatcher r = request.getRequestDispatcher("Error.jsp");
      r.include(request,response);

      }
    } catch (ClassNotFoundException | SQLException e) {
      // An exception was thrown, redirect the user to an error page
      response.sendRedirect("error.jsp");
    } 
}
else
{
response.sendRedirect("search.html");
}
}

}