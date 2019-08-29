package restaurant_cafe02;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant_cafe.bean.ItemBean;
import restaurant_cafe.dao.ItemDAO;
import restaurant_cafe.util.PropertyLoader;

/**
 * Servlet implementation class ItemManager
 */
public class ItemManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String resultPage = PropertyLoader.getProperty("url.jsp.error");
//        try {
//            ItemDAO dao = new ItemDAO();
//            List<ItemBean> itemList = dao.getItemList();
//            request.setAttribute("itemList", itemList);
//            resultPage = PropertyLoader.getProperty("url.jsp.selectItem");
//
//        } catch (NamingException e) {
//            request.setAttribute("errorMessage", e.getMessage());
//
//        } catch (SQLException e) {
//            request.setAttribute("errorMessage", e.getMessage());
//        }
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
//        dispatcher.forward(request, response);
//	}
		String resultPage = PropertyLoader.getProperty("url.jsp.error");

        try {
            ItemDAO dao = new ItemDAO();
            List<ItemBean> itemList = dao.getItemList();

          //request.setAttribute("itemList", itemList);
            Iterator<ItemBean> iterator = itemList.iterator();
            List<ItemBean> itemList10 = new ArrayList<ItemBean> ();
            for (int i = 0; iterator.hasNext() && i < 10; i++) {
                itemList10.add(iterator.next());
            }
            request.setAttribute("itemList", itemList10);
            resultPage = PropertyLoader.getProperty("url.jsp.selectItem");

            int maxPage = (int) (itemList.size() / 10 + 1);
            HttpSession session = request.getSession(true);
            session.setAttribute("itemList", itemList);
            session.setAttribute("page", "1");
            session.setAttribute("maxPage", Integer.toString(maxPage));

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

		String resultPage = PropertyLoader.getProperty("url.jsp.error");

        try {
            ItemDAO dao = new ItemDAO();
            List<ItemBean> itemList = dao.getItemList();

          //request.setAttribute("itemList", itemList);
            Iterator<ItemBean> iterator = itemList.iterator();
            List<ItemBean> itemList10 = new ArrayList<ItemBean> ();
            for (int i = 0; iterator.hasNext() && i < 10; i++) {
                itemList10.add(iterator.next());
            }
            request.setAttribute("itemList", itemList10);
            resultPage = PropertyLoader.getProperty("url.jsp.selectItem");

            int maxPage = (int) (itemList.size() / 10 + 1);
            HttpSession session = request.getSession(true);
            session.setAttribute("itemList", itemList);
            session.setAttribute("page", "1");
            session.setAttribute("maxPage", Integer.toString(maxPage));

        } catch (NamingException e) {
            request.setAttribute("errorMessage", e.getMessage());

        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
        dispatcher.forward(request, response);
       	}
}