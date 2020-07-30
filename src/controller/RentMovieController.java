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

public class RentMovieController extends Controller<Catalogue> {

    @FXML
    private TextField textID;
    @FXML
    private Button buttonID;
    @FXML
    private TableView<Movie> movies;
    @FXML
    private Button rentButton;
    @FXML
    private Text feedback;

    private Customer customer;

    @FXML
    public void initialize() {
        
        buttonID.disableProperty().bind(textID.textProperty().isEmpty());
        
        rentButton.disableProperty().bind(movies.getSelectionModel().selectedItemProperty().isNull());
    }

    public Catalogue getCatalogue() {
       
        return model;
    }

    public void setCustomer(ActionEvent event) { //customer to which movie will be rented
      
        try {
        
            customer = model.getCustomer(Integer.parseInt(textID.getText()));
            
            if (customer != null) {
            
                movies.setItems(model.getAvailableMovies());
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

    public void rentMovie(ActionEvent event) {  //allow to rent movies
      
        if (model.rentMovieToCustomer(movies.getSelectionModel().getSelectedItem(), customer)) {
          
            feedback.setText("Movie Rented.");
        } 
        
        else {
           
            feedback.setText("Insufficient funds.");
        }
    }

    public void close(ActionEvent event) {
      
        stage.close();
    }

}
