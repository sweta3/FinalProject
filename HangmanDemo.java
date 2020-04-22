package FinalProject;
import java.util.*;

/*
1. Generate random word String[] words;
2. Convert word (replace each letter to *);
3. Show game status to user;
4. User enter letter try to guess the word. Looping if letter has been used;
5. Compare letter provided by user if letters is in the current word;
6. If user guess letter then replace star * in word decrement -1 lives;
7. Check if all letters are guess and set completed to true;
8. Loop working until lives >0 and word not completed;
9. Show user result of the game (lost, won) and update games statistics;
10. Ask user to continue or end game;
11. If user press Y then continue loop;
12. If not display game statistics and finish program.
 */
public class HangmanDemo {

	public static void main(String[] args) {
		
		String words[] = {"Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus", "Czechia", "Denmark", "Estonia",
						"Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania",
						"Luxemburg", "Malta", "Netherlands","Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain",
						"Sweden"};
		
		//variables
		String currentWord;
		String wordToShow;
		int lives;
		boolean completed;
		boolean letterMatched;
		char currentLetter;
		char playAgain;
		
		HangmanStats stats = new HangmanStats();
		System.out.println("Hello, welcome to my Hangman project. \n\tThe 27 member countries of the EU!"
				+ "\nPress ENTER to START the game: ← ");

		do {
			System.out.println("Enter any letter to guess  ");
			Scanner scan = new Scanner(System.in);
			
			scan.nextLine();
			
			scan.nextLine();
			//#1 Generate random word from String[] words
			currentWord = words[(char)(Math.random()*words.length)]; //Pick a random word
			
			HangmanLetters usedLetters = new HangmanLetters(); //initialized empty usedLetters
			wordToShow = usedLetters.convertWord(currentWord); //#2 Convert word (replace each letter to *)
			lives = 4;
			completed = false;
			
			//#8 Loop working until lives >0 and word is not completed
			while (lives > 0 && !completed) {
				//the number of lives
				//#3 Show game status to user
				System.out.println("\n" + " Lives: " + lives );
				//#3 Show game status to user
				//Show the currentWord with the known letters
				System.out.println("Word: " + wordToShow);
				//#3 Show game status to user
				//Show used letters
				System.out.println("Letters used: ");
				
				if (usedLetters.getLength() == 0) {
					System.out.println("Waiting for your first letter!");
				}else {
					usedLetters.display();
					System.out.println();
				}

			//ask a letter and decrement -1 lives if letter is not in the word
			currentLetter = ' '; //#4user enter latter try to guess the word.Looping if...
			boolean letterUsed = false;
			do {
				if (letterUsed) {
					System.out.println("Letter is already used: " +currentLetter);
				}
				System.out.println("Guess a letter: ");
				currentLetter = scan.next().charAt(0);
				currentLetter = (char) Character.toUpperCase((char)currentLetter);
				letterUsed = usedLetters.letterIsUsed(currentLetter);//checking if letter is used
			}while(letterUsed||currentLetter < 'A' ||currentLetter>'Z');
			
			letterMatched = false;
			//#5 Compare letter provided by user if letters is in the current word
			char[] showChars = wordToShow.toCharArray();// convert word to char Array
			for (char i = 0; i <showChars.length; i++) {
				if (Character.toUpperCase(currentWord.charAt(i)) == currentLetter) {
					showChars[i] = currentLetter;
					letterMatched = true;
				}
			}
			
			//#6 If user guess letter, then replace star * in word to show, otherwise decrements
			wordToShow= String.valueOf(showChars);
			if (!letterMatched) {
				lives--;
			}
			//Add currentLetter to usedLetters
			usedLetters.addNewLetter(currentLetter);
			//Check whether user has won or not
			//#7 Check if all letters are guess and set completed to true
			completed = true;
			for(char i = 0; i<wordToShow.length(); i++) {
				if (wordToShow.charAt(i) == '*') {
					completed = false;
				}
			}
		}
			//#9 Show user result of the game (lost, won) and update games statistics
			if (lives == 0) { 
				System.out.println(0 + "You lost:(");
				System.out.println("You coldn't find the word: " + currentWord.toUpperCase());
				stats.getGamesLost();
			}else{//user won the game (completed = true)
				System.out.println("_______________________ ");
				System.out.println("You won!\nYou found the word: " + wordToShow + "\nWith" );
				stats.incrementGamesWon();	
			}
			//Ask if user wants to play again
			//#10 Ask user to continue a game or end game
			do {
				System.out.println("Are you  ready for another game (y/n): ");
				playAgain = scan.next().charAt(0);
			}while (!"YN".contains(String.valueOf(playAgain).toUpperCase()));
	}while(!"N".contains(String.valueOf(playAgain).toUpperCase())); //#11 if user press Y to continiue game
	//end game +show the game stats
	//#12 if not display game statistics and finish program.
	System.out.println("________________");
	System.out.println("Game Statistics: ");
	System.out.println("Game played: " + stats.getGamesTotal());
	System.out.println("Game won: " + stats.getGamesWon());
	System.out.println("Game lost: " + stats.getGamesLost());
	System.out.println("Good luck!");
	}

}
