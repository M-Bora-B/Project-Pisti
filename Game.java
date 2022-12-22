import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cardnum = 52;
        Cards[] deck = new Cards[cardnum];
        Deck temp = new Deck();
        temp.Shuffle();
        deck = temp.getDeck();
        Cards[] cutdeck = new Cards[cardnum];
		
		
        int x = 0;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.println("Please enter an integer value for x: ");
                x = sc.nextInt();
                inputValid = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer value.");
                sc.nextLine(); 
            }
        }
        int hold = 0;
        for(int a = 0; a < cardnum; a++) {
            if(a >= cardnum-x) {
                cutdeck[a] = deck[hold];
                hold++;
            } else cutdeck[a] = deck[a+x];
        }
		deck = cutdeck;
		
		
		
    }
}
