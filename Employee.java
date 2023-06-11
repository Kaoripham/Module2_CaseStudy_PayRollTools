package AP0_Module2_Case_PayRoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {
    private int id;
    static int countID = 1;
    private String name;
    private String identityNumber;
    private String dateOfBirth;
    private String joiningDate;
    private String position;
    //private String ;
    private int dependents;
    private double basicSalary;

    public Employee() {

    }

    public Employee(String name, String identityNumber, String dateOfBirth,
                    String joiningDate, String position, int dependents, double basicSalary) {
        this.id = countID++;
        this.name = name;
        this.identityNumber = identityNumber;
        this.dateOfBirth = dateOfBirth;
        this.joiningDate = joiningDate;
        this.position = position;
        this.dependents = dependents;
        this.basicSalary = basicSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getRole() {
        return position;
    }

    public void setRole(String position) {
        this.position = position;
    }

    public int getDependents() {
        return dependents;
    }

    public void setDependents(int dependents) {
        this.dependents = dependents;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }


    static List<Employee> employees = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public Employee createEmployee() {
        System.out.println("Nhập tên nhân viên: ");
        String name = sc.nextLine();
        System.out.println("Nhập số CMND: ");
        String identityNumber = sc.nextLine();
        System.out.println("Nhập ngày sinh: ");
        String dateOfBirth = sc.nextLine();
        System.out.println("Nhập ngày bắt đầu làm việc: ");
        String joiningDate = sc.nextLine();
        System.out.println("Nhập vị trí : ");
        String position = sc.nextLine();
        System.out.println("Nhập số người phụ thuộc: ");
        int dependents = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập Lương cơ bản");
        double basicSalary = Integer.parseInt(sc.nextLine());

        return new Employee(name, identityNumber, dateOfBirth, joiningDate, position,
                dependents, basicSalary);

    }

    public void addEmployee() {
        Employee employee = createEmployee();
        employees.add(employee);
        System.out.println(employee);
    }

    public void editEmployee(int id) {
        int em_Index = findEmployIndexByID(id);
        if (em_Index != -1) {
            Employee employee = createEmployee();
            employee.setId(id);
            employees.set(em_Index, employee);
        } else {
            System.out.println("Ko Ton tai NV can tim. ");
        }
    }

    public void deleteEmployee(int id) {
        int em_Index = findEmployIndexByID(id);
        if (em_Index != -1) {
            employees.remove(em_Index);
        } else {
            System.out.println("Không tồn tại NV cần tìm");
        }

    }
    public void showEmployee(){
        for(Employee em: employees){
            System.out.println(em.toString());
        }
    }

    public static int findEmployIndexByID(int id) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return
                "id= " + id +
                ", name= " + name +
                ", identityNumber= " + identityNumber +
                ", dateOfBirth= " + dateOfBirth +
                ", joiningDate= " + joiningDate +
                ", role= " + position +
                ", dependents=" + dependents +
                ", basicSalary=" + basicSalary ;
    }
}






