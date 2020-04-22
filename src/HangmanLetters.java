package FinalProject;

import java.util.Arrays;

/**
 Instantiable class HangmanLetters, check if letter is used
 */

public class HangmanLetters {
	private String usedLetters = "";
	
	public boolean letterIsUsed(char letter) {
		for (char i = 0; i<usedLetters.length();i++) {
			if (usedLetters.charAt(i) == letter) {
				return true;
			}
			
		}
		return false;
	}
	
	//method to convert each symbol to char using StringBuilder
	public static String convertWord(String word) {
		StringBuilder result = new StringBuilder();
		for(int i =0; i<word.length(); i++){//each symbol in current word converted to char
			if(word.charAt(i) == ' ') {
				result.append(' ');
			}else {
				result.append('*');//add
			}
		}
		return result.toString();
	}
	
	public void addNewLetter(char currentLetter) {
		usedLetters = usedLetters + currentLetter; //add current letter to the String of usedLetter
		char[] usedLettersArray = usedLetters.toCharArray(); //convert usedLetters to char Array
		Arrays.sort(usedLettersArray);; //sorting
		usedLetters = String.valueOf(usedLettersArray); //convert char Array back to String
	}
	
	public void display() {
		for (char i =0; i<usedLetters.length(); i++) {
			System.out.print(usedLetters.charAt(i) + " ");
		}
	}
	
	public int getLength() {
		return usedLetters.length();
	}

}
