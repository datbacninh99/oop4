package ra.business.presentation;

import ra.business.entity.Department;
import ra.business.entity.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ra.business.presentation.DepartmentManagement.departmentManagementMenu;

public class Menu {
    public static List<Department> departementList = new ArrayList<>();
    public static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee(0, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
        employeeList.add(new Employee(1, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
        employeeList.add(new Employee(2, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
        employeeList.add(new Employee(3, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
        employeeList.add(new Employee(4, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
        employeeList.add(new Employee(5, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
        employeeList.add(new Employee(6, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
        employeeList.add(new Employee(7, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
        employeeList.add(new Employee(8, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
        employeeList.add(new Employee(9, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
        employeeList.add(new Employee(10, "Đạt", "Bắc Ninh", "0365981802", LocalDate.of(2002, 8, 1), null, true));
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("===============MENU===============\n" +
                    "1. Quản lý department\n" +
                    "2. Quản lý employee\n" +
                    "3. Thoát\n" +
                    "==================================\n" +
                    "Vui lòng lựa chọn: \n");
        }
        byte choice = scanner.nextByte();
        switch (choice) {
            case 1:
                departmentManagementMenu();
                break;
            case 2:
                employeeManagementMenu();
                break;
            case 3:
                System.out.println("Thoát chương trình.");
                return;
            default:
                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
        }
    }
}