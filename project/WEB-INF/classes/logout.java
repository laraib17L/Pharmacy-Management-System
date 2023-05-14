
import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class logout extends HttpServlet{

public void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {        
   
   PrintWriter out = response.getWriter();
   HttpSession session=request.getSession(false);
   if(session!=null && !session.isNew())
   {
    session.invalidate();
    response.sendRedirect("search.html");
   }
   else if(session==null)
   {
    response.sendRedirect("search.html");
   }
}
}