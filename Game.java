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
		int count = 0;
		int hand[] = {0, 1, 2, 3};
		// zurnanın zırt dediği yer
		int choose = 0;
		while(choose<5) {
		for(int d=0; d<board.length; d++) {
			if(board[d] == null) continue;
			System.out.print(easy(board[d]) + " ");
		}
		System.out.println(" ");
		if(player[hand[0]] != null) System.out.println("1." + easy(player[hand[0]]));
		if(player[hand[1]] != null) System.out.println("2." + easy(player[hand[1]]));
		if(player[hand[2]] != null) System.out.println("3." + easy(player[hand[2]]));
		if(player[hand[3]] != null) System.out.println("4." + easy(player[hand[3]]));
		System.out.println(" ");
		if(ai[hand[0]] != null) System.out.println("1." + easy(ai[hand[0]]));
		if(ai[hand[1]] != null) System.out.println("2." + easy(ai[hand[1]]));
		if(ai[hand[2]] != null) System.out.println("3." + easy(ai[hand[2]]));
		if(ai[hand[3]] != null) System.out.println("4." + easy(ai[hand[3]]));
		choose = sc.nextInt();
		switch(choose) {
			case 1:
			if(board[0] == null) {
				board = playCard(board, player[hand[0]]);
				player[hand[0]] = null;
				break;
			}
			if(board[0].getValue() == player[hand[0]].getValue() || player[hand[0]].getValue() == "J") {
				board = playCard(board, player[hand[0]]);
				pscore += gainPoint(board);
				System.out.println("2 Tetiklendi" + pscore);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[hand[0]] = null;
				break;
			}
			if(board[0].getValue() != player[hand[0]].getValue()) {
				board = playCard(board, player[hand[0]]);
				System.out.println("1 Tetiklendi");
				player[hand[0]] = null;
				break;
			}
			case 2:
			if(board[0] == null) {
				board = playCard(board, player[hand[1]]);
				player[hand[1]] = null;
				break;
			}
			if(board[0].getValue() == player[hand[1]].getValue() || player[hand[1]].getValue() == "J") {
				board = playCard(board, player[hand[1]]);
				pscore += gainPoint(board);
				System.out.println("2 Tetiklendi" + pscore);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[hand[1]] = null;
				break;
			}
			if(board[0].getValue() != player[hand[1]].getValue()) {
				board = playCard(board, player[hand[1]]);
				System.out.println("1 Tetiklendi");
				player[hand[1]] = null;
				break;
			}
			case 3:
			if(board[0] == null) {
				board = playCard(board, player[hand[2]]);
				player[hand[2]] = null;
				break;
			}
			if(board[0].getValue() == player[hand[2]].getValue() || player[hand[2]].getValue() == "J") {
				board = playCard(board, player[hand[2]]);
				pscore += gainPoint(board);
				System.out.println("2 Tetiklendi" + pscore);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[hand[2]] = null;
				break;
			}
			if(board[0].getValue() != player[hand[2]].getValue()) {
				board = playCard(board, player[hand[2]]);
				System.out.println("1 Tetiklendi");
				player[hand[2]] = null;
				break;
			}
			case 4:
			if(board[0] == null) {
				board = playCard(board, player[hand[3]]);
				player[hand[3]] = null;
				break;
			}
			if(board[0].getValue() == player[hand[3]].getValue() || player[hand[3]].getValue() == "J") {
				board = playCard(board, player[hand[3]]);
				pscore += gainPoint(board);
				System.out.println("2 Tetiklendi" + pscore);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[hand[3]] = null;
				break;
			}
			if(board[0].getValue() != player[hand[3]].getValue()) {
				board = playCard(board, player[hand[3]]);
				System.out.println("1 Tetiklendi");
				player[hand[3]] = null;
				break;
			}
		}
		boolean flag = false;
		if(board[0] != null) {
			for(int z=0; z<hand.length; z++) {
				if(ai[hand[z]] == null) continue;
				if(ai[hand[z]].getValue() == board[0].getValue() || ai[hand[z]].getValue() == "J") {
					playCard(board, ai[hand[z]]);
					gainPoint(board);
					for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
					ai[hand[z]] = null;
					flag = true;
					break;
				}
			}
		}
		if(board[0] == null && flag == false) {
			for(int z=0; z<hand.length; z++) {
				if(ai[hand[z]] != null) {
					playCard(board, ai[hand[z]]);
					ai[hand[z]] = null;
					flag = true;
					break;
				}
			}
		}
		if(!flag) {
			for(int z=0; z<hand.length; z++) {
				if(ai[hand[z]] != null) {
					playCard(board, ai[hand[z]]);
					ai[hand[z]] = null;
					break;
				}
			}
		}
		
		System.out.println("------------------------");
		count++;
		if(count%4 == 0 && count != 0) {
			hand[0] += 4;
			hand[1] += 4;
			hand[2] += 4;
			hand[3] += 4;
		}
		}
	}
}