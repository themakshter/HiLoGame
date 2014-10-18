/**
 * Model class of a card in a deck
 * 
 * @author Mohammad Ali
 * 
 */
public class Card {

	private int cardNum;
	private int suitNum;

	// initialise array for card and suit names
	private String[] cardName = { "", "Ace", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
	private String[] suitName = { "", "Clubs", "Diamonds", "Spades", "Hearts" };

	/**
	 * Constructor for the class
	 * 
	 * @param cardNum
	 *            number of the card
	 * @param suitNum
	 *            number of the suit
	 */
	public Card(int cardNum, int suitNum) {
		this.cardNum = cardNum;
		this.suitNum = suitNum;
	}

	/**
	 * Gets value of the card
	 * 
	 * @return number of the card
	 */
	public int getValue() {
		return this.cardNum;
	}

	/**
	 * Get number of the suit
	 * 
	 * @return number of card suit
	 */
	public int getSuit() {
		return this.suitNum; // gets the value of the suit
	}

	/**
	 * Returns string version of card
	 */
	public String toString() {
		// use array values initialised in the class
		return (cardName[cardNum]) + " of " + (suitName[suitNum]);
	}

	/**
	 * Comparator method to check card is higher value
	 * 
	 * @param card
	 *            Card to compare against
	 * @return true if card is greater, false otherwise
	 */
	public boolean higherThan(Card card) {
		boolean ok = false;
		if (this.getValue() > card.getValue()) {
			ok = true;
		} else if (this.getValue() == card.getValue()) {
			if (this.getSuit() > card.getSuit()) {
				ok = true;
			}
		}
		return ok;
	}

	/**
	 * Comparator implementation to check if card is lower value
	 * 
	 * @param card
	 * @return true if card is lower, false otherwise
	 */
	public boolean lowerThan(Card card) {
		boolean ok = false;
		if (this.getValue() < card.getValue()) {
			ok = true;
		} else if (this.getValue() == card.getValue()) {
			if (this.getSuit() < card.getSuit()) {
				ok = true;
			}
		}
		return ok;
	}
}