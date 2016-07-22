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
import customtools.CourseUtil;
import model.Hcclass;
import model.Hccourse;

/**
 * Servlet implementation class CourseProfile
 */
@WebServlet("/CourseProfile")
public class CourseProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id=request.getParameter("viewcourseid");
		long courseid=Integer.parseInt(id);
		Hccourse currcourse= CourseUtil.getCourseById(courseid);
		session.setAttribute("currcourse", currcourse);
		ArrayList<Hcclass> classes=new ArrayList<Hcclass>();
		List<Hcclass> c = ClassUtil.getClassesByCourseId(courseid);
		//List<Hcclass> c = ClassUtil.getClasses();
		classes.addAll(c);
		session.setAttribute("classes", classes);
		String nextURL="/courseprofile.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
	}

}
