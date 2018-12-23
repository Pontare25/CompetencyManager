package employee;

import java.util.Calendar;
import javafx.collections.ObservableList;

/**
 *
 * @author PontusN
 */
public class Person {
    private Main main;
    private int employeeID;
    private String name;
    private String phoneNumber;
    private String email;
    private String gender;
    private Calendar birthday;
    

    public Person(int employeeID, String name, String phoneNumber, String email, String gender, Calendar birthday) {
        this.employeeID = employeeID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        
        
    }
    
    
}
