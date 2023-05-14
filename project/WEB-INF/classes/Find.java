import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Find extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    PrintWriter out = response.getWriter();

	HttpSession session = request.getSession(false);
	String Type= (String)session.getAttribute("user_type");
	if(Type.equals("admin"))
{

	String name =request.getParameter("name");

  String key= "Medicine not Found";
  String ke ="Medicine Found";
    request.setAttribute("k", key);
    request.setAttribute("key", ke);
    try{
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost/class_test";
    Connection con =DriverManager.getConnection(url,"root","root");
    Statement st =con.createStatement();

   

     String query="SELECT * FROM medicine WHERE name= '" + name+"'";
   
     ResultSet rs = st.executeQuery( query );


     if(rs.next()){

      String id = rs.getString("id");
      String price = rs.getString("price");

      request.setAttribute("n", name);
      request.setAttribute("i", id);
      request.setAttribute("p", price);
      
      RequestDispatcher r = request.getRequestDispatcher("success1.jsp");
      r.include(request,response);

	  }
     
     else{
      RequestDispatcher r = request.getRequestDispatcher("Error.jsp");
      r.include(request,response);
          }




    }catch(Exception e){

      out.println(e);
    }
}
else
{
response.sendRedirect("search.html");
}
}

}