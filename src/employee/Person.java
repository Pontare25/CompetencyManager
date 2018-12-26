package employee;

import java.util.Calendar;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author PontusN
 */
public class Person {

    private SimpleStringProperty employeeID;
    // private String name;
    // private String phoneNumber;
    //  private String email;
    //  private String gender;
    //  private String gender;
    //   private Calendar birthday;

    private  SimpleStringProperty fName;
    private  SimpleStringProperty lName;
    private  SimpleStringProperty phoneNumber;
    private  SimpleStringProperty email;
    private  SimpleStringProperty gender;
    private  SimpleStringProperty mainDepartment;
    private  SimpleStringProperty department;

    public Person(String employeeID, String firstName, String lastName, String phoneNumber, String email, String gender, String mainDepartment, String department) {
        this.employeeID = new SimpleStringProperty(employeeID);
        this.fName = new SimpleStringProperty(firstName);
        this.lName = new SimpleStringProperty(lastName);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.email = new SimpleStringProperty(email);
        this.gender = new SimpleStringProperty(gender);
        
        this.mainDepartment = new SimpleStringProperty(mainDepartment);
        this.department = new SimpleStringProperty(department);
    }
    
    public Person(String employeeID, String firstName, String lastName, String phoneNumber, String email, String gender/*, Calendar birthday*/) {
        this.employeeID = new SimpleStringProperty(employeeID);
        this.fName = new SimpleStringProperty(firstName);
        this.lName = new SimpleStringProperty(lastName);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.email = new SimpleStringProperty(email);
        this.gender = new SimpleStringProperty(gender);
        
        this.mainDepartment = new SimpleStringProperty("Unassigned");
        this.department = new SimpleStringProperty("Unassigned");
        //this.birthday = birthday;

        //this.competencies.add(new Competency(1, "Greet", "Greeter"));
    }

    public Person() {
        this.employeeID = new SimpleStringProperty("0");
        this.fName = new SimpleStringProperty("");
        this.lName = new SimpleStringProperty("");
        this.phoneNumber = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
        this.gender = new SimpleStringProperty("");
        this.mainDepartment = new SimpleStringProperty("Unassigned");
        this.department = new SimpleStringProperty("Unassigned");
        //  this.birthday = Calendar.getInstance();

        //this.competencies.add(new Competency(1, "Greet", "Greeter"));

    }

    public String getEmployeeID() {
        return employeeID.get();
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = new SimpleStringProperty(employeeID);
    }

    public String getFirstName() {
        return fName.get();
    }

    public void setFirstName(String name) {
        this.fName = new SimpleStringProperty(name);
    }
    
    public String getLastName() {
        return lName.get();
    }

    public void setLastName(String name) {
        this.lName = new SimpleStringProperty(name);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender = new SimpleStringProperty(gender);
    }

    public String getMainDepartment() {
        return mainDepartment.get();
    }

    public void setMainDepartment(String mainDepartment) {
        this.mainDepartment = new SimpleStringProperty(mainDepartment);
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department = new SimpleStringProperty(department);
    }
 
    public String toString() {
        String ret = "";
        ret += "Name: " + this.fName.get() + " " + this.lName.get() +"\tEmployee ID: " + this.employeeID.get();
        ret += "\nPhoneNumber: " + this.phoneNumber.get();
        ret += "\nEmail: " + this.email.get();
        if (this.gender.get() == "M") {
            ret += "\nGender: Male";
        } else if (this.gender.get() == "F") {
            ret += "\nGender: Female";
        } else {
            ret += "\nGender: " + this.gender.get();
        }

        //ret+= "/nBirthday: " + this.birthday.toString();
        return ret;
    }

   /* public ObservableList<Competency> getCompetencies() {
        return competencies;
    }*/

  /*  public void addCompetency(int CompID) {
        Competency toAdd = main.getCompetency(CompID);
        if (toAdd.equals(null)) {
            //throw error window
            System.out.println("Competency not found");
        } else {
            competencies.add(toAdd);
        }
    }*/

}
