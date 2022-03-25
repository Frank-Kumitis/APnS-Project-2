package project2;
/**
 * Object representing a playing card
 */
public class Card {
	/**
	    * val (int) representing the number of the card
	    */
	private int cardValue;
	/**
	    * suit (String) representing which of the four suits the card is.
	    */
	private String cardSuit;
	/**
	 * 
	 * @param val (int) representing the number of the card
	 * @param suit (String) representing which of the four suits the card is.
	 */
		public Card(int val, String suit) {
			
			this.cardValue = val;
			
			this.cardSuit = suit;
			
		}
		/**
		 * 
		 * @return get (int) this.value
		 */
		public int getValue() {
			
			return this.cardValue;
			
		}
		/**
		 * 
		 * @return get (String) this.suit
		 */
		public String getSuit() {
			
			return this.cardSuit;
			
		}
		
		/**
		 * @return (String) Simplified string representation of this Card.
		 */
		public String toString() {
			
			return cardValue + " of " + cardSuit;

		}

}
