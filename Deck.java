import java.util.Random;

public class Deck {
	private Cards[] deck;
	private int cardnumber = 52;
	private int currentcard;
	private Random rd = new Random(System.currentTimeMillis());
	
	public Deck() {
		String[] suit = {"Hearts", "Diamonds", "Clubs", "Spades"};
		String[] value = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		deck = new Cards[cardnumber];
		for(int i=0; i<deck.length; i++) {
			deck[i] = new Cards(suit[i/13], value[i%13]);
		}
	}
	
	public void Shuffle() {
		for(int u=0; u<deck.length; u++) {
			int random = rd.nextInt(cardnumber);
			Cards temp = deck[u];
			deck[u] = deck[random];
			deck[random] = temp;
		}
	}
	
	public Cards[] getDeck() {
		return deck;
	}
}