import ra.business.entity.Department;
import java.util.Scanner;

public class DepartmentManagement {
    static Scanner scanner = new Scanner(System.in);

    public static void departmentManagementMenu() {
        while (true) {
            System.out.println("===============MENU===============\n" +
                    "1. Hiển thị tất cả department\n" +
                    "2. Thêm mới department\n" +
                    "3. Sửa thông tin department\n" +
                    "4. Thay đổi trạng thái department\n" +
                    "5. Tìm kiếm phòng ban theo tên\n" +
                    "6. Quay lại\n" +
                    "==================================\n" +
                    "Vui lòng lựa chọn: \n");
            byte choice = scanner.nextByte();
            switch (choice) {
                case 1:
                    displayAllDepartments();
                    break;
                case 2:
                    addNewDepartment();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    changeDepartmentStatus();
                    break;
                case 5:
                    searchDepartmentByName();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void displayAllDepartments() {
        System.out.println("Danh sách các phòng ban:");
        for (Department department : Menu.departementList) {
            System.out.println(department);
        }
    }

    private static void addNewDepartment() {
        System.out.println("Nhập tên phòng ban mới:");
        String name = scanner.nextLine();
        // Kiểm tra xem phòng ban đã tồn tại chưa
        if (nameExists(name)) {
            System.out.println("Phòng ban đã tồn tại.");
            return;
        }
        // Tạo mới đối tượng Department và thêm vào danh sách
        Department newDepartment = new Department(name);
        Menu.departementList.add(newDepartment);
        System.out.println("Thêm mới phòng ban thành công.");
    }

    private static void updateDepartment() {
        System.out.println("Nhập ID của phòng ban cần cập nhật:");
        int id = scanner.nextInt();
        // Tìm kiếm phòng ban theo ID
        Department department = findDepartmentById(id);
        if (department == null) {
            System.out.println("Không tìm thấy phòng ban với ID đã nhập.");
            return;
        }
        System.out.println("Nhập tên mới cho phòng ban:");
        String newName = scanner.nextLine();
        department.setName(newName);
        System.out.println("Cập nhật thông tin phòng ban thành công.");
    }

    private static void changeDepartmentStatus() {
        System.out.println("Nhập ID của phòng ban cần thay đổi trạng thái:");
        int id = scanner.nextInt();
        // Tìm kiếm phòng ban theo ID
        Department department = findDepartmentById(id);
        if (department == null) {
            System.out.println("Không tìm thấy phòng ban với ID đã nhập.");
            return;
        }
        // Thay đổi trạng thái phòng ban
        department.setActive(!department.isActive());
        System.out.println("Thay đổi trạng thái phòng ban thành công.");
    }

    private static void searchDepartmentByName() {
        System.out.println("Nhập tên phòng ban cần tìm kiếm:");
        String name = scanner.nextLine();
        // Tìm kiếm phòng ban theo tên
        List<Department> foundDepartments = findDepartmentsByName(name);
        if (foundDepartments.isEmpty()) {
            System.out.println("Không tìm thấy phòng ban nào với tên đã nhập.");
            return;
        }
        System.out.println("Danh sách phòng ban tìm kiếm:");
        for (Department department : foundDepartments) {
            System.out.println(department);
        }
    }

    // Các phương thức phụ trợ

    private static boolean nameExists(String name) {
        // Kiểm tra xem phòng ban có tồn tại trong danh sách không
        for (Department department : Menu.departementList) {
            if (department.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private static Department findDepartmentById(int id) {
        // Tìm kiếm phòng ban theo ID
        for (Department department : Menu.departementList) {
            if (department.getId() == id) {
                return department;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    private static List<Department> findDepartmentsByName(String name) {
        List<Department> foundDepartments = new ArrayList<>();
        // Tìm kiếm phòng ban theo tên
        for (Department department : Menu.departementList) {
            if (department.getName().equalsIgnoreCase(name)) {
                foundDepartments.add(department);
            }
        }
        return foundDepartments;
    }
}
