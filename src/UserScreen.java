import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class UserScreen extends BorderPane {
	public User currUser;
	
	public UserScreen (User currentUser) {
		currUser=currentUser;
		setup();
	}
	
	private void setup() {
		Label name=new Label(currUser.getName()+" (Age: "+currUser.getAge()+")");
		Label happiness=new Label("Current Happiness Score: "+currUser.getHappinessScore());
		
		name.setPadding(new Insets(40));
		happiness.setPadding(new Insets(40));
		
		name.setAlignment(Pos.TOP_LEFT);
		happiness.setAlignment(Pos.TOP_RIGHT);
		this.setLeft(name);
		this.setRight(happiness);
		this.setBottom(setupButtons());
	}
	
	
	
	private VBox setupButtons() {
		VBox buttons=new VBox();
		buttons.setAlignment(Pos.CENTER);
		buttons.setPadding(new Insets(0,0,100,0));
		HBox row1=new HBox();
		HBox row2=new HBox();
		
		row1.setAlignment(Pos.CENTER);
		row2.setAlignment(Pos.CENTER);
		Image logo=new Image("file:/images/logo.png", false);
		ImageView logoView=new ImageView(logo);
		
		ButtonHandler handler=new ButtonHandler();
		
		
		Button button1=new Button("Log For Today");
		button1.setPadding(new Insets(5));
		button1.setMinWidth(200);
		button1.setMinHeight(225);
		button1.setMaxWidth(200);
		button1.setMaxHeight(225);
		button1.setWrapText(true);
		button1.setTextAlignment(TextAlignment.CENTER);
		button1.setOnAction(handler);
		
		Button button2=new Button("Trends");
		button2.setPadding(new Insets(5));
		button2.setMinWidth(200);
		button2.setMinHeight(225);
		button2.setMaxWidth(200);
		button2.setMaxHeight(225);
		button2.setWrapText(true);
		button2.setTextAlignment(TextAlignment.CENTER);
		button2.setOnAction(handler);
		
		Button button3=new Button("Submit to Doctor");
		button3.setPadding(new Insets(5));
		button3.setMinWidth(200);
		button3.setMinHeight(225);
		button3.setMaxWidth(200);
		button3.setMaxHeight(225);
		button3.setWrapText(true);
		button3.setTextAlignment(TextAlignment.CENTER);
		button3.setOnAction(handler);
		
		Button button4=new Button("Your Medication");
		button4.setPadding(new Insets(5));
		button4.setMinWidth(200);
		button4.setMinHeight(225);
		button4.setMaxWidth(200);
		button4.setMaxHeight(225);
		button4.setWrapText(true);
		button4.setTextAlignment(TextAlignment.CENTER);
		button4.setOnAction(handler);
		
		Button button5=new Button();
		button5.setPadding(new Insets(5));
		button5.setMinWidth(200);
		button5.setMinHeight(225);
		button5.setMaxWidth(200);
		button5.setMaxHeight(225);
		button5.setWrapText(true);
		button5.setTextAlignment(TextAlignment.CENTER);
		button5.setOnAction(handler);
		
		Button button6=new Button();
		button6.setPadding(new Insets(5));
		button6.setMinWidth(200);
		button6.setMinHeight(225);
		button6.setMaxWidth(200);
		button6.setMaxHeight(225);
		button6.setWrapText(true);
		button6.setTextAlignment(TextAlignment.CENTER);
		button6.setOnAction(handler);
		
		row1.getChildren().addAll(button1, button2, button3);
		row2.getChildren().addAll(button4, button5, button6);
		
		buttons.getChildren().addAll(row1, row2);
		return buttons;
	}
	
	
	
	
	private class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			Button button=(Button) event.getSource();
			
			if(button.getText().equals("Trends")) {
				MainMenu.changeView(new TrendView(currUser));
			}
			else if(button.getText().equals("Your Medication")) {
				MainMenu.changeView(new MedicationView(currUser));
			}
			else if(button.getText().equals("Log For Today")) {
				MainMenu.changeView(new LogView(currUser));
			}
			else if(button.getText().equals("Submit to Doctor")) {
				MainMenu.changeView(new DoctorView(currUser));
			}
			
		}
		
		
	}
}











