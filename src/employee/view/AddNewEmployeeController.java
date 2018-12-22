package employee.view;

import java.util.Calendar;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddNewEmployeeController {
    
    
    //Contact Information
    @FXML
    private TextField nameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    
    
    //Personal Information
    @FXML
    private DatePicker DateOfBirth;
    @FXML
    private TextField ageField;
    
    
    @FXML
    private void handleAge(){
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int birthYear = (DateOfBirth.getValue().getYear());
        int age = year - birthYear;
        ageField.setText(Integer.toString(age));
    }
}