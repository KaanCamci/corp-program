import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Developer extends RegularEmployee{

    private ArrayList<Project> projects;
    private int numberOfDevelopers;


    public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
                     String hasDriverLicense, double salary, Calendar hireDate, Department department, double performanceScore,
                     ArrayList<Project> projects) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department,
                performanceScore);
        this.projects = projects;

        numberOfDevelopers++;
    }

    public Developer(RegularEmployee regularEmployee, ArrayList<Project> projects) {
        super(regularEmployee.getId(), regularEmployee.getFirstName(), regularEmployee.getLastName(), regularEmployee.getGender(), regularEmployee.getBirthDate(), regularEmployee.getMaritalStatus(), regularEmployee.getHasDriverLicense(), regularEmployee.getSalary(), regularEmployee.getHireDate(), regularEmployee.getDepartment(), regularEmployee.getPerformanceScore());
        this.projects=projects;

        numberOfDevelopers++;
    }


    public boolean addProject(Project s) {
        if(s!=null) {
            projects.add(s);
            return true;
        }
        else{
            return false;
        }
    }


    public boolean removeProject(Project s) {
        if(projects.contains(s)) {
            projects.remove(s);
            return true;
        }
        else {
            return false;
        }

    }




    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public int getNumberOfDevelopers() {
        return numberOfDevelopers;
    }

    public void setNumberOfDevelopers(int numberOfDevelopers) {
        this.numberOfDevelopers = numberOfDevelopers;
    }

    public String toString() {

        Date date1 = this.getHireDate().getTime();

        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

        String hireDate = dateFormat1.format(date1);

        ArrayList<String> projectStartDates = new ArrayList<String>();

        for(int i = 0 ; i<projects.size();i++) {
            Date date = this.getProjects().get(i).getStartDate().getTime();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String startDate = dateFormat.format(date);

            projectStartDates.add(startDate);
        }

        String x = "Developer\n" + "\t\t\t    Person Info [id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", gender=" + this.getGender() + "]" +
                "\n\t\t\t    Employee Info [salary="+ this.getSalary() +", hireDate=" + hireDate + "]" +
                "\n\t\t\t    RegularEmployee Info [performanceScore=" + this.getPerformanceScore() + ", bonus=" + this.getBonus() + "]" +
                "\n\t\t\t    [Project ";


        for(int i = 0; i<projects.size();i++) {
            if(i!=projects.size()-1) {
                x = x + "[projectName=" + projects.get(i).getProjectName() + ", startDate=" + projectStartDates.get(i) + ", state=" + projects.get(i).getState() + "], ";
            }
            else {
                x = x + "[projectName=" + projects.get(i).getProjectName() + ", startDate=" + projectStartDates.get(i) + ", state=" + projects.get(i).getState() + "]";
            }
        }

        x = x + "]";

        return x;
    }




}
