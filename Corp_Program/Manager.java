import java.util.ArrayList;
import java.util.Calendar;

public class Manager extends Employee{

    private ArrayList<RegularEmployee> regularEmployees;
    private double bonusBudget;


    public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
                   String hasDriverLicense, double salary, Calendar hireDate, Department department, double bonusBudget) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate,
                department);
        if (bonusBudget < 0) {
            throw new ArithmeticException("Bonus Budget cannot be negative!!!");
        }
        else {
            this.bonusBudget=bonusBudget;
        }
    }


    public Manager(Employee employee, double bonusBudget) {
        super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicense(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
        if (bonusBudget < 0) {
            throw new ArithmeticException("Bonus Budget cannot be negative!!!");
        }
        else {
            this.bonusBudget=bonusBudget;
        }
    }


    public void addEmployee(RegularEmployee e) {
        if(regularEmployees == null) {
            regularEmployees = new ArrayList<RegularEmployee>();
        }

        regularEmployees.add(e);

    }

    public void removeEmployee(RegularEmployee e) {
        regularEmployees.remove(e);
    }

    public void distributeBonusBudget() {
        double totalofSalaryTimesPerformanceScore=0;

        for(int i=0;i<regularEmployees.size();i++) {
            totalofSalaryTimesPerformanceScore= totalofSalaryTimesPerformanceScore+ (regularEmployees.get(i).getSalary()*regularEmployees.get(i).getPerformanceScore());
        } // totalofSalaryTimesPerformanceScore is the sum of all of the regular employees' salary * perfomanceScore


        for(int i=0; i<regularEmployees.size();i++) {
            double bonus=0;
            double score=regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore();

            bonus = (score / totalofSalaryTimesPerformanceScore) * bonusBudget;

            regularEmployees.get(i).setBonus(bonus);
        }

    }


    public ArrayList<RegularEmployee> getRegularEmployees() {
        return regularEmployees;
    }


    public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
        this.regularEmployees = regularEmployees;
    }


    public double getBonusBudget() {
        return bonusBudget;
    }


    public void setBonusBudget(double bonusBudget) {

        if (bonusBudget < 0) {
            throw new ArithmeticException("Bonus Budget cannot be negative!!!");
        }
        else {
            this.bonusBudget=bonusBudget;
        }

    }

    public String toString() {
        return "	Manager [id: " + this.getId() + ", " + this.getFirstName() + " " + this.getLastName() + "\n		# of Employees: " + regularEmployees.size() + "]";
    }



}
