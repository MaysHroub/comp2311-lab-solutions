package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

// I got a bit excited and I did this before the lab...

public class ImprovedAct1 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		final int WIDTH = 500, HEIGHT = 500, RADIUS = 30;
		
		Pane pane = new Pane();

		ImageView background = new ImageView("file:///C:/Users/ismae/eclipse-workspace/Lab_8/background1.jpg");
		background.setFitWidth(WIDTH);
		background.setFitHeight(HEIGHT);
		
		Group ball = drawPokemonBall(RADIUS);
		ball.setLayoutX(WIDTH/2);
		ball.setLayoutY(HEIGHT/2);
		
		ball.setFocusTraversable(true);
		ball.requestFocus();
		
		ball.setOnKeyPressed(e -> {			
			switch (e.getCode()) {
				case UP: 
					if (ball.getLayoutY() - RADIUS == 0) break;
					ball.setLayoutY(ball.getLayoutY()-5); break;
				case DOWN: 
					if (ball.getLayoutY() + RADIUS == pane.getHeight()) break;
					ball.setLayoutY(ball.getLayoutY()+5); break;
				case RIGHT: 
					if (ball.getLayoutX() + RADIUS == pane.getWidth()) break;
					ball.setLayoutX(ball.getLayoutX()+5); break;
				case LEFT: 
					if (ball.getLayoutX() - RADIUS == 0) break;
					ball.setLayoutX(ball.getLayoutX()-5); break;
			default:
				break;
			}
		});
		
		pane.getChildren().addAll(background, ball);
		primaryStage.setScene(new Scene(pane, WIDTH, HEIGHT));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public Group drawPokemonBall(double radius) {
		Arc upperHalf = new Arc();
		upperHalf.setRadiusX(radius);
		upperHalf.setRadiusY(radius);
		upperHalf.setStyle("-fx-stroke: black; -fx-stroke-width: 3; -fx-fill: red;");
		upperHalf.setStartAngle(0);
		upperHalf.setLength(180);
		upperHalf.setType(ArcType.ROUND);
		
		Arc lowerHalf = new Arc();
		lowerHalf.setRadiusX(radius);
		lowerHalf.setRadiusY(radius);
		lowerHalf.setStyle("-fx-stroke: black; -fx-stroke-width: 3; -fx-fill: white;");
		lowerHalf.setStartAngle(0);
		lowerHalf.setLength(-180);
		lowerHalf.setType(ArcType.ROUND);
		
		Circle blackCir = new Circle(radius/4, Color.BLACK);
		blackCir.centerXProperty().bind(upperHalf.centerXProperty());
		blackCir.centerYProperty().bind(upperHalf.centerYProperty());
		
		return new Group(upperHalf, lowerHalf, blackCir);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}












