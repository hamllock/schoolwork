package ProjExer11;

public class Subject {

    private String subjCode;
    private int credUnits;

    public Subject(String s, int c) {
        this.subjCode = s;
        this.credUnits = c;
    }

    public String getCode() {
        return subjCode;
    }

    public int getUnits() {
        return credUnits;
    }
}
