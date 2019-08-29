package restaurant_cafe.util;

import java.util.Calendar;

public class Time {

	public static String getNow() {

        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        int dayOfWeekInteger = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        String[] dayOfWeek = {"日", "月", "火", "水", "木", "金", "土"};

        String now = year + "/" + month + "/" + date
                 + "日(" + dayOfWeek[dayOfWeekInteger] + ")"
                 + hour + ":" + minute + ":" + second;

        return now;
    }
}

