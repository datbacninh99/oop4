package ra.business.design;

import ra.business.entity.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDesign {
    private Map<Integer, Employee> employeeMap;

    public EmployeeDesign() {
        this.employeeMap = new HashMap<>();
    }

    // Hiển thị tất cả nhân viên (phân trang)
    public List<Employee> findAllEmployees(int pageNumber, int pageSize) {
        int startIndex = (pageNumber - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, employeeMap.size());
        return new ArrayList<>(employeeMap.values()).subList(startIndex, endIndex);
    }

    // Thêm mới nhân viên
    public void addEmployee(Employee employee) {
        int id = employee.getEmployeeId();
        if (!employeeMap.containsKey(id)) {
            employeeMap.put(id, employee);
        }
    }

    // Sửa thông tin nhân viên
    public void updateEmployee(Employee employee) {
        int id = employee.getEmployeeId();
        if (employeeMap.containsKey(id)) {
            employeeMap.put(id, employee);
        }
    }

    // Thay đổi trạng thái nhân viên
    public void changeEmployeeStatus(int employeeId, boolean newStatus) {
        Employee employee = employeeMap.get(employeeId);
        if (employee != null) {
            employee.setEmployeeStatus(newStatus);
        }
    }

    // Danh sách nhân viên theo phòng ban
    public List<Employee> findEmployeesByDepartment(int departmentId) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeMap.values()) {
            if (employee.getDepartment() != null && employee.getDepartment().getDepartmentId() == departmentId) {
                result.add(employee);
            }
        }
        return result;
    }

    // Sắp xếp nhân viên theo tên tăng dần
    public List<Employee> sortEmployeesByNameAsc() {
        List<Employee> sortedEmployees = new ArrayList<>(employeeMap.values());
        sortedEmployees.sort((e1, e2) -> e1.getFullName().compareToIgnoreCase(e2.getFullName()));
        return sortedEmployees;
    }

    // Tìm kiếm nhân viên theo ID
    public Employee findEmployeeById(int employeeId) {
        return employeeMap.get(employeeId);
    }
}