import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegularEmployee extends Employee{

    private double performanceScore;
    private double bonus;

    public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
                           String maritalStatus, String hasDriverLicense, double salary, Calendar hireDate, Department department,
                           double performanceScore) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate,
                department);
        if (performanceScore < 0) {
            throw new ArithmeticException("Performance Score cannot be negative!!!");
        }
        else {
            this.performanceScore = performanceScore;
        }
    }

    public RegularEmployee(Employee employee, double performanceScore) {
        super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicense(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
        if (performanceScore < 0) {
            throw new ArithmeticException("Performance Score cannot be negative!!!");
        }
        else {
            this.performanceScore = performanceScore;
        }
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {

        if (performanceScore < 0) {
            throw new ArithmeticException("Performance Score cannot be negative!!!");
        }
        else {
            this.performanceScore = performanceScore;
        }

    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if (bonus < 0) {
            throw new ArithmeticException("Bonus cannot be negative!!!");
        }
        else {
            this.bonus=bonus;
        }
    }



    public String toString() {

        Date date1 = this.getHireDate().getTime();

        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

        String hireDate = dateFormat1.format(date1);


        String x = "\tRegular Employee\n" + "\t\t\t    Person Info[id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", gender=" + this.getGender() + "]" +
                "\n\t\t\t    Employee Info [salary="+ this.getSalary() +", hireDate=" + hireDate + "]" +
                "\n\t\t\t    RegularEmployee Info [performanceScore=" + this.getPerformanceScore() + ", bonus=" + this.getBonus() + "]";




        return x;
    }



}
