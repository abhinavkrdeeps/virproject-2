package com.vir.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vir.dao.BatchDAOImpl;
import com.vir.dao.BatchDao;
import com.vir.dao.EnrollmentDao;
import com.vir.dao.EnrollmentService;
import com.vir.dao.EnrollmentServiceImpl;
import com.vir.model.Batch;

/**
 * Servlet implementation class BatchAction
 */
@WebServlet("/batchaction")
public class BatchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BatchDao bdao=new BatchDAOImpl();
    EnrollmentService eservice=new EnrollmentServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchAction() {
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
		HttpSession session=request.getSession();
		String i=request.getParameter("action");
		Batch ba=(Batch) session.getAttribute("batch");
		int id=ba.getBatchID();
		
		if(i.equals("remove"))
		{
			
			if(eservice.removeByBatch(id))
			{

				if(bdao.removeBatch(ba))
				{
					request.setAttribute("message", "Batch removed successfully");
					request.getRequestDispatcher("batchremoveupdate.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("message", "Batch could not be removed");
					request.getRequestDispatcher("batchremoveupdate.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("message", "Batch could not be removed");
				request.getRequestDispatcher("batchremoveupdate.jsp").forward(request, response);

			}
			
			
		}
		else
		{
			
		}
	}

}
