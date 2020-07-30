package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Customer;
import model.Kiosk;

public class TopUpAccountController extends Controller<Kiosk> {

    @FXML
    private TextField textID;
    @FXML
    private TextField textAmount;
    @FXML
    private Text feedback;
    @FXML
    private Button buttonTopUp;

    @FXML
    public void initialize() {
        
        buttonTopUp.disableProperty().bind(Bindings.or(textID.textProperty().isEmpty(), textAmount.textProperty().isEmpty()));
    }

    public Kiosk getKiosk() {
       
        return model;
    }

    public void topUp(ActionEvent event) {
        
        try {
        
            Customer c = model.getCustomer(Integer.parseInt(textID.getText()));
            
            if (c != null) {
            
                model.topUpAccount(c, Integer.parseInt(textAmount.getText()));
                
                feedback.setText("Transaction Complete.");
            } 
            
            else {
            
                feedback.setText("ID does not exist.");
            }
        } 
        
        catch (Exception e) {
        
            feedback.setText("ID and Amount must be numeric.");
        }

    }

    public void close(ActionEvent event) {
       
        stage.close();
    }
}
