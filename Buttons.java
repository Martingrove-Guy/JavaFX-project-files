

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.*;
import javafx.scene.effect.DropShadow;

public class Buttons extends Application{
	Button button1 = new Button();
	Button button2 = new Button();
	Button button3 = new Button();
	Button button4 = new Button();
	RadioButton[] buttons = new RadioButton[4];
	
	public void makeButton1(){
		button1 = new Button();
        button1.setText("Press Me!");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if (!button1.getText().equals("Pressed"))
            		button1.setText("Pressed");
            	else button1.setText("Unpressed");
            }
        });
        button1.setPrefSize(150,50);
        button1.setLayoutY(10- button1.getLayoutBounds().getMinY());
	}
	
	//NOTE: Figure out what the fuck went wrong
	public void makeButton2(){
		Image imageDecline = new Image(getClass().getResourceAsStream("not.png"));
		button2 = new Button();
		button2.setGraphic(new ImageView(imageDecline));
		button2.setLayoutX(200 - button1.getLayoutBounds().getMinX());
        button2.setLayoutY(210- button1.getLayoutBounds().getMinY());
	}
	
	public void makeButton3(){
		button3.setText("Mouse Over Me!");
		final DropShadow shadow = new DropShadow();
		button3.addEventHandler(MouseEvent.MOUSE_ENTERED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		            button3.setEffect(shadow);
		        }
		});
		button3.addEventHandler(MouseEvent.MOUSE_EXITED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		            button3.setEffect(null);
		        }
		});
		button3.setPrefSize(150,50);
		button3.setLayoutX(350 - button1.getLayoutBounds().getMinX());
        button3.setLayoutY(240- button1.getLayoutBounds().getMinY());
	}
	
	public void makeButton4(){
		button4.setText("PRESS ME FOR COLOR!!");
		button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	button4.setStyle("-fx-base: #" + 
            Integer.toHexString((int)(Math.random()*16777216)) + ";");
            }
        });
		button4.setPrefSize(150,50);
		
        button4.setLayoutY(240- button1.getLayoutBounds().getMinY());
	}
	
	public void makeRadioButtons(){
		final ToggleGroup toggleGroup = new ToggleGroup();
		
		for (int i = 0 ; i<buttons.length ; i++){
			buttons[i] = new RadioButton("RadioButton" + (i+1));
			buttons[i].setPrefSize(120,20);
			buttons[i].setLayoutX(200 - buttons[i].getLayoutBounds().getMinX());
			buttons[i].setLayoutY(100 + i*20 - buttons[i].getLayoutBounds().getMinY());
			buttons[i].setToggleGroup(toggleGroup);
		}
		buttons[0].setSelected(true);
	}
	
	public void makeObjects(){
		makeButton1();
		//makeButton2();
		makeButton3();
		makeButton4();
		makeRadioButtons();
	}
	
	public void start(Stage stage) {
		Pane root = new Pane();
		Scene scene = new Scene(root, 500, 300);
		scene.setFill(Color.WHITE);
		
		makeObjects();
		
		root.getChildren().add(button1);
		//root.getChildren().add(button2);
		root.getChildren().add(button3);
		root.getChildren().add(button4);
		for (int i = 0; i<buttons.length ; i++)
			root.getChildren().add(buttons[i]);
		
		stage.setTitle("Buttons");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
