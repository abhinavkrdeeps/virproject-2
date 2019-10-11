package com.vir.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vir.dao.EnrollmentDao;
import com.vir.dao.EnrollmentService;
import com.vir.dao.EnrollmentServiceImpl;
import com.vir.model.Batch;
import com.vir.model.Enrollment;
import com.vir.model.Student;


@WebServlet("/enrollment")
public class EnrollmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public EnrollmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student student = (Student)req.getSession().getAttribute("data");
		if(student!=null) {
			EnrollmentService enrollmentService = new EnrollmentServiceImpl();
			Enrollment enrollment = enrollmentService.findByStudentId(student.getStudentID());
			boolean isRemoved=enrollmentService.removeEnrollment(enrollment);
			System.out.println(isRemoved);
			req.getRequestDispatcher("/student.jsp").forward(req, resp);
			
	   }else {
		   System.out.println("student null");
	   }
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BuisnessService service = new BuisnessService();
		
		
		Student student = (Student)request.getSession().getAttribute("data");
		if(student!=null)
		{
			if(service.isAlreadyEnrolledInSomeCourse(student.getStudentID()))
			{
				request.setAttribute("alreadyenroll", "You are already Enrolled in a batch..Cannot Enroll Again");
				request.getRequestDispatcher("/batch.jsp").forward(request, response);
			}else{
				
				Batch batch = (Batch)request.getSession().getAttribute("batch");
				Enrollment enrollment = new Enrollment();
				enrollment.setBatchID(batch.getBatchID());
				enrollment.setStudentID(student.getStudentID());
				EnrollmentService enrollmentService = new EnrollmentServiceImpl();
				boolean isAdded = enrollmentService.addEnrollment(enrollment);
				if(isAdded)
				{
					request.getSession().setAttribute("student",student);
					request.setAttribute("success","Successfully Enrolled..Start Learning");
					
					request.getRequestDispatcher("/student.jsp").forward(request, response);
				}else {
					System.out.println("cannot enroll");
					request.setAttribute("cannotenoll","Some Error Ocurred..Try Again");
					request.getRequestDispatcher("/batch.jsp").forward(request, response);
				}
				
			}
		}
		else {
			request.setAttribute("notloggedIn","Pleae Log In First");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	
	}


	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	
	

}
}