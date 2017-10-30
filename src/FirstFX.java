import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

interface Calculate {
	public int calculate(String arr[]);
}

class Equals implements Calculate {
	
	@Override
	public int calculate(String arr[]) {
		Add add = new Add();
		Subtract subtract = new Subtract();
		Multiply multiply = new Multiply();
		Divide divide = new Divide();
		int val = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				if (arr[i].equals("x")) 
					val = multiply.calculate(arr);
				else if (arr[i].equals("÷")) 
					val = divide.calculate(arr);
				else if (arr[i].equals("+"))  
					val = add.calculate(arr);
				else if (arr[i].equals("-"))
					val = subtract.calculate(arr);
			}
		}
		arr = new String[10];
		return(val);
	}
}

class Add implements Calculate {
	
	@Override
	public int calculate(String arr[]) {
		int result = 0;
		int result2 = 0;
		String vals = "";
		for (int a = 0; a < arr.length - 1; a++) {
			if (arr[a] != null) {
				if (arr[a].equals("+") && result == 0) { 
					result = Integer.parseInt(vals);
					vals = "";
				}
				else {
					vals = vals + arr[a];
				}
			}
		}
		result2 = Integer.parseInt(vals);
		System.out.println(result + " " + result2);
		return(result + result2);
	}
}

class Subtract implements Calculate {
	
	@Override
	public int calculate(String arr[]) {
		int result = 0;
		int result2 = 0;
		String vals = "";
		for (int a = 0; a < arr.length - 1; a++) {
			if (arr[a] != null) {
				if (arr[a].equals("-") && result == 0) { 
					result = Integer.parseInt(vals);
					vals = "";
				}
				else {
					vals = vals + arr[a];
				}
			}
		}
		result2 = Integer.parseInt(vals);
		System.out.println(result + " " + result2);
		return(result - result2);
	}
}

class Multiply implements Calculate {
	
	@Override
	public int calculate(String arr[]) {
		int result = 0;
		int result2 = 0;
		String vals = "";
		for (int a = 0; a < arr.length - 1; a++) {
			if (arr[a] != null) {
				if (arr[a].equals("x") && result == 0) { 
					result = Integer.parseInt(vals);
					vals = "";
				}
				else {
					vals = vals + arr[a];
				}
			}
		}
		result2 = Integer.parseInt(vals);
		System.out.println(result + " " + result2);
		return(result * result2);
	}
}

class Divide implements Calculate {
	
	@Override
	public int calculate(String arr[]) {
		int result = 0;
		int result2 = 0;
		String vals = "";
		for (int a = 0; a < arr.length - 1; a++) {
			if (arr[a] != null) {
				if (arr[a].equals("÷") && result == 0) { 
					result = Integer.parseInt(vals);
					vals = "";
				}
				else {
					vals = vals + arr[a];
				}
			}
		}
		result2 = Integer.parseInt(vals);
		System.out.println(result + " " + result2);
		return(result / result2);
	}
}

public class FirstFX extends Application {
	
	Label label1;
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button button5;
	String arr[] = new String[10];
	boolean number = false;
	boolean symbol = false;
	int i = 0;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("My Calculator");
		GridPane grid = new GridPane();
		GridPane calc_grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		calc_grid.setAlignment(Pos.CENTER);
		grid.setHgap(5.0);
		grid.setVgap(5.0);
		
		for (int b = 0; b < 3; b++) {
			for (int c = 0; c < 3; c++) {
				int num = 3 * b + c + 1;
				Button button = new Button(String.valueOf(num));
				button.setOnAction(new EventHandler<ActionEvent>() {
					
					public void handle(ActionEvent event) {
						if (symbol == true) {
							label1.setText("");
						}
						label1.setText(label1.getText() + button.getText());
						arr[i] = button.getText();
						i++;
						number = true;
						symbol = false;
					}
				});
				grid.add(button, c, b);
			}
			Button bbutton1 = new Button("  ");
			Button bbutton2 = new Button("  ");
			Button zero = new Button("0");
			zero.setOnAction(new EventHandler<ActionEvent>() {
				
				public void handle(ActionEvent event) {
					if (symbol == true) {
						label1.setText("");
					}
					label1.setText(label1.getText() + zero.getText());
					arr[i] = zero.getText();
					i++;
					number = true;
					symbol = false;
				}
			});
			
			grid.add(bbutton1, 0, 3);
			grid.add(zero, 1, 3);
			grid.add(bbutton2, 2, 3);
		}
		
		label1 = new Label("");
		VBox root = new VBox();
		
		button1 = new Button("Calculate");
		button2 = new Button("+");
		button3 = new Button("-");
		button4 = new Button("x");
		button5 = new Button("÷");
		button1.setAlignment(Pos.CENTER);
		button2.setAlignment(Pos.CENTER);
		button3.setAlignment(Pos.CENTER);
		button4.setAlignment(Pos.CENTER);
		button5.setAlignment(Pos.CENTER);
		
		calc_grid.add(button2, 0, 0);
		calc_grid.add(button3, 0, 1);
		calc_grid.add(button4, 1, 0);
		calc_grid.add(button5, 1, 1);
		
		button1.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				Equals equals = new Equals();
				if (number == true) {
					label1.setText(Integer.toString(equals.calculate(arr)));
					arr = new String[10];
					i = 0;
				}
				symbol = true;
			}
		});
		button2.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if (number == true) {
					label1.setText("");
				}
				label1.setText(button2.getText());
				arr[i] = button2.getText();
				i++;
				symbol = true;
			}
		});
		button3.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				if (number == true) {
					label1.setText("");
				}
				label1.setText(button3.getText());
				arr[i] = button3.getText();
				i++;
				symbol = true;
			}
		});
		button4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (number == true) {
					label1.setText("");
				}
				label1.setText(button4.getText());
				arr[i] = button4.getText();
				i++;
				symbol = true;
			}
		});
		button5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (number == true) {
					label1.setText("");
				}
				label1.setText(button5.getText());
				arr[i] = button5.getText();
				i++;
				symbol = true;
			}
		});
		
		root.getChildren().add(label1);
		root.getChildren().add(grid);
		root.getChildren().add(calc_grid);
		root.getChildren().add(button1);
		root.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(root, 200, 300);
		stage.setScene(scene);
		stage.show();
	}
}
