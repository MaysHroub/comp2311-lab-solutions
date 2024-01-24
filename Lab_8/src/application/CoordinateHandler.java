package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class CoordinateHandler implements EventHandler<ActionEvent>{

	final static String UP = "Up";
	final static String DOWN = "Down";
	final static String LEFT = "Left";
	final static String RIGHT = "Right";
	
	private Circle ball;
	
	public CoordinateHandler(Circle ball) {
		this.ball = ball;
	}

	@Override
	public void handle(ActionEvent event) {		
		String op = ((Button)event.getSource()).getText();
		switch (op) {
			case UP: 
				ball.setLayoutY(ball.getLayoutY() - 5); break;
			case DOWN: 
				ball.setLayoutY(ball.getLayoutY() + 5); break;
			case RIGHT: 
				ball.setLayoutX(ball.getLayoutX() + 5); break;
			case LEFT: 
				ball.setLayoutX(ball.getLayoutX() - 5); break;
		}
	}

}