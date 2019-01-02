/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.util.Calendar;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author PontusN
 */
public class CompetencyValidity {
    
    //private int empID;
    private int competencyID;
    private SimpleStringProperty CompName;
    private SimpleStringProperty CompDescription;
    private SimpleStringProperty validFrom;
    private SimpleStringProperty validUntil;

    public CompetencyValidity(/*int empID,*/ int competencyID, String CompName, String CompDesc, String validFrom, String validUntil) {
      //  this.empID = empID;
        this.competencyID = competencyID;
        this.CompName = new SimpleStringProperty(CompName);
        this.CompDescription = new SimpleStringProperty(CompDesc);
        this.validFrom = new SimpleStringProperty(validFrom);
        this.validUntil = new SimpleStringProperty(validUntil);
    }

   /* public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }*/
    
    public int getCompetencyID() {
        return competencyID;
    }

    public void setCompetencyID(int competencyID) {
        this.competencyID = competencyID;
    }

    public String getCompName() {
        return CompName.get();
    }

    public void setCompName(String CompName) {
        this.CompName = new SimpleStringProperty(CompName);
    }

    public String getCompDescription() {
        return CompDescription.get();
    }

    public void setCompDescription(String CompDescription) {
        this.CompDescription = new SimpleStringProperty(CompDescription);
    }

    public String getValidFrom() {
        return validFrom.get();
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = new SimpleStringProperty(validFrom);
    }

    public String getValidUntil() {
        return validUntil.get();
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = new SimpleStringProperty(validUntil);
    }

    

    
    
    
    
}
