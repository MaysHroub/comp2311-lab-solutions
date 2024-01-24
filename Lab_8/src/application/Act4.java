package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Act4 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label fileNameLabel = new Label("File name: ");
		fileNameLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
		
		TextArea contentArea = new TextArea();
		
		TextField fileTF = new TextField("data.txt");
		fileTF.setStyle("-fx-border-color: #D97E1B; -fx-border-width: 2;");
		
		Button loadBtn = new Button(" Load ");
		loadBtn.setStyle("-fx-border-color: orange; -fx-border-width: 2;");
		
		loadBtn.setOnAction(e -> {
			if (fileTF.getText().equals("")) {
				contentArea.setText("Text field is empty");
				return;
			}
			contentArea.setText("");
			try (Scanner in = new Scanner(new File(fileTF.getText()))) {
				while (in.hasNext())
					contentArea.setText((contentArea.getText().equals("")) ? in.nextLine()
							: contentArea.getText() + "\n" + in.nextLine());
				
			} catch (FileNotFoundException ex) {
				contentArea.setText(ex.getMessage());
			}
		});
		
		Button saveBtn = new Button("Save");
		saveBtn.setStyle("-fx-border-color: orange; -fx-border-width: 2;");
		
		saveBtn.setOnAction(e -> {
			if (contentArea.getText().equals("")) {
				contentArea.setText("There is nothing to save");
				return;
			}
			try (PrintWriter out = new PrintWriter(fileTF.getText())) {
				out.print(contentArea.getText());
				
			} catch (FileNotFoundException ex) {
				contentArea.setText(ex.getMessage());
			}
			contentArea.setText("");
		});
		
		HBox hBox = new HBox(20, fileNameLabel, fileTF, loadBtn);
		hBox.setAlignment(Pos.CENTER);
		
		BorderPane pane = new BorderPane(contentArea, hBox, null, saveBtn, null);
		pane.setStyle("-fx-border-color: #D97E1B; -fx-border-width: 4; -fx-background-color: #2C2C2C;");
		pane.setPadding(new Insets(30));
		BorderPane.setMargin(contentArea, new Insets(15));
		BorderPane.setAlignment(saveBtn, Pos.CENTER);
		
		fileTF.prefWidthProperty().bind(pane.widthProperty().divide(2));
		saveBtn.prefWidthProperty().bind(pane.widthProperty().divide(3));
		
		primaryStage.setScene(new Scene(pane, 450, 300));
		primaryStage.setTitle("File editor UI");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
