package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Act3 extends Application {

	final int N = 3, MASK = 1;
//	private int turn = 1;
	private boolean turn = true; 
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		GridPane layout = new GridPane();
		layout.setStyle("-fx-background-color: #2C2C2C");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Label label = new Label();
				label.setOnMouseClicked(e -> {
					if (!label.getText().equals("")) return;
					label.setText((turn) ? "1" : "0");
					turn = !turn;
//					turn ^= MASK;
				});
				label.setStyle("-fx-font-size: 40px; -fx-text-fill: white; -fx-border-color: orange; -fx-border-width: 4;");
				label.prefHeightProperty().bind(layout.heightProperty().divide(N));
				label.prefWidthProperty().bind(layout.widthProperty().divide(N));
				label.setAlignment(Pos.CENTER);
				layout.add(label, i, j);
			}
		}

		Scene scene = new Scene(layout, 400, 400);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Dummy tic-tac-toe");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
