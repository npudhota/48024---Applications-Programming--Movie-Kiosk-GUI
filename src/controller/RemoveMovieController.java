package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import model.Catalogue;
import model.Movie;

public class RemoveMovieController extends Controller<Catalogue> {

    @FXML
    private TableView<Movie> movies;
    @FXML
    private Button removeButton;

    @FXML
    public void initialize() {
       
        removeButton.disableProperty().bind(movies.getSelectionModel().selectedItemProperty().isNull());
    }

    public Catalogue getCatalogue() {
        
        return model;
    }

    public void remove(ActionEvent event) { //remove movie from the db
        
        model.removeMovie(movies.getSelectionModel().getSelectedItem());
    }

    public void exit(ActionEvent event) {
        
        stage.close();
    }

}
