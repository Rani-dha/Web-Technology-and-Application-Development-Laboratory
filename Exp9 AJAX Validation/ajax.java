import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ajax extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
								throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String field_name = request.getParameter("field");
		String value = request.getParameter("data");

		if(field_name.equals("username")){
			if(value!=" " && value!=null){
				String regex1 = "^[a-zA-Z0-9]+$";
				Pattern pattern1 = Pattern.compile(regex1);
				Matcher matcher1 = pattern1.matcher(value);
				if(value.length()<4 || value.length()>25 || !matcher1.matches()){
					out.write("Name must contain atleast 4 characters!");
				}
				else{
					out.write("valid");
				}
			}
		}
        if(field_name.equals("dob")){
			if(value!=" " && value!=null){
				int user_age = Integer.parseInt(value);
				if(user_age< 18 || user_age>=100){
					out.write("Age must be between 18 and 100!");
				}
				else{
						out.write("valid");
					}
				}
		}

		if(field_name.equals("emailId")){
			if(value!=" " && value!=null){
				String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+[.][a-z]+$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(value);
				if(!matcher.matches()){
					out.write("Please enter a Valid Email Address!");
				}
				else{
					out.write("valid");
				}
			}
		}

		if(field_name.equals("pwd1")){
			if(value!=" " && value!=null){
				if(value.length()<8 || value.length()>15)
				{
					out.write("Password must contains atleast 8 Characters!");
				}
				else{
					out.write("valid");
				}
			}
		}
		out.close();
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) 
								throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		out.println("<head>");
        out.println("<title>Ajax Form Validation</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"#1b1b4b\">");
		out.println("<h2 style='font-family: Arial, Helvetica, sans-serif;font-style: italic;color:white;position: absolute;top: 45%;left: 50%;margin-right: -50%;transform: translate(-50%, -50%)'>Hey ");
		out.println("<span style='color:white'>"+ username +", </span></h2>");	
	    out.println("<p style='color:white; margin-top:330px; margin-left:350px; margin-bottom:0px; margin-right:0px;'>The Details was Successfully registered to Ajax Form Validation</p>");
		out.println("</body>");
        out.println("</html>");
		out.close();
	}
}