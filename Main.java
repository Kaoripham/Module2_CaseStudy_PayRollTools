package AP0_Module2_Case_PayRoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static AP0_Module2_Case_PayRoll.Employee.employees;
import static AP0_Module2_Case_PayRoll.TimeRecord.timeRecords;

public class Main {

    public static void main(String[] args) {


        Authentication authentication = new Authentication();
        Employee employee = new Employee();
        TimeRecord timeRecord = new TimeRecord();

        Scanner sc = new Scanner(System.in);

Employee employee1 = new Employee("Nguyen AAA", "123456", "1/1/1990", "1/1/2000", "Manager", 1, 40000000);
Employee employee2 = new Employee("Nguyen BBB", "223456", "1/1/1991", "2/1/2000", "Staff Senior", 1, 30000000);
Employee employee3 = new Employee("Nguyen CCC", "323456", "1/1/1992", "3/1/2000", "Staff", 1, 25000000);
Employee employee4 = new Employee("Nguyen DDD", "423456", "1/1/1993","4/1/2000", "Staff", 1, 20000000);
Employee employee5 = new Employee("Nguyen EEE", "523456", "1/1/1994", "5/1/2000", "Staff", 1, 18000000);
employees.add(employee1)   ;
employees.add(employee2)   ;
employees.add(employee3)   ;
employees.add(employee4)   ;
employees.add(employee5)   ;


TimeRecord timeRecord1 = new TimeRecord(1, 2023, 6, 6, 10,0);
TimeRecord timeRecord2 = new TimeRecord(3, 2023, 6,10, 10,10);
TimeRecord timeRecord3 = new TimeRecord(2, 2023, 6,5, 5,5);
TimeRecord timeRecord4 = new TimeRecord(4, 2023, 6, 0, 0,0);
TimeRecord timeRecord5 = new TimeRecord(5, 2023, 6, 40, 0,0);
 timeRecords.add(timeRecord1);
 timeRecords.add(timeRecord2);
 timeRecords.add(timeRecord3);
 timeRecords.add(timeRecord4);
 timeRecords.add(timeRecord5);



        System.out.println("Nhập username: ");
        String user = sc.nextLine();
        System.out.println("Nhập password: ");
        String password = sc.nextLine();
        // authentication.addUser(user,password,false);
        User user1 = authentication.login(user, password, false);
        if (user1 != null) {
            if (user1.isAdmin()) {
                while (true) {
                    System.out.println("---");
                    System.out.println("Quản lý Lương Nhân viên");
                    System.out.println("1. Thêm Nhân viên");
                    System.out.println("10. Record thời gian làm việc");
                    System.out.println("2. Sửa thông tin nhân viên");
                    System.out.println("3. Xóa thông tin nhân viên");
                    System.out.println("4. Hiển thị danh sách nhân viên");
                    System.out.println("5. Hiển thị bảng lương");
                    System.out.println("6. Thoát");
                    int choice = Integer.parseInt(sc.nextLine());
                    switch (choice) {
                        case 1:
                            employee.addEmployee();
                            break;

                        case 2:
                            System.out.println("Nhập Id của nhân viên muốn sửa: ");
                            int idEdit = Integer.parseInt(sc.nextLine());
                            employee.editEmployee(idEdit);
                            break;
                        case 3:
                            System.out.println("Nhập Id của nhân viên muốn xóa: ");
                            int idDelete = Integer.parseInt(sc.nextLine());
                            employee.deleteEmployee(idDelete);
                            break;
                        case 4:
                            System.out.println("Danh sách nhân viên: ");
                            employee.showEmployee();
                            break;
                        case 5:
                            System.out.println("Nhập id của nhân viên đầu: ");
                            int ids1 = Integer.parseInt(sc.nextLine());
                            System.out.println("Nhập id của nhân viên cuối: ");
                            int ids2 = Integer.parseInt(sc.nextLine());
                            System.out.println("Nhập năm:");
                            int year = Integer.parseInt(sc.nextLine());
                            System.out.println("Nhập tháng:");
                            int month = Integer.parseInt(sc.nextLine());
for (int j=ids1; j<=ids2; j++) {
    int workHoursOfMonth = 8 * WorkDay.noOfWorkingDay(year, month);
    int em_index = Employee.findEmployIndexByID(j);
    String name = employees.get(em_index).getName();
    int dependents = employees.get(em_index).getDependents();
    double basicSalary = employees.get(em_index).getBasicSalary();

    int leaveHour = 0;
    int nomalOTHour = 0;
    int holidayOTHour = 0;

    int tr_index = TimeRecord.findTRIndexById(j);
    if ((timeRecords.get(tr_index).getYear() == year) && (timeRecords.get(tr_index).getMonth() == month)) {
        leaveHour = timeRecords.get(tr_index).getLeaveHour();
        nomalOTHour = timeRecords.get(tr_index).getNomalOTHour();
        holidayOTHour = timeRecords.get(tr_index).getHolidayOTHour();

    }

    int salaryPerHour = (int) (basicSalary / workHoursOfMonth);
    int leaveDeduct = leaveHour * salaryPerHour;
    int otSalary = (int) (salaryPerHour * 1.5 * nomalOTHour + salaryPerHour * 2 * holidayOTHour);
    int grossSalary = (int) (basicSalary - leaveDeduct + otSalary);
    int insurance = (int) (basicSalary * 0.105);
    int preTaxSalary = grossSalary - insurance;
    int taxAbleSalary = preTaxSalary - 11000000 - 4400000 * dependents;
    int taxPIT = (int) Calculate.canculatePIT(taxAbleSalary);
    int netSalary = grossSalary - insurance - taxPIT;

    System.out.println();
    System.out.println("----------------------");
    System.out.println("Bảng lương tháng: " +  + month + "/" + year );
    System.out.println("Số ngày làm việc: " + WorkDay.noOfWorkingDay(year, month) + " ngày/ " + "Số giờ tiêu chuẩn: " +workHoursOfMonth + " giờ");
    System.out.println("Id: " + j + "/ Ho ten: " + name +
            "\n"+"I.Lương cơ bản: " + basicSalary + " VND " +
            "  Lương làm thêm: " + otSalary +" VND" + "\n" +
            "II. Lương Gross: " +grossSalary+ " VND"+"\n" +"Các khoản Giảm trừ: " + "\n"+ "1. Nghỉ không lương: " + leaveDeduct +" VND"
            + " 2.Các loại BH phần do nhân viên đóng : " + insurance +" VND" + " 3. Thuế TNCN: " + taxPIT + " VND" +
            "\n"+ "III. Lương NET: " + netSalary + " VND "
    );
}
                            break;
                        case 6:
                            return;
                  }
                }
            } else {
                while (true) {
                    System.out.println("---");
                    System.out.println("TimeRecord:");
                    System.out.println("1. Nhập TimeRecord");
                    System.out.println("2. Sửa TimeRecord");
                    System.out.println("3. Thoát");
                    int choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1:
                            timeRecord.addTimeRecord();
                            break;
                        case 2:
                            System.out.println("Nhập Id của nhân viên muốn sửa: ");
                            int idEdit = Integer.parseInt(sc.nextLine());
                            timeRecord.editTimeRecord(idEdit);
                            break;

                        case 3:
                            return;

                    }

                }

            }
        }
    }
}
