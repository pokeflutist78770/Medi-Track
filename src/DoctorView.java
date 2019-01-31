import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class DoctorView extends BorderPane{

	public User currentUser;
	
	public DoctorView(User currentUser) {
		this.currentUser=currentUser;
		setup();
	}
	
	
	
	private void setup() {
		
		VBox emailForm=new VBox();
		Label intro=new Label("Please enter your doctors email and message");
		intro.setAlignment(Pos.TOP_CENTER);
		
		TextField email=new TextField();
		email.setPromptText("Doctor Email");
		email.setPadding(new Insets(20));
		
		
		Label blank=new Label("");
		
		TextField message=new TextField();
		message.setPadding(new Insets(20));
		message.setMinHeight(300);
		emailForm.getChildren().addAll(intro, email, blank, message);
		
		
		Button back=new Button("Back");
		back.setAlignment(Pos.TOP_LEFT);
		back.setOnAction(e -> {
			MainMenu.changeView(new UserScreen(currentUser));
		});
		
		this.setCenter(emailForm);
		this.setTop(back);
		
		Button submit=new Button("Submit");
		submit.setOnAction(e ->{
			MainMenu.changeView(new UserScreen(currentUser));
		});
		
		submit.setAlignment(Pos.TOP_CENTER);
		this.setBottom(submit);
		

	}
	
	
	
}
