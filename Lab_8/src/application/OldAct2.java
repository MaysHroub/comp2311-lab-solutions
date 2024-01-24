package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class OldAct2 extends Application {
	
	private class CalulationHandler implements EventHandler<ActionEvent> {
		private TextField num1TF;
		private TextField num2TF;
		private TextField resTF;
		
		public CalulationHandler(TextField num1tf, TextField num2tf, TextField resTf) {
			num1TF = num1tf;
			num2TF = num2tf;
			resTF = resTf;
		}
		
		@Override
		public void handle(ActionEvent event) {
			String operation = ((Button)event.getSource()).getText();
			try {
				double num1 = Double.parseDouble(num1TF.getText());
				double num2 = Double.parseDouble(num2TF.getText());
				double res = 0;
				switch (operation) {
					case ADD: res = num1 + num2; break;
					case SUB: res = num1 - num2; break;
					case MUL: res = num1 * num2; break;
					case DIV: res = num1 / num2; break;
				}
				resTF.setText(res + "");
				
			} catch (NumberFormatException e) {
				resTF.setText("Error");
			}
		}
	}

	private final double WIDTH = 500;
	private final double HEIGHT = 200;
	
	private final String ADD = "Add";
	private final String SUB = "Subtract";
	private final String MUL = "Multiply";
	private final String DIV = "Divide";
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label num1Label = new Label("First number: ");
		Label num2Label = new Label("Second number: ");
		Label resLabel = new Label("Result: ");
		TextField num1TF = new TextField("4");
		TextField num2TF = new TextField("3");
		TextField resTF = new TextField();
		num1TF.setPrefColumnCount(5);
		num2TF.setPrefColumnCount(5);
		resTF.setPrefColumnCount(5);
		resTF.setEditable(false);
		
		HBox hBox = new HBox(10, num1Label, num1TF, num2Label, num2TF, resLabel, resTF);
		hBox.setAlignment(Pos.CENTER);
		
		Button addBtn = new Button(ADD), subBtn = new Button(SUB),
				mulBtn = new Button(MUL), divBtn = new Button(DIV);
		
		CalulationHandler handler = new CalulationHandler(num1TF, num2TF, resTF);
		addBtn.setOnAction(handler);
		subBtn.setOnAction(handler);
		mulBtn.setOnAction(handler);
		divBtn.setOnAction(handler);
		
		HBox buttonsHBox = new HBox(10, addBtn, subBtn, mulBtn, divBtn);
		buttonsHBox.setAlignment(Pos.CENTER);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(hBox);
		pane.setBottom(buttonsHBox);
		pane.setPadding(new Insets(10));
		
		primaryStage.setScene(new Scene(pane, WIDTH, HEIGHT));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	

}











