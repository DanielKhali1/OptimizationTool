package UI;


import java.util.ArrayList;

import Experiment.TestCase;
import Optimization.Optimizer;
import SolutionSpace.SolutionSpace;
import SolutionSpace.Benchmarks.Ackley;
import SolutionSpace.Benchmarks.EggHolder;
import SolutionSpace.Benchmarks.HolderTable;
import SolutionSpace.Benchmarks.Levy;
import SolutionSpace.Benchmarks.Rastrigin;
import SolutionSpace.Benchmarks.Sphere;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application
{
	Manager manager = new Manager();
	Pane pane = new Pane();
	Scene scene = new Scene(pane, 600, 600);
	
	ArrayList<TaskButton> buttons = new ArrayList<TaskButton>();
	
	VBox taskPane = new VBox();

	
	Button newTestCase = new Button("New Test Case");
	Button removeTestCase = new Button("Remove Test Case");
	Button clearAll = new Button("Clear All");



	@Override
	public void start(Stage stage) 
	{
		UI();
		stage.setScene(scene);
		stage.setTitle("Optimization Toolset");
		stage.show();
		
	}
	
	public void UI()
	{
		pane.setStyle("-fx-background-color: '#b8b8b8';");
		
		
		setPosition(newTestCase, 50, 20);
		buttonStyle(newTestCase);
		pane.getChildren().add(newTestCase);
		
		setPosition(removeTestCase, 50, 60);
		buttonStyle(removeTestCase);
		pane.getChildren().add(removeTestCase);
		
		addTask();
		removeSelectedTask();
		clearAll();
		
		Button editTestCase = new Button("Edit Test Case");
		setPosition(editTestCase, 50, 100);
		buttonStyle(editTestCase);
		pane.getChildren().add(editTestCase);
		
		setPosition(clearAll, 50, 140);
		buttonStyle(clearAll);
		pane.getChildren().add(clearAll);
		
		Line line = new Line(20, 210, 250, 210);
		pane.getChildren().add(line);
		
		Button runVerbose = new Button("Run Verbose");
		setPosition(runVerbose, 50, 250);
		buttonStyle(runVerbose);
		pane.getChildren().add(runVerbose);
		
		Button runCSV = new Button("Run & Save");
		setPosition(runCSV, 50, 290);
		buttonStyle(runCSV);
		pane.getChildren().add(runCSV);
		
		ScrollPane scrollPane = new ScrollPane();
		
		taskPane.setStyle("-fx-background-color: '#dedede';");
		
		scrollPane.setContent(taskPane);
		scrollPane.setPrefSize(300, 560);
		setPosition(scrollPane, 275, 20);
		pane.getChildren().add(scrollPane);
	}
	
	public static void main(String[] args) {launch(args);}
	
	
	public void clearAll()
	{
		clearAll.setOnAction( e->{
			
				while(buttons.size() > 0)
				{
					taskPane.getChildren().remove(buttons.get(0));
					buttons.remove(0);
				}

		});
	}
	
	public void removeSelectedTask()
	{
		removeTestCase.setOnAction( e->{
			
			for(int i = 0; i < buttons.size(); i++)
			{
				if(buttons.get(i).selected)
				{
					taskPane.getChildren().remove(buttons.get(i));
					buttons.remove(i);
				}
			}

		});
	}
	
	
	public void addTask()
	{
		newTestCase.setOnAction( e->{
			
			//disable pane
			pane.setDisable(true);
			
			Stage stage = new Stage();
			Pane testCasePane = new Pane();
			Scene scene = new Scene(testCasePane, 300, 400);
			
			stage.setScene(scene);
			stage.setTitle("New Test Case");
			stage.show();
			
			// add new test case button
			
			Text iterationTxt = new Text("Iterations");
			setPosition(iterationTxt, 20, 45);
			TextField iterationTf = new TextField("50");
			setPosition(iterationTf, 20, 50);
			Text SolutionSpaceTxt = new Text("SolutionSpace");
			setPosition(SolutionSpaceTxt, 20, 95);

			String[] ss = { "Ackley", "Eggholder","HolderTable", "Levy", "Rastrigin", "Sphere" };
			
			ComboBox SolutionSpaces = new ComboBox(FXCollections.observableArrayList(ss));
			SolutionSpaces.getSelectionModel().selectFirst();
			setPosition(SolutionSpaces, 20, 100);
			
			
			Text AlgorithmTxt = new Text("Algorithms");
			setPosition(AlgorithmTxt, 20, 145);
			
			String[] alg = { "GA", "PSO","Hybrid1", "Hybrid2", "Hybrid3" };
			
			ComboBox Algorithms = new ComboBox(FXCollections.observableArrayList(alg));
			Algorithms.getSelectionModel().selectFirst();

			setPosition(Algorithms, 20, 150);
			
			Button addBt = new Button("Add");
			setPosition(addBt, 230, 350);
			
			addBt.setOnAction(f->{
				
				SolutionSpace tempSolution = null;
				
				System.out.println(SolutionSpaces.getValue());
				if(SolutionSpaces.getValue().equals("Ackley"))
				{
					tempSolution = new Ackley();
				}
				else if(SolutionSpaces.getValue().equals("Eggholder"))
				{
					tempSolution = new EggHolder();
				}
				else if(SolutionSpaces.getValue().equals("HolderTable"))
				{
					tempSolution = new HolderTable();
				}
				else if(SolutionSpaces.getValue().equals("Levy"))
				{
					tempSolution = new Levy();
				}
				else if(SolutionSpaces.getValue().equals("Rastrigin"))
				{
					tempSolution = new Rastrigin();
				}
				else if(SolutionSpaces.getValue().equals("Sphere"))
				{
					tempSolution = new Sphere();
				}
				
				Optimizer tempOptimizer = null;
				if(Algorithms.getValue().equals("GA"))
				{
					tempOptimizer = new Optimizer("GA");
				}
				else if(Algorithms.getValue().equals("PSO"))
				{
					tempOptimizer = new Optimizer("PSO");
				}
				else if(Algorithms.getValue().equals("Hybrid1"))
				{
					tempOptimizer = new Optimizer("Hybrid1");
				}
				else if(Algorithms.getValue().equals("Hybrid2"))
				{
					tempOptimizer = new Optimizer("Hybrid2");
				}
				else if(Algorithms.getValue().equals("Hybrid3"))
				{
					tempOptimizer = new Optimizer("Hybrid3");
				}
				
				
				
				TaskButton button = new TaskButton( new TestCase(Integer.parseInt(iterationTf.getText()), tempSolution, tempOptimizer) );
				taskPane.getChildren().add(button);
				buttons.add(button);
				
				button.setOnAction(a->{

					button.selected = !button.selected;
					
					if(button.selected)
					{
						for(int i = 0; i < buttons.size(); i++)
						{
							buttons.get(i).selected = false;
							buttons.get(i).setStyle("-fx-background-color: #e0e0e0; -fx-border: solid; -fx-border-color: black");
						}
						button.selected = true;
						button.setStyle("-fx-background-color: #5e5e5e; -fx-border: solid; -fx-border-color: white; -fx-text-fill: white");
						
					}
					else
						button.setStyle("-fx-background-color: #e0e0e0; -fx-border: solid; -fx-border-color: black");

				});
				
				pane.setDisable(false);
				stage.hide();
				
			});

			Button cancelBt = new Button("Cancel");
			setPosition(cancelBt, 160, 350);


			testCasePane.getChildren().addAll(iterationTxt, iterationTf, SolutionSpaceTxt, SolutionSpaces, Algorithms, AlgorithmTxt, addBt, cancelBt);
			
			
			// ---------------------------
			
			stage.setOnCloseRequest(a->{
				pane.setDisable(false);
				
			});
			
		});

	}
	
	
	
	
	public void setPosition(Node node, double x, double y)
	{
		node.setLayoutX(x);
		node.setLayoutY(y);
	}
	
	public void buttonStyle(Button button)
	{
		button.setPrefWidth(175);
		button.setStyle("-fx-background-color: '#e0e0e0'; -fx-border-color: 'black'; -fx-border-style: solid; -fx-font-size: 16;");
		button.setOnMouseEntered(e->{
			button.setStyle("-fx-background-color: 'black'; -fx-border-color: 'black'; -fx-border-style: solid; -fx-text-fill: 'white'; -fx-font-size: 16;");
		});
		button.setOnMouseExited(e->{
			button.setStyle("-fx-background-color: '#e0e0e0'; -fx-border-color: 'black'; -fx-border-style: solid; -fx-font-size: 16;");
		});
		
	}
	
	class TaskButton extends Button
	{
		
		boolean selected = false;
		TestCase testcase;
		
		public TaskButton(TestCase testCase)
		{
			super();
			this.testcase = testCase;

			setText("Test Case "+buttons.size()+": \nIterations: " + testcase.getIterations() + "\nSolution Space: " + testcase.getSs().getName() + "\nOptimizer: " + testcase.getOptimizer().getAlgorithm());

			
			
			
			setStyle("-fx-background-color: #e0e0e0; -fx-border: solid; -fx-border-color: black;");
			setPrefSize(298, 100);
		}
		
	}
}
