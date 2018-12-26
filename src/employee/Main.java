package employee;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;
    private static BorderPane mainLayout;
    public ObservableList<Person> employeeList = FXCollections.observableArrayList();
    public ObservableList<Competency> competencyList = FXCollections.observableArrayList();
    public ObservableList<String> mainDepartmentList = FXCollections.observableArrayList();
    public ObservableList<String> departmentList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Competency Manager");
        
        
        generateEmployees();
        showMainView();
        showMainItems();
    }

    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainView.fxml")); //Subpaket/fil
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showMainItems() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainItems.fxml"));
        BorderPane mainItems = loader.load();
        mainLayout.setCenter(mainItems);
    }

    public static void showElectricalScene() throws IOException //Should be public static void
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("electrical/ElectricalDep.fxml"));
        BorderPane electricalDep = loader.load();
        mainLayout.setCenter(electricalDep);
    }

    public static void showMechanicalScene() throws IOException //Should be public static void
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("mechanical/MechanicalDep.fxml"));
        BorderPane mechanicalDep = loader.load();
        mainLayout.setCenter(mechanicalDep);
    }
    
    public static void showAllEmployeesInfoScene() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("AllEmployees/AllEmployeesInfo.fxml"));
        BorderPane allEmployeesInfo = loader.load();
        mainLayout.setCenter(allEmployeesInfo);
    }
    
    public static void showAddStage() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/AddNewEmployee.fxml"));
        BorderPane addNewEmployee = loader.load();
        
        Stage addDialogeStage = new Stage();
        addDialogeStage.setTitle("Add new Employee");
        addDialogeStage.initModality(Modality.WINDOW_MODAL);
        addDialogeStage.initOwner(primaryStage);
        
        Scene scene = new Scene(addNewEmployee);
        addDialogeStage.setScene(scene);
        addDialogeStage.showAndWait();
    }
    
    public void generateEmployees(){
        //ReadFromFile and add to list
        
        
    }
    
    public void generateCompetencies(){
        //ReadFromFile and add to list
        
        
    }
    
    public void addEmployeeToList(Person employeeToAdd){
        //PrintToFile
        
        //AddToList
        //OBS! SKA EGENTLIGEN VARA
        //employeeList.addAll(new Person());
        employeeList.add(employeeToAdd);
    }
    
    public ObservableList<Person> getEmployees(){
        return this.employeeList;
    }
    
    public void addCompetencyToList(Competency competencyToAdd){
        //PrintToFile
        
        //AddToList
        competencyList.add(competencyToAdd);
    }

    public ObservableList<Competency> getCompetencies(){
        return this.competencyList;
    }
    
    public Competency getCompetency(int CompID){
        for (int i = 0; i < competencyList.size(); i++)
        {
            if (competencyList.get(i).getCompetencyID()==CompID)
            {
                return competencyList.get(i);
            }
        }
       return null;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
