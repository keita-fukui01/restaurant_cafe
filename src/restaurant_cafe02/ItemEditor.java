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
import restaurant_cafe.util.Encoder;
import restaurant_cafe.util.PropertyLoader;

/**
 * Servlet implementation class ItemEditor
 */
public class ItemEditor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemEditor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
	//	String id = request.getAttribute("id");
	//	String id = Encoder.encodeUTF8(request.getParameter("id"));
	//	String name = (String) request.getAttribute("id");
	    String resultPage = PropertyLoader.getProperty("url.jsp.error");

	    try {
            ItemDAO dao = new ItemDAO();
            ItemBean item = dao.getItemById(id);
            request.setAttribute("item", item);
            resultPage = PropertyLoader.getProperty("url.jsp.editItem");

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
//		String name = (String) request.getAttribute("name");
//        String resultPage = PropertyLoader.getProperty("url.jsp.error");

		request.setCharacterEncoding("UTF-8");
		String id = Encoder.encodeUTF8(request.getParameter("id"));
//		String id = (String) request.getAttribute("id");
	    String resultPage = PropertyLoader.getProperty("url.jsp.error");

        try {
            ItemDAO dao = new ItemDAO();
            ItemBean item = dao.getItemById(id);
            request.setAttribute("item", item);
            resultPage = PropertyLoader.getProperty("url.jsp.editItem");

        } catch (NamingException e) {
            request.setAttribute("errorMessage", e.getMessage());

        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
        dispatcher.forward(request, response);
    }
}
//	@SuppressWarnings("unused")
//	private String setAttribute(String name, String mail, String mailForCheck, String phoneNumber, String cellphoneNumber, String gender) {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}
//
//}
