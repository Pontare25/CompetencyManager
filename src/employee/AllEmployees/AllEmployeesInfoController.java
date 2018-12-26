/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.AllEmployees;

import employee.Person;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author PontusN
 */
public class AllEmployeesInfoController implements Initializable {

    private ObservableList<Person> empList = FXCollections.observableArrayList();
    
    
    //Employees Table
    @FXML
    private TableView<Person> employeeTable;
    @FXML
    private TableColumn<Person, String> idColumn;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
   
    //General Information
    @FXML
    private TextField EmpIDField;
    @FXML
    private TextField FNameField;
    @FXML
    private TextField LNameField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
     @FXML
    private TextField mDepartmentField;
    @FXML
    private TextField departmentField;
    @FXML
    private TextField cityField;
   
    
    //Competency Table
    @FXML
    private TableView<?> CompetencyTable;
    @FXML
    private TableColumn<?, ?> compCodeColumn;
    @FXML
    private TableColumn<?, ?> compNameColumn;
    @FXML
    private TableColumn<?, ?> validUntilColumn;
    @FXML
    private TableColumn<?, ?> validFromColumn;
    @FXML
    private TextArea CompetencyDescriptionTextArea;
   
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initEmployeeColumns();
        loadEmpData();
    }    
    
    public void initEmployeeColumns(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
    }
    
    public void initCompetencyColumns(){
        
    }
    
    public void loadEmpData(){
        empList.removeAll(empList);
        //Person p = new Person("1", "Pontus", "Nellgård", "0737", "pontus.nellgard", "M");
        
        empList.addAll(new Person("0001", "Pontus", "Nellgård", "0737286560", "pontus.nellgard@gmail.com", "M"));
        empList.addAll(new Person("0002", "Ludvig", "de Fine Licht", "3782", "ludvigdfldfl@gmail.com", "M"));
        empList.addAll(new Person("0003", "Erik", "Bernstrup", "7238", "erik.bernstrup@gmail.com", "M"));
        empList.addAll(new Person("0004", "Johanna", "Strand", "0737", "johannastraand@hotmail.com", "M"));
        employeeTable.getItems().addAll(empList);
    }

    @FXML
    private void DisplayEmployeeInformation(MouseEvent event) {
        String empID = employeeTable.getSelectionModel().getSelectedItem().getEmployeeID();
        if (empID.isEmpty() || empID.equals(null))
        {
           EmpIDField.setText("Nothing Selected");
        }
        else
        {
            EmpIDField.setText(empID);
            FNameField.setText(employeeTable.getSelectionModel().getSelectedItem().getFirstName());
            LNameField.setText(employeeTable.getSelectionModel().getSelectedItem().getLastName());
            phoneField.setText(employeeTable.getSelectionModel().getSelectedItem().getPhoneNumber());
            emailField.setText(employeeTable.getSelectionModel().getSelectedItem().getEmail());
            
            mDepartmentField.setText(employeeTable.getSelectionModel().getSelectedItem().getMainDepartment());
            departmentField.setText(employeeTable.getSelectionModel().getSelectedItem().getDepartment());
            //cityField.setText(employeeTable.getSelectionModel().getSelectedItem().getCity());
            cityField.setText("Not implemented yet");
        }
    }
}
