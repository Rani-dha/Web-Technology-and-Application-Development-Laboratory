import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sessionn extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Session Tracking in servlet</title>");
        out.println("</head>");
        out.println("<body bgcolor=\" #2F3061\">");
        HttpSession session = request.getSession();
        Integer c = (Integer) session.getAttribute("count");
        
        if (session.isNew()) {
            String dataName = request.getParameter("user");
            c = 1;
            if (dataName != null && dataName.length() > 0) {
                session.setAttribute("nameOfTheUser", dataName);
            }
           
            out.println("<center><h3 style='color:white;'>");
            out.println("The First request of the servlet is made by " + session.getAttribute("nameOfTheUser"));
            out.println("</h3></center>");
            session.setAttribute("count", c);
        } else {
            out.println("<center>");
            out.println("<h3 style='color:white;'>");
            out.println("<p> Request was made by " + session.getAttribute("nameOfTheUser")+"</p>");
            out.println("<p>Now " + session.getAttribute("nameOfTheUser") + " has visited "+"</p>");
            c++;
            out.println("<h3 style='color:red;font-family:sans-serif;font-style:normal;padding:7px;height:30px;font-size:30px'>");
            out.println(c +" times");
            out.println("</h3></h3>");
            out.println("</p>");
            session.setAttribute("count", c);

            Date created = new Date(session.getCreationTime());
            Date accessed = new Date(session.getLastAccessedTime());
            out.println("<h3 style='color:white;'>");
            out.println("<p>Session ID " + session.getId() +"</p>");
            out.println("<p>Created On: " + created +"</p>");
            out.println("<p>Last Accessed On: " + accessed +"</p>");
            out.println("</h3></center></body></html>");
        }

    }
}

