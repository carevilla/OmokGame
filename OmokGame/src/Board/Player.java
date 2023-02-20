package Board;

public class Player {
	private String name;
	private Boolean human;// 0: human, 1: computer
	private Boolean turn;
	private Boolean win;
	
	public Player() {
		this.name = "";
		this.human = true;
		this.turn = false;
		this.win = false;
	}
	
	public Player ( String name) {
		this.name = name;
		this.human = true;
		this.turn = false;
		this.win = false;
	}
	
	public Player ( String name , Boolean h) {
		this.name = name;
		this.human = h;
		this.turn = false;
		this.win = false;
	}
	
	public String getPlayerName() {
		return this.name;
	}
	
	public Boolean getPlayerType() {
		return this.human;
	}
	
	public Boolean getPlayerTurn() {
		return this.turn;
	}
	
	public Boolean getPlayerWin() {
		return this.win;
	}
	
	public void setPlayerWin( String name) {
		this.name = name;
	}
	
	public void setPlayerType ( Boolean t) {
		this.human = t;
	}
	
	public void setPlayerTurn ( Boolean t) {
		this.turn = t;
	}
	
	public void setPlayerWin ( Boolean w) {
		this.win = w;
	}
}
