/**
 * Test class for Card and Pack classes
 * 
 * @author Mohammad Ali
 * 
 */
public class PackTestHarness {
	public static void main(String[] args) {
		PackTestHarness tester = new PackTestHarness();

		tester.testCard();

		tester.testPack();

		tester.testShuffle();
	}

	/**
	 * Method to test the Card class
	 */
	public void testCard() {
		Card aceOfClubs = new Card(1, 1);
		Card kingOfDiamonds = new Card(13, 2);
		Card queenOfSpades = new Card(12, 3);
		Card sevenOfHearts = new Card(7, 4);

		System.out.println("Created four cards\n");
		int suit = aceOfClubs.getSuit();

		if (suit == 1)
			System.out.println("Correctly made a Club ->"
					+ aceOfClubs.toString());
		else
			System.out.println("Doesn't look like a Club ->"
					+ aceOfClubs.toString());

		int number = kingOfDiamonds.getValue();
		if (number == 13)
			System.out.println("Correctly made a King ->"
					+ kingOfDiamonds.toString());
		else
			System.out.println("Doesn't look like a King ->"
					+ aceOfClubs.toString());

		System.out.println("Cards created -> " + aceOfClubs.toString() + ", "
				+ kingOfDiamonds.toString() + ", " + queenOfSpades.toString()
				+ ", " + sevenOfHearts.toString());
	}

	/**
	 * Method to test the Pack class
	 */
	public void testPack() {
		System.out.println("Creating a pack");
		Pack deck = new Pack();
		System.out.println("Pack has " + deck.size() + " cards in it");
		System.out.println("Top Card is the " + deck.get(0).toString());

		System.out.println("Cards are:");
		deck.display();
	}

	/**
	 * Method to test the Shuffle() method in Pack class
	 */
	public void testShuffle() {
		System.out.println("Creating a pack");
		Pack deck = new Pack();
		System.out.println("Pack has " + deck.size() + " cards in it");
		System.out.println("Top Card is the " + deck.get(0).toString());

		System.out.println("Cards are:");
		deck.display();

		System.out.println("Shuffling the pack");

		deck.shuffle();
		System.out.println("Shuffled Pack has " + deck.size() + " cards in it");
		System.out.println("Bottom Card is the "
				+ deck.get(deck.size() - 1).toString());
		System.out.println("Cards are:");
		deck.display();

	}

}