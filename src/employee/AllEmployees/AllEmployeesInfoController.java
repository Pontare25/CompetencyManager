/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.AllEmployees;

import employee.Competency;
import employee.CompetencyValidity;
import employee.Main;
import employee.Person;
import java.net.URL;
import java.util.Calendar;
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
    private ObservableList<Competency> competencyList = FXCollections.observableArrayList();
    private ObservableList<CompetencyValidity> competencyValidityList = FXCollections.observableArrayList();
    
    
    
    //Employees Table
    @FXML
    private TableView<Person> employeeTable;
    @FXML
    private TableColumn<Person, Integer> idColumn;
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
    private TableView<CompetencyValidity> CompetencyTable;
    @FXML
    private TableColumn<CompetencyValidity, Integer> compCodeColumn;
    @FXML
    private TableColumn<CompetencyValidity, String> compNameColumn;
    @FXML
    private TableColumn<CompetencyValidity, String> validUntilColumn;
    @FXML
    private TableColumn<CompetencyValidity, String> validFromColumn;
    @FXML
    private TextArea CompetencyDescriptionTextArea;
   
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initEmployeeColumns();
        initCompetencyColumns();
        loadEmpData();
    }    
    
    public void initEmployeeColumns(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
    }
    
    public void initCompetencyColumns(){
        compCodeColumn.setCellValueFactory(new PropertyValueFactory<>("CompetencyID"));
        compNameColumn.setCellValueFactory(new PropertyValueFactory<>("CompName"));
        validFromColumn.setCellValueFactory(new PropertyValueFactory<>("ValidFrom"));
        validUntilColumn.setCellValueFactory(new PropertyValueFactory<>("ValidUntil"));
    }
    
    public void loadEmpData(){
        empList.removeAll(empList);
        //Person p = new Person("1", "Pontus", "Nellgård", "0737", "pontus.nellgard", "M");
        
        empList.addAll(new Person(1, "Pontus", "Nellgård", "0737286560", "pontus.nellgard@gmail.com", "M", "R&D", "Programming"));
        empList.addAll(new Person(2, "Ludvig", "de Fine Licht", "3782", "ludvigdfldfl@gmail.com", "M"));
        empList.addAll(new Person(3, "Erik", "Bernstrup", "7238", "erik.bernstrup@gmail.com", "M"));
        empList.addAll(new Person(4, "Johanna", "Strand", "0737", "johannastraand@hotmail.com", "M"));
        
        employeeTable.getItems().addAll(empList);
    }
    
    public void loadCompData(int id){
        competencyValidityList.removeAll(competencyValidityList);
        if (id == 1){
            competencyValidityList.addAll(new CompetencyValidity(2, "Test", "Testing", "2017-12-20", "2018-12-20"));
        }
        
        CompetencyTable.getItems().addAll(competencyValidityList);
    }
    
     

    @FXML
    private void DisplayEmployeeInformation(MouseEvent event) {
        String FName = employeeTable.getSelectionModel().getSelectedItem().getFirstName();
        if (FName.isEmpty() || FName.equals(null))
        {
           EmpIDField.setText("Nothing Selected");
        }
        else
        {
            EmpIDField.setText(Integer.toString(employeeTable.getSelectionModel().getSelectedItem().getEmployeeID()));
            FNameField.setText(employeeTable.getSelectionModel().getSelectedItem().getFirstName());
            LNameField.setText(employeeTable.getSelectionModel().getSelectedItem().getLastName());
            phoneField.setText(employeeTable.getSelectionModel().getSelectedItem().getPhoneNumber());
            emailField.setText(employeeTable.getSelectionModel().getSelectedItem().getEmail());
            
            mDepartmentField.setText(employeeTable.getSelectionModel().getSelectedItem().getMainDepartment());
            departmentField.setText(employeeTable.getSelectionModel().getSelectedItem().getDepartment());
            //cityField.setText(employeeTable.getSelectionModel().getSelectedItem().getCity());
            cityField.setText("Not implemented yet");
            
            
           loadCompData(employeeTable.getSelectionModel().getSelectedItem().getEmployeeID());
            
        }
    }

   
}