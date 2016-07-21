package hcservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customtools.StudentUtil;
import customtools.UserUtil;
import model.Hcstudent;
import model.Hcuser;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request
	 * , HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request
	 * , HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String firstname= request.getParameter("firstname");
		final String lastname= request.getParameter("lastname");
		final String username= request.getParameter("username");
		final String email= request.getParameter("email");
		final String password= request.getParameter("password");
		final String major=request.getParameter("major");
		final String entryyear=request.getParameter("entryyear");
		Hcuser user = new Hcuser();
		user.setEmail(email);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setPassword(password);
		user.setUsername(username);
		UserUtil.insert(user);
		Hcstudent student = new Hcstudent();
		student.setMajor(major);
		student.setHcuser(user);
		student.setEntryyear(entryyear);
		StudentUtil.insert(student);
		String nextURL="/login.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
