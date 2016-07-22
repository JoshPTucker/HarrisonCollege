package hcservlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class ClassFeed
 */
@WebServlet("/ClassFeed")
public class ClassFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassFeed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Hcstudent student = null;
		String uid =request.getParameter("curruserid");
		long userid = Integer.parseInt(uid);
		student = StudentUtil.getStudentByUserId(userid);
		
		ArrayList<Hcclassroster> studentclasses=new ArrayList<Hcclassroster>();
		List<Hcclassroster> r = RosterUtil.getRosterByStudentId(student.getStudentid());
	
		studentclasses.addAll(r);
		session.setAttribute("studentclasses", studentclasses);
		String nextURL="/classfeed.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
