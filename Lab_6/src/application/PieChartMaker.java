package application;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PieChartMaker extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		final int width = 400, height = 400;
		
		final int n = 3; // number of arcs
		final int sciPer = 35, literPer = 55, otherPer = 10;
		double[] angles = {sciPer * 3.6, literPer * 3.6, otherPer * 3.6}; // percentage/100*360
		String[] titles = {"Scientific", "Literary", "Other"};
		Color[] colors = {Color.DEEPPINK, Color.CORNFLOWERBLUE, Color.DARKSEAGREEN};
		
		Pane layout = new Pane();
		
		int radius = width / 3;
		double preAngle = 0;
		for (int i = 0; i < n; i++) {
			Arc arc = new Arc();
			arc.setRadiusX(radius);
			arc.setRadiusY(radius);
			arc.setStartAngle(preAngle);
			arc.setLength(angles[i]);
			arc.setType(ArcType.ROUND);
			arc.setFill(colors[i]);
			arc.centerXProperty().bind(layout.widthProperty().divide(2));
			arc.centerYProperty().bind(layout.heightProperty().divide(2));
			
			arc.radiusXProperty().bind(layout.widthProperty().divide(3));
			arc.radiusYProperty().bind(layout.heightProperty().divide(3));
			
			Text title = new Text(String.format("%s %d%%", titles[i], (int) (angles[i] / 3.6)));

			title.setX(getXPosOfText(arc.getCenterX(), radius, preAngle));
			title.setY(getYPosOfText(arc.getCenterY(), radius, preAngle));
			
			title.xProperty().bind(arc.centerXProperty()
					.add(getXPosOfText(arc.getCenterX(), radius/2, angles[i]/2 + preAngle)));

			title.yProperty().bind(arc.centerYProperty()
					.add(getYPosOfText(arc.getCenterY(), radius/2, angles[i]/2 + preAngle)));
			
			title.setTextOrigin(VPos.TOP);
			title.setFont(new Font(12));
			title.setFill(Color.BLACK.brighter().brighter());
			
			preAngle += angles[i];
			
			layout.getChildren().addAll(arc, title);
			
		}
		
		Scene scene = new Scene(layout, width, height);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tawjihi Statistics");
		primaryStage.show();
	}

	private double getXPosOfText(double centreX, double r, double arcAngle) {
		double angle = Math.cos( Math.toRadians(arcAngle) );
		return centreX + r * angle * ((angle < 0) ? 1.5 : 1);
	}
	
	private double getYPosOfText(double centreY, double r, double arcAngle) {
		return (centreY + r * Math.sin(Math.toRadians(arcAngle))) * -1;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}






















