
package employee.AllEmployees;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author PontusN
 */
public class SimpleEmployee {
    
    private static SimpleStringProperty ID;
    private static SimpleStringProperty Name;

    public SimpleEmployee(String ID, String Name) {
        this.ID = new SimpleStringProperty(ID);
        this.Name = new SimpleStringProperty(Name);
    }

    public String getID() {
        return ID.get();
    }

    /*public void setID(String ID) {
        this.ID = new SimpleStringProperty(ID);
    }*/

    public String getName() {
        return Name.get();
    }

   /* public void setName(String Name) {
        this.Name = new SimpleStringProperty(Name);
    }*/
    
    
    
}
