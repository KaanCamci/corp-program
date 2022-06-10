import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//Kaan CAMCI

/*
gets datas from input file and creates objects from these datas

writes output to output.txt
 */
public class Test {

    public static void main(String[] args) throws IOException {



        ArrayList<String> inputs = new ArrayList<String>(); // List of inputs (each line)
        ArrayList<Department> departmentsList = new ArrayList<Department>(); //List of Department objects
        ArrayList<Project> projectsList = new ArrayList<Project>(); //List of Project objects
        ArrayList<Product> productsList = new ArrayList<Product>(); //List of Product objects
        ArrayList<Person> peopleList = new ArrayList<Person>(); //List of Person objects
        ArrayList<Customer> customersList = new ArrayList<Customer>(); //List of Customer objects
        ArrayList<Employee> employeesList = new ArrayList<Employee>(); //List of Employee objects
        ArrayList<Manager> managersList = new ArrayList<Manager>(); //List of Manager objects
        ArrayList<RegularEmployee> regularEmployeesList = new ArrayList<RegularEmployee>(); //List of RegularEmployee objects
        ArrayList<SalesEmployee> salesEmployeesList = new ArrayList<SalesEmployee>(); //List of SalesEmployee objects
        ArrayList<Developer> developersList = new ArrayList<Developer>(); //List of Developer objects

        //adding lines to inputs ArrayList from input text file
        FileInputStream fstream = new FileInputStream("input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        while ((strLine = br.readLine()) != null)   {
            inputs.add(strLine);
        }
        fstream.close();



        for(int i=0; i<inputs.size();i++) { //searching each lines of input txt

            String[] currentLine = inputs.get(i).split("\\s+"); //splitting of words of each lines to choose if they are Department, project etc.

            if(currentLine[0].equals("Department")) { //creating department objects and adding them into departmentsList ArrayList if the first word of input is department
                departmentsList.add(new Department(Integer.parseInt(currentLine[1]),currentLine[2]));
            }


        }





        for(int i=0; i<inputs.size();i++) {

            String[] currentLine = inputs.get(i).split("\\s+");


            if(currentLine[0].equals("Project")) { //creating project objects and adding them into projectsList ArrayList

                String[] dateArray = currentLine[2].split("/"); //creating date variable from input for constructing project object
                int year = Integer.parseInt(dateArray[2])-1900;
                int month = Integer.parseInt(dateArray[1])-1;
                int day = Integer.parseInt(dateArray[0]);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(year,month,day));



                boolean state;

                if(currentLine[3].equals("Open")) {
                    state=true;
                }
                else{
                    state=false;
                }



                projectsList.add(new Project(currentLine[1],calendar,state));
            }

        }







        for(int i=0; i<inputs.size();i++) {

            String[] currentLine = inputs.get(i).split("\\s+");


            if(currentLine[0].equals("Product")) { //creating product objects and adding them into productsList ArrayList

                String[] dateArray = currentLine[2].split("/");
                int year = Integer.parseInt(dateArray[2])-1900;
                int month = Integer.parseInt(dateArray[1])-1;
                int day = Integer.parseInt(dateArray[0]);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(year,month,day));

                productsList.add(new Product(currentLine[1],calendar, Double.parseDouble(currentLine[3])));
            }
        }







        for(int i=0; i<inputs.size();i++) {

            String[] currentLine = inputs.get(i).split("\\s+");


            if(currentLine[0].equals("Person")) { //creating person objects and adding them into peopleList ArrayList

                String[] dateArray = currentLine[5].split("/");
                int year = Integer.parseInt(dateArray[2])-1900;
                int month = Integer.parseInt(dateArray[1])-1;
                int day = Integer.parseInt(dateArray[0]);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(year,month,day));

                peopleList.add(new Person(Integer.parseInt(currentLine[3]), currentLine[1], currentLine[2], currentLine[4], calendar, currentLine[6], currentLine[7]));
            }

        }








        for(int i=0; i<inputs.size();i++) {

            String[] currentLine = inputs.get(i).split("\\s+");


            if(currentLine[0].equals("Customer")) { //creating customer objects and adding them into customersList ArrayList

                ArrayList<Product> productsBought = new ArrayList<Product>(); // ArrayList of items of that customer bought
                Person person=null;

                for(int x =0 ; x<peopleList.size();x++) {
                    if(Integer.parseInt(currentLine[1])==peopleList.get(x).getId()) {
                        person = peopleList.get(x);
                        peopleList.remove(x);
                    }
                }

                for(int x=0; x<currentLine.length;x++) {
                    for(int y=0; y<productsList.size();y++) {
                        if(currentLine[x].equals(productsList.get(y).getProductName())){
                            productsBought.add(productsList.get(y));
                        }
                    }
                }


                customersList.add(new Customer(person,productsBought));

            }
        }









        for(int i=0; i<inputs.size();i++) {

            String[] currentLine = inputs.get(i).split("\\s+");


            if(currentLine[0].equals("Employee")){

                Person person=null;
                Department department=null;

                for(int x =0 ; x<peopleList.size();x++) {
                    if(Integer.parseInt(currentLine[1])==peopleList.get(x).getId()) {
                        person = peopleList.get(x);
                        peopleList.remove(x);
                    }
                }

                double salaryOfEmployee=Double.parseDouble(currentLine[2]);

                String[] dateArray = currentLine[3].split("/");
                int year = Integer.parseInt(dateArray[2])-1900;
                int month = Integer.parseInt(dateArray[1])-1;
                int day = Integer.parseInt(dateArray[0]);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(year,month,day));


                for(int x = 0 ; x<departmentsList.size(); x++) {
                    if(currentLine[4].equals(departmentsList.get(x).getDepartmentName())) {
                        department = departmentsList.get(x);
                    }
                }

                employeesList.add(new Employee(person, salaryOfEmployee, calendar, department));

            }

        }












        for(int i=0; i<inputs.size();i++) {

            String[] currentLine = inputs.get(i).split("\\s+");


            if(currentLine[0].equals("Manager")){

                Employee employee=null;
                double bonusBudgetOfManager = Double.parseDouble(currentLine[2]);

                for(int x=0; x<employeesList.size();x++) {
                    if(Integer.parseInt(currentLine[1])==employeesList.get(x).getId()) {
                        employee = employeesList.get(x);
                        employeesList.remove(x);
                    }
                }

                managersList.add(new Manager(employee, bonusBudgetOfManager));

            }
        }











        for(int i=0; i<inputs.size();i++) {

            String[] currentLine = inputs.get(i).split("\\s+");


            if(currentLine[0].equals("RegularEmployee")){
                Employee employee=null;
                double performanceScoreOfRegularEmployee = Double.parseDouble(currentLine[2]);

                for(int x=0; x<employeesList.size();x++) {
                    if(Integer.parseInt(currentLine[1])==employeesList.get(x).getId()) {
                        employee = employeesList.get(x);
                        employeesList.remove(x);
                    }
                }



                regularEmployeesList.add(new RegularEmployee(employee, performanceScoreOfRegularEmployee));



                for(int y = 0; y<managersList.size();y++) {//adding regular employees to their managers



                    if(managersList.get(y).getDepartment().getDepartmentName().equals(regularEmployeesList.get(regularEmployeesList.size()-1).getDepartment().getDepartmentName())) {
                        managersList.get(y).addEmployee(regularEmployeesList.get(regularEmployeesList.size()-1));
                    }

                }


            }

        }










        for(int i=0; i<inputs.size();i++) {

            String[] currentLine = inputs.get(i).split("\\s+");


            if(currentLine[0].equals("SalesEmployee")){

                RegularEmployee regularEmployee=null;
                ArrayList<Product> salesOfSalesEmployee = new ArrayList<Product>();

                for(int x=0; x<regularEmployeesList.size();x++) {
                    if(Integer.parseInt(currentLine[1])==regularEmployeesList.get(x).getId()) {
                        regularEmployee = regularEmployeesList.get(x);
                        regularEmployeesList.remove(x);
                    }
                }

                salesEmployeesList.add(new SalesEmployee(regularEmployee, salesOfSalesEmployee));

                for(int x=0; x<productsList.size();x++) {
                    for(int y=0; y<currentLine.length;y++) {

                        if(currentLine[y].equals(productsList.get(x).getProductName())) {
                            salesEmployeesList.get(salesEmployeesList.size()-1).addSale(productsList.get(x));
                        }

                    }

                }

            }
        }












        for(int i=0; i<inputs.size();i++) {

            String[] currentLine = inputs.get(i).split("\\s+");


            if(currentLine[0].equals("Developer")){

                RegularEmployee regularEmployee=null;
                ArrayList<Project> projectsOfDeveloper = new ArrayList<Project>();

                for(int x=0; x<regularEmployeesList.size();x++) {
                    if(Integer.parseInt(currentLine[1])==regularEmployeesList.get(x).getId()) {
                        regularEmployee = regularEmployeesList.get(x);
                        regularEmployeesList.remove(x);
                    }
                }

                developersList.add(new Developer(regularEmployee, projectsOfDeveloper));


                for(int x=0; x<projectsList.size();x++) {
                    for(int y=0; y<currentLine.length;y++) {

                        if(currentLine[y].equals(projectsList.get(x).getProjectName())) {
                            developersList.get(developersList.size()-1).addProject(projectsList.get(x));
                        }

                    }

                }
            }

        }















        String outputData = ""; //the String variable that will be written on the output

        for(int i=0;i<departmentsList.size();i++) {
            outputData += "************************************************\n";
            outputData += departmentsList.get(i).toString() + "\n";

            for(int x = 0; x< managersList.size();x++) {
                if(managersList.get(x).getDepartment().getDepartmentName().equals(departmentsList.get(i).getDepartmentName())){
                    outputData+= managersList.get(x).toString() + "\n";


                    for(int y = 0; y<managersList.get(x).getRegularEmployees().size();y++) { //writing each datas of regular employees of that manager
                        outputData+= "			" + (y+1) + ".";

                        for(int d = 0; d<developersList.size();d++) {

                            if(developersList.get(d).getId()==managersList.get(x).getRegularEmployees().get(y).getId()) {
                                outputData+= " " + developersList.get(d).toString() + "\n";
                            }

                        }


                        for(int s = 0; s< salesEmployeesList.size(); s++) {
                            if(salesEmployeesList.get(s).getId()==managersList.get(x).getRegularEmployees().get(y).getId()) {
                                outputData+= " " + salesEmployeesList.get(s).toString() + "\n";
                            }

                        }

                        for(int r=0; r< regularEmployeesList.size();r++) {
                            if(regularEmployeesList.get(r).getId()==managersList.get(x).getRegularEmployees().get(y).getId()) {
                                outputData+= " " + regularEmployeesList.get(r).toString() + "\n";
                            }
                        }


                    }

                }
            }
            outputData+= "\n";
        }

        outputData += "\n\n**********************CUSTOMERS************************\n";


        for(int c=0; c<customersList.size();c++) {
            outputData+= customersList.get(c).toString() + "\n";
        }

        outputData += "\n\n**********************PEOPLE************************\n";

        for(int p=0; p<peopleList.size();p++) {
            outputData+= peopleList.get(p).toString() + "\n";
        }


        try {
            // Creates a FileWriter
            FileWriter output = new FileWriter("output.txt");

            // Writes the string to the file
            output.write(outputData);

            // Closes the writer
            output.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }


        int a=10;
        double b=5;
        int c=9;
        //if(peopleList.get(0).getClass() == peopleList.get(1).getClass()) {

        if(peopleList.get(0).getClass().equals("class Person")) {
            System.out.println(peopleList.get(0).getClass());

        }

    }

}
