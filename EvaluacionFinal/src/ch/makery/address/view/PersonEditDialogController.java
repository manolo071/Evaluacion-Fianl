package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;

/**
 * Dialog to edit details of a person.
 * 
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    @FXML
    private TextField NombreField;
    @FXML
    private TextField ApellidoField;
    @FXML
    private TextField CalleField;
    @FXML
    private TextField CodigopostalField;
    @FXML
    private TextField CiudadField;
    @FXML
    private TextField NacimientoField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        NombreField.setText(person.getNombre());
        ApellidoField.setText(person.getApellido());
        CalleField.setText(person.getCalle());
        CodigopostalField.setText(Integer.toString(person.getCodigopostal()));
        CiudadField.setText(person.getCiudad());
        NacimientoField.setText(DateUtil.format(person.getNacimiento()));
        NacimientoField.setPromptText("dd.mm.yyyy");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setNombre(NombreField.getText());
            person.setApellido(ApellidoField.getText());
            person.setCalle(CalleField.getText());
            person.setCodigopostal(Integer.parseInt(CodigopostalField.getText()));
            person.setCiudad(CiudadField.getText());
            person.setNacimiento(DateUtil.parse(NacimientoField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (NombreField.getText() == null || NombreField.getText().length() == 0) {
            errorMessage += "No valid Nombre!\n"; 
        }
        if (ApellidoField.getText() == null || ApellidoField.getText().length() == 0) {
            errorMessage += "No valid apellido!\n"; 
        }
        if (CalleField.getText() == null || CalleField.getText().length() == 0) {
            errorMessage += "No valid street!\n"; 
        }

        if (CodigopostalField.getText() == null || CodigopostalField.getText().length() == 0) {
            errorMessage += "No valid Codigo postal!\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(CodigopostalField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Codigo posta (must be an integer)!\n"; 
            }
        }

        if (CiudadField.getText() == null || CiudadField.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (NacimientoField.getText() == null || NacimientoField.getText().length() == 0) {
            errorMessage += "No valid Nacimiento!\n";
        } else {
            if (!DateUtil.validDate(NacimientoField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}