/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.AllEmployees;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author PontusN
 */
public class AddEmployeeController implements Initializable {

    @FXML
    private TextField FNameField;
    @FXML
    private TextField LNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private DatePicker bDayDatePicker;
    @FXML
    private RadioButton maleBtn;
    @FXML
    private ToggleGroup genderGroup;
    @FXML
    private RadioButton femaleBtn;
    @FXML
    private TextField ageField;
    @FXML
    private ChoiceBox<?> mainDepBox;
    @FXML
    private ChoiceBox<?> depBox;
    @FXML
    private TextField workTitleField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddBtnPressed(ActionEvent event) {
    }
    
}
