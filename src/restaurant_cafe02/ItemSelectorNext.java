package restaurant_cafe02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant_cafe.bean.ItemBean;
import restaurant_cafe.util.Cast;
import restaurant_cafe.util.PropertyLoader;

/**
 * Servlet implementation class ItemSelectorNext
 */
public class ItemSelectorNext extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemSelectorNext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);

        List<ItemBean> itemList = Cast.castList(session.getAttribute("itemList"));
        Iterator<ItemBean> iterator = itemList.iterator();

        List<ItemBean> itemList10 = new ArrayList<ItemBean> ();
        int page = Integer.parseInt((String) session.getAttribute("page"));
        int maxPage = (int) (itemList.size() / 10 + 1);

        if (page < maxPage) {
            page++;
        }

        for (int i = 0; iterator.hasNext() && i < page * 10; i++) {
            ItemBean item = iterator.next();
            if (i >= (page -1) * 10) {
                itemList10.add(item);
            }
        }

        request.setAttribute("itemList", itemList10);
        session.setAttribute("page", Integer.toString(page));

        String resultPage = PropertyLoader.getProperty("url.jsp.selectItem");
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
