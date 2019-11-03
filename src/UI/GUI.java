package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI extends Application
{
	Manager manager = new Manager();

	@Override
	public void start(Stage stage) 
	{
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 600, 600);
		stage.setScene(scene);
		stage.setTitle("Optimization Toolset");
		stage.show();
		
	}
	
	public static void main(String[] args) {launch(args);}
}
