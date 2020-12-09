import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ColorGetServlet extends HttpServlet {
 public  void doGet (HttpServletRequest request, HttpServletResponse response) 
       throws IOException, ServletException{
           String color =  request.getParameter("color");
           response.setContentType("text/html");
           PrintWriter pw= response.getWriter();
           pw.println("<b>The selected color is: ");
           pw.println(color);
           pw.close();
       }
    }
    