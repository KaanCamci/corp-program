import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private byte gender;
    private java.util.Calendar birthDate;
    private byte maritalStatus;
    private boolean hasDriverLicense;


    public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
                  String hasDriverLicense) {

        if (id < 0) {
            throw new ArithmeticException("ID cannot be negative!!!");
        }
        else {
            this.id = id;
        }

        if (firstName.length() < 3) {
            throw new ArithmeticException("First Name cannot be less than 3 letters!!!");
        }
        else {
            this.firstName = firstName;
        }

        if (lastName.length() < 3) {
            throw new ArithmeticException("Last Name cannot be less than 3 letters!!!");
        }
        else {
            this.lastName = lastName;
        }

        this.birthDate = birthDate;



        if (gender.length() < 3) {
            throw new ArithmeticException("Gender input cannot be less than 3 letters!!!");
        }

        else {

            if(gender.equals("Woman")) {
                this.gender=1;
            }
            else {
                this.gender=2;
            }
        }


        if (maritalStatus.length() < 3) {
            throw new ArithmeticException("Marital Status Input cannot be less than 3 letters!!!");
        }
        else {

            if(maritalStatus.equals("Single")) {
                this.maritalStatus=1;
            }
            else {
                this.maritalStatus=2;
            }
        }


        if(hasDriverLicense.equals("Yes")) {
            this.hasDriverLicense=true;
        }
        else {
            this.hasDriverLicense=false;
        }

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {

        if (id < 0) {
            throw new ArithmeticException("ID cannot be negative!!!");
        }
        else {
            this.id = id;
        }


    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {

        if (firstName.length() < 3) {
            throw new ArithmeticException("First Name cannot be less than 3 letters!!!");
        }
        else {
            this.firstName = firstName;
        }

    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {

        if (lastName.length() < 3) {
            throw new ArithmeticException("Last Name cannot be less than 3 letters!!!");
        }
        else {
            this.lastName = lastName;
        }

    }


    public String getGender() {
        if(this.gender==1) {
            return "Woman";
        }

        else {
            return "Man";
        }
    }


    public void setGender(String gender) {

        if (gender.length() < 3) {
            throw new ArithmeticException("Gender input cannot be less than 3 letters!!!");
        }

        else {

            if(gender.equals("Woman")) {
                this.gender=1;
            }
            else {
                this.gender=2;
            }
        }

    }


    /*Date date = this.birthDate.getTime();

    DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");

    String strDate = dateFormat.format(date);

    return strDate;*/
    public java.util.Calendar getBirthDate() {

        return this.birthDate;

    }


    public void setBirthDate(java.util.Calendar birthDate) {
        this.birthDate = birthDate;
    }


    public String getMaritalStatus() {
        if(this.maritalStatus==1) {
            return "Single";
        }

        else {
            return "Married";
        }
    }


    public void setMaritalStatus(String maritalStatus) {

        if (maritalStatus.length() < 3) {
            throw new ArithmeticException("Marital Status Input cannot be less than 3 letters!!!");
        }
        else {

            if(maritalStatus.equals("Single")) {
                this.maritalStatus=1;
            }
            else {
                this.maritalStatus=2;
            }
        }



    }


    public String getHasDriverLicense() {
        if(this.hasDriverLicense) {
            return "Yes";
        }
        else {
            return "No";
        }
    }


    public void setHasDriverLicense(String hasDriverLicense) {
        if(hasDriverLicense.equals("Yes")) {
            this.hasDriverLicense=true;
        }
        else {
            this.hasDriverLicense=false;
        }
    }

    public String toString() {

        Date date1 = this.getBirthDate().getTime();

        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");

        String BirthDate1 = dateFormat1.format(date1);

        return "Person [id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", gender=" + this.getGender() + ", birthDate=" + BirthDate1 + ", maritalStatus=" + this.getMaritalStatus() + ", hasDriverLicence=" + this.getHasDriverLicense() + "]";
    }


}
