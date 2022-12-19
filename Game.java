import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		int cardnum = 52;
		Cards[] deck = new Cards[cardnum];
		Deck temp = new Deck();
		temp.Shuffle();
		deck = temp.getDeck();
		for (int i = 0; i < cardnum; i++) {
			System.out.println(deck[i].getValue() + " of " + deck[i].getSuit());
		}
	}
}