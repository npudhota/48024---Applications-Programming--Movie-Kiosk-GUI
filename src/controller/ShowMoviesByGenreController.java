package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Catalogue;
import model.Genre;
import model.Movie;

public class ShowMoviesByGenreController extends Controller<Catalogue> {

    @FXML
    private ListView<Genre> genres;
    @FXML
    private TableView<Movie> movies;
    @FXML
    private Button displayButton;
    @FXML
    private VBox movieTable;

    @FXML
    public void initialize() {
        
        displayButton.disableProperty().bind(genres.getSelectionModel().selectedItemProperty().isNull()); //disable button if genre is not selected
       
        HBox.setHgrow(movieTable, Priority.ALWAYS);
    }

    public Catalogue getCatalogue() {
        
        return model;
    }

    public void loadMovies(ActionEvent event) {
       
        movies.setItems(model.getMoviesInGenre(genres.getSelectionModel().getSelectedItem()));
    }

    public void exit(ActionEvent event) {
      
        stage.close();
    }

}
