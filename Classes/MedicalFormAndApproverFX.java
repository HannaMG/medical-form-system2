package gmu.cs321;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MedicalFormAndApproverFX extends Application {

    private TextField nameTextField = new TextField();
    private TextField dobTextField = new TextField();
    private TextField addressTextField = new TextField();
    private TextField alienNumberTextField = new TextField();
    private ComboBox<String> conditions = new ComboBox<>();
    private TextField phoneNumberField = new TextField();
    private TextField conditionStartDateField = new TextField();

    @Override
    public void start(Stage primaryStage) {
        login(primaryStage);
    }

    private void login(Stage primaryStage) {
        Stage loginStage = new Stage();
        VBox loginLayout = new VBox(5);
        loginLayout.setPadding(new Insets(10));

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login To Your Medical Form");

        loginLayout.getChildren().addAll(
                new Label("Enter you Username:"),
                usernameField,
                new Label("Enter you Password:"),
                passwordField,
                loginButton
        );

        loginButton.setOnAction(e -> {
            loginStage.close();
            showMainForm(primaryStage);
        });

        Scene loginScene = new Scene(loginLayout, 350, 200);
        loginStage.setScene(loginScene);
        loginStage.show();
    }

    private void showMainForm(Stage primaryStage) {
        GridPane panel = new GridPane();
        panel.setVgap(5);
        panel.setHgap(5);
        panel.setPadding(new Insets(10));

        VBox loginLayout = new VBox(5);
        loginLayout.setPadding(new Insets(10));

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login To Your Medical Form");

        loginLayout.getChildren().addAll(
                new Label("Name"),
                nameTextField,


                new Label("DOB (dd/mm/yyyy)"),
                dobTextField,

                new Label("Address:"),
                addressTextField,

                new Label("Alien Number:"),
                alienNumberTextField,

                new Label("Condition Start Date (dd/mm/yyyy)"),
                conditionStartDateField,

                new Label("Phone Number:"),
                phoneNumberField

        );

        Scene loginScene = new Scene(loginLayout, 550, 400);


        Button submitButton = createSubmitButton();
        Button deleteButton = createDeleteButton();
        Button newFormButton = createNewFormButton();
        Button saveButton = createSaveButton();

        panel.add(loginLayout,0,0);
        panel.add(submitButton, 0, 9);
        panel.add(deleteButton, 1, 9);
        panel.add(newFormButton, 2, 9);
        panel.add(saveButton, 3, 9);

        Scene scene = new Scene(panel, 550, 450);
        primaryStage.setTitle("Medical Form");
        primaryStage.setScene(scene);
        primaryStage.show();

        ComboBox<String> diseaseComboBox = new ComboBox<>();
        diseaseComboBox.setPromptText("Medical Condition:");
        diseaseComboBox.getItems().addAll(
                "Turbecolosis",
                "HIV/AIDS",
                "Malaria",
                "Zika Virus",
                "Measles",
                "Hepatitis",
                "Chickenpox"
        );
        diseaseComboBox.setOnAction(e -> {
            String selectedDisease = diseaseComboBox.getValue();
            System.out.println("Medical Condition: " + selectedDisease);
        });

        panel.add(new Label("Medical Condition:"), 0, 8);
        panel.add(diseaseComboBox, 1, 8);
    }

    private Button createSubmitButton() {
        Button submitButton = new Button("Submit Form");
        submitButton.setOnAction(e -> showFormDataScreen());
        return submitButton;
    }

    private Button createDeleteButton() {
        Button deleteButton = new Button("Delete Form");
        deleteButton.setOnAction(e -> resetFormFields());
        return deleteButton;
    }

    private Button createNewFormButton() {
        Button newFormButton = new Button("Create New Form");
        newFormButton.setOnAction(e -> resetFormFields());
        return newFormButton;
    }

    private Button createSaveButton() {
        Button saveButton = new Button("Save Form");
        saveButton.setOnAction(e -> printFormData());
        return saveButton;
    }

    private void resetFormFields() {
        nameTextField.clear();
        dobTextField.clear();
        addressTextField.clear();
        alienNumberTextField.clear();
        conditions.getSelectionModel().clearSelection();
        phoneNumberField.clear();
        conditionStartDateField.clear();
        System.out.println("Form has been reset.");
    }

    private void showFormDataScreen() {
        Alert formDataAlert = new Alert(Alert.AlertType.INFORMATION);
        formDataAlert.setTitle("Submitted Form Data");
        formDataAlert.setHeaderText("Enter the information below");

        StringBuilder formDataBuilder = new StringBuilder();
        formDataBuilder.append("Name: ").append(nameTextField.getText()).append("\n");
        formDataBuilder.append("DOB: ").append(dobTextField.getText()).append("\n");
        formDataBuilder.append("Address: ").append(addressTextField.getText()).append("\n");
        formDataBuilder.append("Alien Number: ").append(alienNumberTextField.getText()).append("\n");
        formDataBuilder.append("Medical Condition: ").append(conditions.getValue()).append("\n");
        formDataBuilder.append("Phone Number: ").append(phoneNumberField.getText()).append("\n");
        formDataBuilder.append("Condition Start Date: ").append(conditionStartDateField.getText()).append("\n");

        String formData = formDataBuilder.toString();
        formDataAlert.setContentText(formData);

        formDataAlert.showAndWait();
    }

    private void printFormData() {
        System.out.println("Name: " + nameTextField.getText());
        System.out.println("DOB: " + dobTextField.getText());
        System.out.println("Address: " + addressTextField.getText());
        System.out.println("Alien Number: " + alienNumberTextField.getText());
        System.out.println("Medical Condition: " + conditions.getValue());
        System.out.println("Phone Number: " + phoneNumberField.getText());
        System.out.println("Condition Start Date: " + conditionStartDateField.getText());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
