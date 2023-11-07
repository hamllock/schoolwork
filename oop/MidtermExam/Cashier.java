package MidtermExam;

public class Cashier extends Employee {
    private double salary;

    public Cashier(String name, String barName, double salary) {
        super(name, barName);
        this.salary = salary;
    }

    @Override
    public String employeeTask() {
        // TODO Auto-generated method stub
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
