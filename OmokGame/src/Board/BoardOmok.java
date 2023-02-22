package Board;

//import java.util.Random;
//import java.util.Scanner;
//import java.util.concurrent.ThreadLocalRandom;

public class BoardOmok {

	private int [][] gameBoard;
	private int boardSize;

	
	public BoardOmok() {
		this.gameBoard = new int[0][0];
		this.boardSize = 0;
	}
	
	public BoardOmok(int size) {
		this.gameBoard = new int[size][size];
		this.boardSize = size;
	}
	
	public BoardOmok (int [][] b, int size) {
		this.gameBoard = b;
		this.boardSize = size;
	}
	
	public int[][] getBoard(){
		return this.gameBoard;
	}
	
	public int getBoardSize () {
		return this.boardSize;
	}
	
	public void setBoard(int [][] b , int s) {
		this.gameBoard = b;
		this.boardSize = s;
	}

	public void setBoardSelection ( int x , int y , int p) {
		this.gameBoard[x][y] = p;
	}
	
	public void drawBoard() {
		//if ( this.gameBoard == null && this.boardSize > 0 ) {
			//this.gameBoard = new int[this.boardSize][this.boardSize];
		//}
			
		for(int i=0; i<this.boardSize; i++) {
			for(int j=0; j<this.boardSize; j++) {
				if (this.gameBoard[i][j] == 0) {
					System.out.print(". ");
				} else if (this.gameBoard[i][j] == 1) {
					System.out.print("X "); //to be replaced
				} else if (this.gameBoard[i][j] == 2) {
					System.out.print("* ");
				} else {
					System.out.print("Error invalid player: " + this.gameBoard[i][j]);
				}
			}
			System.out.println();
		}
	}
	
	public void updateBoard() {
		
	}
	
/*
	private boolean checkForWinner(int x, int y) {
		if ( this.gameBoard[x][y] != 0 ) {
			System.out.println("We found a winnder at (x y): " + x + " " + y );
			return true;
		}
		return false;
		
	}	
	/*
	public int updateBoard() {
		int x=0, y=0;
		String s;
		System.out.print("X's turn: " + "Index of place (x y) or -1 to quit?");
		
		Scanner in = new Scanner(System.in);  // Create a Scanner object	
		s = in.nextLine();
		x = Integer.parseInt(s);
		y = Integer.parseInt(s);
		//in.nextLine();
		//y = in.nextInt();
		//in.nextLine();
		in.close();
		
		//x = ThreadLocalRandom.current().nextInt(0, this.boardSize);
		//y = ThreadLocalRandom.current().nextInt(0, this.boardSize);
		
		System.out.println(x + " " + y);
		
		if ( x < 0 ) {
			return -1;
		}
		
		if ( x > this.getBoardSize() || y > this.getBoardSize() ) {
			System.out.println("Invalid coordinate please try again" + x + " " + y + " " + this.getBoardSize());
			return 1;
		}
		
		if ( checkForWinner(x,y) ) return -1;
		else this.gameBoard[x][y] = 1;
		
		return 0;
	}
	*/



}
