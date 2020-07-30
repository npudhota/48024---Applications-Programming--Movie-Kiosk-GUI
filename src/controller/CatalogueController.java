package controller;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Catalogue;

public class CatalogueController extends Controller<Catalogue> {

    @FXML
    public void initialize() {

    }

    public Catalogue getCatalogue() {

        return model;
    }

    //by clicking on  each button the view of respected button is shown to user
    public void showAllMovies(ActionEvent event) throws IOException {  //movie menu left side buttons

        ViewLoader.showStage(model, "/view/ShowAllMovies.fxml", "All Movies", new Stage());
    }

    public void showAvailableMovies(ActionEvent event) throws IOException {

        ViewLoader.showStage(model, "/view/ShowAvailableMovies.fxml", "Available Movies", new Stage());
    }

    public void showMoviesByGenre(ActionEvent event) throws IOException {

        ViewLoader.showStage(model, "/view/ShowMoviesByGenre.fxml", "Movies By Genre", new Stage());
    }

    public void showMoviesByYear(ActionEvent event) throws IOException {

        ViewLoader.showStage(model, "/view/ShowMoviesByYear.fxml", "Movies By Year", new Stage());
    }

    //rent and return buttons
    public void rentMovie(ActionEvent event) throws IOException {

        ViewLoader.showStage(model, "/view/RentMovie.fxml", "Rent a Movie", new Stage());
    }

    public void returnMovie(ActionEvent event) throws IOException {

        ViewLoader.showStage(model, "/view/ReturnMovie.fxml", "Return a Movie", new Stage());
    }

    public void exit(ActionEvent event) {

        stage.close();
    }

}
