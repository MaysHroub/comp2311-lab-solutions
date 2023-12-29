package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ResizableChess extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		final int width = 400, height = 400;
		final int n = 8;
		
		Pane board = new Pane();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Rectangle square = new Rectangle();
				
				// bind its x and y coordinates with the pane's width and height
				square.xProperty().bind(board.widthProperty().divide(n).multiply(j));
				square.yProperty().bind(board.heightProperty().divide(n).multiply(i));
				
				// bind its width and height with the pane's width and height
				square.widthProperty().bind(board.widthProperty().divide(n));
				square.heightProperty().bind(board.heightProperty().divide(n));
				
				// setting the sqaure's colour
				square.setFill( ((i + j) % 2 == 0) ? Color.WHITE : Color.BLACK );
				
				board.getChildren().add(square);
			}
		}
		
		Scene scene = new Scene(board, width, height);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Chess");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}


















