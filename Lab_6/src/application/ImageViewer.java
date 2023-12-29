package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;


public class ImageViewer extends Application {
	@Override
	public void start(Stage primaryStage) {
		ImageView iv = new ImageView("cat.jpg");
		StackPane root = new StackPane(iv);
		
		iv.setPreserveRatio(true);
		iv.fitHeightProperty().bind(root.heightProperty()); 
		iv.fitWidthProperty().bind(root.widthProperty());

		Scene scene = new Scene(root, 400, 500);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
