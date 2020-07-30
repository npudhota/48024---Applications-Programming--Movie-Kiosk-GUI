import au.edu.uts.ap.javafx.ViewLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Kiosk;

public class KioskApplication extends Application {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Kiosk kiosk = new Kiosk();
		ViewLoader.showStage(kiosk, "/view/Kiosk.fxml", "Movie Kiosk - Main Menu", stage);

	}

}
