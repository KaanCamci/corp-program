import java.util.Calendar;

public class Project {


    private String projectName;
    private java.util.Calendar startDate;
    private boolean state;

    public Project(String projectName, Calendar startDate, boolean state) {
        super();
        this.projectName = projectName;
        this.startDate = startDate;
        this.state = state;
    }

    public void close(){
        state=false;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public java.util.Calendar getStartDate() {

        return this.startDate;
    }

    public void setStartDate(java.util.Calendar startDate) {

        this.startDate = startDate;
    }

    public String getState() {
        if(this.state==true) {
            return "Open";
        }
        else {
            return "Close";
        }
    }

    public void setState(String state) {
        if(state.equals("Open")) {
            this.state=true;
        }
        else {
            this.state=false;
        }
    }



}
