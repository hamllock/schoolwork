package MidtermExam;

public abstract class Employee {
    private String name;
    private final String barName;

    public abstract String employeeTask();

    public abstract void setSalary(double salary);

    public Employee(String name, String barName) {
        this.name = name;
        this.barName = barName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarName() {
        return barName;
    }
}
