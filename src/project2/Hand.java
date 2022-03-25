package project2;

import java.util.ArrayList;
import java.util.Arrays;
/**
 *  Class containing comparisons for possible Poker hands and an ArrayList<Card> implementation of a typical 5-card poker hand. 
 * 
 */
public class Hand {
    
	/**
	    * ArrayList<> representation of a 5-card poker hand.
	    */    
    private ArrayList<Card> currentHand = new ArrayList<Card>();
    /**
     * Constructs a new hand.
     * @param deck from which cards will be drawn.
     */
    public Hand(Deck deck) {
        while(currentHand.size() < 5){
            currentHand.add(deck.drawCard());
        }
        
    }
    
    /**
     * 
     * @return true if each Card in this.currentHand has a matching String suit.
     */
    private boolean compareFlush(){
        for(int i = 0; i < currentHand.size(); i++){
        	for(int j = 0; j < currentHand.size(); j++) {
        		if(!(currentHand.get(i).getSuit().compareTo(currentHand.get(j).getSuit()) == 0) && !(j == i)){
        			return false;
        		}
        	}
        }
     
           return true;
    }
    /**
     * 
     * @return true if each value in currentHand (if ordered) equals exactly 1 less than the number high than it.
     */
    private boolean compareStraight(){
        int temp[] = new int[currentHand.size()];
        for(int i = 0; i < currentHand.size(); i++){
            temp[i] = currentHand.get(i).getValue();
        }
        Arrays.sort(temp);
        for(int i = 1; i < temp.length; i++){
            if(!(temp[i] -1 == temp[i - 1])){
                return false;
            }
        }
        
        
        
        return true;
    }
    /**
     * 
     * @return true if the card values total the exact value of a Royal Flush.
     */
    private boolean compareRoyal(){
        int sum = 0;
        for(int i = 0; i < currentHand.size(); i++){
            sum += currentHand.get(i).getValue();
        }
        
        if(sum == 47){
            return true;
        }
        return false;
    }
    /**
     * 
     * @return int representing the the number of times the mode of this.CurrentHand occurs.
     */
    public int highestOfAKind(){
        int most = 0;
        int count = 1;
        int indexOfCurrentMost = 0;
        int[] temp = new int[5];
        for(int i = 0; i < currentHand.size(); i++){
            temp[i] = currentHand.get(i).getValue();
        }
       
        return getCountOfMode(temp);
    }
    /**
     * 
     * @param arr (int[]) int values of the Cards in currentHand.
     * @return int representing number of times the mode of the array occurs.
     */
     private int getCountOfMode(int[] arr) {
        int counter = 0;
        int mode = 0;
        int count = 0;
        for (int possibleMode : arr) {
            count = 0;
            for (int index : arr) {
                if (possibleMode == index) {
                    count++;
                }
            }
            if (count > counter) {
                counter = count;
                mode = possibleMode;
            }
        }
        return counter;
    }
    

     /**
      * 
      * @return true if this.currentHand contains a Royal Flush.
      */
     public boolean isRoyal() {
    	 if(compareFlush() && compareStraight() && compareRoyal()){
             return true;
         }
    	 return false;
     }
     /**
      * 
      * @return true if this.currentHand contains a straight flush.
      */
     public boolean isStraightFlush() {
    	 if(compareFlush() && compareStraight()){
             return true;
         }
    	 return false;
     }
     /**
      * 
      * @return true if this.currentHand contains a 4-of-a-kind.
      */
     public boolean is4OfAKind() {
    	 if(highestOfAKind() == 4){
             return true;
         }
    	 return false;
     }
     /**
      * 
      * @return true if this.currentHand contains a full house.
      */
     public boolean isFullHouse() {
    	 int val1 = currentHand.get(0).getValue();
     	int val2 = currentHand.get(1).getValue();
     	for(int i = 0; i < currentHand.size(); i++) {
     		if(!(val1 == currentHand.get(i).getValue())) {
     			val2 = currentHand.get(i).getValue();
     			
     		}
     		
     		
     	}
     	for(int i = 0; i < currentHand.size(); i++) {
     		if(!(val1 == currentHand.get(i).getValue()) && (!(val2 == currentHand.get(i).getValue()))) {
     			return false;
     			
     		}
     		
     		
     	}
     	 return true;
     }
     /**
      * 
      * @return true if this.currentHand contains a flush.
      */
     public boolean isFlush() {
    	 return compareFlush();
     }
     /**
      * 
      * @return true if this.currentHand contains a straight.
      */
     public boolean isStraight() {
    	 return compareStraight();
     }
     
     /**
      * 
      * @return true if this.currentHand contains a pair of pairs.
      */
     public boolean isTwoPair() {
    	 for(int i = 0; i < currentHand.size(); i++) {
    		 for(int j = 0; j < currentHand.size(); j++) {
    			 if(currentHand.get(j).getValue() == currentHand.get(i).getValue() && !(i == j)) {
    				 if(j > i) {
    					 currentHand.remove(j);
    					 currentHand.remove(i);
    					 if(isPair()) {
    						 return true;
    					 }
    				 } else {
    					 currentHand.remove(i);
    					 currentHand.remove(j);
    					 if(isPair()) {
    						 return true;
    					 }
    				 }
    			 }
    		 }
    	 }
    	 return false;
     
     }
     
     
     /**
      * 
      * @return true if this.currentHand contains a 3-of-a-kind.
      */
     public boolean is3OfAKind() {
    	 if(highestOfAKind() == 3){
             return true;
         }
    	 return false;
     }
     
     /**
      * 
      * @return true if this.currentHand contains a pair.
      */
     public boolean isPair() {
    	 for(int i = 0; i < currentHand.size(); i++) {
    		 for(int j = 0; j < currentHand.size(); j++) {
    			 if(currentHand.get(j).getValue() == currentHand.get(i).getValue() && !(i == j) && !(isTwoPair())) {
    				 return true;
    			 }
    		 }
    	 }
    	 return false;
     }
     
    
    
    
}
