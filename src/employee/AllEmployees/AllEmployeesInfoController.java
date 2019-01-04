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
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

    private Main main;

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
        generateEmpData();
        loadEmpData();
    }

    public void initEmployeeColumns() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("LastName"));
    }

    public void initCompetencyColumns() {
        compCodeColumn.setCellValueFactory(new PropertyValueFactory<>("CompetencyID"));
        compNameColumn.setCellValueFactory(new PropertyValueFactory<>("CompName"));
        validFromColumn.setCellValueFactory(new PropertyValueFactory<>("ValidFrom"));
        validUntilColumn.setCellValueFactory(new PropertyValueFactory<>("ValidUntil"));
    }
    
    public void generateEmpData(){
        empList.removeAll(empList);

        //Adds employees to the list
        empList.addAll(new Person(1, "Pontus", "Nellgård", "+46737286560", "pontus.nellgard@gmail.com", "M", "R&D", "Programming"));
        empList.addAll(new Person(2, "Ludvig", "de Fine Licht", "+46761345857", "ludvigdfldfl@gmail.com", "M"));
        empList.addAll(new Person(3, "Erik", "Bernstrup", "+46708254153", "erik.bernstrup@gmail.com", "M"));
        empList.addAll(new Person(4, "Johanna", "Strand", "+46737212227", "johannastraand@hotmail.com", "M"));

         //Adds Competencies to specific employees
        empList.get(0).addCompetency(27, "Java Programmer", "A Programmer familiar with the Java language", "2017-12-20", "2018-12-20");
        empList.get(0).addCompetency(29, "GUI Programmer", "A Programmer familiar with handling graphical user interface (GUI) elements", "2017-12-20", "2018-12-20");

        empList.get(1).addCompetency(2, "Driver", "license to drive", "2017-12-20", "2018-12-20");
        empList.get(1).addCompetency(4, "Trucker", "Licensed Truck Driver", "2017-10-20", "2018-11-20");

        empList.get(2).addCompetency(7, "Head Economist", "Head of the economy department", "2017-12-20", "2018-12-20");
        empList.get(2).addCompetency(6, "Client Support", "Handles client communications", "2017-12-20", "2018-12-20");

        empList.get(3).addCompetency(2, "Driver", "Licensed to drive", "2017-12-20", "2018-12-20");
        empList.get(3).addCompetency(4, "Trucker", "Licensed Truck Driver", "2017-10-20", "2018-11-20");
        empList.get(3).addCompetency(6, "Client Support", "Handles client communications", "2017-12-20", "2018-12-20");
        //OBS! Adding the competencies to the table is done in the method loadCompData(int id) since it needs to be tied to a unique employee
    }

    public void loadEmpData() { 
        //Adds the employee list to the table
        employeeTable.getItems().clear();
        employeeTable.getItems().addAll(empList);
    }

    //Load competency data from the selected employee from the employee table
    public void loadCompData(int selectedEmp) { 
        CompetencyTable.getItems().clear();
        CompetencyTable.getItems().addAll(empList.get(selectedEmp).getCompetencies());
    }

    @FXML
    private void DisplayEmployeeInformation(MouseEvent event) {
        CompetencyDescriptionTextArea.clear();

        String FName = employeeTable.getSelectionModel().getSelectedItem().getFirstName();
        if (FName.isEmpty() || FName.equals(null)) {
            EmpIDField.setText("Nothing Selected");
        } else {
            EmpIDField.setText(Integer.toString(employeeTable.getSelectionModel().getSelectedItem().getEmployeeID()));
            FNameField.setText(employeeTable.getSelectionModel().getSelectedItem().getFirstName());
            LNameField.setText(employeeTable.getSelectionModel().getSelectedItem().getLastName());
            phoneField.setText(employeeTable.getSelectionModel().getSelectedItem().getPhoneNumber());
            emailField.setText(employeeTable.getSelectionModel().getSelectedItem().getEmail());

            mDepartmentField.setText(employeeTable.getSelectionModel().getSelectedItem().getMainDepartment());
            departmentField.setText(employeeTable.getSelectionModel().getSelectedItem().getDepartment());
            //cityField.setText(employeeTable.getSelectionModel().getSelectedItem().getCity());
            cityField.setText("Not implemented yet");

            //Load competency data from the selected employee from the employee table
            loadCompData(employeeTable.getSelectionModel().getSelectedIndex());
        }
    }

    @FXML
    private void DisplayCompetencyDescription(MouseEvent event) {
        String description = CompetencyTable.getSelectionModel().getSelectedItem().getCompDescription();
        if (description.isEmpty() || description.equals(null)) {
            CompetencyDescriptionTextArea.setText("Nothing Selected");
        } else {
            CompetencyDescriptionTextArea.setText(description);
        }
    }

    @FXML
    private void AddCompetency(ActionEvent event) {
        int selectedEmp = employeeTable.getSelectionModel().getSelectedIndex();
        empList.get(selectedEmp).addCompetency(42, "Meaning", "The meaining of life", "0000-00-00", "9999-99-99");
        CompetencyTable.getItems().clear();
        loadCompData(selectedEmp);
    }

    @FXML
    private void deleteCompetency(ActionEvent event) {
        int selectedEmp = employeeTable.getSelectionModel().getSelectedIndex();
        int selectedComp = CompetencyTable.getSelectionModel().getSelectedIndex();
        empList.get(selectedEmp).deleteCompetency(selectedComp);
        
        CompetencyTable.getItems().clear();
        loadCompData(selectedEmp);
    }

   
            
    
    @FXML
    private void AddNewEmployee(ActionEvent event) throws IOException {
       /* empList.addAll(new Person(99, "firstName", "lastName", "99999999", "email", "gender"));
        empList.get(empList.size()-1).addCompetency(0, "ComTitle", "CompDesc", "000000", "9999999");
       */ 
        
         main.showAddEmpStage();
        
        
        CompetencyTable.getItems().clear();
        loadEmpData();
    }
    
    
    

    @FXML
    private void DeleteEmployee(ActionEvent event) {
        int empID = employeeTable.getSelectionModel().getSelectedItem().getEmployeeID();
        
        for (int i = 0; i < empList.size(); i++)
        {
            if (empList.get(i).getEmployeeID() == empID){
                empList.remove(i);
                i = empList.size();
                
            }
        }
        CompetencyTable.getItems().clear();
        loadEmpData(); //OBS! Clear function implemented
    }

}
