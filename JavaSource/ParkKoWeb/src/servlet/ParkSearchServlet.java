package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBData;
import bean.*;

/**
 * Servlet implementation class ParkSearchServlet
 */
@WebServlet("/ParkSearchServlet")
public class ParkSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Content-Type", "text/html; charset=UTF-8");
		String carId = request.getParameter("txtCarID");
		String provice = request.getParameter("lstProvince");
		
		PrintWriter pw = response.getWriter();
		
		
		DBData data = new DBData();
		User user = data.getUser(carId, provice, "");
		ParkTransaction transaction = data.getParkTransaction(carId, provice, "");
		
		pw.append("<p> "+ user.toString());
		pw.append("<p> "+ transaction.toString());
		pw.flush();
		pw.close();
	}

}
