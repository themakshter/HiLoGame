
import java.util.*;
import java.util.ArrayList;
public class Pack {
 private ArrayList<Card> packOfCards = new ArrayList<Card>();
 private Card chosenCard;
 public Pack(){
	 for(int suit = 1; suit <= 4; suit ++){						//instead of adding every card singularly, unnecessarily increasing the size of the code, a
		 for(int card = 1; card <=13; card ++){					// loop is used instead, which does exactly that. For each suit, the cards are added
			 packOfCards.add(new Card(card, suit));			
		 }
	 }
	  }
 public void display(){
	 for(Card c : packOfCards)
		 System.out.println(c.toString());						//prints out all the cards in the pack
 }
 public int size(){
	 int packSize;
	 packSize = packOfCards.size();								//gives the size of the pack
	 return packSize;
 }
 public Card get(int position){
     chosenCard = packOfCards.get(position);					//gets a certain card from its position
     return chosenCard;
     
    }
 public void shuffle(){
     Random generator = new Random();									
     for(int i = 0; i < 100; i++){
         int randomCardNum1 = generator.nextInt(packOfCards.size());		//this gets a random position number from inside the pack
         int randomCardNum2 = generator.nextInt(packOfCards.size());		// this gets another random position number
         Card Card1 = packOfCards.get(randomCardNum1);						// this puts the card present at the first position in a new card
         Card Card2 = packOfCards.get(randomCardNum2);						// this does the same for the second position
         
         packOfCards.set(randomCardNum2, Card1);							//these two lines switch the positions of the two cards got out
         packOfCards.set(randomCardNum1, Card2);							// this process repeated for a hundred times in this for loop
        }
    }
 }