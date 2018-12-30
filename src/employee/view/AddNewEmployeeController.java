package employee.view;

import employee.Main;
import employee.Person;
import java.util.Calendar;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AddNewEmployeeController {
    private Main main;
    
    //Contact Information
    @FXML
    private TextField firstNameField;
     @FXML
    private TextField lastNameField;
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
    private RadioButton maleBtn;
    @FXML
    private RadioButton femaleButton;
    
    //Department Information
    @FXML
    private ComboBox mainDepartMentBox;
    @FXML
    private ComboBox departMentBox;
    @FXML
    private TextField workTitleField;

    @FXML
    private void handleAge() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int birthYear = (DateOfBirth.getValue().getYear());
        int age = year - birthYear;
        ageField.setText(Integer.toString(age) + " Years");
    }

    @FXML
    private String handleObligatoryFields() {
        boolean fieldsFilled = true;
        String fieldsNotFilled = "The following fields needs to be Filled:\n__________________________________________";

        //nameField.getText().equals("");
        
        if (firstNameField.getText().equals("")) {
            fieldsFilled = false;
            fieldsNotFilled += "\nFirst Name";
        }
        if (lastNameField.getText().equals("")) {
            fieldsFilled = false;
            fieldsNotFilled += "\nLast Name";
        }
        if (phoneField.getText().equals("")) {
            fieldsFilled = false;
            fieldsNotFilled += "\nPhone";
        }
        if (emailField.getText().equals("")) {
            fieldsFilled = false;
            fieldsNotFilled += "\nEmail";
        }

        if (fieldsFilled == true) {
            return "";
        } else {
            return fieldsNotFilled;
        }
    }

    @FXML
    private void okBtnPressed() {
        if (handleObligatoryFields().equals("")){

        String gender = "Undefined";
        if (maleBtn.isSelected()) {
            gender = "M";
        } else {
            gender = "F";
        }
        
        
        Person emp1 = new Person(1, firstNameField.getText(), lastNameField.getText(),  phoneField.getText(), emailField.getText(), gender);
        //main.addEmployeeToList(emp1);
        
        //System.out.println(main.employeeList.get(0).toString());
        
        System.out.println(emp1.toString() + "\n___________________________\nAdded.");
        }
        else 
            System.out.println(handleObligatoryFields());
    }
}
