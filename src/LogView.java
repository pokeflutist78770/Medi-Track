import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class LogView extends BorderPane{

	public User currentUser;
	
	public LogView(User currentUser) {
		this.currentUser=currentUser;
		setup();
	}
	
	
	
	private void setup() {
		
		VBox questions=new VBox();
		questions.setAlignment(Pos.CENTER);
		Label greeting=new Label("Hello "+currentUser.getName()+",");
		greeting.setPadding(new Insets(10));
		
		Label q1=new Label("On a scale of 1 through 10, how happy were you today? (10 happy, 1 sad)");
		q1.setWrapText(true);
		
		ChoiceBox rating=new ChoiceBox();
		rating.getItems().setAll(1,2,3,4,5,6,7,8,9,10);
		
		Label symptoms=new Label("Please write any symptoms you felt, and separate each one with a comma");
		
		TextField writeSympt=new TextField();
		writeSympt.setMinHeight(200);
		writeSympt.setMaxWidth(600);
		
		
		questions.getChildren().addAll(greeting, q1, rating, symptoms, writeSympt);
		Button back=new Button("Back");
		back.setAlignment(Pos.TOP_LEFT);
		back.setOnAction(e -> {
			MainMenu.changeView(new UserScreen(currentUser));
		});
		
		this.setTop(back);
		
		Button submit=new Button("Submit");
		submit.setOnAction(e ->{
			int num=(int) rating.getSelectionModel().getSelectedItem();
			if(num<6) {
				num*=-1.5;
			}
			else {
				num*=1.1;
			}
			
			currentUser.addToHappinessScore(num);
			
			MainMenu.changeView(new UserScreen(currentUser));
		});
		
		submit.setAlignment(Pos.TOP_CENTER);
		this.setBottom(submit);
		
		this.setCenter(questions);
	}
	
	
	
}
