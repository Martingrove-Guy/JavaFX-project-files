

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleDraw extends Application {

	public void start(Stage stage) {
		Group group = new Group();
		Scene scene = new Scene(group, 200, 150);
		scene.setFill(Color.WHITE);
		
		Circle circle = new Circle(50, 50, 40, Color.RED);
		
		group.getChildren().add(circle);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
