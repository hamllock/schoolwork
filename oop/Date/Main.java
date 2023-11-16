package oop.Date;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidYearException, InvalidMonthException, InvalidDayException {
        Scanner sc = new Scanner(System.in);
        int year = 0, month = 0, day = 0;

        try {
            year = sc.nextInt();
            if (year < 1) {
                throw new InvalidYearException("Invalid year input");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid year input");
            return;
        }

        try {
            month = sc.nextInt();
            if (month < 1 || month > 12) {
                throw new InvalidMonthException("Invalid number of months");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid month input");
            return;
        } catch (InvalidMonthException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            day = sc.nextInt();
            if (day < 1 || day > 31) {
                throw new InvalidDayException("Invalid number of days");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid day input");
            return;
        } catch (InvalidDayException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            Date date = new Date(year, day, month);
            System.out.println(date.toString());
        } catch (InvalidDayException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static class Date {
        private int year;
        private int date;
        private int month;

        public Date(int year, int date, int month) throws InvalidDayException {
            this.year = year;
            this.date = date;
            this.month = month;

            if (month == 2) {
                if (isLeapYear() && date > 29 || !isLeapYear() && date > 28) {
                    throw new InvalidDayException("Invalid number of days");
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (date > 30) {
                    throw new InvalidDayException("Invalid number of days");
                }
            } else if (date > 31) {
                throw new InvalidDayException("Invalid number of days");
            }
        }

        public String printDate() {
            String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                    "October", "November", "December" };

            return months[this.month - 1] + " " + this.date + ", " + this.year;
        }

        public String dateCount() {
            int count;

            switch (this.month) {
                case 2:
                    if (this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0) {
                        count = 29;
                    } else {
                        count = 28;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    count = 30;
                    break;
                default:
                    count = 31;
            }

            return count + (count == 1 ? " day" : " days");
        }

        public boolean isLeapYear() {
            return this.year % 4 == 0 && this.year % 100 != 0 || this.year % 400 == 0;
        }

        public String toString() {
            return printDate() + "\n" + dateCount() + "\n"
                    + (isLeapYear() ? this.year + " is a Leap Year" : this.year + " is a Common Year");
        }
    }

    public static class InvalidYearException extends Exception {
        public InvalidYearException(String message) {
            super(message);
        }
    }

    public static class InvalidMonthException extends Exception {
        public InvalidMonthException(String message) {
            super(message);
        }
    }

    public static class InvalidDayException extends Exception {
        public InvalidDayException(String message) {
            super(message);
        }
    }
}