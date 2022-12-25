import java.util.Scanner;

public class Game {
	
	public static int gainPoint(Cards[] board) {
		int score = 0;
		for(int a=0; a<board.length; a++) {
			if(board[a] == null) {
				continue;
			}
			if(board[a].getSuit() == "D" && board[a].getValue() == "10") score += 3;
			if(board[a].getSuit() == "C" && board[a].getValue() == "2") score += 2;
			else score += 1;
		}
		return score;
	}
	
	public static Cards[] playCard(Cards[] board, Cards player) {
	if(board[0] == null) {
		board[0] = player;
	} else {
		for(int a=board.length-1; a>0; a--) {
			board[a] = board[a-1];
		}
		board[0] = player;
	}
	return board;
	}
	
	public static String easy(Cards a) {
		return a.getValue() + a.getSuit();
	}
	
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
                System.out.println("Please enter an integer value to cut the deck: ");
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
		
		
		Cards[] player = new Cards[24]; 
		Cards[] ai = new Cards[24];
		Cards[] board = new Cards[52];
		int pscore = 0;
		int ascore = 0;
		board[0] = deck[8];
		board[1] = deck[9];
		board[2] = deck[10];
		board[3] = deck[11];
		for(int b=0; b<player.length; b++) {
		if(b<4) player[b] = deck[b*2];
        else player[b] = deck[b*2+4];	
		}
		for(int c=0; c<ai.length; c++) {
		if(c<4) ai[c] = deck[c*2+1];
        else ai[c] = deck[c*2+5];	
		}
		// zurnanın zırt dediği yer
		int choose = 0;
		while(choose<5) {
		for(int d=0; d<board.length; d++) {
			if(board[d] == null) continue;
			System.out.print(easy(board[d]) + " ");
		}
		System.out.println(" ");
		for(int p=0; p<4; p++) {
			if(player[p] == null) continue;
			System.out.println((p+1) + "." + easy(player[p]));
		}
		choose = sc.nextInt();
		switch(choose) {
			case 1:
			if(board[0] == null) {
				board = playCard(board, player[0]);
				player[0] = null;
				break;
			}
			if(board[0].getValue() == player[0].getValue() || player[0].getValue() == "J") {
				board = playCard(board, player[0]);
				pscore += gainPoint(board);
				System.out.println("2 Tetiklendi" + pscore);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[0] = null;
				break;
			}
			if(board[0].getValue() != player[0].getValue()) {
				board = playCard(board, player[0]);
				System.out.println("1 Tetiklendi");
				player[0] = null;
				break;
			}
			case 2:
			if(board[0] == null) {
				board = playCard(board, player[1]);
				player[1] = null;
				break;
			}
			if(board[0].getValue() == player[1].getValue() || player[1].getValue() == "J") {
				board = playCard(board, player[1]);
				pscore += gainPoint(board);
				System.out.println("2 Tetiklendi" + pscore);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[1] = null;
				break;
			}
			if(board[0].getValue() != player[1].getValue()) {
				board = playCard(board, player[1]);
				System.out.println("1 Tetiklendi");
				player[1] = null;
				break;
			}
			case 3:
			if(board[0] == null) {
				board = playCard(board, player[2]);
				player[2] = null;
				break;
			}
			if(board[0].getValue() == player[2].getValue() || player[2].getValue() == "J") {
				board = playCard(board, player[2]);
				pscore += gainPoint(board);
				System.out.println("2 Tetiklendi" + pscore);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[2] = null;
				break;
			}
			if(board[0].getValue() != player[2].getValue()) {
				board = playCard(board, player[2]);
				System.out.println("1 Tetiklendi");
				player[2] = null;
				break;
			}
			case 4:
			if(board[0] == null) {
				board = playCard(board, player[3]);
				player[3] = null;
				break;
			}
			if(board[0].getValue() == player[3].getValue() || player[3].getValue() == "J") {
				board = playCard(board, player[3]);
				pscore += gainPoint(board);
				System.out.println("2 Tetiklendi" + pscore);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[3] = null;
				break;
			}
			if(board[0].getValue() != player[3].getValue()) {
				board = playCard(board, player[3]);
				System.out.println("1 Tetiklendi");
				player[3] = null;
				break;
			}
		}
		}
	}
}