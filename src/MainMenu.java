import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;






public class MainMenu extends Application {
	public Stage mainStage;
	public static BorderPane  root;
	public Label response;
	public static Pane currentWindow;
	public Button userScreenTransition;
	
	public HashMap<String, Medication> medicationList;
	public ArrayList<User> userList;
	public User currentUser;
	
	public static int WIDTH, HEIGHT;
	
	public static void main(String args[]) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		WIDTH=1000;
		HEIGHT=600;
		
		setup();
		
		
		
		mainStage = primaryStage;    
		primaryStage.setTitle("Medi-Track");
		
		root = new BorderPane();
		currentWindow=root;
		
		Image logo=new Image("file:/images/logo_transparent.png", false);
		ImageView logoView=new ImageView(logo);
		//logoView.setImage(logo);
		
		logoView.setFitHeight(150);
		logoView.setFitWidth(150);
		
	
		//set up basic greeting
		Label greeting=new Label("Welcome Angel!");
		Label question=new Label("How are you feeling today?");
		response=new Label();
		response.setVisible(false);
		
		question.setPadding(new Insets(10,10,40,10));
		response.setPadding(new Insets(50,0,0,0));
		
		//Set up choices for the question posed
		ToggleGroup choice=new ToggleGroup();
		RadioButton good=new RadioButton("Good");
		RadioButton bad=new RadioButton("Bad");
		RadioButton notSure=new RadioButton("Not Sure");
		
		ChoiceHandler mooder=new ChoiceHandler();
		good.setOnAction(mooder);
		bad.setOnAction(mooder);
		notSure.setOnAction(mooder);
		
		good.setToggleGroup(choice);
		bad.setToggleGroup(choice);
		notSure.setToggleGroup(choice);
		
		good.setPadding(new Insets(10));
		bad.setPadding(new Insets(10));
		notSure.setPadding(new Insets(10));
		
		
		//Set all choices in a nice HBox
		HBox choices = new HBox();
		choices.getChildren().addAll(good,bad,notSure);
		choices.setAlignment(Pos.CENTER);
		
		
		userScreenTransition=new Button("Let's go!");
		userScreenTransition.setOnAction(e -> {
			UserScreen userScreen = new UserScreen(currentUser);
			changeView(userScreen);
		});
		
		userScreenTransition.setVisible(false);
		
		HBox buttonBox = new HBox();
		buttonBox.getChildren().add(userScreenTransition);
		buttonBox.setPadding(new Insets(40,0,0,0));
		buttonBox.setAlignment(Pos.TOP_CENTER);
		//Lay everything out before displaying it
		VBox intro = new VBox();
		intro.getChildren().addAll(greeting, question, choices, response, buttonBox);
		
		intro.setAlignment(Pos.TOP_CENTER);
		intro.setPadding(new Insets(100,0,0,0));
		
		//root.setTop(logoView);
		root.setCenter(intro);

		Scene scene=new Scene(currentWindow, 1000,600);
		scene.getStylesheets().clear();
		scene.getStylesheets().add("style.css");
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	/* setup
	 * servees to set up global variables as well as information that will be used for the application
	 * Parameters: None
	 * Returns: None
	 */
	private void setup() {
		//norrmally this would just be a file we update
		medicationList=new HashMap<>();
		userList=new ArrayList<>();
		
		//Set up all basic symptoms for medication
		Symptom itching=new Symptom("Itching/Hives",50);
		Symptom faceSwelling=new Symptom("Swelling in face/hands", 40);
		Symptom anxiety=new Symptom("Anxiety/Restlessness", 25);
		Symptom eyePain=new Symptom("Eye pain", 34);
		Symptom blistering=new Symptom("Blistering, peeling, or red skin rash", 45);
		Symptom musclePain=new Symptom("Muscle/Joint pain", 30);
		Symptom vision=new Symptom("Vision changes", 15);
		Symptom seizures=new Symptom("Seizures", 75);
		Symptom chestTight=new Symptom("Chest tightening", 20);
		Symptom breathing=new Symptom("Trouble breathing", 35);
		Symptom hallucination=new Symptom("Seeing or hearing things that are not there", 50);
		Symptom heartbeat=new Symptom("Fast, slow, or uneven heartbeat", 35);
		Symptom fear=new Symptom("Feeling like people are against you", 25);
		Symptom cutting=new Symptom("Thoughts of hurting yourself or others", 55);
		
		
		//add medication
		Medication sertaline=new Medication("Sertaline");
		sertaline.addSymptom(itching);
		sertaline.addSymptom(faceSwelling);
		sertaline.addSymptom(anxiety);
		sertaline.addSymptom(eyePain);
		sertaline.addSymptom(blistering);
		sertaline.addSymptom(cutting);
		sertaline.addSymptom(hallucination);
		medicationList.put("Sertaline", sertaline);
		
		Medication bupropion=new Medication("Bupropion");
		bupropion.addSymptom(musclePain);
		bupropion.addSymptom(vision);
		bupropion.addSymptom(itching);
		bupropion.addSymptom(seizures);
		bupropion.addSymptom(fear);
		bupropion.addSymptom(heartbeat);
		bupropion.addSymptom(chestTight);
		bupropion.addSymptom(blistering);
		medicationList.put("Bupropion", bupropion);
		
		//set up current users and their medication
		User angel=new User("Angel", 21);
		angel.addMedication(medicationList.get("Bupropion"));
		angel.addMedication(medicationList.get("Sertaline"));
		
		currentUser=angel;
		userList.add(angel);
	}
	
	
	public static void changeView(Pane newView) {
		currentWindow=newView;
		root.setCenter(newView);
	}
	
	private class ChoiceHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			RadioButton mood=(RadioButton) event.getSource();
			
			
			if(mood.getText().equals("Good")) {
				response.setText("That's awesome! Keep it up! :)");
				response.setVisible(true);
				currentUser.addToHappinessScore(1);
			}
			else if(mood.getText().equals("Bad")){
				response.setText("I'm sorry about that! But we can make it better!");
				response.setVisible(true);
				currentUser.addToHappinessScore(-1);
			}
			else if(mood.getText().equals("Not Sure")) {
				response.setText("Well, lets find out!");
				response.setVisible(true);
			}
			
			userScreenTransition.setVisible(true);
		}
	}
}










