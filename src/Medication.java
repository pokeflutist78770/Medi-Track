import java.util.ArrayList;






public class Medication {
	private String name;
	private ArrayList<Symptom> symptoms;
	
	public Medication(String name) {
		this.name=name;
		symptoms=new ArrayList<>();
	}
	
	
	
	public void addSymptom(Symptom symptom) {
		symptoms.add(symptom);
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Symptom> getSymptoms() {
		return symptoms;
	}
	
	
}
