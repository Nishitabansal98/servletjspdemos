import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public void LoginServlet() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		doGet(request, response);
		String uName=request.getParameter("uName");
		String pass=request.getParameter("pwd");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd;
		if(uName.equals("Nishita.bansal@gmail.com")&&pass.equals("password"))
		{
			HttpSession session=request.getSession(true);
			session.setAttribute("username", uName);
			rd=request.getRequestDispatcher("Dashboard");
			rd.forward(request, response);
		}
		else {
			out.println("Invalid Username or Password");
			rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}

}