package restaurant_cafe02;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restaurant_cafe.bean.ItemBean;
import restaurant_cafe.dao.ItemDAO;
import restaurant_cafe.util.PropertyLoader;

/**
 * Servlet implementation class ItemUpdate
 */
public class ItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//	String id = Encoder.encodeUTF8(request.getParameter("id"));
//	String name = Encoder.encodeUTF8(request.getParameter("name"));
//    String resultPage = PropertyLoader.getProperty("url.jsp.error");

//	String name = (String) request.getAttribute("name");
//  String name = Encoder.encodeUTF8(request.getParameter("name"));
//	String mail = Encoder.encodeUTF8(request.getParameter("mail"));
//	String mailForCheck = Encoder.encodeUTF8(request.getParameter("mailForCheck"));
//	String phoneNumber = Encoder.encodeUTF8(request.getParameter("phoneNumber"));
//	String cellphoneNumber = Encoder.encodeUTF8(request.getParameter("cellphoneNumber"));
//	String gender = Encoder.encodeUTF8(request.getParameter("gender"));
//	String resultPage = PropertyLoader.getProperty("url.jsp.error");

//    String name = (String) request.getAttribute("name");
//    String mail = (String) request.getAttribute("mail");
//    String mailForCheck = (String) request.getAttribute("mailForCheck");
//    String phoneNumber = (String) request.getAttribute("phoneNumber");
//    String cellphoneNumber = (String) request.getAttribute("cellphoneNumber");
//    String gender = (String) request.getAttribute("gender");
//    String resultPage = PropertyLoader.getProperty("url.jsp.error");

	String id = request.getParameter("id");
//	String id = Encoder.encodeUTF8(request.getParameter("id"));
	String resultPage = PropertyLoader.getProperty("url.jsp.error");
    try {
        ItemDAO dao = new ItemDAO();
        ItemBean item = dao.getItemById(id);
        request.setAttribute("item", item);
        resultPage = PropertyLoader.getProperty("url.jsp.updateItem");

    } catch (NamingException e) {
        request.setAttribute("errorMessage", e.getMessage());

    } catch (SQLException e) {
        request.setAttribute("errorMessage", e.getMessage());
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
    dispatcher.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		String id = Encoder.encodeUTF8(request.getParameter("id"));
//		String name = Encoder.encodeUTF8(request.getParameter("name"));
//      String name = (String) request.getAttribute("name");
//	    String resultPage = PropertyLoader.getProperty("url.jsp.error");

//	      String name = (String) request.getAttribute("name");
//	      String mail = (String) request.getAttribute("mail");
//	      String mailForCheck = (String) request.getAttribute("mailForCheck");
//	      String phoneNumber = (String) request.getAttribute("phoneNumber");
//	      String cellphoneNumber = (String) request.getAttribute("cellphoneNumber");
//	      String gender = (String) request.getAttribute("gender");
//	      String resultPage = PropertyLoader.getProperty("url.jsp.error");

	}
}
