package project2;
import java.math.BigInteger;
import java.util.InputMismatchException;
/**
 * Library for pmf distribution calculation
 */
public class DistributionsLibrary{
	/**
	    *Euler's number for the Poisson distribution
	    */
		private final double e = 2.71828;
	
		/**
		 * Calculates probability of Y
		 * @param average lambda average occurences per unit of time
		 * @param y desired number of occurences
		 * @return probability of Y occurences
		 */
	public double getPoisson(double average, int y) {
		
		return (Math.pow(average, y) * (Math.pow(e, (average)*-1))) / getFactorial(y).intValue();

	}
	/**
	 * Calculates probability of y successes across n trials
	 * @param p = probability of A
	 * @param n = n trials
	 * @param y = desired occurences of p during n trials
	 * @return probability of y successes across n trials
	 */
	public double getBinomial(double p, int n, int y) {
		
		double q = getInverse(p);
	
			return (getCombination(n, y)) * (Math.pow(p, y)) * (Math.pow(q, n-y));
		
	}
	/**
	 * Calculates probability of a success after y trials
	 * @param p probability of a
	 * @param y number of trials before a success
	 * @return probability of success after y trials
	 */
	public double getGeometric(double p, int y) {
		
		double q = getInverse(p);
		
			return  Math.pow(q, y-1)*p;
		
	}
	
	/**
	 * Calculates probability of x based upon n,r,N
	 * @param N Population of objects with two states, S or F
	 * @param n subset of N tested on 
	 * @param r subset of N with state S
	 * @param x desired number of r
	 * @return probability of x based upon n,r,N
	 */
	public double getHyperGeometric(int N, int n, int r, int x) {
		
		return ((getCombination(r, x)) * (getCombination(N-r, n-x))) / (getCombination(N, n));

	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Helper method utilizing BigInteger to avoid overflow problems due to Factorial operation's large values.
	 * Calculates factorial of 
	 * @param number (int)
	 * @return BigInteger factorial
	 */
	private BigInteger getFactorial(int number){
		
		BigInteger result = new BigInteger("1");
		
		BigInteger input = new BigInteger(String.valueOf(number));
		
		while(input.intValue() > 1) {
			
			result = result.multiply(input);
			
			input = input.subtract(new BigInteger("1"));
			
		}
		
		return result;
		
	}
	/**
	 * Calculates inverse probability of A
	 * @param probability of a
	 * @return inverse of probability a
	 * @throws InputMismatchException ensures 0 < p(a) < 1
	 */
	private double getInverse(double probability) throws InputMismatchException {
		
		if(probability > 1) {
			
			throw new InputMismatchException();
			
		} else if (probability < 0) {
			
			throw new InputMismatchException();
			
		}
		
		return 1 - probability;
		
	}
	
	/**
	 * Calculates combinatoric operation on n, r
	 * @param n total sample space
	 * @param r tests across sample space
	 * @return double value of nCr
	 */
	private double getCombination(int n, int r){

		
		BigInteger numerator = getFactorial(n);
		
		BigInteger denominator1 = getFactorial(n-r);
		
		BigInteger denominator2 = getFactorial(r);
		
		BigInteger denominator = denominator1.multiply(denominator2);
		
		return numerator.divide(denominator).doubleValue();
		
	}
	


}
