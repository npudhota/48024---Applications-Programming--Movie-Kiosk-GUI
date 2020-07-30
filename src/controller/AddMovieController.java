package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Catalogue;

public class AddMovieController extends Controller<Catalogue> {

    @FXML
    private TextField textTitle;
    @FXML
    private TextField textYear;
    @FXML
    private TextField textGenre;
    @FXML
    private TextField textPrice;
    @FXML
    private Text feedback;
    @FXML
    private Button buttonAdd;

    @FXML
    public void initialize() {

        buttonAdd.disableProperty() //check whether all fields are filled or not
                .bind(Bindings.or(textTitle.textProperty().isEmpty(), Bindings.or(textYear.textProperty().isEmpty(),
                        Bindings.or(textGenre.textProperty().isEmpty(), textPrice.textProperty().isEmpty()))));
    }

    public Catalogue getCatalogue() {

        return model;
    }

    public void addMovie(ActionEvent event) {

        try {
            model.addMovie(textTitle.getText(), Integer.parseInt(textYear.getText()), textGenre.getText(), Integer.parseInt(textPrice.getText()));

            feedback.setText("Movie added to Catalogue.");

        } catch (Exception e) {

            feedback.setText("Year and Price must be numeric.");

        }

    }

    public void close(ActionEvent event) {
       
        stage.close();
    }

}
