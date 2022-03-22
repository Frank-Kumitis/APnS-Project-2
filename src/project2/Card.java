package project2;
public class Card {
	
	private int cardValue;
	private String cardSuit;
	
		public Card(int val, String suit) {
			this.cardValue = val;
			this.cardSuit = suit;
		}
		
		public int getValue() {
			return this.cardValue;
		}
		
		public String getSuit() {
			return this.cardSuit;
		}
		
		public void setValue(int val) {
			this.cardValue = val;
		}
		
		public void setSuit(String suit) {
			this.cardSuit = suit;
		}
		
		public String toString() {
			return cardValue + " of " + cardSuit;
		}

}
