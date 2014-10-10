
public class Card {
	private int cardNum;
	private int suitNum;
	private String[] cardName = {"","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"}; //initialises the array for the names of the cards
	private String[] suitName = {"", "Clubs","Diamonds","Spades","Hearts"};	//initialises the array for the name of the suits
	public Card(int cardNum, int suitNum) {
		this.cardNum = cardNum;       //we've assigned values to cards. 1, 11, 12 and 13 are for Ace, Jack, Queen and King respectively
		this.suitNum = suitNum;		  //we've also assigned values to the cards 1,2,3 and 4 are for Clubs, Diamonds, Spades and Hearts respectively
	}

	public int getValue() {
		return this.cardNum;  //gets the value of the card
	}

	public int getSuit() {
		return this.suitNum;  //gets the value of the suit
	}

	public String toString() {
		return (cardName[cardNum]) + " of " + (suitName[suitNum]);  //converts the numbers of the card and suit and returns their name instead of writing 
																	//an if statement or a switch case for each card and suit number, the array was made
																	// at the beginning of the class
	}
	public boolean higherThan(Card card){
		boolean ok = false;
		if(this.getValue()> card.getValue()){			//if the card guessed was higher than the previous one, then the value turns true as
			ok = true;									//the user had guessed correctly. Otherwise, the user is wrong
		}
		else if(this.getValue()==card.getValue()){		//if the value of the cards is the same, then the value of the suits is compared
			if(this.getSuit()>card.getSuit()){
				ok = true;
			}
		}
		return ok;
	}
	public boolean lowerThan(Card card){
		boolean ok = false;								//if the card guessed was lower than the previous one, then the value turns true as the
		if(this.getValue()<card.getValue()){			// user had guessed correctly. Otherwise, the user is wrong
			ok = true;
		}
		else if(this.getValue()==card.getValue()){		//if the value of the cards is the same, the value of the suits is compared
			if(this.getSuit()<card.getSuit()){
				ok = true;
			}
	}
		return ok;
	}
}