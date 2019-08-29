package restaurant_cafe02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PasswordAuthenticaiton
 */
public class PasswordAuthenticaiton extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id = "winschool";
    private String password = "winschool";
    /**
     * @see HttpServlet#HttpServlet()
     */
           // TODO Auto-generated constructor stub
   	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        response.sendRedirect("/restaurant_cafe/loginForm.jsp");
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(true);
        if (this.id.equals(id) && this.password.equals(password)) {
            session.setAttribute("status", "login");
            session.setAttribute("id", id);
    //      response.sendRedirect("/restaurant_cafe/selectItem.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ItemManager");
            dispatcher.forward(request, response);

        } else {
            session.setAttribute("status", "logout");
            response.sendRedirect("/restaurant_cafe/loginForm.jsp");
        }
	}
}
