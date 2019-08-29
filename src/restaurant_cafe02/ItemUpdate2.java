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
 * Servlet implementation class ItemUpdate2
 */
public class ItemUpdate2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemUpdate2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @param oldId
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String oldId = request.getParameter("oldId");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		String mail = request.getParameter("mail");
		String phoneNumber = request.getParameter("phoneNumber");
		String cellphoneNumber = request.getParameter("cellphoneNumber");
		String gender = request.getParameter("gender");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String time = request.getParameter("time");
		String minutes = request.getParameter("minutes");
		String resultPage = PropertyLoader.getProperty("url.jsp.error");

//		String oldId = Encoder.encodeUTF8(request.getParameter("oldId"));
//		String id = Encoder.encodeUTF8(request.getParameter("id"));
//		String name = Encoder.encodeUTF8(request.getParameter("name"));
//		String course = Encoder.encodeUTF8(request.getParameter("course"));
//      String mail = Encoder.encodeUTF8(request.getParameter("mail"));
//      String mailForCheck = Encoder.encodeUTF8(request.getParameter("mailForCheck"));
//        String phoneNumber = Encoder.encodeUTF8(request.getParameter("phoneNumber"));
//        String cellphoneNumber = Encoder.encodeUTF8(request.getParameter("cellphoneNumber"));
//        String gender = Encoder.encodeUTF8(request.getParameter("gender"));
//        String year = Encoder.encodeUTF8(request.getParameter("year"));
//        String month = Encoder.encodeUTF8(request.getParameter("month"));
//        String day = Encoder.encodeUTF8(request.getParameter("day"));
//        String time = Encoder.encodeUTF8(request.getParameter("time"));
//        String minutes = Encoder.encodeUTF8(request.getParameter("minutes"));
//        String resultPage = PropertyLoader.getProperty("url.jsp.error");

//		String oldName = Encoder.encodeUTF8(request.getParameter("oldName"));
//		String id = (String) request.getAttribute("id");
//        String name = (String) request.getAttribute("name");
//        String mail = (String) request.getAttribute("mail");
//        String mailForCheck = (String) request.getAttribute("mailForCheck");
//        String phoneNumber = (String) request.getAttribute("phoneNumber");
//        String cellphoneNumber = (String) request.getAttribute("cellphoneNumber");
//        String gender = (String) request.getAttribute("gender");
//        String resultPage = PropertyLoader.getProperty("url.jsp.error");

        if (id.length() != 0 && name.length() != 0 && course.length() != 0 && mail.length() != 0 && phoneNumber.length() != 0 && cellphoneNumber.length() != 0 && gender.length() != 0
        		&& year.length() != 0 && month.length() != 0 && day.length() != 0 && time.length() != 0 && minutes.length() != 0) {
  //   	if (id.length() != 0 && name.length() != 0 && mail.length() != 0 && mailForCheck.length() != 0 && phoneNumber.length() != 0 && cellphoneNumber.length() != 0 && gender.length() != 0) {
   //   if (name.length() != 0 && mail.length() != 0 && mailForCheck.length() != 0 && phoneNumber.length() != 0 && cellphoneNumber.length() != 0 && gender.length() != 0) {
            try {
                ItemDAO dao = new ItemDAO();
                ItemBean item = dao.getItemById(id);
      //          ItemBean item = dao.getItemByName(name);

               //  if (name.equals(oldId) || item.getId() == null) {
                	 if (id.equals(oldId) || item.getId() == null) {
                //	 if (item.getName() == null) {

//                  dao.updateItem(id, name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender);
//                  item = dao.getItemById(id);
//                    dao.updateItem(oldId, name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender);
//                    item = dao.getItemByName(name);
                    dao.updateItem(id, name, course, mail, phoneNumber, cellphoneNumber, gender,year, month, day, time, minutes, oldId);
//                    dao.updateItem(id, name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender,oldId);
                    item = dao.getItemById(id);
                    request.setAttribute("item", item);
                    request.setAttribute("message", PropertyLoader.getProperty("message.completeUpdate"));
                    resultPage = PropertyLoader.getProperty("url.jsp.editComplete");

                } else {
                    resultPage = PropertyLoader.getProperty("url.jsp.error");
                    request.setAttribute("errorMessage",
                                           PropertyLoader.getProperty("message.duplication"));
                }

            } catch (NamingException e) {
                request.setAttribute("errorMessage", e.getMessage());

            } catch (SQLException e) {
                request.setAttribute("errorMessage", e.getMessage());

            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", e.getMessage());
            }

        } else {
            resultPage = PropertyLoader.getProperty("url.jsp.error");
            request.setAttribute("errorMessage",
                                          PropertyLoader.getProperty("message.inputNull"));
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
        dispatcher.forward(request, response);
    }
/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}
}
