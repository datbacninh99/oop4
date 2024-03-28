package ra.business.entity;

import java.util.Scanner;

public class Department {
    private static int id = 1;
    private int departmentId;
    private String name;
    private int numberEmployee;
    private boolean departmentStatus;

    public Department() {
        this.departmentId = id++;
        this.departmentStatus = true;
        this.numberEmployee = 0;
    }

    public Department(int departmentId, String name, int numberEmployee, boolean departmentStatus) {
        this.departmentId = departmentId;
        this.name = name;
        this.numberEmployee = numberEmployee;
        this.departmentStatus = departmentStatus;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(int numberEmployee) {
        this.numberEmployee = numberEmployee;
    }

    public boolean isDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(boolean departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên phòng ban:");
        String inputName = scanner.nextLine().trim();
        while (inputName.isEmpty() || nameExists(inputName)) {
            System.out.println("Tên phòng ban không được để trống và không được trùng lặp, vui lòng nhập lại:");
            inputName = scanner.nextLine().trim();
        }
        this.name = inputName;
    }

    public void displayData() {
        System.out.println("ID phòng ban: " + this.departmentId);
        System.out.println("Tên: " + this.name);
        System.out.println("Số lượng nhân viên: " + this.numberEmployee);
        System.out.println("Trạng thái: " + (this.departmentStatus ? "Hoạt động" : "Ngưng hoạt động"));
    }

    private boolean nameExists(String inputName) {
        return false;
    }
}