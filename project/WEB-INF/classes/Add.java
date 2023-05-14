import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class Add extends HttpServlet {

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
    PrintWriter out = response.getWriter();
 HttpSession session = request.getSession(false);
   	String Type= (String)session.getAttribute("user_type");

     String key= "Medicine Added";
     String ke ="Medicine not added";

     request.setAttribute("key", key);
    request.setAttribute("k", ke);

	if(Type.equals("admin"))
{
	String name =request.getParameter("name");
    String id =request.getParameter("id");
	String price =request.getParameter("price");



    try{
    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://localhost/class_test";

    Connection con =DriverManager.getConnection(url,"root","root");
    Statement st =con.createStatement();

    String in ="Id# Already Exist !!!!!!";

    request.setAttribute("in", in);


    String q="Select * from medicine where id='"+id+"'";

      ResultSet rt =st.executeQuery(q);
      System.out.println(rt.next());



      if(rt.next())
      {
        RequestDispatcher rd = request.getRequestDispatcher("Error3.jsp");
        rd.forward(request,response);
        
      }
       else
       {

     String query="INSERT INTO medicine(name,id,price)VALUES('"+ name + "','" + id+ "','"+price+"') ";
   
     int rs = st.executeUpdate( query );

   
     if(rs==1){
	
      RequestDispatcher r = request.getRequestDispatcher("Success.jsp");
      r.include(request,response);

	  }
     
     else{
      RequestDispatcher r = request.getRequestDispatcher("Error.jsp");
      r.include(request,response);
          }
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