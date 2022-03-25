package project2;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
/**
 * Class to salt CSV plot points
 */
public class GraphSalter {


	private FileWriter fw;
	private BufferedWriter bw;
	/**
	    * Range to salt values with
	    */
	private int saltRange = 0;
	private ArrayList<String> values = new ArrayList<String>();

	/**
	 * Constructs new graphSalter object
	 * @param saltRange range to be randomized in
	 */
	public GraphSalter(int saltRange) {

		setSaltRange(saltRange);
		
		File file = new File("C:\\Users\\Franc\\eclipse-workspace\\AP&S_Project2\\PlotPoints.csv");
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
	

	}
	/**
	 * Getter
	 * @return saltRange
	 */
	public int getSaltRange() {
		return this.saltRange;
	}
	/**
	 * Setter
	 * @param desiredSaltRange mutator
	 */
	public void setSaltRange(int desiredSaltRange) {
		this.saltRange = desiredSaltRange;
	}
	
	/**
	 * Applies random double subtraction addition with 1 significant figure to each CSV Y value
	 */
	private void randomize() {
		double[] temp = new double[values.size()];
		
		
		
		for(int i = 0; i < temp.length; i++) {
			if(i > 1) {
			temp[i] = Double.valueOf(values.get(i));
			}
		}
		


		
		for(int i = 0; i < temp.length; i++) {
		
				if(i % 2 == 1) {				
					int positivity = (int) (Math.random() * 2);
					if(positivity > 0) {
						temp[i] = ((temp[i]) + (Math.random()*saltRange));
					} else {
						temp[i] = ((temp[i]) - (Math.random()*saltRange));
					}
					
				}
	
		
			
		}
		
		for(int i = 0; i < temp.length; i++){
			if(i > 1) {
							
			values.set(i, String.format("%.1f", temp[i]));
			}
			
			
			}
		
	
	}
	
	/**
	 * Outputs CSV file "SaltedPoints.csv" with updated Y values
	 * 
	 */
	public void saltGraph() {
		
		randomize();
	
		
		try {
		fw = new FileWriter("SaltedPoints.csv");
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
