package com.vir.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vir.dao.BatchDAOImpl;
import com.vir.dao.BatchDao;
import com.vir.model.Batch;


@WebServlet("/batch")
public class BatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Batch> al=new ArrayList<>();
       
  
    public BatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Integer cid = Integer.parseInt(request.getParameter("cid"));
		Integer CourseId = Integer.parseInt(request.getParameter("cid"));
		Date startDat = Date.valueOf(request.getParameter("startdate"));
		Date endDate = Date.valueOf(request.getParameter("enddate"));
		double price  = Double.parseDouble(request.getParameter("price"));
		Batch batch = new Batch(CourseId,startDat,endDate,price);
		BatchDao bdao=(BatchDao) new BatchDAOImpl();
		boolean expected =bdao.addBatch(batch);
		
		if(expected)
		{
			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		}else {
			request.setAttribute("message","Not Added..Try Again");
			request.getRequestDispatcher("/newbatch.jsp").forward(request, response);;
		}
		
		
			
	}
	
}
