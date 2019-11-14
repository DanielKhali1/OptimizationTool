package UI;

import Experiment.TestCase;
import Optimization.Optimizer;
import Optimization.GA.GA;
import Optimization.GA.CrossoverMethod.BLX;
import Optimization.GA.SelectionMethod.DeepTournament;
import Optimization.PSO.PSO;
import SolutionSpace.SolutionSpace;
import SolutionSpace.Benchmarks.Rastrigin;
import SolutionSpace.Benchmarks.Sphere;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Visual extends Application
{
	
	Circle[] circles;
	Circle[] otherCircles;
	
	public static void main(String[] args){launch(args);}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 500, 500);
		
		SolutionSpace sphere = new Rastrigin(2);
		Optimizer pso = new PSO(100, 0.9, 2, 2);
		
		Optimizer ga = new GA(100, 0.01, new DeepTournament(), new BLX());
		((GA) ga).setElitismRate(0.2);
		
		int iteration = 20;
		
		TestCase test = new TestCase(iteration, sphere, pso, ga);
		
		circles = new Circle[pso.getPopulation().length];
		for(int i = 0; i < circles.length; i++)
		{
			circles[i] = new Circle(3);
			circles[i].setFill(Color.RED);
			circles[i].relocate(pso.getPopulation()[i].getComponents()[0]+sphere.getHigherBound(), pso.getPopulation()[i].getComponents()[1]+sphere.getHigherBound());
			
			circles[i].setLayoutX(circles[i].getLayoutX() * 25);
			circles[i].setLayoutY(circles[i].getLayoutY() * 25);
			
			pane.getChildren().add(circles[i]);
		}
		
		otherCircles = new Circle[ga.getPopulation().length];
		for(int i = 0; i < otherCircles.length; i++)
		{
			otherCircles[i] = new Circle(3);
			otherCircles[i].setFill(Color.GREEN);
			otherCircles[i].relocate(ga.getPopulation()[i].getComponents()[0]+sphere.getHigherBound(), ga.getPopulation()[i].getComponents()[1]+sphere.getHigherBound());
			
			otherCircles[i].setLayoutX(otherCircles[i].getLayoutX() * 25);
			otherCircles[i].setLayoutY(otherCircles[i].getLayoutY() * 25);
			
			pane.getChildren().add(otherCircles[i]);
		}
		
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(400), (ActionEvent event) -> {
			test.step();
			
			for(int i = 0; i < circles.length; i++)
			{
				circles[i].relocate(pso.getPopulation()[i].getComponents()[0]+sphere.getHigherBound(), pso.getPopulation()[i].getComponents()[1]+sphere.getHigherBound());
				circles[i].setLayoutX(circles[i].getLayoutX() * 25);
				circles[i].setLayoutY(circles[i].getLayoutY() * 25);
			}
			
			for(int i = 0; i < otherCircles.length; i++)
			{
				otherCircles[i].relocate(ga.getPopulation()[i].getComponents()[0]+sphere.getHigherBound(), ga.getPopulation()[i].getComponents()[1]+sphere.getHigherBound());
				otherCircles[i].setLayoutX(otherCircles[i].getLayoutX() * 25);
				otherCircles[i].setLayoutY(otherCircles[i].getLayoutY() * 25);
			}
			System.out.println("PSO: " + sphere.Function(pso.bestSolution()) + " GA: " + sphere.Function(ga.bestSolution()));
			
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("visualization");
		primaryStage.show();
	}
}
