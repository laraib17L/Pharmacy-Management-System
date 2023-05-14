import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Insert extends HttpServlet {
  
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
  HttpSession session = request.getSession(true);
	// get PrintWriter object
	PrintWriter out = response.getWriter();

    String name=request.getParameter("firstName");
    String password=request.getParameter("pass");
    String email=request.getParameter("mail");
    String usertype=request.getParameter("type");

    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/class_test";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();

    String value = "Successfully Inserted";
    request.setAttribute("key", value);

    String er="Type should be either admin or user  !!!";
    request.setAttribute("er", er);


    String in ="Already Has Account !!!!!!";

    request.setAttribute("in", in);

    String val = "Error!!!!";
    request.setAttribute("k", val);

    String q="Select * from ins where username='"+name+"'";

      ResultSet rt =st.executeQuery(q);
      System.out.println(rt.next());

      if(rt.next())
      {
        RequestDispatcher rd = request.getRequestDispatcher("Error3.jsp");
        rd.forward(request,response);
        
      }
      else{


    if(usertype.equals("admin") || usertype.equals("user"))
    {
     

     String query = "INSERT INTO ins(username,password,email,Type)VALUES('"+ name + "','" + password+ "','"+email+"','"+usertype+"') ";

     System.out.println(query);

      int rs = st.executeUpdate( query );

     if(rs==1){	

      RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
      rd.include(request,response);
     }
	 
	else{	
    RequestDispatcher r = request.getRequestDispatcher("Error.jsp");
      r.include(request,response);
   		}
    }
    else{
      RequestDispatcher r = request.getRequestDispatcher("Error2.jsp");
      r.include(request,response);
    }
  }
      
     out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
