package Board;

//import java.util.Scanner;
//Started to work on project in another eclipse workspace
//Project is finished over there just pushing to git to screenshot 
public class OmokGame {
	
	private BoardGameUI ui;
	private BoardOmok board;
	private Boolean humanOpp;
	private Player p1, p2;
	
	public OmokGame() {	
	}

	public OmokGame( BoardOmok b , Boolean h) {
		this.board = b;
		this.humanOpp = h;
	}
	
	public BoardOmok getBoardOmok() {
		return this.board;
	}
	
	public Boolean getGameType() {
		return this.humanOpp;
	}
	
	public Player getPlayer1() {
		return this.p1;
	}
	
	public Player getPlayer2() {
		return this.p2;
	}
	
	public void setBoardOmok( BoardOmok b ) {
		this.board = b;
	}
	
	public void setGameTYpe ( Boolean h) {
		this.humanOpp = h;
	}
	
	public void setOmokPlayer1 ( Player p) {
		this.p1 = p;
	}
	
	public void setOmokPlayer2 ( Player p) {
		this.p2 = p;
	}
	
	public void startOmokGame() {
		Boolean winnerFlag = false;
		this.ui = new BoardGameUI(true);
		this.ui.setUpGame(this);
		this.board.drawBoard();
		while ( winnerFlag == false ) {
			this.p1.setPlayerTurn(true);
			if (this.playerTurn()) break;
			this.p1.setPlayerTurn(false);
			this.p2.setPlayerTurn(true);
			if (this.playerTurn()) break;
			this.p2.setPlayerTurn(false);
		}
		if (this.p1.getPlayerWin()) {
			System.out.println(this.p1.getPlayerName() + " has won the game!");
		} else if ( this.p2.getPlayerWin()) {
			System.out.println(this.p2.getPlayerName() + " has won the game!");
		} else {
			System.out.println("Game ended without a winner");
		}
	}
	
	public Boolean playerTurn() {
		int pNum = this.p1.getPlayerTurn() ? 1 : 2;
		if (this.ui.executePlayerTurn(this) < 0 ) return true;
		this.board.drawBoard();
		if ( pNum == 1 ) this.p1.setPlayerWin(this.checkForWinner(pNum));
		else this.p2.setPlayerWin(this.checkForWinner(pNum));
		return pNum == 1 ? this.p1.getPlayerWin() : this.p2.getPlayerWin();
	}
	
	public Boolean checkArow ( int pNum ) {
		return false;
	}
	
	public Boolean checkAdiag( int pNum ) {
		return false;
	}
	
	public Boolean checkACol ( int pNum ) {
		return false;
	}
	
	public Boolean checkForWinner (int pNum ) {
		return this.checkArow(pNum) || this.checkACol(pNum) || this.checkAdiag(pNum);
	}
/*
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
*/
}
