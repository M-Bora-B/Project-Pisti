import java.util.Scanner;

public class Game {
	
	public static int gainPoint(Cards[] board) {
		int score = 0;
		for(int a=0; a<board.length; a++) {
			if(board[a] == null) {
				continue;
			}
			if(board[a].getSuit() == "D" && board[a].getValue() == "10") score += 2;
			if(board[a].getSuit() == "C" && board[a].getValue() == "2") score += 1;
			score += 1;
		}
		if(board[2] == null && board[0].getValue() == board[1].getValue()) score = 10;
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
		
		int hold = 0;
        int x = 0;
        while (true) {
            try {
                System.out.println("Please enter an integer value to cut the deck: ");
                x = sc.nextInt();
				for(int a = 0; a < cardnum; a++) {
					if(a >= cardnum-x) {
						cutdeck[a] = deck[hold];
						hold++;
						} else cutdeck[a] = deck[a+x];
						}
						deck = cutdeck;
						break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer value.");
                sc.nextLine(); 
            }
        }
		
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
		int last = 0;
		int count = 0;
		int hand[] = {0, 1, 2, 3};
		// zurnanın zırt dediği yer
		int choose = 0;
		int aicard = 0;
		
		while(count<player.length) {
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
		System.out.println(" ");
		boolean check = true;
		while(check) {
			while(true) {
				try{
		        choose = sc.nextInt();
				break;
				} catch(Exception e) {
					System.out.println("Enter a valid input");
					sc.nextLine();
				}
			}
		switch(choose) {
			case 1:
			if(player[hand[0]] == null) break;
			if(board[0] == null) {
				board = playCard(board, player[hand[0]]);
				player[hand[0]] = null;
				check = false;
				break;
			}
			if(board[0].getValue() == player[hand[0]].getValue() || player[hand[0]].getValue() == "J") {
				board = playCard(board, player[hand[0]]);
				pscore += gainPoint(board);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[hand[0]] = null;
				last = 1;
				check = false;
				break;
			}
			if(board[0].getValue() != player[hand[0]].getValue()) {
				board = playCard(board, player[hand[0]]);				
				player[hand[0]] = null;
				check = false;
				break;
			}
			case 2:
			if(player[hand[1]] == null) break;
			if(board[0] == null) {
				board = playCard(board, player[hand[1]]);
				player[hand[1]] = null;
				check = false;
				break;
			}
			if(board[0].getValue() == player[hand[1]].getValue() || player[hand[1]].getValue() == "J") {
				board = playCard(board, player[hand[1]]);
				pscore += gainPoint(board);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[hand[1]] = null;
				last = 1;
				check = false;
				break;
			}
			if(board[0].getValue() != player[hand[1]].getValue()) {
				board = playCard(board, player[hand[1]]);				
				player[hand[1]] = null;
				check = false;
				break;
			}
			case 3:
			if(player[hand[2]] == null) break;
			if(board[0] == null) {
				board = playCard(board, player[hand[2]]);
				player[hand[2]] = null;
				check = false;
				break;
			}
			if(board[0].getValue() == player[hand[2]].getValue() || player[hand[2]].getValue() == "J") {
				board = playCard(board, player[hand[2]]);
				pscore += gainPoint(board);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[hand[2]] = null;
				last = 1;
				check = false;
				break;
			}
			if(board[0].getValue() != player[hand[2]].getValue()) {
				board = playCard(board, player[hand[2]]);
				player[hand[2]] = null;
				check = false;
				break;
			}
			case 4:
			if(player[hand[3]] == null) break;
			if(board[0] == null) {
				board = playCard(board, player[hand[3]]);
				player[hand[3]] = null;
				check = false;
				break;
			}
			if(board[0].getValue() == player[hand[3]].getValue() || player[hand[3]].getValue() == "J") {
				board = playCard(board, player[hand[3]]);
				pscore += gainPoint(board);
				for (int i = 0; i < board.length; i++) {
					board[i] = null;
					}
				player[hand[3]] = null;
				last = 1;
				check = false;
				break;
			}
			if(board[0].getValue() != player[hand[3]].getValue()) {
				board = playCard(board, player[hand[3]]);				
				player[hand[3]] = null;
				check = false;
				break;
			}
		}
		}
		boolean flag = false;
		if(board[0] != null) {
			for(int z=0; z<hand.length; z++) {
				if(ai[hand[z]] == null) continue;
				if(ai[hand[z]].getValue() == board[0].getValue() || ai[hand[z]].getValue() == "J") {
					playCard(board, ai[hand[z]]);
					ascore += gainPoint(board);
					for (int i = 0; i < board.length; i++) {
					if(board[i] != null) {
					aicard++;
					}
					board[i] = null;
					}
					ai[hand[z]] = null;
					flag = true;
					last = 0;
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
		System.out.println(ascore);
		System.out.println(pscore);
		System.out.println(aicard);
		System.out.println(last);
		}
		for(int i=0; i<board.length; i++) {
			if(last == 1) break;
			if(last == 0) {
				if(board[i] != null) aicard++;
			}
		}
		if(last == 0 && board[0] != null) ascore += gainPoint(board);
		if(last == 1 && board[0] != null) pscore += gainPoint(board);
		if(aicard>26) ascore += 3;
		if(aicard<26) pscore += 3;
		if(ascore>pscore) {
			System.out.println("You lost...");
			System.out.println("AI:" + ascore);
			System.out.println("You:" + pscore);
		}
		if(ascore<pscore) {
			System.out.println("You won!");
			System.out.println("You:" + pscore);
			System.out.println("AI:" + ascore);
		}
		if(ascore==pscore) {
			System.out.println("Wow, it's a tie!");
			System.out.println("You:" + pscore);
			System.out.println("AI:" + ascore);
		}
	}
}