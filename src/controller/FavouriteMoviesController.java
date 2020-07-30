package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Customer;
import model.Kiosk;
import model.Movie;

public class FavouriteMoviesController extends Controller<Kiosk> {

    @FXML
    private TextField textID;
    @FXML
    private TableView<Movie> movies;
    @FXML
    private Button buttonID;
    @FXML
    private Text feedback;

    @FXML
    public void initialize() {

        buttonID.disableProperty().bind(textID.textProperty().isEmpty());
    }

    public Kiosk getKiosk() {

        return model;
    }

    public void loadMovies(ActionEvent event) { //get fav movies of the customer
       
        try {
        
            Customer c = model.getCustomer(Integer.parseInt(textID.getText()));
            
            c = model.getCustomer(Integer.parseInt(textID.getText()));
            
            if (c != null) {
            
                movies.setItems(c.favouriteMovies());
            } 
            
            else {
               
                feedback.setText("ID does not exist.");
                
                movies.setItems(null);
            }
        }
        catch (Exception e) {
        
            feedback.setText("Invalid ID.");
            
            movies.setItems(null);
        }
    }

    public void close(ActionEvent event) {
       
        stage.close();
    }

}
