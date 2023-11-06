package Classes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fernanda Garcia
 * This class serves as a template for generating medical form instances.
 */
public class MedicalForm {
    private static List<MedicalForm> forms = new ArrayList<> (); //i had to creat this, otherwise i would get an error to Get.
    /** Variable to compute the Last, and First name */
    private String name;
    /** Variable to compute the date of birth */
    private int dob;
    /** Variable to compute the address */
    private String address;
    /** Variable to compute condition */
    private String condition;
    /** Variable to compute Alien Number */
    private int alienNumber;
    /** Variable to compute date when the condition started */
    private int dateWhenConditionStarted;
    /** Variable to compute the phone number */
    private int phoneNumber;
    /** Variable to check submission */
    private boolean submit;
    /** Variable to compute form Id. */
    private int formId;
    /** Variable to compute the status of the form */
    private String status;
    /** Static variable to keep track of the next ID in case the patient needs to create a new form */
    static private int nextID = 0;
    /**
     * Constructor to initialize a new medicalForm object.
     */
    public MedicalForm ( String name, int dob, String address, String condition, int alienNumber, int dateWhenConditionStarted ) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.condition = condition;
        this. alienNumber = alienNumber;
        this.dateWhenConditionStarted = dateWhenConditionStarted;
        this.formId = nextID++;
        this.status="New";
    }
    /**
     * Static method to create a new medicalForm object and increment nextID, the nextID starts at 0..
     * @return String message indicating that the new form has been created.
     */
    static public String createNewForm(String name, int dob, String address, String condition, int alienNumber) {
        MedicalForm form = new MedicalForm (name, dob, address, condition, alienNumber, nextID);
        //Add form to database
        return "New Form has been created" + form.formId;
    }
    /**
     * Method to submit the medical form.
     * @return true if successful, false otherwise.
     */
    public boolean submitForm() {
        // Implementation here
        return true;
    }
    /**
     * Method to verify will be used later on to check if the information of the form was valid.
     * @return true if successful, false otherwise.
     */
    public boolean verifyForm() {
        // Implementation here
        return true;
    }
    /**
     * Method created in case the patient wants to update the medical form.
     * @return String message indicating the status of the form, if it was updated or not.
     */
    public String updateForm() {
        // Implementation here
        return "Updated";
    }
    /**
     * Method to delete the medical form.
     * @return true if successful, false otherwise.
     */
    public boolean deleteForm() {
        // Implementation here
        return true;
    }
    /**
     * Method to get a medical form by its ID.
     * @param formId The ID of the medical form to get.
     * @return medicalForm object.
     */
    public static MedicalForm getForm(int formId) {
        return forms.get(formId);
    }
    /**
     * Method to change the status of the medical form.
     * @param StatusChange The new status to be set.
     * @return String message indicating what the new status is.
     */
    public String changeStatus(String StatusChange) {
        // Change the status of the form
        this.status = StatusChange;
        return "Status will change to: " + StatusChange;
    }

}