package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import model.Customer;
import model.Kiosk;

public class RemoveCustomerController extends Controller<Kiosk> {

    @FXML
    private TableView<Customer> customers;
    @FXML
    private Button removeButton;

    @FXML
    public void initialize() {
        
        removeButton.disableProperty().bind(customers.getSelectionModel().selectedItemProperty().isNull());
    }

    public Kiosk getKiosk() {
        
        return model;
    }

    public void remove(ActionEvent event) { //remove customer from the db
        
        model.removeCustomer(customers.getSelectionModel().getSelectedItem());
    }

    public void exit(ActionEvent event) {
        
        stage.close();
    }
}
