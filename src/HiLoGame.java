
import java.io.*;

public class HiLoGame {
	public static void main(String[] args) {
		Pack myPack = new Pack();					//creates a new pack
		myPack.shuffle();							// shuffles the new pack
		HiLoGame aGame = new HiLoGame();			// creates a new game
		System.out
				.println("Welcome, fellow mortal, to the High or Lower game!");			//the introductory line of the game
		int play = 1;																	//this will make the loop repeat itself until the value of play changes
		while (play == 1) {
			System.out.println("Choose where you want to cut the pack at.");			//prompts the user to choose where they want to cut the pack at
			int cutPackNum;					
			do {
				cutPackNum = aGame.readIntegerFromCmd() - 1;							//keeps asking unless a number in the right range is chosen
			} while (cutPackNum < 0 || cutPackNum > 51);
			Card firstCard = myPack.get(cutPackNum);
			System.out.println("The card you have chosen is the "						//shows the user the card they chose
					+ firstCard.toString());
			System.out
					.println("What do you think the next card will be?(H)igher or (L)ower?");	//asks them to choose Higher or Lower
			String choice;
			do {
				choice = aGame.readStringFromCmd();												//keeps asking until either H(higher) or L(lower) is entered
			} while (!(choice.equals("H") || choice.equals("L")));
			System.out
					.println("Okay, you've chosen that the next card will be "					//Reminds the user of the choice they made
							+ choice
							+ "\nNow, choose again, where you want to cut the pack at.");		//prompts user to choose the place to cut pack again
			int cutPackNum2 = aGame.readIntegerFromCmd() - 1;
			Card secondCard = myPack.get(cutPackNum2);
			System.out.println("The card you have chosen is the "								//displays the chosen card
					+ secondCard.toString());
			System.out.println("You had chosen " + choice);
			if (choice.equals("H")) {
				boolean result = secondCard.higherThan(firstCard);
				System.out.println(result);
				if (result == true) {
					System.out.println("Congratulations, you win!");						// if the user had chosen H, then it is compared if the card was higher
				} else {																	//or lower. Then the message is produced accordingly
					System.out.println("Sorry! You lose!");
				}
			}
			if (choice.equals("L")) {
				boolean result = secondCard.lowerThan(firstCard);							//if the user had chosen L, then it is compared again with the message
				if (result == true) {														// produced accordingly
					System.out.println("Congratulations, you win!");
				} else {
					System.out.println("Sorry! You lose!");
				}
			}
			System.out.println("Do you want to play again?[Y/N]");							//user is asked to play the game again
			String decision;
			do {
				decision = aGame.readStringFromCmd();
			} while (!(decision.equals("Y") || decision.equals("N")));						//user is kept being asked until Y or N is entered
																							//if Y is selected, the game repeats
			if (decision.equals("N")) {
				System.out.println("Thank you for playing. Goodbye!");						//If N is selected, the goodbye message is produced
				play = 2;
			}

		}
	}

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
