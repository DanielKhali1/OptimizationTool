package UI;



import Experiment.TestCase;
import Optimization.Optimizer;
import Optimization.GA.GA;
import Optimization.GA.CrossoverMethod.BLX;
import Optimization.GA.SelectionMethod.DeepTournament;
import Optimization.Hybrid.TandemHybrid;
import Optimization.PSO.PSO;
import SolutionSpace.SolutionSpace;
import SolutionSpace.Benchmarks.Ackley;
import SolutionSpace.Benchmarks.EggHolder;
import SolutionSpace.Benchmarks.HolderTable;
import SolutionSpace.Benchmarks.Rastrigin;
import SolutionSpace.Benchmarks.Sphere;
import Util.Vector;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Visual extends Application
{
	// hey leo do you know how you would be able to create like a random 3d solution space?
	Circle[] circles;
	Circle[] otherCircles;
	
	int detail = 100;
	
	public static void main(String[] args){launch(args);}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 600, 600);
		
		GridPane gridPane = new GridPane();
		SolutionSpace sphere = new Rastrigin(2);
		
		for(int i = 0; i < detail; i++)
		{
			for(int j = 0; j < detail; j++)
			{
				Rectangle rect = new Rectangle(scene.getWidth()/detail, scene.getHeight()/detail);
				rect.setFill(new Color((double)j/(double)detail, (double)i/(double)detail, (double)j/(double)detail, (double)j/(double)detail));
				gridPane.add(rect, j, i);
			}
		}
		
		pane.getChildren().add(gridPane);
		
		
		
		Optimizer pso = new PSO(100, 0.9, 2, 2);
		
//		Optimizer ga = new GA(100, 0.01, new DeepTournament(), new BLX());
//		((GA) ga).setElitismRate(0.2);
		
		Optimizer ga = new TandemHybrid(100, 0.9, 2, 2, 0.01);
		
		
		int iteration = 20;

		TestCase test = new TestCase(iteration, sphere, pso, ga);
		
		circles = new Circle[pso.getPopulation().length];
		for(int i = 0; i < circles.length; i++)
		{
			circles[i] = new Circle(3);
			circles[i].setFill(Color.RED);
			circles[i].setStroke(Color.BLACK);
			circles[i].relocate(pso.getPopulation()[i].getComponents()[0]+ sphere.getHigherBound(), pso.getPopulation()[i].getComponents()[1]+ sphere.getHigherBound());
			
			circles[i].setLayoutX(circles[i].getLayoutX() * (scene.getWidth()/detail));
			circles[i].setLayoutY(circles[i].getLayoutY() * (scene.getHeight()/detail));
			
			pane.getChildren().add(circles[i]);
		}
		
		otherCircles = new Circle[ga.getPopulation().length];
		for(int i = 0; i < otherCircles.length; i++)
		{
			otherCircles[i] = new Circle(3);
			otherCircles[i].setFill(Color.GREEN);
			otherCircles[i].setStroke(Color.BLACK);
			otherCircles[i].relocate(ga.getPopulation()[i].getComponents()[0]+ sphere.getHigherBound(), ga.getPopulation()[i].getComponents()[1]+ sphere.getHigherBound());
			
			otherCircles[i].setLayoutX(otherCircles[i].getLayoutX() * (scene.getWidth()/25));
			otherCircles[i].setLayoutY(otherCircles[i].getLayoutY() * (scene.getHeight()/25));
			
			pane.getChildren().add(otherCircles[i]);
		}
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(250), (ActionEvent event) -> {
			test.step();
			
			for(int i = 0; i < circles.length; i++)
			{
				circles[i].relocate(pso.getPopulation()[i].getComponents()[0]+ sphere.getHigherBound(), pso.getPopulation()[i].getComponents()[1]+ sphere.getHigherBound());
				circles[i].setLayoutX(circles[i].getLayoutX() * (scene.getWidth()/25));
				circles[i].setLayoutY(circles[i].getLayoutY() * (scene.getHeight()/25));
			}
			
			System.out.println((scene.getWidth()*4/detail));

			for(int i = 0; i < otherCircles.length; i++)
			{
				
				otherCircles[i].relocate(ga.getPopulation()[i].getComponents()[0] + sphere.getHigherBound(), ga.getPopulation()[i].getComponents()[1]+ sphere.getHigherBound());
				otherCircles[i].setLayoutX(otherCircles[i].getLayoutX() * (scene.getWidth()/25));
				otherCircles[i].setLayoutY(otherCircles[i].getLayoutY() * (scene.getHeight()/25));
			}
			System.out.println("PSO: " + sphere.Function(pso.bestSolution()) + " tandem: " + sphere.Function(ga.bestSolution()) + " Target: " + sphere.Function(sphere.getGlobalMinimum()));
			
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("visualization");
		primaryStage.show();
	}
}
