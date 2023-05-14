import java.io.*;

public class log extends HttpServlet
{
    public void doGet(HttpServletRequest request , HttpServletResponse response )
    {
        int no1 = Integer.parseInt(request.getParameter("num1"));
        int no2 = Integer.parseInt(request.getparameter("num2"));

        PrintWriter out= response.getPrintWriter();

        int sum= no1+no2;

        out.println(sum);

    }
}