
package playingcards;

public class card {
    private int suit;
    private int rank;
    /**
     * 
     * 
     * @param rank makes the number 0=2 12 = ace
     * @param suit the suit of the cards.
     */
    public card(int rank, int suit){
        
      
        this.suit = suit;
        this.rank = rank;
        
    }
public card (int cardno){
    this.rank = cardno % 13;
    this.suit = (cardno/13) % 4;
    
}
public int rank(){ return rank;
}
public int suit(){ return suit;
}
public boolean samesuit(card c ) {
    return (this.suit == c.suit);
}
public boolean samerank(card c ) {
    return (this.rank == c.rank);
}
public boolean samecard(card c ) {
    return (this.samerank(c) && this.samesuit(c));
}
public String tostring() {
    String ranks = "23456789TJQKA";
    String suits = "\u2663 \u2666 \u2665 \u2660"; 
    return ranks.charAt(rank) + "" + suits.charAt(suit);
}


}
