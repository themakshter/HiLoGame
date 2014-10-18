import java.util.*;
import java.util.ArrayList;

public class Pack {
	private ArrayList<Card> packOfCards = new ArrayList<Card>();
	private Card chosenCard;

	public Pack() {
		// instead of adding every card, loop used
		for (int suit = 1; suit <= 4; suit++) {
			for (int card = 1; card <= 13; card++) {
				packOfCards.add(new Card(card, suit));
			}
		}
	}

	/**
	 * Prints out all the cards in the pack
	 */
	public void display() {
		for (Card c : packOfCards)
			System.out.println(c.toString());
	}

	/**
	 * Method to determine size of the pack
	 * 
	 * @return size of the pack
	 */
	public int size() {
		int packSize;
		packSize = packOfCards.size();
		return packSize;
	}

	/**
	 * gets a certain card from its position
	 * 
	 * @param position
	 *            number in array of the pack
	 * @return card at the given position
	 */
	public Card get(int position) {
		chosenCard = packOfCards.get(position);
		return chosenCard;

	}

	/**
	 * Shuffles the pack
	 */
	public void shuffle() {
		Random generator = new Random();
		for (int i = 0; i < 100; i++) {

			// get two random positions from pack
			int randomCardNum1 = generator.nextInt(packOfCards.size());
			int randomCardNum2 = generator.nextInt(packOfCards.size());

			// gets card from the positions
			Card Card1 = packOfCards.get(randomCardNum1);
			Card Card2 = packOfCards.get(randomCardNum2);

			// switch the two cards
			packOfCards.set(randomCardNum2, Card1);
			packOfCards.set(randomCardNum1, Card2);
		}
	}
}