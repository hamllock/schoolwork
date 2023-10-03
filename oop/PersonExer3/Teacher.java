package PersonExer3;

public class Teacher extends Person{
    private String department;

    public Teacher(String name, String address, String department) {
        super(name, address);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String toString() {
        return super.toString() + " of department " + this.getDepartment();
    }
}
