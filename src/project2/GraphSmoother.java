package project2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 * Class to average CSV plot points
 */
public class GraphSmoother {

	private FileWriter fw;
	private BufferedWriter bw;
	/**
	    * (int) range of Y values to smooth
	    */
	private int averageRange = 1;
	/**
	    * ArrayLists to temporarily store values
	    */
	private ArrayList<String> values = new ArrayList<String>();
	private ArrayList<Double> yValues = new ArrayList<Double>();
	/**
	 * Constructs new GraphSmoother object
	 * @param avgRange range of Y values to smooth
	 */
	public GraphSmoother(int avgRange) {
		
		this.averageRange = avgRange;
		
		File file = new File("C:\\Users\\Franc\\eclipse-workspace\\AP&S_Project2\\SaltedPoints.csv");
		try {
		Scanner sc = new Scanner(file);
		sc.useDelimiter(",");
		while (sc.hasNext()) {
		      
		      values.add(sc.next().trim());
		    }
		
			values.remove(values.size() - 1);
		    sc.close();
		
		}catch(Exception e) {
			System.out.println("Error, File Not Found: " + e.toString());
			
		}
		

		smoothY();

		
	}
	/**
	 * Loads values into ArrayList<Double> and averages using applySmoothing(int) helper method.
	 */
	private void smoothY() {
		int count = 0;
		
		for(int i = 0; i < values.size(); i++) {
			
			if(i > 1) {
				
				if(i%2 > 0) {
					
				
				yValues.add(Double.valueOf(values.get(i)));
				
				}
			}		
		}
		
		for(int i = 0; i < yValues.size(); i++) {
			
			yValues.set(i, applySmoothing(i));

			
			
		}
		
		for(int i = 0; i < values.size(); i++) {
			
			if(i > 1 && i%2 > 0) {
				
				values.set(i, String.format("%.2f", yValues.get(count)));
				count++;
		
			}
		}
	}
	
	/**
	 * Helper method to average values, stopping at the top or bottom of values
	 * @param (int) index designates the index of ArrayList<Double> to average 
	 * @return averaged double to place into the ArrayList<>
	 */
	
	private double applySmoothing(int index) {
		
		int tracker = index;
		int count = 0;
		
		double[] temp = new double[(averageRange*2)+1];
		
		for(int i = 0; i <= averageRange; i ++) {
			
			if(tracker > (yValues.size()-1)) {
				tracker--;
			}
			
			temp[count] = yValues.get(tracker);
			
			count++;
			tracker++;
		}
		
		tracker = (index - 1);
		
		for(int i = 1; i <= averageRange; i ++) {
			
			if(tracker < 0) {
				tracker++;
			}
			
			temp[count] = yValues.get(tracker);
		
			count++;
			tracker--;
		}
		
		double sum = 0;
		
		for(int i = 0; i < temp.length; i++) {
			sum += temp[i];
		}
		
		
		sum = sum / temp.length;
		
		
		return sum;
	}
	/**
	 * Outputs new CSV file "SmoothedPoints.csv" with smoothed values
	 */
	public void smoothGraph() {
		
		try {
			fw = new FileWriter("SmoothedPoints.csv");
			bw = new BufferedWriter(fw);
			

		
			String temp = "";
			for(int i = 0; i < values.size(); i++) {
				temp = temp.concat(values.get(i) + ", ");
				if(i%2 == 1) {
					temp = temp.concat("\n");
				}
			}
			temp = temp.substring(0, temp.length()-3);
			bw.write(temp);
			

	        bw.close();
	        fw.close();
	        
			}catch(Exception e){
				System.out.println("IO Exception has occured: " + e.toString());
			}
		
		
	}

}
