

//NOTE: All measurements in this program are in pixels

import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;

public class GraphDraw extends Application{ 
	//The class must extend Application for the javafx application to work
	
	Line line1; //The various objects to be drawn
	Line line2;
	Text[] text = new Text[3];
	Rectangle[] rectangles = new Rectangle[7];
	
	double startingLocation = 70; 
	/*This variable defines how far down and how far right
	 * from the top left corner all objects are drawn
	 */
	
	double graphLength = 350;
	/*The graph dimensions, as the graph is drawn 
	 * with dimensions graphLength x graphLength
	 */
	

	
	public void drawRectangles(){ //Creates the rectangles of the bar graph
		double rectangleWidth = 40; //How wide the rectangles are
		double spacing = 10; //The spacing between rectangles
		
		Color fillColor = Color.ROYALBLUE;//The inside color of the rectangles
		Color borderColor = Color.BLACK;//The border color of the rectangles
		
		//The heights of the rectangles
		double[] height = new double[rectangles.length];
		height[0] = 150;
		height[1] = 300;
		height[2] = 200;
		height[3] = 70;
		height[4] = 20;
		height[5] = 250;
		height[6] = 180;
		
		//Used for drawing the rectangles (do not change)
		double x1 = startingLocation + spacing;
		double y1;
		
		/* Here the text is created
		 * The constructor is as such:
		 * x-coordinate,y-coordinate (upper left corner),
		 * width, height
		 */
		for (int i = 0; i < rectangles.length; i++){ 
			y1 = graphLength + startingLocation - height[i]; 
			//Defines the y-coordinate at which the rectangle is drawn
			rectangles[i] = new Rectangle(x1,y1,rectangleWidth,height[i]);
			//Draws a rectangle
			rectangles[i].setFill(fillColor);
			rectangles[i].setStroke(borderColor); //Sets the rectangle colors
			x1+=spacing + rectangleWidth; 
			//Shifts the x-coordinate at which the rectangle is drawn
		}
	}
	
	
	public void drawText(){ //Creates the text on the graph
		double indent = 150; 
		//The distance from the left of the graph at which the text is drawn
		double distanceFromGraph = 30; 
		//The vertical distance between the text and the graph
		
		double text3Distance = 45;
		//Text #3 has its own distance from the graph, defined here
		
		/* Here the text is created
		 * The constructor is as such:
		 * x-coordinate,y-coordinate (upper left corner),string message
		 */
		text[0] = new Text(startingLocation + indent, 
				startingLocation-distanceFromGraph,
				"Sample Graph");		
		text[1] = new Text(startingLocation + indent, 
				startingLocation+graphLength+distanceFromGraph,
				"Bottom Axis");
		text[2] = new Text(startingLocation-text3Distance,
				startingLocation+indent,
				"Side Axis");
		
		text[2].setRotate(-90); 
		//Rotates the third string to fit vertically on the left of the graph
			
	}
	
	public void drawLines(){ //Creates the lines
		/* Here the lines are created
		 * The constructor is as such:
		 * starting x-coordinate, starting y-coordinate,
		 * ending x-coordinate, ending y-coordinate
		 */
		line1 = new Line(startingLocation,startingLocation
				,startingLocation,startingLocation + graphLength);
		
		line2 = new Line(startingLocation
				,startingLocation + graphLength,startingLocation + graphLength
				,startingLocation + graphLength);
	}
	
	public void start(Stage stage) { 
		//The necessary start method to run the application
		Group group = new Group(); //The group on which the objects go
		Scene scene = new Scene(group, 500, 500,Color.WHITE);
		
		drawLines();
		drawRectangles();
		drawText();
		
		group.getChildren().add(line1);
		group.getChildren().add(line2);
		
		for (int i = 0; i < rectangles.length; i++)
			group.getChildren().add(rectangles[i]);
		
		for (int i = 0; i < text.length;i++)
			group.getChildren().add(text[i]);
		
		stage.setTitle("JavaFX Graph");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main (String [] args){
		Application.launch(args);
	}
}
