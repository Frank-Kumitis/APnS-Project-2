package project2;
import java.util.ArrayList;

/**
 * 
 * @author Frank_K
 *
 */
public class Main {
	
	/**
	 * 
	 * @param args .
	 */
	
	public static void main(String[] args) {
	
			
		//System.out.println(handEvaluator());
		
	
		/*GraphPlotter test = new GraphPlotter(0.9, 0.0, 2.1);
		
	
		GraphSalter salt = new GraphSalter(6);
		salt.saltGraph();
		

		GraphSmoother smooth = new GraphSmoother(1);
		smooth.smoothGraph();*/
		
		

		/*DistributionsLibrary distLib = new DistributionsLibrary();
			/*System.out.println("geo");
			System.out.println(distLib.getGeometric(.2, 3));
			System.out.println();
			System.out.println("bi");
			System.out.println(distLib.getBinomial(.5, 10, 8));
			System.out.println();
			System.out.println("hyp");
			System.out.println(distLib.getHyperGeometric(52, 13, 5, 2));
			/*System.out.println();
			System.out.println("poisson");
			System.out.println(distLib.getPoisson(.05, 1));
		
		 		*/
		
		
			
	}
	/**
	 * Helper tester method for Card, Hand, Deck classes
	 * @return (String) representation of 10,000 standard 5-card poker hands and their results
	 */
	public static String handEvaluator() {
		String result = "";
		int count = 0;
		for(int i = 0; i < 10000; i++) {
			Deck deck = new Deck();
			deck.shuffleDeck();
			Hand hand = new Hand(deck);
			if(hand.isRoyal()) {
				count++;
			}
			
		}
		result = result.concat("Out of 10,000 hands, " + count + " were a Royal Flush." + "\n");
		count = 0;
		for(int i = 0; i < 10000; i++) {
			Deck deck = new Deck();
			deck.shuffleDeck();
			Hand hand = new Hand(deck);
			if(hand.isStraightFlush()) {
				count++;
			}

		}
		result = result.concat("Out of 10,000 hands, " + count + " were a Straight Flush." + "\n");
		count = 0;
		for(int i = 0; i < 10000; i++) {
			Deck deck = new Deck();
			deck.shuffleDeck();
			Hand hand = new Hand(deck);
			if(hand.is4OfAKind()) {
				count++;
			}

			
		}
		result = result.concat("Out of 10,000 hands, " + count + " were Four-of-a-kind." + "\n");
		count = 0;
		for(int i = 0; i < 10000; i++) {
			Deck deck = new Deck();
			deck.shuffleDeck();
			Hand hand = new Hand(deck);
			if(hand.isFullHouse()) {
				count++;
			}

			
		}
		result = result.concat("Out of 10,000 hands, " + count + " were a Full House." + "\n");
		count = 0;
		for(int i = 0; i < 10000; i++) {
			Deck deck = new Deck();
			deck.shuffleDeck();
			Hand hand = new Hand(deck);
			if(hand.isFlush()) {
				count++;
			}

			
		}
		result = result.concat("Out of 10,000 hands, " + count + " were a Flush." + "\n");
		count = 0;
		for(int i = 0; i < 10000; i++) {
			Deck deck = new Deck();
			deck.shuffleDeck();
			Hand hand = new Hand(deck);
			if(hand.isStraight()) {
				count++;
			}

			
		}
		result = result.concat("Out of 10,000 hands, " + count + " were a Straight." + "\n");
		count = 0;
		for(int i = 0; i < 10000; i++) {
			Deck deck = new Deck();
			deck.shuffleDeck();
			Hand hand = new Hand(deck);
			if(hand.isTwoPair()) {
				count++;
			}

			
		}
		result = result.concat("Out of 10,000 hands, " + count + " were Two Pairs." + "\n");
		count = 0;
		for(int i = 0; i < 10000; i++) {
			Deck deck = new Deck();
			deck.shuffleDeck();
			Hand hand = new Hand(deck);
			if(hand.is3OfAKind()) {
				count++;
			}

			
		}
		result = result.concat("Out of 10,000 hands, " + count + " were Three-of-a-kind." + "\n");
		count = 0;
		for(int i = 0; i < 10000; i++) {
			Deck deck = new Deck();
			deck.shuffleDeck();
			Hand hand = new Hand(deck);
			if(hand.isPair()) {
				count++;
			}

			
		}
		result = result.concat("Out of 10,000 hands, " + count + " were a Pair." + "\n");

		
		return result;
	}
	

	

}

