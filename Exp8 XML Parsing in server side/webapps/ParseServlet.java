import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ParseServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>XML Parsing in Server side</title>");
		out.println("<style> table{ background-color:  hsl(240, 47%, 20%); Color: whitesmoke;font-family: Arial; font-size:24px;margin: 180px 420px;} tr,th,td { padding: 15px; } </style>");
		out.println("</head>");
		out.println("<body>");
		
			DomParser parser=new DomParser();
			String str[]=parser.searchcollege(request.getParameter("data"));
			if(str!=null)
			{
				out.println("<center><table border='1'>");
				out.println("<tr>");
				
				out.println("<th>"+"College Name"+"</th>");
				out.println("<th>"+"Short Form "+"</th>");
				out.println("<th>"+"District"+"</th>");
		        out.println("</tr><tr>");
				
				out.println("<td><h3>"+str[1]+"</td>");
				out.println("<td><h3>"+str[2]+"</td>");
				out.println("<td><h3>"+str[3]+"</td></center>");
				out.println("<tr>");
				
			}
			else{
				out.println("<h2>"+""+"</h2>");
			}
	out.println("</body>");
	out.println("</html>");
}
}
		