import java.util.Calendar;

public class Employee extends Person{


    private double salary;
    private java.util.Calendar hireDate;
    private Department department;
    private int numberofEmployees;


    public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
                    String hasDriverLicense, double salary, Calendar hireDate, Department department) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense);
        if (salary < 0) {
            throw new ArithmeticException("Salary cannot be negative!!!");
        }
        else {
            this.salary=salary;
        }
        this.hireDate=hireDate;
        this.department=department;

        numberofEmployees++;
    }


    public Employee(Person person, double salary, Calendar hireDate, Department department) {
        super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(),person.getHasDriverLicense());
        if (salary < 0) {
            throw new ArithmeticException("Salary cannot be negative!!!");
        }
        else {
            this.salary=salary;
        }
        this.hireDate=hireDate;
        this.department=department;

        numberofEmployees++;
    }




    public double raiseSalary(int amount) {

        this.salary=this.salary+amount;

        return this.salary;
    }

    public double raiseSalary(double percent) {

        this.salary=this.salary+(this.salary*percent);

        return this.salary;
    }






    public double getSalary() {
        return salary;
    }


    public void setSalary(double salary) {

        if (salary < 0) {
            throw new ArithmeticException("Salary cannot be negative!!!");
        }
        else {
            this.salary=salary;
        }

    }


    public java.util.Calendar getHireDate() {
        return hireDate;
    }


    public void setHireDate(java.util.Calendar hireDate) {
        this.hireDate = hireDate;
    }


    public Department getDepartment() {
        return department;
    }


    public void setDepartment(Department department) {
        this.department = department;
    }


    public int getNumberofEmployees() {
        return numberofEmployees;
    }


    public void setNumberofEmployees(int numberofEmployees) {
        this.numberofEmployees = numberofEmployees;
    }




}
