import java.util.ArrayList;
import java.util.HashMap;




public class User {
	private String name;
	private int age;
	private int happinessScore;
	private ArrayList<Integer> scores;
	private ArrayList<Medication> medication;
	
	public User(String name, int age) {
		this.name=name;
		this.age=age;
		medication=new ArrayList<>();
		scores=new ArrayList<>();
		
		scores.add(75);
		scores.add(78);
		scores.add(30);
		scores.add(46);
		scores.add(42);
		scores.add(58);
		scores.add(59);
		scores.add(65);
		scores.add(40);
		scores.add(16);
		scores.add(39);
		scores.add(46);
		scores.add(57);
		scores.add(54);
		
		this.happinessScore=70;    //Baseline, treated like a school A to F scale out of 100
	}
	
	public void addMedication(Medication medicine) {
		medication.add(medicine);
	}
	
	public void addToHappinessScore(int increment) {
		happinessScore+=increment;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public ArrayList<Medication> getMedication(){
		return medication;
	}
	
	public ArrayList<Integer> getScores(){
		return scores;
	}
	
	public int getHappinessScore() {
		return happinessScore;
	}
	
}
