package project2;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class GraphPlotter {

	private FileWriter fw;
    private BufferedWriter bw;
	private double xVal = 0;
	private double bVal = 0;
	private double mVal = 0;
	private double yVal = 0;

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
	
	private void generateY(){
		yVal = (mVal*xVal) + bVal;
	}
	
	public double getY() {
		return yVal;
	}
	
	
	public double getX() {
		return xVal;
	}
	
	
	public double getM() {
		return mVal;
	}
	
	
	public double getB() {
		return bVal;
	}

	
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
	
	public void generateNumbers() {

        String temp = "X Value, Y Value, " + "\n";

        for (int i = 0; i < 10; i++) {
          	xVal *= 2;
          	generateY();
            temp = temp.concat("" + xVal + ", " + yVal + ", " + "\n");
        }

        
    }
}

	
	