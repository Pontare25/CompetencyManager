package employee;

import java.util.Calendar;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author PontusN
 */
public class Person {

    private int employeeID;
    private SimpleStringProperty fName;
    private SimpleStringProperty lName;
    private SimpleStringProperty phoneNumber;
    private SimpleStringProperty email;
    private SimpleStringProperty gender;
    private SimpleStringProperty mainDepartment;
    private SimpleStringProperty department;
    
    private ObservableList<Competency> competencies = FXCollections.observableArrayList();

    public Person(int employeeID, String firstName, String lastName, String phoneNumber, String email, String gender, String mainDepartment, String department) {
        this.employeeID = employeeID;
        this.fName = new SimpleStringProperty(firstName);
        this.lName = new SimpleStringProperty(lastName);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.email = new SimpleStringProperty(email);
        this.gender = new SimpleStringProperty(gender);

        this.mainDepartment = new SimpleStringProperty(mainDepartment);
        this.department = new SimpleStringProperty(department);
        
        this.competencies.removeAll(competencies);
    }

    public Person(int employeeID, String firstName, String lastName, String phoneNumber, String email, String gender/*, Calendar birthday*/) {
        this.employeeID = employeeID;
        this.fName = new SimpleStringProperty(firstName);
        this.lName = new SimpleStringProperty(lastName);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.email = new SimpleStringProperty(email);
        this.gender = new SimpleStringProperty(gender);

        this.mainDepartment = new SimpleStringProperty("Unassigned");
        this.department = new SimpleStringProperty("Unassigned");
        
        this.competencies.removeAll(competencies);
        //this.birthday = birthday;

        //this.competencies.add(new Competency(1, "Greet", "Greeter"));
    }

    public Person() {
        this.employeeID = 0;
        this.fName = new SimpleStringProperty("Unassigned");
        this.lName = new SimpleStringProperty("Unassigned");
        this.phoneNumber = new SimpleStringProperty("Unassigned");
        this.email = new SimpleStringProperty("Unassigned");
        this.gender = new SimpleStringProperty("Unassigned");
        this.mainDepartment = new SimpleStringProperty("Unassigned");
        this.department = new SimpleStringProperty("Unassigned");
        
        this.competencies.removeAll(competencies);
        //  this.birthday = Calendar.getInstance();

        //this.competencies.add(new Competency(1, "Greet", "Greeter"));
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
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
        ret += "Name: " + this.fName.get() + " " + this.lName.get() + "\tEmployee ID: " + Integer.toString(employeeID);
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
    
    public void addCompetency(int compID, String ComTitle, String CompDesc){
        competencies.addAll(new Competency(compID, ComTitle, CompDesc));
    }

    public ObservableList<Competency> getCompetencies() {
        return competencies;
    }
    

    
   
}
