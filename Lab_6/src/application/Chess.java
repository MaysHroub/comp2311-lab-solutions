package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Chess extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		final int width = 400, height = 400;
		final int n = 8;

		GridPane board = new GridPane();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) 
				board.add(new Rectangle(width / n, height / n,
						((i + j) % 2 == 0) ? Color.WHITE : Color.BLACK), i, j);

		Scene scene = new Scene(board, width, height);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Chess Board");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
