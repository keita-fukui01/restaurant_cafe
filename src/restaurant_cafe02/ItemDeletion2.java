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
 * Servlet implementation class ItemDeletion
 */
public class ItemDeletion2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDeletion2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = Encoder.encodeUTF8(request.getParameter("id"));
	//	String name = request.getParameter("name");

        String resultPage = PropertyLoader.getProperty("url.jsp.error");

        try {
            ItemDAO dao = new ItemDAO();
            ItemBean item = dao.getItemById(id);

            dao.deleteItem(id);
            request.setAttribute("item", item);
            request.setAttribute("message", PropertyLoader.getProperty("message.completeDeletion"));
            resultPage = PropertyLoader.getProperty("url.jsp.editComplete2");

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
		// TODO Auto-generated method stub
	}

}
