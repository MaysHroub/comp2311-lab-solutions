package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Monalisa extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Circle face = new Circle(150);
		face.setFill(Color.BURLYWOOD);
		
		Group leftEye = getEye(face);
		Group rightEye = getEye(face);

		HBox eyebrows = new HBox(face.getRadius()/2.4);
		Rectangle leftEyebrow = new Rectangle(face.getRadius()/3, face.getRadius()/15);
		leftEyebrow.setRotate(-20);
		Rectangle rightEyebrow = new Rectangle(face.getRadius()/3, face.getRadius()/15);
		eyebrows.setAlignment(Pos.BOTTOM_CENTER);
		eyebrows.getChildren().addAll(leftEyebrow, rightEyebrow);
		
		HBox eyes = new HBox(face.getRadius()/3);
		eyes.setAlignment(Pos.BOTTOM_CENTER);
		eyes.getChildren().addAll(leftEye, rightEye);
		
		Polygon nose = new Polygon();
		nose.setFill(Color.BROWN);
		nose.getPoints().addAll(new Double[] {
				25.0, 0.0,
				0.0, 50.0,
				50.0, 50.0 
		});

		Rectangle mustache = new Rectangle(face.getRadius()/1.5, face.getRadius()/10);

//		GridPane teeth = new GridPane();
//		for (int i = 0; i < 5; i++) 
//			for (int j = 0; j < 2; j++) 
//				teeth.add(new Rectangle(face.getRadius()/10, face.getRadius()/10, Color.WHITE), i, j);
//		
//		teeth.setGridLinesVisible(true);
//		teeth.setAlignment(Pos.CENTER);
		
		Rectangle mouth = new Rectangle(face.getRadius()/3, face.getRadius()/50);
		mouth.setRotate(5);
			
		VBox faceComponents = new VBox(face.getRadius()/15);
		faceComponents.setAlignment(Pos.CENTER);
		faceComponents.getChildren().addAll(eyebrows, eyes, nose, mustache, mouth);
		
		Rectangle hat = new Rectangle(face.getRadius(), face.getRadius()/1.5, Color.DARKRED);
		
		StackPane wholeFace = new StackPane();
		wholeFace.getChildren().addAll(face, faceComponents);
		
		Polygon triangle = new Polygon();
		triangle.setFill(Color.BLACK);
		triangle.getPoints().addAll(new Double[] {
				0.0, 0.0,
				0.0, 50.0,
				10.0, 10.0 
		});
		
		Text name = new Text("\n\nAbu Isam");
		name.setFont(Font.font("Courier New", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 25));
		
		VBox vb = new VBox(-20);
		vb.getChildren().addAll(triangle, hat, wholeFace, name);
		vb.setAlignment(Pos.CENTER);
		
		Rectangle leftGlass = new Rectangle(face.getRadius() / 2, face.getRadius() / 4);
		leftGlass.setFill(Color.TRANSPARENT);
		leftGlass.setStroke(Color.DARKGOLDENROD);
		leftGlass.setStrokeWidth(3);
		Rectangle rightGlass = new Rectangle(face.getRadius() / 2, face.getRadius() / 4);
		rightGlass.setFill(Color.TRANSPARENT);
		rightGlass.setStroke(Color.DARKGOLDENROD);
		rightGlass.setStrokeWidth(3);
		
		Line line = new Line(0, 0, 40, 0);
		line.setStroke(Color.DARKGOLDENROD);
		line.setStrokeWidth(2);
		
		HBox glasses = new HBox();
		glasses.getChildren().addAll(leftGlass, line, rightGlass);
		glasses.setAlignment(Pos.CENTER);
		
		StackPane sp = new StackPane();
		sp.getChildren().addAll(vb, glasses);
		
		Scene scene = new Scene(sp, 400, 500);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Bab al-7ara");
		primaryStage.show();
	}

	private static Group getEye(Circle face) {
		Ellipse eye = new Ellipse(face.getRadius() / 5, face.getRadius() / 6);
		eye.setFill(Color.WHITE);
		Circle pupil = new Circle(eye.getRadiusY() / 1.5);
		return new Group(eye, pupil);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
