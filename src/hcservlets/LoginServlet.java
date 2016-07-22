package hcservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customtools.StudentUtil;
import customtools.UserUtil;
import model.Hcstudent;
import model.Hcuser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// this page does not require user to be logged in
		
		HttpSession session = request.getSession();
		int count =0;
		String useremail = request.getParameter("email");
		String userpassword = request.getParameter("password");

		String nextURL = "/error.jsp";

		Hcuser user = null;
		//Hcstudent student = null;
		String action = "login";
		if (action.equals("logout")) {
			nextURL = "/logout.jsp";
		} else {
			user = UserUtil.getUserByEmail(useremail);
			if (UserUtil.isValidUser(user) && userpassword.equals(user.getPassword())) {
			//	student = StudentUtil.getStudentByUserId(user.getUserid());
				UserUtil.update(user);
				session.setAttribute("user", user);
				//session.setAttribute("student", student);
				nextURL = "/home.jsp";
			} else if(count <=3) {
				nextURL = "/login.jsp";
				count ++;
			}else if (count==3){
				nextURL = "/createaccount.jsp";
				count =0;
			}else{
				nextURL = "/createaccount.jsp";
			}

		}
		// redirect to next page as indicated by the value of the nextURL
		// variable
		// getServletContext().getRequestDispatcher(nextURL).forward(request,response);
		response.sendRedirect(request.getContextPath() + nextURL);

	}

}
