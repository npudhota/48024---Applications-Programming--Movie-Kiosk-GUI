package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Kiosk;

public class ShowAllCustomersController extends Controller<Kiosk> {

    @FXML
    public void initialize() {

    }

    public Kiosk getKiosk() {
        
        return model;
    }

    public void exit(ActionEvent event) {
        
        stage.close();
    }

}
