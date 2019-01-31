import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;





public class TrendView extends BorderPane {
	private User currentUser;
	
	
	public TrendView(User currUser) {
		currentUser=currUser;
		
		setup();
	}
	
	
	private void setup() {
		//Defining X axis  
		NumberAxis xAxis = new NumberAxis(1960, 2020, 10); 
		xAxis.setLabel("Days"); 
		xAxis.setLowerBound(0);
		xAxis.setUpperBound(7);
		        
		//Defining y axis 
		NumberAxis yAxis = new NumberAxis(0, 350, 50); 
		yAxis.setLabel("Happy Score");
		yAxis.setLowerBound(0);
		yAxis.setUpperBound(100);
		
		LineChart linechart = new LineChart(xAxis, yAxis);
		//linechart.set
		XYChart.Series series = new XYChart.Series(); 
		series.setName("Happy Score Over Last Week");
		
		int sum=0;
		ArrayList<Integer> list=currentUser.getScores();
		
		for(int i=0; i< 8; i++) {
			sum+=list.get(list.size()-(8-i));
			series.getData().add(new XYChart.Data(i, list.get(list.size()-(8-i))));
		}
		
		
		XYChart.Series average = new XYChart.Series(); 
		average.setName("Average Over Last 7 Days");
		for(int i=0; i< 8; i++) {
			average.getData().add(new XYChart.Data(i, sum/8));
		}
		
		//Setting the data to Line chart    
		linechart.getData().add(series);
		linechart.getData().add(average);
		
		this.setCenter(linechart);
		
		
		Button back=new Button("Back");
		back.setAlignment(Pos.TOP_LEFT);;
		back.setOnAction(e -> {
			MainMenu.changeView(new UserScreen(currentUser));
		});
		this.setLeft(back);
	}
	
}
