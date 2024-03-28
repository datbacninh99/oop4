package ra.business.presentation;

import ra.business.entity.Employee;
import ra.business.entity.Department;

import java.util.Scanner;
import java.util.List;

public class EmployeeManagement {
    static Scanner scanner = new Scanner(System.in);

    public static void employeeManagementMenu() {
        while (true) {
            System.out.println("==========MENU==========\n" +
                    "1. Hiển thị tất cả employee\n" +
                    "2. Thêm mới employee\n" +
                    "3. Sửa thông tin employee\n" +
                    "4. Thay đổi trạng thái employee\n" +
                    "5. Tìm kiếm theo tên nhân viên\n" +
                    "6. Tìm kiếm nhân viên theo mã phòng ban\n" +
                    "7. Quay lại\n" +
                    "========================\n" +
                    "Vui lòng lựa chọn: \n");
            byte choice = scanner.nextByte();
            switch (choice) {
                case 1:
                    displayAllEmployees();
                    break;
                case 2:
                    addNewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    changeEmployeeStatus();
                    break;
                case 5:
                    searchEmployeeByName();
                    break;
                case 6:
                    searchEmployeeByDepartmentId();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void displayAllEmployees() {
        System.out.println("Danh sách tất cả nhân viên:");
        for (Employee employee : Menu.employeeList) {
            System.out.println(employee);
        }
    }

    private static void addNewEmployee() {
        System.out.println("Nhập thông tin cho nhân viên mới:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        System.out.print("Tên: ");
        String name = scanner.next();
        System.out.print("Địa chỉ: ");
        String address = scanner.next();
        System.out.print("Số điện thoại: ");
        String phoneNumber = scanner.next();
        System.out.print("Ngày sinh (yyyy-MM-dd): ");
        String dobString = scanner.next();
        LocalDate dob = LocalDate.parse(dobString);
        Employee newEmployee = new Employee(id, name, address, phoneNumber, dob, null, true);
        Menu.employeeList.add(newEmployee);
        System.out.println("Nhân viên mới đã được thêm vào danh sách.");
    }

    private static void updateEmployee() {
        System.out.println("Nhập ID của nhân viên cần cập nhật:");
        int id = scanner.nextInt();
        Employee employeeToUpdate = findEmployeeById(id);
        if (employeeToUpdate == null) {
            System.out.println("Không tìm thấy nhân viên với ID đã nhập.");
            return;
        }
        System.out.println("Nhập thông tin mới cho nhân viên:");
        System.out.print("Tên mới: ");
        String newName = scanner.next();
        employeeToUpdate.setName(newName);
        // Tương tự, bạn cần cập nhật các trường thông tin khác nếu cần
        System.out.println("Thông tin nhân viên đã được cập nhật.");
    }

    private static void changeEmployeeStatus() {
        System.out.println("Nhập ID của nhân viên cần thay đổi trạng thái:");
        int id = scanner.nextInt();
        Employee employeeToChangeStatus = findEmployeeById(id);
        if (employeeToChangeStatus == null) {
            System.out.println("Không tìm thấy nhân viên với ID đã nhập.");
            return;
        }
        System.out.println("Nhập trạng thái mới (true/false): ");
        boolean newStatus = scanner.nextBoolean();
        employeeToChangeStatus.setStatus(newStatus);
        System.out.println("Trạng thái của nhân viên đã được cập nhật.");
    }

    private static void searchEmployeeByName() {
        System.out.println("Nhập tên nhân viên cần tìm kiếm:");
        String name = scanner.next();
        boolean found = false;
        for (Employee employee : Menu.employeeList) {
            if (employee.getName().equals(name)) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy nhân viên với tên đã nhập.");
        }
    }

    private static void searchEmployeeByDepartmentId() {
        System.out.println("Nhập mã phòng ban cần tìm kiếm nhân viên:");
        int departmentId = scanner.nextInt();
        boolean found = false;
        for (Employee employee : Menu.employeeList) {
            if (employee.getDepartment() != null && employee.getDepartment().getId() == departmentId) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy nhân viên nào thuộc phòng ban có mã " + departmentId);
        }
    }

    private static Employee findEmployeeById(int id) {
        for (Employee employee : Menu.employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}