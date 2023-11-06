package Classes;
/**
 * Imports
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hanna Mendoza-Garcia
 * Workflow stores and gives Data Entry and Approver the next available medical form ID to work on.
 * Database passes medical form IDs to the Workflow.
 * Can also be used by approver to retrieve next steps message.
 */
public class Workflow {
    private static Queue<Integer> completeQueue = new LinkedList<>(); //Stores completed medical form IDs
    private static Queue<Integer> savedQueue = new LinkedList<>();; //Stores saved medical form IDs
    private static ArrayList<String[]> nextStepsList = new ArrayList<>(); //Stores medical conditions and next steps messages available
    private static boolean savedEmpty; //Indicates whether the savedQueue is empty or not
    private static boolean completeEmpty; //Indicates whether the completeQueue is empty or not

    /**
     * Removes and returns the next completed medical form ID available in the completeQueue.
     * @return next completed medical form ID or -1 if completeQueue is empty/unsuccessful
     */
    public static int getNextComplete() {
        return 0;
    }

    /**
     * Removes and returns the next saved medical form ID available in the savedQueue.
     * @return next saved medical form ID or -1 if savedQueue is empty/unsuccessful
     */
    public static int getNextSaved() {
        return 0;
    }

    /**
     * Checks if savedQueue is empty.
     * @return true if savedQueue is empty, false otherwise
     */
    public static boolean isSavedEmpty() {
        return false;
    }

    /**
     * Checks if completeQueue is empty.
     * @return true if completeQueue is empty, false otherwise
     */
    public static boolean isCompleteEmpty() {
        return false;
    }

    /**
     * Inserts complete medical form ID to completeQueue.
     * @param form completed medical form whose ID will be inserted
     * @return true if insert is successful, false otherwise
     */
    public static boolean insertComplete(MedicalForm form) {
        return false;
    }

    /**
     * Inserts saved medical form ID to savedQueue.
     * @param form saved medical form whose ID will be inserted
     * @return true if insert is successful, false otherwise
     */
    public static boolean insertSaved(MedicalForm form) {
        return false;
    }

    /**
     * Returns corresponding next steps message based on inputted medical condition.
     * @param condition medical condition 
     * @return corresponding next steps message or empty String if none is available for that medical condition
     */
    public static String getNextStepsMessage(String condition) {
        return "None available";
    }

    /**
     * Inserts a new medical condition along with its corresponding next steps message to nextStepsList.
     * Should fail if medical condition is already inserted.
     * @param condition medical condition
     * @param message corresponding next steps message
     * @return true if insert is successful, false otherwise
     */
    public static boolean insertNextSteps(String condition, String message) {
        return false;
    }

    /**
     * Removes an existing medical condition along with its corresponding next steps message from nextStepsList.
     * Should fail if medical condition is not found.
     * @param condition medical condition
     * @return true if successful, false otherwise
     */
    public static boolean removeNextSteps(String condition) {
        return false;
    }
}
