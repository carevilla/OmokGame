package Board;

import java.util.Scanner;

public class BoardGameUI extends OmokGame {
	private Boolean uiEnabled;

	
	public BoardGameUI() {

	}
	
	public BoardGameUI( Boolean s) {
		this.uiEnabled = s;
	}
	
	public Boolean getBoardGameUI() {
		return this.uiEnabled;
	}
	
	public void setBoardGameUI( Boolean s) {
		this.uiEnabled = s;
	}
	
	public void setUpGame( OmokGame omokGame) {
		int gameSize;
		int gameType;
		
		System.out.println("Welcome to Omok!");
		System.out.println("Please enter board size: ");
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner (System.in);
		while (true) {
			gameSize = in.nextInt();
			in.nextLine();
			if ( gameSize > 0 ) break;
		}
		
		omokGame.setBoardOmok( new BoardOmok(gameSize) );
		
		while (true) {
			System.out.print("Please enter game type: 1 for h vs h or 2 for h vs Ai");
			gameType = in.nextInt();
			in.nextLine();
			if ( gameType == 1 || gameType == 2 ) break;
		}
		
		System.out.println("Please enter your name: ");
		omokGame.setOmokPlayer1( new Player(in.nextLine(), true));
		
		if ( gameType == 2) {
			omokGame.setOmokPlayer2( new Player("AI" , false));
		} else {
			System.out.print("Please enter opponents name: ");
			omokGame.setOmokPlayer2( new Player(in.nextLine(), true ));
		}
	}
	
	public int executePlayerTurn ( OmokGame g ) {
		String p = "";
		String[] s = new String[2];
		
		@SuppressWarnings("resource")
		Scanner in = new Scanner (System.in);
		
		if (g.getPlayer1().getPlayerTurn() == true ) p = g.getPlayer1().getPlayerName();
		if (g.getPlayer2().getPlayerTurn() == true ) p = g.getPlayer2().getPlayerName();
		
		while(true) {
			System.out.print(p + " Please enter coordinates (x y) of point selected.. (ex: 1 5 press -1 to quit");
			s = in.nextLine().split(" ");
			if ( s.length != 2 && Integer.parseInt(s[0]) == -1) return -1;
			if ( s.length != 2 ) continue;
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			System.out.println("You selected location: (" + x + "," + y+ ")");
			g.getBoardOmok().setBoardSelection(x, y, 1);
			if ( g.getPlayer1().getPlayerTurn() == true && g.getPlayer2().getPlayerTurn() == false) {
				g.getBoardOmok().setBoardSelection(x, y, 1);
				break;
			} else if ( g.getPlayer1().getPlayerTurn() == false && g.getPlayer2().getPlayerTurn() == true) {
				g.getBoardOmok().setBoardSelection(x, y, 2);
				break;
			} else {
				System.out.println("!Error: Unknown Player Turn");
				return -1;
			}
		}
		
		return 0;
		
	}
	
}
