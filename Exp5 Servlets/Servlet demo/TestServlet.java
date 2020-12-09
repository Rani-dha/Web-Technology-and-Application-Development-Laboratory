import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet {
 public  void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
     response.setContentType("text/html");
     PrintWriter out= response.getWriter();
     out.println("<head>");
     out.println("<title>the servlet test...</title>"); 
     out.println("</head>"); 
     out.println("<body bgcolor=\"orange\">");
     out.println("<h1>Hey, wait! The servlet is running...</h1>");
     out.println("</body>");
     out.println("</html>");   

}
}                               
                                           
