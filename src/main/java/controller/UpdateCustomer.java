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
 * Servlet implementation class UpdateCustomer
 */
@WebServlet("/update_customer")
public class UpdateCustomer extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String searchCode = request.getParameter("search");

		if (searchCode != null) {
			try {
				CustomerDao customerDao = new CustomerDao();
				Customer customer = customerDao.findCustomerByCustomerCode(searchCode);
				request.setAttribute("customer", customer);

			} catch (JsysException e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("search2.jsp");
		requestDispatcher.forward(request, response);
	}

}
