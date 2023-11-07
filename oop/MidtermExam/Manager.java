package MidtermExam;

public class Manager extends Employee {

    private double salary;

    public Manager(String name, String barName, double salary) {
        super(name, barName);
        this.salary = salary;
    }

    @Override
    public String employeeTask() {
        throw new UnsupportedOperationException("Unimplemented method 'employeeTask'");
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

}
