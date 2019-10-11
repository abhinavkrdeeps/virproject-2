package com.vir.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vir.dao.StudentServiceImpl;
import com.vir.model.Student;
@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BuisnessService service=null;
  	public void init() {
	 service = new BuisnessService();
	}
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String fname = request.getParameter("fname");
		String uid = request.getParameter("uid");
		int age = Integer.parseInt(request.getParameter("age"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(service.checkForUniqueUsername(username))
		{
			Student student = new Student(name,fname,uid,age,username,password);
			StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
			boolean expected = studentServiceImpl.addStudent(student);
			System.out.println(expected);
			if(expected)
			{
				//request.setAttribute("message", student);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				request.setAttribute("message","Some Error Occurred..Try Again");
				request.getRequestDispatcher("/Studentregistration.jsp").forward(request, response);
			}
			
		}else
		{
			request.setAttribute("message","Username Already Exists");
			request.getRequestDispatcher("/Studentregistration.jsp").forward(request, response);
		}	
		
	}

}
