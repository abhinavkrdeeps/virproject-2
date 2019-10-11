package com.vir.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vir.dao.StudentServiceImpl;
import com.vir.dao.TrainerDAOImpl;
import com.vir.model.Student;
import com.vir.model.Trainer;

/**
 * Servlet implementation class TrainerServlet
 */
@WebServlet("/TrainerServlet")
public class TrainerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BuisnessService service=null;
  	public void init() {
	 service = new BuisnessService();
	}
  	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainerServlet() {
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
		String name=request.getParameter("name");
		String uid=request.getParameter("uid");
		int age=Integer.parseInt(request.getParameter("age"));
		String specialization=request.getParameter("specialization");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(service.checkForUniqueTrainer(username))
		{
			Trainer t=new Trainer(name,uid,age,specialization,username,password);
			TrainerDAOImpl tdi=new TrainerDAOImpl();
			boolean expected = tdi.addTrainer(t);
			System.out.println(expected);
			if(expected)
			{
				//request.setAttribute("message", student);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				request.setAttribute("message","Some Error Occurred..Try Again");
				request.getRequestDispatcher("/trainerdashboard.jsp").forward(request, response);
			}
			
		}else
		{
			request.setAttribute("message","Username Already Exists");
			request.getRequestDispatcher("/tainerReg.jsp").forward(request, response);
		}	
		
		}
	}


