package AP0_Module2_Case_PayRoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeRecord {
    private int idTR;
    private int year;
    public int month;
    private int leaveHour;
    private int nomalOTHour;
    private int holidayOTHour;

    public TimeRecord() {
    }

    public TimeRecord(int idTR, int year, int month, int leaveHour, int nomalOTHour, int holidayOTHour) {
        this.idTR = idTR;
        this.year = year;
        this.month = month;
        this.leaveHour = leaveHour;
        this.nomalOTHour = nomalOTHour;
        this.holidayOTHour = holidayOTHour;
    }


    public int getIdTR() {
        return idTR;
    }

    public void setIdTR(int idTR) {
        this.idTR = idTR;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getLeaveHour() {
        return leaveHour;
    }

    public void setLeaveHour(int leaveHour) {
        this.leaveHour = leaveHour;
    }

    public int getNomalOTHour() {
        return nomalOTHour;
    }

    public void setNomalOTHour(int nomalOTHour) {
        this.nomalOTHour = nomalOTHour;
    }

    public int getHolidayOTHour() {
        return holidayOTHour;
    }

    public void setHolidayOTHour(int holidayOTHour) {
        this.holidayOTHour = holidayOTHour;
    }

   static List<TimeRecord> timeRecords = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public TimeRecord createTR() {
        System.out.println("Nhập Id nhân viên");
        int idTR = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập năm");
        int year = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tháng");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số giờ nghỉ trong tháng: ");
        int leaveHour = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số giờ làm thêm OT nomal : ");
        int nomalOTHour = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số giờ làm thêm nghày nghỉ OT holiday: ");
        int holidayOTHour = Integer.parseInt(sc.nextLine());
        return new TimeRecord(idTR, year, month, leaveHour, nomalOTHour, holidayOTHour);
    }


    public void addTimeRecord() {
        TimeRecord timeRecord = createTR();
        timeRecords.add(timeRecord);
        // System.out.println(timeRecord);
    }

    public void editTimeRecord(int id) {
        int tr_index = findTRIndexById(id);

        if (tr_index != -1) {
            TimeRecord timeRecord = createTR();
            timeRecord.setIdTR(timeRecords.get(tr_index).getIdTR());
            timeRecords.set(tr_index, timeRecord);
            // System.out.println(timeRecord);
        } else {
            System.out.println("Khong ton tai NV muon sua. ");
        }
    }

    public static int findTRIndexById(int idt) {
        for (int j = 0; j < timeRecords.size(); j++) {
            if (timeRecords.get(j).getIdTR() == idt) {
                return j;
            }
        }
        return -1;
    }




    @Override
    public String toString() {
        return "TimeRecord{" +
                "idTR=" + idTR +
                ", year=" + year +
                ", month=" + month +
                ", leaveHour=" + leaveHour +
                ", nomalOTHour=" + nomalOTHour +
                ", holidayOTHour=" + holidayOTHour +

                            '}';
    }
}



