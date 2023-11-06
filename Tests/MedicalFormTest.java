package Tests;

/**
 * @author Fernanda Garcia
 * Imports
 */
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import Classes.MedicalForm;

/**
 * Used to test MedicalForm.java
 */
public class MedicalFormTest {
    private MedicalForm form1 = new MedicalForm ( "Garcia Fernanda", 1994, "Fairfax,Virginia", "Tuberculosis", 21, 2014 );
    private MedicalForm form2 = new MedicalForm ( "Tejada Elon", 2020, "Manassas, Virginia", "Hepatitis", 5, 2019 );
    private MedicalForm form3 = new MedicalForm ( "Messi Leo", 1989, "Chantilly, Virginia", "Measles", 3, 2000 );
    private MedicalForm form4 = new MedicalForm ( "1", -5, "", "", -5, -1 );  // this has to fail

// this test will allow me to create the forms
    @Test
    public void createNewForm() {
        // Test creating forms with the info above
        String test1 = MedicalForm.createNewForm("Garcia Fernanda", 1994, "Fairfax, Virginia", "Tuberculosis", 21);
        assertEquals("New Form has been created, 1", test1);

        String test2 = MedicalForm.createNewForm("Tejada Elon", 2020, "Manassas, Virginia", "Hepatitis", 5);
        assertEquals("New Form has been created, 2", test2);

        String test3 = MedicalForm.createNewForm("Messi Leo", 1989, "Chantilly, Virginia", "Measles", 3);
        assertEquals("New Form has been created, 3", test3);

        String test4 = MedicalForm.createNewForm("1", -5, "", "", -5);
        assertNotEquals("New Form has  been created, 4", test4);  // The test will pass, but will fail when we verify
    }
// this will check if the form is valid to be sent for submission
    @Test
    public void verifyForm() {
        MedicalForm form1 = MedicalForm.getForm(1);
        assertTrue(form1.verifyForm()); //should pass

        MedicalForm form2 = MedicalForm.getForm(2);
        assertTrue(form2.verifyForm()); // should pass

        MedicalForm form3 = MedicalForm.getForm(3);
        assertTrue(form3.verifyForm()); // should pass

        MedicalForm form4 = MedicalForm.getForm(4);
        assertFalse(form4.verifyForm()); // this should fail
    }

    @Test
    public void submitForm() {
        boolean test1 = form1.submitForm();
        assertTrue(test1);

        boolean test2 = form2.submitForm();
        assertTrue(test2);

        boolean test3 = form3.submitForm();
        assertTrue(test3);

        // again, needs to fail
        boolean test4 = form4.submitForm();
        assertFalse(test4);
    }
    @Test
    public void updateForm() {
        MedicalForm form1 = MedicalForm.getForm(1); // Replace with your actual method to get the form by ID
        String test1 = form1.updateForm();
        assertEquals("Updated", test1);

        MedicalForm form2 = MedicalForm.getForm(2);
        String test2 = form2.updateForm();
        assertEquals("Updated", test2);

        MedicalForm form4 = MedicalForm.getForm(4);
        String test4 = form2.updateForm();
        assertEquals("Updated", test4);

    }

    @Test
    public void deleteForm() {
        MedicalForm form1 = MedicalForm.getForm(0); // Replace with your actual method to get the form by ID
        boolean test1 = form1.deleteForm();
        assertTrue(test1);

        MedicalForm form2 = MedicalForm.getForm(1);
        boolean test2 = form2.deleteForm();
        assertTrue(test2);

    }

    @Test
    public void changeStatus() {
        MedicalForm form1 = MedicalForm.getForm(0); // Replace with your actual method to get the form by ID
        String test1 = form1.changeStatus("Submitted");
        assertEquals("Status will change to: Submitted", test1);

        MedicalForm form2 = MedicalForm.getForm(1);
        String test2 = form2.changeStatus("Processing");
        assertEquals("Status will change to: Processing", test2);

    }
}