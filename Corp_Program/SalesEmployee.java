import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SalesEmployee extends RegularEmployee{

    private ArrayList< Product> sales;
    private int numberofSalesEmployees;


    public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
                         String maritalStatus, String hasDriverLicense, double salary, Calendar hireDate, Department department,
                         double performanceScore, ArrayList<Product> sales) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department,
                performanceScore);
        this.sales = sales;

        numberofSalesEmployees++;
    }


    public SalesEmployee(RegularEmployee regularEmployee, ArrayList<Product> sales) {
        super(regularEmployee.getId(), regularEmployee.getFirstName(), regularEmployee.getLastName(), regularEmployee.getGender(), regularEmployee.getBirthDate(), regularEmployee.getMaritalStatus(), regularEmployee.getHasDriverLicense(), regularEmployee.getSalary(), regularEmployee.getHireDate(), regularEmployee.getDepartment(), regularEmployee.getPerformanceScore());
        this.sales=sales;

        numberofSalesEmployees++;
    }


    public boolean addSale(Product s) {
        if(s!=null) {
            sales.add(s);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeSale(Product s) {
        if(sales.contains(s)) {
            sales.remove(s);
            return true;
        }
        else {
            return false;
        }
    }




    public ArrayList<Product> getSales() {
        return sales;
    }


    public void setSales(ArrayList<Product> sales) {
        this.sales = sales;
    }


    public int getNumberofSalesEmployees() {
        return numberofSalesEmployees;
    }


    public void setNumberofSalesEmployees(int numberofSalesEmployees) {
        this.numberofSalesEmployees = numberofSalesEmployees;
    }


    public String toString() {

        Date date1 = this.getHireDate().getTime();

        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

        String hireDate = dateFormat1.format(date1);

        ArrayList<String> productsSaleDates = new ArrayList<String>();

        for(int i = 0 ; i<sales.size();i++) {
            Date date = this.getSales().get(i).getSaleDate().getTime();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String saleDate = dateFormat.format(date);

            productsSaleDates.add(saleDate);
        }

        String x = "\tSales Employee\n" + "\t\t\t    Person Info[id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", gender=" + this.getGender() + "]" +
                "\n\t\t\t    Employee Info [salary="+ this.getSalary() +", hireDate=" + hireDate + "]" +
                "\n\t\t\t    RegularEmployee Info [performanceScore=" + this.getPerformanceScore() + ", bonus=" + this.getBonus() + "]" +
                "\n\t\t\t    [";


        for(int i = 0; i<sales.size();i++) {

            if(i!=sales.size()-1) {
                x = x + "Product [Product Name=" + sales.get(i).getProductName() + ", Transaction Date=" + productsSaleDates.get(i) + ", Price=" + sales.get(i).getPrice() + "], ";
            }
            else {
                x = x + "Product [Product Name=" + sales.get(i).getProductName() + ", Transaction Date=" + productsSaleDates.get(i) + ", Price=" + sales.get(i).getPrice() + "]";
            }
        }

        x = x + "]";

        return x;
    }


}
