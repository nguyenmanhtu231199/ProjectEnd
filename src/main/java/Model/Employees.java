package Model;

public class Employees {
    private int employee_id;
    private String full_name;
    private String born;
    private String email;
    private String phone_number;
    private String address;
    private Double salary;
    private int gender;
    private String hire_date;
    private String position;
    private int department_id;

    public Employees() {
    }

    public Employees(int employee_id, String full_name, String born, String email,
                     String phone_number, String address, Double salary, int gender, String hire_date,
                     String position, int department_id) {
        this.employee_id = employee_id;
        this.full_name = full_name;
        this.born = born;
        this.email = email;
        this.phone_number = phone_number;
        this.address = address;
        this.salary = salary;
        this.gender = gender;
        this.hire_date = hire_date;
        this.position = position;
        this.department_id = department_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getHire_date() {
        return hire_date;
    }

    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
    @Override
    public String toString() {
        return "Employees{" +
                "employee_id=" + employee_id +
                ", full_name='" + full_name + '\'' +
                ", born='" + born + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                ", hire_date='" + hire_date + '\'' +
                ", position='" + position + '\'' +
                ", department_id=" + department_id +
                '}';
    }
}
