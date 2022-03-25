package project2;
import java.util.ArrayList;
/**
 * Class for creating and manipulating ArrayList<> based representations of a deck.
 */
public class Deck{
	/**
	 * ArrayList<Object> Representation of a standard 52-card deck
	 * Consists of Card objects.
	 */
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	/**
	 * The 4 possible suits of any given card
	 */
	private enum Suits{
		hearts,
		spades,
		clubs,
		diamonds
	}
	/**
	 * Constructs an ordered deck
	 */
	public Deck() {
		for (Suits suits : Suits.values()) {
		    for(int i = 1; i < 14; i++) {
		    	deck.add(new Card(i, suits.toString()));
		    }
		}
		
	}
	
	/**
	 * Get method
	 * @return 		this.ArrayList<Deck>
	 */
	public ArrayList<Card> getDeck(){
		return this.deck;
		
	}
	
	/**
	 * Void		Moves all cards in this.ArrayList<Deck> to a new ArrayList<Deck> in a random order before returning them
	 */
	public void shuffleDeck() {
		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		while(deck.size() > 0 ) {
		shuffledDeck.add(deck.remove((int)(Math.random()*size())));
		}	
		while(shuffledDeck.size() > 0) {
			deck.add(shuffledDeck.remove(0));
		}
	}
	
	/**
	 * @return		Card object at index(0) of this.ArrayList<Card>
	 */
	public Card drawCard() {
		 return deck.remove(0);		
	}
	
	/**
	 * @return		this.ArrayList<Card> size
	 */
	public int size() {
		return deck.size();
	}
	
	
	
	
	
}
