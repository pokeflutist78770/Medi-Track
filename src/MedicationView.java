import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MedicationView extends BorderPane{
	public User currentUser;
	
	public MedicationView(User currUser) {
		currentUser=currUser;
		setup();
	}
	
	private void setup() {
		
		HBox boxy=new HBox();
		
		for(Medication medicine: currentUser.getMedication()) {
			VBox column=new VBox();
			column.setAlignment(Pos.CENTER);
			
			Label title=new Label(medicine.getName());
			title.setAlignment(Pos.TOP_CENTER);
			
			column.getChildren().add(title);
			
			for(Symptom symptom: medicine.getSymptoms()) {
				Label sympt=new Label("\u2022 "+symptom.getDescription());
				sympt.setAlignment(Pos.CENTER_LEFT);
				sympt.setWrapText(true);
				Label severity=new Label("\u2022 \u2022 "+symptom.getSeverity() + " \u2022 \u2022");
				
				column.getChildren().addAll(sympt, severity);
			}
			boxy.getChildren().add(column);
		}
		
		this.setCenter(boxy);
		
		Button back=new Button("Back");
		back.setAlignment(Pos.TOP_LEFT);;
		back.setOnAction(e -> {
			MainMenu.changeView(new UserScreen(currentUser));
		});
		
		this.setLeft(back);
	}
	
}
