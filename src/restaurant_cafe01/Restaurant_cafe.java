package restaurant_cafe01;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Restaurant_cafe
 */
public class Restaurant_cafe extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Restaurant_cafe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String c_course = null;
		String t_tanpin = null;
		String d_drink = null;
		String y_yoyaku = null;

		c_course = "コース";
		t_tanpin = "単品";
		d_drink = "飲み物";
		y_yoyaku = "予約";

		request.setAttribute("c_course", c_course);
		request.setAttribute("t_tanpin", t_tanpin);
		request.setAttribute("d_drink", d_drink);
		request.setAttribute("y_yoyaku", y_yoyaku);

	    String url ="/r_cafe.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}


