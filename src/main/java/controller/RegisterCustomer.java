package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import exception.JsysException;
import model.Customer;

/**
 * Servlet implementation class RegisterCustomer
 */
@WebServlet("/register_customer")
public class RegisterCustomer extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String buttonId = request.getParameter("button");
		String nextPage = "confirm.jsp";

		String customerCode = request.getParameter("customerCode");
		String customerName = request.getParameter("customerName");
		String customerTelno = request.getParameter("customerTelno");
		String customerPostalcode = request.getParameter("customerPostalcode");
		String customerAddress = request.getParameter("customerAddress");
		String sDiscountRate = request.getParameter("discountRate");

		int discountRate = 0;
		if (!sDiscountRate.isEmpty()) {
			discountRate = Integer.parseInt(sDiscountRate);
		}

		switch (buttonId) {
		case "input":
			nextPage = "confirm.jsp";
			break;
		case "register":
			try {
				CustomerDao customerDao = new CustomerDao();
				Customer customer = new Customer(customerCode, customerName, customerTelno, customerPostalcode,
						customerAddress,
						discountRate, false);
				System.out.println(customer.toString());
				customerDao.registerCustomer(customer);
			} catch (JsysException e) {
				String message = e.getMessage();
				request.setAttribute("message", message);
				request.setAttribute("error", "true");
			}
			nextPage = "result.jsp";
			break;
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	}
}
