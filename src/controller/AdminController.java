package controller;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Kiosk;

public class AdminController extends Controller<Kiosk> {

    @FXML
    public void initialize() {

    }

    public Kiosk getKiosk() {

        return model;
    }

    public void customerViewAll(ActionEvent event) throws IOException {  //buttons for the customer menu

        ViewLoader.showStage(model, "/view/ShowAllCustomers.fxml", "Show All Customers", new Stage());
    }

    public void customerAdd(ActionEvent event) throws IOException {

        ViewLoader.showStage(model, "/view/AddCustomer.fxml", "Add Customer", new Stage());
    }

    public void customerRemove(ActionEvent event) throws IOException {

        ViewLoader.showStage(model, "/view/RemoveCustomer.fxml", "Remove Customer", new Stage());
    }

    public void movieViewAll(ActionEvent event) throws IOException { //buttons for the movie menu

        ViewLoader.showStage(model.getCatalogue(), "/view/ShowAllMovies.fxml", "Show All Movies", new Stage());
    }

    public void movieAdd(ActionEvent event) throws IOException {

        ViewLoader.showStage(model.getCatalogue(), "/view/AddMovie.fxml", "Add Movie", new Stage());
    }

    public void movieRemove(ActionEvent event) throws IOException {

        ViewLoader.showStage(model.getCatalogue(), "/view/RemoveMovie.fxml", "Remove Movie", new Stage());
    }

    public void exit(ActionEvent event) {

        stage.close();
    }

}
