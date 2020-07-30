package controller;

import java.io.IOException;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import model.Kiosk;

public class KioskController extends Controller<Kiosk> {
	
	@FXML
	public void initialize() {

	}

	public final Kiosk getKiosk() {
		
            return model;
	}

	// display the corresponding stage of each button on click
	public void showAdmin(ActionEvent event) throws IOException {
	
            ViewLoader.showStage(model, "/view/Admin.fxml", "Administration Menu", new Stage());
	}

	public void showCatalogue(ActionEvent event) throws IOException {
		
            ViewLoader.showStage(model.getCatalogue(), "/view/Catalogue.fxml", "Catalogue", new Stage());
	}

	public void showCustRecords(ActionEvent event) throws IOException {
		
            ViewLoader.showStage(model, "/view/CustomerRecord.fxml", "Patron Record", new Stage());

	}

	public void showTopUp(ActionEvent event) throws IOException {
	
            ViewLoader.showStage(model, "/view/TopUpAccount.fxml", "Account Top-up", new Stage());
	}

	public void showFavourites(ActionEvent event) throws IOException {
		
            ViewLoader.showStage(model, "/view/FavouriteMovies.fxml", "Favourites", new Stage());
	}

	public void quit() {
	
            Platform.exit();
	}

}
