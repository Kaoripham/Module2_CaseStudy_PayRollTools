package AP0_Module2_Case_PayRoll;

import java.util.Calendar;

public class WorkDay {
    public static int lastday;

    public static int lastDay(int nam, int thang) {

        switch (thang) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                lastday = 31;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                lastday = 30;
                break;

            case 2: {
                if ((nam % 4 == 0) && !((nam % 100 == 0) && (nam % 400 != 0)))
                    lastday = 29;
                else lastday = 28;
                break;

            }
            default:
                break;
        }
        return lastday;
    }

    public static String getDayOfWeek(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return daysOfWeek[dayOfWeek - 1];
    }

       public static int noOfWorkingDay(int year, int month){
        int workDayOfMonth = 20;
        for(int day = 29; day <= lastDay(year, month); day++){
            if ((getDayOfWeek(year, month, day).compareTo ("Saturday") != 0) && (getDayOfWeek(year, month, day).compareTo ("Sunday") != 0))
            {
                workDayOfMonth +=1;
            }
        } return workDayOfMonth;

    }


}
