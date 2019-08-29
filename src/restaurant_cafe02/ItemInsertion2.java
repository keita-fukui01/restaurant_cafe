package restaurant_cafe02;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class ItemInsertion2
 */
public class ItemInsertion2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemInsertion2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @param session
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//	      String id = Encoder.encodeUTF8(request.getParameter("id"));
//		String name =Encoder.encodeUTF8 ((String) request.getAttribute("name"));
//      String mail = Encoder.encodeUTF8 ((String) request.getAttribute("mail"));
//      String mailForCheck = Encoder.encodeUTF8((String) request.getAttribute("mailForCheck"));
//      String phoneNumber = Encoder.encodeUTF8((String) request.getAttribute("phoneNumber"));
//      String cellphoneNumber = Encoder.encodeUTF8((String) request.getAttribute("cellphoneNumber"));
//      String gender = Encoder.encodeUTF8((String) request.getAttribute("gender"));
//      String resultPage = PropertyLoader.getProperty("url.jsp.error");

//		String id = null;
//		  String name = (String) request.getAttribute("name");
//	      String mail = (String) request.getAttribute("mail");
//	      String mailForCheck = (String) request.getAttribute("mailForCheck");
//	      String phoneNumber = (String) request.getAttribute("phoneNumber");
//	      String cellphoneNumber = (String) request.getAttribute("cellphoneNumber");
//	      String gender = (String) request.getAttribute("gender");
//	      String resultPage = PropertyLoader.getProperty("url.jsp.error");

	HttpSession session = request.getSession();

	String id = null;
	String name =(String)session.getAttribute("name");
	String mail = (String) session.getAttribute("mail");
	String course = (String) session.getAttribute("course");
//  String mailForCheck = (String) session.getAttribute("mailForCheck");
    String phoneNumber = (String) session.getAttribute("phoneNumber");
    String cellphoneNumber = (String) session.getAttribute("cellphoneNumber");
    String gender = (String) session.getAttribute("gender");
    String year = (String)session.getAttribute("year");
    String month = (String)session.getAttribute("month");
    String day = (String)session.getAttribute("day");
    String time = (String)session.getAttribute("time");
    String minutes = (String)session.getAttribute("minutes");
    String resultPage = PropertyLoader.getProperty("url.jsp.error");

//      if (name.length() != 0 &&  mail.length() != 0 && mailForCheck.length() != 0 && phoneNumber.length() != 0
//    		  && cellphoneNumber.length() != 0 && gender.length() != 0) {
    if (name.length() != 0 && mail.length() != 0 && course.length() != 0 && phoneNumber.length() != 0 && cellphoneNumber.length() != 0 && gender.length() != 0
  		  && year.length() != 0 && month.length() != 0 && day.length() != 0 && time.length() != 0 && minutes.length() != 0) {

          try {
              ItemDAO dao = new ItemDAO();
//              ItemBean item = dao.getItemById(id);
              //ItemBean item = dao.getItemByName(name);


//              dao.insertItem( id, name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender );
//              item = dao.getItemById(id);
              	id=String.valueOf(dao.getMaxID());
//              dao.insertItem(id, name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender);
                dao.insertItem(id, name, course, mail, phoneNumber, cellphoneNumber, gender, year, month, day,time, minutes);
                ItemBean item = dao.getItemById(id);
                request.setAttribute("item", item);
                request.setAttribute("message", PropertyLoader.getProperty("message.completeInsertion"));
                resultPage = PropertyLoader.getProperty("url.jsp.editComplete1");
            }


//              if (item.getId() == null) {
////                  dao.insertItem( id, name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender );
////                  item = dao.getItemById(id);
//              	dao.insertItem(id );
//                  item = dao.getItemById(name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender);
//                  request.setAttribute("item", item);
//                  request.setAttribute("message", PropertyLoader.getProperty("message.completeInsertion"));
//                  resultPage = PropertyLoader.getProperty("url.jsp.editComplete");
//
//              } else {
//                  resultPage = PropertyLoader.getProperty("url.jsp.error");
//                  request.setAttribute("errorMessage",
//                                        PropertyLoader.getProperty("message.duplication"));
//              }

            catch (NamingException e) {
              request.setAttribute("errorMessage", e.getMessage());

          } catch (SQLException e) {
              request.setAttribute("errorMessage", e.getMessage());

          } catch (NumberFormatException e) {
              request.setAttribute("errorMessage", PropertyLoader.getProperty("message.NumberFormatException"));
          }

      } else {
          resultPage = PropertyLoader.getProperty("url.jsp.error");
          request.setAttribute("errorMessage", PropertyLoader.getProperty("message.inputNull"));
      }

      RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
      dispatcher.forward(request, response);
	}
}
//		String id = null;
//		  String name = (String) request.getAttribute("name");
//	      String mail = (String) request.getAttribute("mail");
//	      String mailForCheck = (String) request.getAttribute("mailForCheck");
//	      String phoneNumber = (String) request.getAttribute("phoneNumber");
//	      String cellphoneNumber = (String) request.getAttribute("cellphoneNumber");
//	      String gender = (String) request.getAttribute("gender");
//	      String resultPage = PropertyLoader.getProperty("url.jsp.error");
//
//
//	        if (name.length() != 0 && mail.length() != 0 && mailForCheck.length() != 0 && phoneNumber.length() != 0 && cellphoneNumber.length() != 0 && gender.length() != 0) {
//	            try {
//	                ItemDAO dao = new ItemDAO();
//	                int maxid=dao.getMaxID();
//	                id=Integer.toString(maxid);
//	               ItemBean item = dao.getItemById(id);
//
//	            //    ItemBean item = dao.getItemByName(name);
//
//
//	           //     dao.insertItem( name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender );
//	           //      item = dao.getItemByName(name);
//	                dao.insertItem(id, name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender);
//	                item = dao.getItemById(id);
//	                  request.setAttribute("item", item);
//	                  request.setAttribute("message", PropertyLoader.getProperty("message.completeInsertion"));
//	                  resultPage = PropertyLoader.getProperty("url.jsp.editComplete");
//	             }
//
//	              catch (NamingException e) {
//	                request.setAttribute("errorMessage", e.getMessage());
//
//	            } catch (SQLException e) {
//	                request.setAttribute("errorMessage", e.getMessage());
//
//	            } catch (NumberFormatException e) {
//	                request.setAttribute("errorMessage",
//	                               PropertyLoader.getProperty("message.NumberFormatException"));
//	            }
//
//	        } else {
//	            resultPage = PropertyLoader.getProperty("url.jsp.error");
//	            request.setAttribute("errorMessage",
//	                                          PropertyLoader.getProperty("message.inputNull"));
//	        }
//
//	        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
//	        dispatcher.forward(request, response);
//	    }
//}