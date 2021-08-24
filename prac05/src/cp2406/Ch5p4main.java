package cp2406;

import java.util.Random;

/*
A Blackjack hand typically contains from two to six cards.
Write a program to test the BlackjackHand class.
You should create a BlackjackHand object and a Deck object.
Pick a random number between 2 and 6. Deal that many cards from the deck and add them to the hand.
Print out all the cards in the hand, and then print out the value computed for the hand by getBlackjackValue().
Repeat this as long as the user wants to continue.
 */
public class Ch5p4main {
    public static void main(String[] args) {
        BlackjackHand hand = new BlackjackHand();
        Deck deck = new Deck();
        deck.shuffle();
//      Pick a random number between 2 & 6
        int randNum = new Random().nextInt(5) + 2;
        for (int i = 0; i < randNum; i++) {
            Card card = deck.dealCard();
            hand.addCard(card);
            System.out.println("card = " + card);

        }
        System.out.println("value = " + hand.getBlackjackValue());
    }

}
