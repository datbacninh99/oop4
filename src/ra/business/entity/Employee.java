package ra.business.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Employee {
    private int employeeId;
    private String fullName;
    private String address;
    private String phone;
    private LocalDate dateOfBirth;
    private Department department;
    private boolean employeeStatus;

    public Employee() {
        this.employeeStatus = true;
    }

    public Employee(int employeeId, String fullName, String address, String phone, LocalDate dateOfBirth, Department department, boolean employeeStatus) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.employeeStatus = employeeStatus;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ và tên:");
        this.setFullName(scanner.nextLine().trim());
        System.out.println("Nhập địa chỉ:");
        this.setAddress(scanner.nextLine().trim());
        boolean validPhone = false;
        while (!validPhone) {
            System.out.println("Nhập số điện thoại (theo định dạng số điện thoại Việt Nam):");
            String inputPhone = scanner.nextLine().trim();
            if (inputPhone.matches("((\\+84)|(0))[0-9]{9}")) {
                this.setPhone(inputPhone);
                validPhone = true;
            } else {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại.");
            }
        }
        System.out.println("Nhập ngày sinh (theo định dạng dd-MM-yyyy):");
        String dobString = scanner.nextLine().trim();
        this.setDateOfBirth(LocalDate.parse(dobString, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    public void displayData() {
        System.out.println("ID nhân viên: " + this.employeeId);
        System.out.println("Họ và tên: " + this.fullName);
        System.out.println("Địa chỉ: " + this.address);
        System.out.println("Số điện thoại: " + this.phone);
        System.out.println("Ngày sinh: " + this.dateOfBirth.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        System.out.println("Phòng ban: " + (this.department != null ? this.department.getName() : "Chưa có"));
        System.out.println("Trạng thái: " + (this.employeeStatus ? "Hoạt động" : "Ngưng hoạt động"));
    }
}