package restaurant_cafe02;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import restaurant_cafe.util.PropertyLoader;

/**
 * Servlet implementation class Validator
 */
public class Validator extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String id = Encoder.encodeUTF8(request.getParameter("id"));
//		String name = Encoder.encodeUTF8(request.getParameter("name"));
//		String mail = Encoder.encodeUTF8(request.getParameter("mail"));
//		String mailForCheck = Encoder.encodeUTF8(request.getParameter("mailForCheck"));
//		String phoneNumber = Encoder.encodeUTF8(request.getParameter("phoneNumber"));
//		String cellphoneNumber = Encoder.encodeUTF8(request.getParameter("cellphoneNumber"));
//		String gender = Encoder.encodeUTF8(request.getParameter("gender"));

//	  String id = request.getParameter("id");
//	  String name = request.getParameter("name");
//      String mail = request.getParameter("mail");
//      String mailForCheck = request.getParameter("mailForCheck");
//      String phoneNumber = request.getParameter("phoneNumber");
//      String cellphoneNumber = request.getParameter("cellphoneNumber");
//      String gender = request.getParameter("gender");
//
//      //エラーメッセージ
////      String[] errorMessages = check1(id, name, mail, mailForCheck, phoneNumber, cellphoneNumber,gender);
//        String[] errorMessages = check(id, name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender);
//
//        boolean isError = false;
//        for (int i = 0; i < errorMessages.length; i++) {
//            if (errorMessages[i] != null) {
//                isError = true;
//                break;
//            }
//        }
//
//        if (isError) {
//            request.setAttribute("errorMessages", errorMessages);
//            String url = "/registerForm.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//            dispatcher.forward(request, response);
//        } else {
//            request.setAttribute("id", id);
//        	request.setAttribute("name", name);
//        	request.setAttribute("mail", mail);
//        	request.setAttribute("mailForCheck", mailForCheck);
//        	request.setAttribute("phoneNumber", phoneNumber);
//        	request.setAttribute("cellphoneNumber", cellphoneNumber);
//        	request.setAttribute("gender", gender);
//
//          String url = PropertyLoader.getProperty("url.servlet.ItemInsertion2");
//       //     String url = "/registerForm";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//            dispatcher.forward(request, response);
//        }

//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//        String mail = request.getParameter("mail");
//        String mailForCheck = request.getParameter("mailForCheck");
//        String phoneNumber = request.getParameter("phoneNumber");
//        String cellphoneNumber = request.getParameter("cellphoneNumber");
//        String gender = request.getParameter("gender");
//
//      //エラーメッセージ
//      String[] errorMessages = check(id, name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender);
// //       String[] errorMessages = check(name, mail, mailForCheck, phoneNumber, cellphoneNumber, gender);
//
//        boolean isError = false;
//        for (int i = 0; i < errorMessages.length; i++) {
//            if (errorMessages[i] != null) {
//                isError = true;
//                break;
//            }
//        }
//
//        if (isError) {
//            request.setAttribute("errorMessages", errorMessages);
//            String url = "/registerForm.jsp";
//            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//            dispatcher.forward(request, response);
//        } else {
//            request.setAttribute("id", id);
//        	request.setAttribute("name", name);
//        	request.setAttribute("mail", mail);
//        	request.setAttribute("mailForCheck", mailForCheck);
//        	request.setAttribute("phoneNumber", phoneNumber);
//        	request.setAttribute("cellphoneNumber", cellphoneNumber);
//        	request.setAttribute("gender", gender);
//
//          String url = PropertyLoader.getProperty("url.jsp.registerForm01");
//        //    String url = "/ItemInsertion2";
//        	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//            dispatcher.forward(request, response);
//        }
//    }
//
//		private String[] check(String id, String name, String mail, String mailForCheck,
//				String phoneNumber, String cellphoneNumber, String gender) {
//
//        String[] errorMessages = new String[10];
//
//        if (name.length() == 0) {
//            errorMessages[0] = "名前が入力されていません。";
//        }
//
//        if (mail.length() == 0) {
//            errorMessages[1] = "メールアドレスが入力されていません";
//        } else if (mail.equals(mailForCheck)) {
//            if (!isMatch(mail, "[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+")) {
//                errorMessages[1] = "正しいメールアドレスを入力してください。";
//            }
//        } else {
//            errorMessages[2] = "メールアドレスとメールアドレス（確認用）が異なります。";
//        }
//        if (mailForCheck.length() == 0) {
//            errorMessages[3] = "メールアドレス（確認用）が入力されていません。";
//        }
//
//        if (phoneNumber.length() == 0) {
//            errorMessages[4] = "電話番号が入力されていません。";
//        } else {
//            if (!(isMatch(phoneNumber, "\\d+\\-\\d+\\-\\d+") &&
//                                                    isMatch(phoneNumber, "\\S{12}"))) {
//                errorMessages[4] = "正しい電話番号を入力してください。" +
//                                    "xx-xxxx-xxxxのようにハイフンを含めて入力してください。";
//            }
//        }
//
//        if (cellphoneNumber.length() == 0) {
//            errorMessages[5] = "携帯電話番号が入力されていません。";
//        } else {
//            if (!isMatch(cellphoneNumber, "\\d{3}\\-\\d{4}\\-\\d{4}")) {
//                errorMessages[5] = "正しい携帯電話番号を入力してください。" +
//                                       "xxx-xxxx-xxxxのようにハイフンを含めて入力してください。";
//            }
//        }
//
//        if (gender == null) {
//            errorMessages[6] = "性別が選択されていません。";
//        }
//
//        return errorMessages;
//    }
//
//    private boolean isMatch(String input, String regex) {
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(input);
//        return m.matches();
//    }
//
//    private boolean isFind(String input, String regex) {
//        Pattern p = Pattern.compile(regex);
//        Matcher m = p.matcher(input);
//        return m.find();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		String id = Encoder.encodeUTF8(request.getParameter("id"));
//		String name = Encoder.encodeUTF8(request.getParameter("name"));
//		String mail = Encoder.encodeUTF8(request.getParameter("mail"));
//		String mailForCheck = Encoder.encodeUTF8(request.getParameter("mailForCheck"));
//		String phoneNumber = Encoder.encodeUTF8(request.getParameter("phoneNumber"));
//		String cellphoneNumber = Encoder.encodeUTF8(request.getParameter("cellphoneNumber"));
//		String gender = Encoder.encodeUTF8(request.getParameter("gender"));

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String course = request.getParameter("course");
        String mail = request.getParameter("mail");
//      String mailForCheck = request.getParameter("mailForCheck");
        String phoneNumber = request.getParameter("phoneNumber");
        String cellphoneNumber = request.getParameter("cellphoneNumber");
        String gender = request.getParameter("gender");
        String year = request.getParameter("year");
		String month = request.getParameter("month");
        String day = request.getParameter("day");
        String time = request.getParameter("time");
        String minutes = request.getParameter("minutes");

      //エラーメッセージ
      String[] errorMessages = check(id, name, course, mail, phoneNumber, cellphoneNumber, gender, year, month, day, time, minutes);


        boolean isError = false;
        for (int i = 0; i < errorMessages.length; i++) {
            if (errorMessages[i] != null) {
                isError = true;
                break;
            }
        }

        if (isError) {
            request.setAttribute("errorMessages", errorMessages);
            String url = "/registerForm.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("id", id);
        	request.setAttribute("name", name);
        	request.setAttribute("course", course);
        	request.setAttribute("mail", mail);
 //       	request.setAttribute("mailForCheck", mailForCheck);
        	request.setAttribute("phoneNumber", phoneNumber);
        	request.setAttribute("cellphoneNumber", cellphoneNumber);
        	request.setAttribute("gender", gender);
        	request.setAttribute("year", year);
        	request.setAttribute("month", month);
        	request.setAttribute("day", day);
        	request.setAttribute("time", time);
        	request.setAttribute("minutes", minutes);

          String url = PropertyLoader.getProperty("url.jsp.registerForm01");
          request.setAttribute("message", PropertyLoader.getProperty("message.registerForm01"));
      //    String url = "/ItemInsertion2";
        	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }

			private String[] check(String id, String name, String course, String mail,
					String phoneNumber, String cellphoneNumber, String gender, String year, String month, String day, String time, String minutes) {

        String[] errorMessages = new String[20];

        if (name.length() == 0) {
            errorMessages[0] = "名前が入力されていません。";
        }

        if (mail.length() == 0) {
            errorMessages[1] = "メールアドレスが入力されていません";
        }

        if (mail.length() == 0) {
            errorMessages[2] = "コースが選択されてません";
        }

//            else if (mail.equals(mailForCheck)) {
//            if (!isMatch(mail, "[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+")) {
//                errorMessages[1] = "正しいメールアドレスを入力してください。";
//            }
//        } else {
//            errorMessages[2] = "メールアドレスとメールアドレス（確認用）が異なります。";
//        }
//        if (mailForCheck.length() == 0) {
//            errorMessages[3] = "メールアドレス（確認用）が入力されていません。";

        if (phoneNumber.length() == 0) {
            errorMessages[3] = "電話番号が入力されていません。";
        } else {
            if (!(isMatch(phoneNumber, "\\d+\\-\\d+\\-\\d+") &&
                                                    isMatch(phoneNumber, "\\S{12}"))) {
                errorMessages[4] = "正しい電話番号を入力してください。" +
                                    "xx-xxxx-xxxxのようにハイフンを含めて入力してください。";
            }
        }

        if (cellphoneNumber.length() == 0) {
            errorMessages[5] = "携帯電話番号が入力されていません。";
        } else {
            if (!isMatch(cellphoneNumber, "\\d{3}\\-\\d{4}\\-\\d{4}")) {
                errorMessages[6] = "正しい携帯電話番号を入力してください。" +
                                       "xxx-xxxx-xxxxのようにハイフンを含めて入力してください。";
            }
        }

        if (gender == null) {
            errorMessages[7] = "性別が選択されていません";
        }

      	if (year == null) {
	            errorMessages[8] = "「年」が選択されていません";
	    }
      	if (month == null) {
            errorMessages[9] = "「月」が選択されていません";
        }
      	if (day == null) {
            errorMessages[10] = "「日」が選択されていません";
        }
      	if (time == null) {
            errorMessages[11] = "「時」が選択されていません";
        }
      	if (minutes == null) {
            errorMessages[12] = "「分」が選択されていません";
        }

	        return errorMessages;
	    }

    private boolean isMatch(String input, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }

 }

