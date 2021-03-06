package hcservlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customtools.ClassUtil;
import customtools.RosterUtil;
import customtools.StudentUtil;
import model.Hcclass;
import model.Hcclassroster;
import model.Hcstudent;

/**
 * Servlet implementation class DropClass
 */
@WebServlet("/DropClass")
public class DropClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Hcstudent student = null;
		Hcclassroster roster = new Hcclassroster();
		Hcclass hcclass = null;
		String uid =request.getParameter("curruserid");
		long userid = Integer.parseInt(uid);
		student = StudentUtil.getStudentByUserId(userid);
		String crns = request.getParameter("classcrn");
		long crn=Integer.parseInt(crns);
		roster=RosterUtil.getRosterByCrnAndStudentid(student.getStudentid(), crn);
		RosterUtil.deleteRoster(roster);
		String nextURL="/home.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
