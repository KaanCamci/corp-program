import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Customer extends Person{



    private ArrayList<Product> products = new ArrayList<Product>();

    public Customer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
                    String hasDriverLicense, ArrayList<Product> products) {

        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense);
        this.products = products;

    }

    public Customer(Person person, ArrayList<Product> products) {
        super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(),person.getHasDriverLicense());
        this.products=products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public String toString() {
        String x = "Customer [id: " + this.getId() + " products=[";

        ArrayList<String> productsBuyDates = new ArrayList<String>();

        for(int i = 0 ; i<products.size();i++) {
            Date date = this.getProducts().get(i).getSaleDate().getTime();

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String buyDate = dateFormat.format(date);

            productsBuyDates.add(buyDate);
        }

        for(int i = 0; i<products.size();i++) {
            if(i!=products.size()-1) {
                x = x + "Product [productName=" + this.products.get(i).getProductName() + ", transactionDate=" + productsBuyDates.get(i) + ", Price=" + this.products.get(i).getPrice() + "], ";
            }
            else {
                x = x + "Product [productName=" + this.products.get(i).getProductName() + ", transactionDate=" + productsBuyDates.get(i) + ", Price=" + this.products.get(i).getPrice() + "]";

            }
        }

        x= x + "]]";

        return x;
    }


}
