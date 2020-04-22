package FinalProject;
/*
 Instantiable class HangmanStas, add +1 to lost or won +sum total games
 */

public class HangmanStats {
	private int gamesLost;
	private int gamesWon;
	
	public int getGamesLost() {
		return gamesLost;
	}
	
	public void incrementGamesLost() {//add number of game lost
		this.gamesLost +=1;
	}
	
	public int getGamesWon() {
		return gamesWon;
	}
	
	public void incrementGamesWon() {//add number of game won
		this.gamesWon +=1;
	}

	public String getGamesTotal() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
