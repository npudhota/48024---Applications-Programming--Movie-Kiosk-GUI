package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import model.Catalogue;
import model.Movie;

public class ShowAllMoviesController extends Controller<Catalogue> {

    @FXML
    private TableView<Movie> movies;

    @FXML
    public void initialize() {

        movies.setItems(model.getAllMovies()); //get all movies and list them in table

        //use lambda method instead of action listener so table will update when a movie is added
        model.getAvailableMovies().addListener((ListChangeListener<Movie>) (c -> {

            movies.setItems(model.getAllMovies());
        }));
    }

    public Catalogue getCatalogue() {

        return model;
    }

    public void exit(ActionEvent event) {

        stage.close();
    }
}
