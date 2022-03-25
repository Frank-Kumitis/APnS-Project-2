package project2;
import java.io.BufferedWriter;
import java.io.FileWriter;
/**
 * Class to generate a set of data points based upon input slope formula.
 */
public class GraphPlotter {
	
	private FileWriter fw;
    private BufferedWriter bw;
    /**
     * double values representing slope formula.
     */
	private double xVal = 0;
	private double bVal = 0;
	private double mVal = 0;
	private double yVal = 0;
	/**
	 * Constructor setting all necessary variables.
	 * @param m slope
	 * @param x x value
	 * @param b x-intercept
	 */
	public GraphPlotter(double m, double x, double b) {
		 try {
	         
	            fw = new FileWriter("PlotPoints.csv");

	        } catch (Exception e) {
	            System.out.println("Error occured " + e.toString());
	        }
		this.xVal = x;
		this.bVal = b;
		this.mVal = m;
		generateY();
	}
	/**
	 * 
	 * Generates Y point from other variables.
	 */
	private void generateY(){
		yVal = (mVal*xVal) + bVal;
	}
	/**
	 * Getter
	 * @return yVal
	 */
	public double getY() {
		return yVal;
	}
	
	/**
	 * Getter
	 * @return xVal
	 */
	public double getX() {
		return xVal;
	}
	
	/**
	 * Getter
	 * @return mVal
	 */
	public double getM() {
		return mVal;
	}
	
	/**
	 * Getter
	 * @return bVal
	 */
	public double getB() {
		return bVal;
	}

	/**
	 * Outputs file "PlotPoints.csv" with generated values based on formula.
	 * @param input (String) 
	 */
	public void outputSingleLine(String input) {
        bw = new BufferedWriter(fw);
        try {
        	input = input.substring(0, input.length()-3);
            bw.write(input);
            bw.close();
        } catch (Exception e) {
            System.out.println("Write Out Error " + e.toString());
        }
    }
	/**
	 * Generates numbers based on the slope formula to be input to the CSV.
	 * 
	 */
	public void generateNumbers() {

        String temp = "X Value, Y Value, " + "\n";

        for (int i = 0; i < 10; i++) {
          	xVal *= 2;
          	generateY();
            temp = temp.concat("" + xVal + ", " + yVal + ", " + "\n");
        }

        
    }
}

	
	