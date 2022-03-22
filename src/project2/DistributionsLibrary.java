package project2;
import java.math.BigInteger;
import java.util.InputMismatchException;
public class DistributionsLibrary{

	
	//Handle 0 Exceptions?
	
	public double getPoisson(double average, int y) {
		double e = 2.1782384; //update to REAL euler's number
		
		return (Math.pow(average, y) * (Math.pow(e, (average)*-1))) / getFactorial(y).intValue();



		
	}
	
	public double getBinomial(double p, int n, int y) {
		double q = getInverse(p);
	
		return (getCombination(n, y)) * (Math.pow(p, y)) * (Math.pow(q, n-y));
		
		
		//(n choose y) * p^y * q^(n-y)
	}
	
	public double getGeometric(double p, int y) {
		double q = getInverse(p);
		
		return  Math.pow(q, y-1)*p;
		
	
		//Required: handle exceptions
		
	}
	
	/*
	 * @params
	 * 	(int) 
	 */
	public double getHyperGeometric(double p, int y, int N, int n) {
		
		
		return ((getCombination(n, y)) * (getCombination(N-y, n-y))) / getCombination(N, n);
		//N n r y
		//(n choose y) * (N-r choose n-y)
		//_______________________________
		//
		//        (N choose n)

	}
	
	
	private BigInteger getFactorial(int number){
		BigInteger result = new BigInteger("1");
		BigInteger input = new BigInteger(String.valueOf(number));
		while(input.intValue() > 1) {
			result = result.multiply(input);
			input = input.subtract(new BigInteger("1"));
		}
		return result;
	}
	
	private double getInverse(double probability) throws InputMismatchException {
		if(probability > 1) {
			throw new InputMismatchException();
		} else if (probability < 0) {
			throw new InputMismatchException();
		}
		return 1 - probability;
	}
	
	
	private int getCombination(int n, int r){

		
		BigInteger numerator = getFactorial(n);
		BigInteger denominator1 = getFactorial(n-r);
		BigInteger denominator2 = getFactorial(r);
		BigInteger denominator = denominator1.multiply(denominator2);
		return numerator.divide(denominator).intValue();
	}
	


}
