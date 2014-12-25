package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBData;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response);
	}
	
	protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html; charset=TIS-620");
		PrintWriter pw = response.getWriter();
		//String cardID = new String("ณข ๙๖๒๐".getBytes("UTF-8"),"TIS-620");
		DBData data = new DBData();
		pw.append("<p> "+ data.getUser("ณข ๙๖๒๐", "ลำปาง", "ธวัชชัย").toString());
		pw.append("<p> "+ data.getUser("111", "111", "111").toString());
		//pw.append("<p> test");
		pw.flush();
		pw.close();
	}

}
