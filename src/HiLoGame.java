import java.io.*;

/**
 * Implementation of HiLoGame
 * 
 * @author Mohammad Ali
 * 
 */
public class HiLoGame {
	public static void main(String[] args) {
		Pack myPack = new Pack(); // creates a new pack
		myPack.shuffle(); // shuffles the new pack
		HiLoGame aGame = new HiLoGame(); // creates a new game
		System.out
				.println("Welcome, fellow mortal, to the High or Lower game!");
		int play = 1;
		// loop till player declines to play
		while (play == 1) {
			System.out.println("Choose where you want to cut the pack at.");
			int cutPackNum;
			// prompt user to cut the pack
			do {
				cutPackNum = aGame.readIntegerFromCmd() - 1;
			} while (cutPackNum < 0 || cutPackNum > 51); // keep asking till
															// they get it right
			Card firstCard = myPack.get(cutPackNum);
			// show chosen card
			System.out.println("The card you have chosen is the "
					+ firstCard.toString());
			// ask to chose higher or lower
			System.out
					.println("What do you think the next card will be?(H)igher or (L)ower?");
			String choice;
			do {
				choice = aGame.readStringFromCmd();
			} while (!(choice.equals("H") || choice.equals("L")));
			// Display their prediction and ask to cut pack again
			System.out
					.println("Okay, you've chosen that the next card will be "
							+ choice
							+ "\nNow, choose again, where you want to cut the pack at.");
			int cutPackNum2 = aGame.readIntegerFromCmd() - 1;
			Card secondCard = myPack.get(cutPackNum2);
			// Show chosen card
			System.out.println("The card you have chosen is the "
					+ secondCard.toString());
			System.out.println("You had chosen " + choice);
			// User chose higher
			if (choice.equals("H")) {
				boolean result = secondCard.higherThan(firstCard);
				System.out.println(result);
				if (result == true) {
					// correct value chosen
					System.out.println("Congratulations, you win!");
				} else {
					System.out.println("Sorry! You lose!");
				}
			}
			// User chose lower
			if (choice.equals("L")) {
				boolean result = secondCard.lowerThan(firstCard);
				if (result == true) { // produced accordingly
					System.out.println("Congratulations, you win!");
				} else {
					System.out.println("Sorry! You lose!");
				}
			}
			// ask to play again
			System.out.println("Do you want to play again?[Y/N]");
			String decision;
			do {
				decision = aGame.readStringFromCmd();
			} while (!(decision.equals("Y") || decision.equals("N")));
			if (decision.equals("N")) {
				System.out.println("Thank you for playing. Goodbye!");
				play = 2;
			}

		}
	}

	/**
	 * Read integer
	 * 
	 * @return number the user entered
	 */
	public Integer readIntegerFromCmd() {
		System.out
				.println("Please enter your number(note, the number must be from 1 to 52. Otherwise, the pack won't be cut):");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number;
		number = null;

		try {
			number = br.readLine();
		} catch (IOException ioe) {
			System.err.println("There was an input error");
		}

		try {
			return new Integer(number);
		} catch (NumberFormatException e) {
			System.err.println("Please enter a number!");
		}

		return 0;
	}

	/**
	 * Read string
	 * 
	 * @return text the user entered
	 */
	public String readStringFromCmd() {
		System.out.println("Enter your choice:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string;
		string = null;

		try {
			string = br.readLine();
		} catch (IOException ioe) {
			System.err.println("There was an input error");
		}
		return string;
	}
}
