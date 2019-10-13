package com.vir.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vir.dao.CourseDAO;
import com.vir.dao.CourseDAOImpl;
import com.vir.model.Course;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/Course")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CourseDAO cdao=new CourseDAOImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
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
		//doGet(request, response);
		String coursename=request.getParameter("coursename");
		Course c=new Course(coursename);
		if(cdao.addCourse(c))
		{
			request.setAttribute("message", "Course added successfully");
			request.getRequestDispatcher("admin.jsp").forward(request, response);
			
		}
		else
		{
			request.setAttribute("message", "Course couldn't be added...try again later");
			request.getRequestDispatcher("admin.jsp").forward(request, response);	
		}
	}

}
