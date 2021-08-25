package Model;

public class Person {
    protected String employee_name;
    protected String employee_gender;
    protected String employee_gmail;

    public Person(String employee_name, String employee_gender, String employee_gmail) {
        this.employee_name = employee_name;
        this.employee_gender = employee_gender;
        this.employee_gmail = employee_gmail;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_gender() {
        return employee_gender;
    }

    public void setEmployee_gender(String employee_gender) {
        this.employee_gender = employee_gender;
    }

    public String getEmployee_gmail() {
        return employee_gmail;
    }

    public void setEmployee_gmail(String employee_gmail) {
        this.employee_gmail = employee_gmail;
    }
}
