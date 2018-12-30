package employee;

/**
 *
 * @author PontusN
 */
public class Competency {
    private int competencyID;
    private String competencyTitle;
    private String competencyDescription;

    public Competency(int competencyID, String competencyTitle, String competencyDescription) {
        this.competencyID = competencyID;
        this.competencyTitle = competencyTitle;
        this.competencyDescription = competencyDescription;
    }

    public int getCompetencyID() {
        return competencyID;
    }

    public void setCompetencyID(int competencyID) {
        this.competencyID = competencyID;
    }

    public String getCompetencyTitle() {
        return competencyTitle;
    }

    public void setCompetencyTitle(String competencyTitle) {
        this.competencyTitle = competencyTitle;
    }

    public String getCompetencyDescription() {
        return competencyDescription;
    }

    public void setCompetencyDescription(String competencyDescription) {
        this.competencyDescription = competencyDescription;
    }
    
    public void clone(Competency toClone){
        toClone.setCompetencyID(this.competencyID);
        toClone.setCompetencyTitle(this.competencyTitle);
        toClone.setCompetencyDescription(this.competencyDescription);
    }
    
    
}
