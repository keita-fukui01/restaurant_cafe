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
public class ItemDeletion extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDeletion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		HttpSession session = request.getSession();

//		String id =(String)session.getAttribute("id");


		String id = Encoder.encodeUTF8(request.getParameter("id"));
//		String name = Encoder.encodeUTF8(request.getParameter("name"));
//		String course = Encoder.encodeUTF8(request.getParameter("course"));
//		String mail = Encoder.encodeUTF8(request.getParameter("mail"));
//		String phoneNumber = Encoder.encodeUTF8(request.getParameter("phoneNumber"));
//		String cellphoneNumber = Encoder.encodeUTF8(request.getParameter("cellphoneNumber"));
//		String gender = Encoder.encodeUTF8(request.getParameter("gender"));
//		String year = Encoder.encodeUTF8(request.getParameter("year"));
//		String month = Encoder.encodeUTF8(request.getParameter("month"));
//		String day = Encoder.encodeUTF8(request.getParameter("day"));
//		String time = Encoder.encodeUTF8(request.getParameter("time"));
//		String minutes = Encoder.encodeUTF8(request.getParameter("minutes"));

        String resultPage = PropertyLoader.getProperty("url.jsp.error");

        try {
            ItemDAO dao = new ItemDAO();
            ItemBean item = dao.getItemById(id);

            dao.deleteItem(id);
            request.setAttribute("item", item);
            request.setAttribute("message",
                                       PropertyLoader.getProperty("message.completeDeletion"));
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

	//	HttpSession session = request.getSession();

	//	String id =(String)session.getAttribute("id");

		String id = Encoder.encodeUTF8(request.getParameter("id"));
        String resultPage = PropertyLoader.getProperty("url.jsp.error");

//	String name =(String)session.getAttribute("name");
//	String mail = (String) session.getAttribute("mail");
//	String course = (String) session.getAttribute("course");
//	String mailForCheck = (String) session.getAttribute("mailForCheck");
//	String phoneNumber = (String) session.getAttribute("phoneNumber");
//	String cellphoneNumber = (String) session.getAttribute("cellphoneNumber");
//	String gender = (String) session.getAttribute("gender");
//	String year = (String)session.getAttribute("year");
//	String month = (String)session.getAttribute("month");
//	String day = (String)session.getAttribute("day");
//	String time = (String)session.getAttribute("time");
//	String minutes = (String)session.getAttribute("minutes");
//	String resultPage = PropertyLoader.getProperty("url.jsp.error");

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

}
