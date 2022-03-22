package project2;
import java.util.ArrayList;
public class Deck{

	private ArrayList<Card> deck;
	private enum Suits{
		heart,
		spade,
		club,
		diamond
	}
	
	public Deck() {
		deck = new ArrayList<Card>();
		for (Suits suits : Suits.values()) {
		    for(int i = 1; i < 14; i++) {
		    	deck.add(new Card(i, suits.toString()));
		    }
		}
		
	}
	
	
	
	public ArrayList<Card> toDeck(){
		return this.deck;
		
	}
	
	public void shuffleDeck() {
		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		while(deck.size() > 0 ) {
		shuffledDeck.add(deck.remove((int)(Math.random()*size())));
		}	
		
		deck = shuffledDeck;
	}
	
	public Card drawCard() {
		
		 return deck.remove(0);		
		
	}
	
	public int size() {
		return deck.size();
	}
	
	
	
	
	
}
