package PersonExer3;

public class Student extends Person{
    private int idNumber;
    private int year;
    
    public Student(String name, String address, int idNumber, int year) {
        super(name, address);
        this.idNumber = idNumber;
        this.year = year;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return super.toString() + " with ID number " + getIdNumber() + " of year level " + getYear();
    }
}
