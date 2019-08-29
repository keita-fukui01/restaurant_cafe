package restaurant_cafe02;

import java.util.ArrayList;

import restaurant_cafe.bean.ResBean;

public class ResList {
    private static ArrayList<ResBean> instance;

    private ResList(){};

    public static synchronized ArrayList<ResBean>
//                                 getInstance(String id, String name, String mail, String mailForCheck,
//                                		 String phoneNumber, String cellphoneNumber, String gender) {
                                   getInstance(String id, String name, String course, String mail, String phoneNumber, String cellphoneNumber, String gender,
                                		   String year, String month, String day, String time, String minutes) {

        if(instance == null) {
            instance = new ArrayList<ResBean>();
        }

//      String time =Time.getNow();
        ResBean res = new ResBean();
        res.setTime(time);
        res.setId(id);
        res.setName(name);
        res.setCourse(course);
        res.setMail(mail);
//      res.setMailForCheck(mailForCheck);
        res.setPhoneNumber(phoneNumber);
        res.setCellphoneNumber(cellphoneNumber);
        res.setGender(gender);
        res.setYear(year);
        res.setMonth(month);
        res.setDay(day);
        res.setTime(time);
        res.setMinutes(minutes);
       // res.setTitle(title);
       // res.setContents(contents);
        instance.add(res);
        return instance;
    }
}
