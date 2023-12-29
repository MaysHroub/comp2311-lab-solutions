package application;

import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BarChartMaker extends Application {

	private static final int N = 4;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		final int WIDTH = 600, HEIGHT = 400;
		
		int[] percentages = promptPercentage();
		String[] info = { "Project", "Quiz", "Midterm", "Final" };
		Color[] colors = { Color.RED, Color.DARKGREEN, Color.BLUEVIOLET, Color.YELLOWGREEN };

		HBox container = new HBox(20);
		container.setAlignment(Pos.CENTER);

		for (int i = 0; i < info.length; i++) {
			Rectangle bar = new Rectangle(WIDTH / 5, HEIGHT * percentages[i] / 100);
			bar.setFill(colors[i]);
			Text text = new Text(String.format("%s -- %d%%", info[i], percentages[i]));
			text.setFont(Font.font("Times New Roman", FontWeight.BOLD, 13));
			VBox vb = new VBox();
			vb.getChildren().addAll(text, bar);
			vb.setAlignment(Pos.BOTTOM_CENTER);
			container.getChildren().add(vb);
		}

		StackPane sp = new StackPane(new Group(container));
		
		Scene scene = new Scene(sp, WIDTH, HEIGHT);
				
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
