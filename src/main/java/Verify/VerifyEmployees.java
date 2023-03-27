package Verify;

import DAO.DepartmentDao;
import DAO.EmployeeDao;
import Model.Departments;
import Model.Employees;

import java.util.List;

public class VerifyEmployees {
    private static final EmployeeDao employeeDAO = new EmployeeDao();
    private static final DepartmentDao departmentDAO = new DepartmentDao();
    private static final List<Departments> departmentList = departmentDAO.getAll();
    private static final List<Employees> employeeList = employeeDAO.getAll();
    public static boolean isCheckIdEmp(int id){
        for (Employees empId : employeeList){
            if (empId.getEmployee_id() == id){
                return true;
            }
        }
        return false;
    }
    public boolean isCheckGender(String gender){
        if (gender.equalsIgnoreCase("Nam")
                || gender.equalsIgnoreCase("Nữ")
                || gender.equalsIgnoreCase("Khác")){
            return true;
        }
        return false;
    }
    public static boolean isCheckIdDep(int id){
        for (Departments depId : departmentList){
            if (depId.getDepartment_id() == id){
                return true;
            }
        }
        return false;
    }
    public boolean isCheckManagerId(int id){
        for (Departments managerId : departmentList){
            if (managerId.getManager_id() == id){
                return true;
            }
        }
        return false;
    }
    public static boolean isCheckManagement(int employeeID, int deparmentId){
        Departments department = departmentDAO.getById(deparmentId);
        for (int i = 0; i<departmentList.size(); i++){
            if (department.getManager_id() != 0 && department.getManager_id() == employeeID){
                return true;
            }
        }
        return false;
    }
}
