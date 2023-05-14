import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Delete extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    PrintWriter out = response.getWriter();
	HttpSession session = request.getSession(false);
	String Type= (String)session.getAttribute("user_type");
	if(Type.equals("admin"))
{
	String name =request.getParameter("name");

  String key= "Medicine Deleted";
     String ke ="Medicine not Deleted";

     request.setAttribute("key", key);
    request.setAttribute("k", ke);

    try{
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost/class_test";
    Connection con =DriverManager.getConnection(url,"root","root");
    Statement st =con.createStatement();
    
     String query="DELETE FROM medicine WHERE name = '"+name+"'";
   
     int rs = st.executeUpdate( query );


   
     if(rs==1){
	
    	
      RequestDispatcher r = request.getRequestDispatcher("Success.jsp");
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
