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
 * Servlet implementation class ItemSelector
 */
public class ItemSelector extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemSelector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		String id = Encoder.encodeUTF8(request.getParameter("id"));
//		String name = Encoder.encodeUTF8(request.getParameter("name"));
//		String mail = Encoder.encodeUTF8(request.getParameter("mail"));
//		String mailForCheck = Encoder.encodeUTF8(request.getParameter("mailForCheck"));
//		String phoneNumber = Encoder.encodeUTF8(request.getParameter("phoneNumber"));
//		String cellphoneNumber = Encoder.encodeUTF8(request.getParameter("cellphoneNumber"));
//		String gender = Encoder.encodeUTF8(request.getParameter("gender"));
//		String resultPage = PropertyLoader.getProperty("url.jsp.error");

//		String name = (String) request.getAttribute("name");
//	    String mail = (String) request.getAttribute("mail");
//	    String mailForCheck = (String) request.getAttribute("mailForCheck");
//	    String phoneNumber = (String) request.getAttribute("phoneNumber");
//	    String cellphoneNumber = (String) request.getAttribute("cellphoneNumber");
//       String gender = (String) request.getAttribute("gender");
//	    String resultPage = PropertyLoader.getProperty("url.jsp.error");

		String name = request.getParameter("name");
        String mail = request.getParameter("mail");
        String phoneNumber = request.getParameter("phoneNumber");
        String cellphoneNumber = request.getParameter("cellphoneNumber");
        String resultPage = PropertyLoader.getProperty("url.jsp.error");

          try {

//        	if (id.length() == 0) {
//                id = "%";
//            }
            if (name.length() == 0) {
                name = "%";
            }
            if (mail.length() == 0) {
          	    mail = "%";
            }
            if (phoneNumber.length() == 0) {
            	phoneNumber = "%";
            }
            if (cellphoneNumber.length() == 0) {
            	cellphoneNumber = "%";
            }
//            if(gender.length() == 0) {
//            	gender = "%";
//            }

            ItemDAO dao = new ItemDAO();
//            List <ItemBean> itemList = dao.getItemListConditionally(name,mail, mailForCheck,phoneNumber,cellphoneNumber,gender);
//            List <ItemBean> itemList = dao.getItemListConditionally(id,name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender);
            List <ItemBean> itemList = dao.getItemListConditionally( name, mail, phoneNumber, cellphoneNumber);

            //request.setAttribute("itemList", itemList);
            Iterator<ItemBean> iterator = itemList.iterator();
            List<ItemBean> itemList10 = new ArrayList<ItemBean>();
            for (int i = 0; iterator.hasNext() && i < 10; i++) {
                itemList10.add(iterator.next());
            }
            request.setAttribute("itemList", itemList10);

            resultPage = PropertyLoader.getProperty("url.jsp.selectItem");

            int maxPage = (int) (itemList.size() / 10 + 1);
            HttpSession session = request.getSession(false);
            session.setAttribute("itemList", itemList);
            session.setAttribute("page", "1");
            session.setAttribute("maxPage", Integer.toString(maxPage));

        } catch (NamingException e) {
            request.setAttribute("errorMessage", e.getMessage());

        } catch (SQLException e) {
            request.setAttribute("errorMessage", e.getMessage());

        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage",
                                PropertyLoader.getProperty("message.NumberFormatException"));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
        dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String name = (String) request.getAttribute("name");
//	    String mail = (String) request.getAttribute("mail");
//	    String mailForCheck = (String) request.getAttribute("mailForCheck");
//	    String phoneNumber = (String) request.getAttribute("phoneNumber");
//	    String cellphoneNumber = (String) request.getAttribute("cellphoneNumber");
//	    String gender = (String) request.getAttribute("gender");
//	    String resultPage = PropertyLoader.getProperty("url.jsp.error");
//
//        try {
//            int price = Integer.MAX_VALUE;
//
//
//            if (name.length() == 0) {
//                name = "%";
//            }
//
//            ItemDAO dao = new ItemDAO();
//            List <ItemBean> itemList = dao.getItemListConditionally(name,mail, mailForCheck,phoneNumber,cellphoneNumber,gender);
//
//            //request.setAttribute("itemList", itemList);
//            Iterator<ItemBean> iterator = itemList.iterator();
//            List<ItemBean> itemList10 = new ArrayList<ItemBean>();
//            for (int i = 0; iterator.hasNext() && i < 10; i++) {
//                itemList10.add(iterator.next());
//            }
//            request.setAttribute("itemList", itemList10);
//
//            resultPage = PropertyLoader.getProperty("url.jsp.selectItem");
//
//            int maxPage = (int) (itemList.size() / 10 + 1);
//            HttpSession session = request.getSession(false);
//            session.setAttribute("itemList", itemList);
//            session.setAttribute("page", "1");
//            session.setAttribute("maxPage", Integer.toString(maxPage));
//
//        } catch (NamingException e) {
//            request.setAttribute("errorMessage", e.getMessage());
//
//        } catch (SQLException e) {
//            request.setAttribute("errorMessage", e.getMessage());
//
//        } catch (NumberFormatException e) {
//            request.setAttribute("errorMessage",
//                                PropertyLoader.getProperty("message.NumberFormatException"));
//        }
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
//        dispatcher.forward(request, response);

//		String id = (String) request.getAttribute("id");
//String name = (String) request.getAttribute("name");
//String mail = (String) request.getAttribute("mail");
////String mailForCheck = (String) request.getAttribute("mailForCheck");
//String phoneNumber = (String) request.getAttribute("phoneNumber");
//String cellphoneNumber = (String) request.getAttribute("cellphoneNumber");
//String gender = (String) request.getAttribute("gender");
//String resultPage = PropertyLoader.getProperty("url.jsp.error");
//
//try {
////    int price = Integer.MAX_VALUE;
//    if (name.length() == 0) {
//        name = "%";
//    }
//    if(mail.length() == 0) {
//    	mail = "%";
//    }
////    if(mailForCheck.length() == 0) {
////    	mailForCheck = "%";
////    }
//    if (phoneNumber.length() == 0) {
//    	phoneNumber = "%";
//    }
//    if (cellphoneNumber.length() == 0) {
//    	cellphoneNumber = "%";
//    }
//    if(gender.length() == 0) {
//    	gender = "%";
//    }
//
//    ItemDAO dao = new ItemDAO();
////    List <ItemBean> itemList = dao.getItemListConditionally(id,name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender);
//    List <ItemBean> itemList = dao.getItemListConditionally(name, mail, phoneNumber, cellphoneNumber, gender);
//
//    //request.setAttribute("itemList", itemList);
//    Iterator<ItemBean> iterator = itemList.iterator();
//    List<ItemBean> itemList10 = new ArrayList<ItemBean>();
//    for (int i = 0; iterator.hasNext() && i < 10; i++) {
//        itemList10.add(iterator.next());
//    }
//    request.setAttribute("itemList", itemList10);
//
//    resultPage = PropertyLoader.getProperty("url.jsp.selectItem");
//
//    int maxPage = (int) (itemList.size() / 10 + 1);
//    HttpSession session = request.getSession(false);
//    session.setAttribute("itemList", itemList);
//    session.setAttribute("page", "1");
//    session.setAttribute("maxPage", Integer.toString(maxPage));
//
//} catch (NamingException e) {
//    request.setAttribute("errorMessage", e.getMessage());
//
//} catch (SQLException e) {
//    request.setAttribute("errorMessage", e.getMessage());
//
//} catch (NumberFormatException e) {
//    request.setAttribute("errorMessage",
//                        PropertyLoader.getProperty("message.NumberFormatException"));
//}
//
//RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
//dispatcher.forward(request, response);
//}
}
}