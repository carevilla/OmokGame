package Board;

import java.util.Scanner;

public class OmokGame {
	
	//private BoardGameUI menu;
	private BoardOmok board;
	private int gameMode;
	private Player p1, p2;
	
	//private OmokGameControl control;

	public OmokGame() {
		// TODO Auto-generated constructor stub
		//BoardGameUI menu = new BoardGameUI();
		this.board = new BoardOmok();
		this.p1 = new Player();
		this.p2 = new Player();
	}
	
	public void setup() {
		String s;
		Scanner userChoice = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Welcome to Omok.");
		
		System.out.println("Give dimensions of board... it will be a (nxn) matrix");
		this.board.setBoardSize(userChoice.nextInt());
		s = userChoice.nextLine();
		
		System.out.println("Select game mode: 1 = Player vs Player  2 = Player vs Computer");
		this.gameMode = userChoice.nextInt();
		s = userChoice.nextLine();
		userChoice.close();
		
	}
	
	public void play() {
		do {
			this.board.drawBoard();
		} while ( this.board.updateBoard() >= 0);
		
		
		
		
		
		
	}

}
