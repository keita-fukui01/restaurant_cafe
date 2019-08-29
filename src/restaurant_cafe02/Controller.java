package restaurant_cafe02;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import restaurant_cafe.bean.ResBean;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		String time = request.getParameter("time");
		String id = request.getParameter("id");
        String name = request.getParameter("name");
        String course = request.getParameter("course");
        String mail = request.getParameter("mail");
//        String mailForCheck = request.getParameter("mailForCheck");
        String phoneNumber = request.getParameter("phoneNumber");
        String cellphoneNumber = request.getParameter("cellphoneNumber");
        String gender = request.getParameter("gender");
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String time = request.getParameter("time");
        String minutes = request.getParameter("minutes");

//        if (id.length() == 0 || name.length() == 0 || mail.length() == 0 || mailForCheck.length() == 0 || phoneNumber.length() == 0 || cellphoneNumber.length() == 0 || gender.length() == 0) {
//            response.sendRedirect("/restaurant_cafe/registerForm.jsp");

        if (id.length() == 0 || name.length() == 0 || course.length() == 0 || mail.length() == 0 || phoneNumber.length() == 0 || cellphoneNumber.length() == 0 || gender.length() == 0
        		|| year.length() == 0 || month.length() == 0 || day.length() == 0 || time.length() == 0 || minutes.length() == 0) {
            response.sendRedirect("/restaurant_cafe/registerForm.jsp");

        } else {
//          List<ResBean> list = ResList.getInstance(id, name, mail, mailForCheck, phoneNumber, cellphoneNumber,gender);
            List<ResBean> list = ResList.getInstance(id, name, course, mail, phoneNumber, cellphoneNumber, gender, year, month, day, time, minutes);
            HttpSession session = request.getSession(true);
            session.setAttribute("list", list);
            response.sendRedirect("/restaurant_cafe/registerForm.jsp");
        }
    }
}
