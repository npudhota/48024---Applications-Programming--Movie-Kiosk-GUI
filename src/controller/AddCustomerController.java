package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Kiosk;

public class AddCustomerController extends Controller<Kiosk> {

    @FXML
    private TextField textID;
    @FXML
    private TextField textName;
    @FXML
    private TextField textBalance;
    @FXML
    private Text feedback;
    @FXML
    private Button buttonAdd;

    @FXML
    public void initialize() {

        buttonAdd.disableProperty().bind(Bindings.or(textID.textProperty().isEmpty(), //check all the fields are filled or not
                Bindings.or(textName.textProperty().isEmpty(), textBalance.textProperty().isEmpty())));
    }

    public Kiosk getKiosk() {

        return model;
    }

    public void addCustomer(ActionEvent event) {   //allow to add customer
        try {
            int potentialID = Integer.parseInt(textID.getText());   //get ID from field and parse it into Int

            if (model.getCustomer(potentialID) == null) {

                model.addCustomer(potentialID, textName.getText(), Integer.parseInt(textBalance.getText()));

                feedback.setText("Customer added to Kiosk.");  //label 
            } else {

                feedback.setText("ID already in use.");
            }

        } catch (Exception e) {

            feedback.setText("ID and Balance must be numeric."); //if user enter data other then numeric
        }
    }

    public void close(ActionEvent event) {  //close the screen
        stage.close();
    }

}
