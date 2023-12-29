package application;


import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MovingBarChartMaker extends Application {
	
	private static final int N = 4; // number of bars
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final int sceneWidth = 600, sceneHeight = 400;
		
		int[] percentages = promptPercentage();
		
		int max = percentages[0];
		for (int i = 1; i < N; i++) 
			if (percentages[i] > max)
				max = percentages[i];
		
		// Both of info and colors have fixed size of 4 elements
		String[] info = {"Project", "Quiz", "Midterm", "Final"}; 
		Color[] colors = { Color.RED, Color.DARKGREEN, Color.BLUEVIOLET, Color.YELLOWGREEN };
		
		Pane container = new Pane();

		for (int i = 0; i < percentages.length; i++) {
			int barHeight = sceneHeight * percentages[i] / 100,
					barWidth = sceneWidth / (N+2);
			
			Rectangle bar = new Rectangle(barWidth, barHeight);
			bar.setFill(colors[i]);
			
			Text text = new Text(String.format("%s -- %d%%", info[i], percentages[i]));
			text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 13));

			bar.xProperty().bind(container.widthProperty().divide(N+1).multiply(i+1).subtract(bar.getWidth()/2));
			text.xProperty().bind(container.widthProperty().divide(N+1).multiply(i+1).subtract(bar.getWidth()/2));

			int longestBarHeight = sceneHeight * max / 100;
			bar.yProperty().bind(container.heightProperty().divide(3).add(longestBarHeight - barHeight));
			
			int seperator = 15;
			text.yProperty().bind(bar.yProperty().subtract(seperator));

			container.getChildren().addAll(text, bar);
		}

		Scene scene = new Scene(container, sceneWidth, sceneHeight);
		primaryStage.setScene(scene);
		primaryStage.setTitle("BarChart");
		primaryStage.show();
	}
	
	private int[] promptPercentage() {
		Scanner in = new Scanner(System.in);
		int[] data = new int[N];
		int sum = 0;
		
		System.out.print("Enter the percentage of Project, Quizzes, and Midterm: ");
		for (int i = 0; i < N - 1; i++) {
			data[i] = in.nextInt();
			sum += data[i];
		}
		data[N - 1] = 100 - sum;
		
		in.close();
		return data;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
