package ra.business.design;

import ra.business.entity.Department;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDesign {
    private Map<Integer, Department> departmentMap;

    public DepartmentDesign() {
        this.departmentMap = new HashMap<>();
    }

    // Hiển thị tất cả phòng ban
    public List<Department> findAllDepartments() {
        return new ArrayList<>(departmentMap.values());
    }

    // Thêm mới phòng ban
    public void addDepartment(Department department) {
        int id = department.getDepartmentId();
        if (!departmentMap.containsKey(id)) {
            departmentMap.put(id, department);
        }
    }

    // Sửa thông tin phòng ban
    public void updateDepartment(Department department) {
        int id = department.getDepartmentId();
        if (departmentMap.containsKey(id)) {
            departmentMap.put(id, department);
        }
    }

    // Tìm kiếm phòng ban theo tên
    public List<Department> findDepartmentsByName(String name) {
        List<Department> result = new ArrayList<>();
        for (Department department : departmentMap.values()) {
            if (department.getName().equalsIgnoreCase(name)) {
                result.add(department);
            }
        }
        return result;
    }

    // Thay đổi trạng thái phòng ban
    public void changeDepartmentStatus(int departmentId, boolean newStatus) {
        Department department = departmentMap.get(departmentId);
        if (department != null) {
            department.setDepartmentStatus(newStatus);
        }
    }

    // Tìm kiếm phòng ban theo ID
    public Department findDepartmentById(int departmentId) {
        return departmentMap.get(departmentId);
    }

    // Lưu thông tin phòng ban
    public void save(Department department) {
        int id = department.getDepartmentId();
        departmentMap.put(id, department);
    }
}