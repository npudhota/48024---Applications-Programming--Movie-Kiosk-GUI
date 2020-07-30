package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.Catalogue;

public class ShowAvailableMoviesController extends Controller<Catalogue> {

    @FXML
    public void initialize() {

    }

    public Catalogue getCatalogue() {
       
        return model;
    }

    public void exit(ActionEvent event) {
       
        stage.close();
    }
}
