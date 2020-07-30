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

public class CustomerRecordController extends Controller<Kiosk> {

    @FXML
    private TextField textID;
    @FXML
    private Button buttonID;
    @FXML
    private Text customerDetails;
    @FXML
    private TableView<Movie> rentedMovies;
    @FXML
    private TableView<Movie> rentingHistory;

    @FXML
    public void initialize() {

        buttonID.disableProperty().bind(textID.textProperty().isEmpty());  //check whether all the fields are completed or not
    }

    public Kiosk getKiosk() {

        return model;
    }

    public void loadMovies(ActionEvent event) { //will load all the movies of that customer

        try {
           
            Customer c = model.getCustomer(Integer.parseInt(textID.getText()));  //get customer model against the ID
            
            if (c != null) {  //if not empty
            
                customerDetails.setText(c.toString());  //set text of specific customer from customer object
                
                rentedMovies.setItems(c.currentlyRented());
                
                rentingHistory.setItems(c.rentingHistory());
            } 
            
            else { 
                
                customerDetails.setText("ID does not exist.");
                
                rentedMovies.setItems(null);  //id not exist so no rented movies and also no history
                
                rentingHistory.setItems(null);
            }
        } 
        catch (Exception e) {
        
            customerDetails.setText("Invalid ID.");
        }

    }

    public void close(ActionEvent event) {
        
        stage.close();
    }

}
