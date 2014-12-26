package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DisplayData;
import bean.ParkTransaction;
import bean.User;
import business.CalculateParkKo;
import db.DBData;

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
		request.setCharacterEncoding("UTF-8");
		
		String carId = request.getParameter("txtCarID");
		String provice = request.getParameter("lstProvince");
		
		PrintWriter pw = response.getWriter();
		
		
		DBData data = new DBData();
		User user = data.getUser(carId, provice, "");
		ParkTransaction transaction = data.getParkTransaction(carId, provice, "");
		
		CalculateParkKo fee = new CalculateParkKo();
		int totalTime = fee.calculateRoundUpParkHour(transaction.getStartTime(), transaction.getEndTime());
		int specialParkTime = fee.calculateSpecialHour(transaction.getStartTime(), transaction.getEndTime());
		int normalTime = totalTime - specialParkTime;
		DisplayData display = getDisplayData( user, transaction, normalTime,specialParkTime );
		pw.append("<p> "+ display.toString());
//		pw.append("<p> "+ transaction.toString());
//		pw.append("<p> TotalTime = "+ totalTime);
		
		pw.flush();
		pw.close();
	}
	
	public DisplayData getDisplayData(User user,ParkTransaction transaction,int normalTime, int specialTime  ){
		DisplayData data = new DisplayData();
		data.setCarId(user.getCarId());
		data.setProvince(user.getProvince());
		data.setName(user.getName());
		data.setSurname(user.getSurname());
		data.setPicture(user.getPicture());
		data.setStartTime(transaction.getStartTime());
		data.setEndTime(transaction.getEndTime());
		data.setTotalNormalParkTime(normalTime);
		data.setTotalSpecialTime(specialTime);
		return data;
	}

}
