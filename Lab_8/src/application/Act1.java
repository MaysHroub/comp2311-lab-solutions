package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Act1 extends Application {

	class MovingHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			if (event.getSource() == upBtn) {
				if (ball.getCenterY() < RADIUS) return;
				ball.setCenterY(ball.getCenterY() - 5);				
			}
			if (event.getSource() == downBtn) {
				if (ball.getCenterY() > layout.getHeight() - RADIUS) return;
				ball.setCenterY(ball.getCenterY() + 5);
			}
			if (event.getSource() == rightBtn) {
				if (ball.getCenterX() > layout.getWidth() - RADIUS) return;
				ball.setCenterX(ball.getCenterX() + 5);	
			}
			if (event.getSource() == leftBtn) {
				if (ball.getCenterX() < RADIUS) return;
				ball.setCenterX(ball.getCenterX() - 5);				
			}
		}
	}
	
	final int WIDTH = 500, HEIGHT = 400, RADIUS = 30;
	private Button upBtn;
	private Button downBtn;
	private Button leftBtn;
	private Button rightBtn;
	private Circle ball;
	
	private BorderPane layout;
	private HBox hBox;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ball = new Circle(RADIUS);
		ball.setFill(Color.WHITE);
		ball.setStroke(Color.GREEN);
		ball.setCenterX(WIDTH / 2);
		ball.setCenterY(HEIGHT / 2);
		Pane pane = new Pane(ball);

		upBtn = new Button("Up");
		downBtn = new Button("Down");
		leftBtn = new Button("Left");
		rightBtn = new Button("Right");
		
		MovingHandler handler = new MovingHandler();
		upBtn.setOnAction(handler);
		downBtn.setOnAction(handler);
		leftBtn.setOnAction(handler);
		rightBtn.setOnAction(handler);

		hBox = new HBox(15, upBtn, downBtn, leftBtn, rightBtn);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(new Insets(20));

		layout = new BorderPane();
		layout.setCenter(pane);
		layout.setBottom(hBox);

		primaryStage.setScene(new Scene(layout, WIDTH, HEIGHT));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
