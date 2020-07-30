package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Catalogue;
import model.Customer;
import model.Movie;

public class ReturnMovieController extends Controller<Catalogue> {

    @FXML
    private TextField textID;
    @FXML
    private Button buttonID;
    @FXML
    private TableView<Movie> movies;
    @FXML
    private Text feedback;

    @FXML
    private Button returnButton;

    private Customer customer;

    @FXML
    public void initialize() {
        buttonID.disableProperty().bind((textID.lengthProperty()).isEqualTo(0));

        
        returnButton.disableProperty().bind(movies.getSelectionModel().selectedItemProperty().isNull());  //disable return if there is no movie is rented

    }

    public Catalogue getCatalogue() {
        
        return model;
    }

    public void loadMovies(ActionEvent event) { //load all movies the customer rented
        
        try {
        
            customer = model.getCustomer(Integer.parseInt(textID.getText()));
            
            if (customer != null) {
            
                movies.setItems(customer.currentlyRented());
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

    public void returnMovie(ActionEvent event) { //allow to return movies
        
        model.returnMovieFromCustomer(movies.getSelectionModel().getSelectedItem(), customer);
        
        feedback.setText("Movie Returned.");
    }

    public void close(ActionEvent event) {
        
        stage.close();
    }

}
