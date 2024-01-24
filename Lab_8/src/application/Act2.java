package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Act2 extends Application {
	
	private Label num1Label, num2Label, resLabel;
	private TextField num1TF, num2TF, resTF;
//	private Button addBtn, subBtn, mulBtn, divBtn;
	private ComboBox<String> comboBox;
	
	final String ADD = "ADD", SUB = "SUB", MUL = "MUL", DIV = "DIV";
	
	class CalcHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			double num1, num2, res = 0;
			try {
				num1 = Double.parseDouble(num1TF.getText());
				num2 = Double.parseDouble(num2TF.getText());
				
			} catch (NumberFormatException e) {
				resTF.setText("Error");
				return;
			}
			
			switch (comboBox.getValue()){
				case ADD: res = num1 + num2; break;
				case SUB: res = num1 - num2; break;
				case MUL: res = num1 * num2; break;
				case DIV: res = num1 / num2; break;
			}
			resTF.setText(res + "");
			
//			if (event.getSource() == addBtn) 
//				res = num1 + num2;
//			else if (event.getSource() == subBtn) 
//				res = num1 - num2;
//			else if (event.getSource() == mulBtn) 
//				res = num1 * num2;
//			else if (event.getSource() == divBtn) 
//				res = num1 / num2;
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		num1Label = new Label("Number 1: ");
		num2Label = new Label("Number 2: ");
		resLabel = new Label("Result: ");
		
		num1TF = new TextField("2");
		num2TF = new TextField("2");
		resTF = new TextField("4");
		
		num1TF.setPrefColumnCount(5);
		num2TF.setPrefColumnCount(5);
		resTF.setPrefColumnCount(5);
		resTF.setEditable(false);
				
		HBox upperHBox = new HBox(10, num1Label, num1TF, num2Label, num2TF, resLabel, resTF);
		upperHBox.setAlignment(Pos.CENTER);
		
		comboBox = new ComboBox<>();
		comboBox.getItems().addAll(ADD, SUB, MUL, DIV);
		
		CalcHandler handler = new CalcHandler();
		comboBox.setOnAction(handler);
		
//		addBtn = new Button("ADD");
//		subBtn = new Button("SUB");
//		mulBtn = new Button("MUL");
//		divBtn = new Button("DIV");
//		addBtn.setOnAction(handler);
//		subBtn.setOnAction(handler);
//		mulBtn.setOnAction(handler);
//		divBtn.setOnAction(handler);
//		HBox lowerHBox = new HBox(10, addBtn, subBtn, mulBtn, divBtn);
//		lowerHBox.setAlignment(Pos.CENTER);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(upperHBox);
		pane.setBottom(comboBox);
		pane.setPadding(new Insets(10));
		BorderPane.setAlignment(comboBox, Pos.CENTER_RIGHT);
		
		primaryStage.setScene(new Scene(pane, 500, 200));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}