package com.sapient.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.entity.Greeting;
import com.sapient.service.GreetingService;

// http://localhost:1234/myapp/greet

@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. read all inputs
		String name = req.getParameter("name");
		
		// 2. get an appropriate model (service/dao) and invoke business logic methods
		GreetingService service = new GreetingService();
		Greeting gr = service.getGreeting(name);
		
		// 3. store the model data in a place (scope) that is accessible to view
		// request/session/application
		req.setAttribute("greeting", gr);
		
		// 4. forward the request/response to view (JSP)
		req.getRequestDispatcher("/WEB-INF/views/greet.jsp").forward(req, resp);
		
	}

}
