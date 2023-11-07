package MidtermExam;

import java.util.ArrayList;

public class Waiter extends Employee {

    private ArrayList<Integer> tableNumber = new ArrayList<>();
    private ArrayList<Double> tip = new ArrayList<>();
    private double salary;

    public Waiter(String name, String barName, ArrayList<Integer> tableNumber, ArrayList<Double> tip, double salary) {
        super(name, barName);
        this.tableNumber = tableNumber;
        this.tip = tip;
        this.salary = salary;
    }

    public ArrayList<Integer> getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(ArrayList<Integer> tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public String employeeTask() {
        StringBuilder tables = new StringBuilder();
        int index = 0;
        for (int d : getTableNumber()) {
            tables.append(d);
            if (index < getTableNumber().size() - 1) {
                tables.append(", ");
            }
            index++;
        }
        return tables.toString();
    }

    public double getSalary() {
        for (Double d : getTip()) {
            salary += d;
        }
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<Double> getTip() {
        return tip;
    }

    public void setTip(ArrayList<Double> tip) {
        this.tip = tip;
    }
}
