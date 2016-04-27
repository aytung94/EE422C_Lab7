/**
  Game Class
  EE422C Bonus Program
  @author Alvin Tung (ayt243)
  @version 1.00 2016-04-26
 */

package assignment7;
 
import java.util.*;
import javax.swing.*;

public class Game{
	
	private static boolean test_mode = true; 
	
	private Gameboard gameboard;
	
	private int num_guesses;
	
	private String guess_code_str;
	private Code guess_code;
	private Pegs guess_pegs;
	
	private String msg_title = "Mastermind";
	private boolean correct_guess;
	
	public Game(boolean displayAnswer){
		
		greetGame();				  // Greet user
		gameboard = settingsGame();   // Setup Game Settings
		gameboard.generateCode(); 	  // Generate secret code 
		if(displayAnswer){
			  msg_title = msg_title + " (" + gameboard.getSecretCodeString() + ")";
			  JOptionPane.showMessageDialog(null, "Generating secret code....", msg_title, JOptionPane.INFORMATION_MESSAGE);   			  
		} else{
			JOptionPane.showMessageDialog(null, "Generating secret code....", msg_title, JOptionPane.INFORMATION_MESSAGE);   
		}
		
		num_guesses = 0; // Begin game with 0 guesses  
		correct_guess = false; // Begin game with no correct guess
		while(num_guesses < gameboard.getGuessSize() && !correct_guess){
			 // grab user code guess
			guess_code_str = JOptionPane.showInputDialog(null, "You have " + (gameboard.getGuessSize() - num_guesses) + " guesses left.\n"
					+ "What is your next guess?\n"
					+ "Type in the characters " + gameboard.getColor().toPrintString() + " for your guess and press enter.\n" 
					+ "(To get past inputs and feedback, type \"History\" and press enter)\n"
					+ "Enter guess:" , msg_title, JOptionPane.INFORMATION_MESSAGE);			 
			 // TODO CATCH CANCEL BUTTON
			 String matchme = new String(".*[^" + gameboard.getColor().toString() + "].*");
			 
			 // check if valid input code guess
			 if(guess_code_str.length() == gameboard.getCodeSize() && !guess_code_str.matches(matchme)){ 
				 // save guess to history
				 num_guesses++; 
				 guess_code = new Code(guess_code_str); 
				 guess_pegs = guess_code.getPegs(gameboard.getSecretCode());
				 gameboard.addHistory(guess_code, guess_pegs);
				 
				 // if guess is correct 
				 if(guess_code.correctCode(gameboard.getSecretCode())){
					 correct_guess = true; 
					 JOptionPane.showMessageDialog(null, guess_code.toString() + " -> Result: 4 black pegs - You win!!", msg_title, JOptionPane.INFORMATION_MESSAGE); 					 					 
				 } 
				 // show pegs after guess
				 else {
					 String black_pegs = guess_pegs.toBlackString();
					 String white_pegs = guess_pegs.toWhiteString();
					 if(black_pegs.equals("") && white_pegs.equals("")){
						 black_pegs = "No pegs";
					 }
					 JOptionPane.showMessageDialog(null, guess_code.toString() + " -> Result: " + black_pegs + white_pegs, msg_title, JOptionPane.INFORMATION_MESSAGE); 					 					 
				 }
			 }
			 else if(guess_code_str.equals("History")){
				  JOptionPane.showMessageDialog(null, gameboard.getHistroyString(), "Histroy", JOptionPane.INFORMATION_MESSAGE); 				 
			 }
			 else{
				  JOptionPane.showMessageDialog(null, guess_code_str + " -> INVALID GUESS", msg_title, JOptionPane.ERROR_MESSAGE); 					 
			 }
		}
		
		
		
	}
	
    public static void main(String[] args) throws Exception
    {
    	runGame();
    }
    
	public static void runGame(){
		int play_again;
		do{
			Game play = new Game(test_mode);
			// ask user to play again
            play_again = JOptionPane.showConfirmDialog(null, "Are you ready for another game of Mastermind?!", "Y/N", JOptionPane.YES_NO_OPTION);        
        } while(play_again == JOptionPane.YES_OPTION);
	}
    
    private boolean greetGame(){
		int greet_cfrm;
		String greet_msg;
		boolean greet_cont;
		do{
			greet_msg = "Welcome to Mastermind.  Here are the rules.\n\n"
					+ "This is a text version of the classic board game Mastermind.\n"
					+ "The computer will think of a secret code. The code consists of 4 colored pegs.\n"
					+ "The pegs may be one of six colors: blue, green, orange, purple, red, or yellow. A color may appear\n"
					+ "more than once in the code. You try to guess what colored pegs are in the code and what order they are\n"
					+ "in.   After you make a valid guess the result (feedback) will be displayed.\n"
					+ "The result consists of a black peg for each peg you have guessed exactly correct (color and position) in\n"
					+ "your guess.  For each peg in the guess that is the correct color, but is out of position, you get a white"
					+ "peg.  For each peg, which is fully incorrect, you get no feedback.\n\n"
					+ "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n"
					+ "When entering guesses you only need to enter the first character of each color as a capital letter.\n"
					+ "You have 12 guesses to figure out the secret code or you lose the game.  Are you ready to play?";
			greet_cfrm = JOptionPane.showConfirmDialog(null, greet_msg, "Mastermind", JOptionPane.YES_NO_OPTION);
			if(greet_cfrm == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "Let me know when you're ready then!", "Mastermind", JOptionPane.INFORMATION_MESSAGE);
				greet_cont = true;
			} else if(greet_cfrm == JOptionPane.YES_OPTION){
				greet_cont = false;
			}
			else {
				System.exit(0);
				greet_cont = false; // should not be reached
			}
	    } while(greet_cont);
		return true;
	}
    
    private Gameboard settingsGame(){
    	int settings_def;
    	String settings_quest = "Play with default settings?";
		settings_def = JOptionPane.showConfirmDialog(null, settings_quest, "Mastermind", JOptionPane.YES_NO_OPTION);
		
    	if(settings_def == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "TODO ASK FOR SETTINGS");
			Gameboard gameboard = new Gameboard(Gameboard.DEF_CODE_SIZE, Gameboard.DEF_GUESS_SIZE, Gameboard.DEF_COLOR_SIZE, Gameboard.DEF_COLORS);
			return gameboard;
		} else if(settings_def == JOptionPane.YES_OPTION){
			Gameboard gameboard = new Gameboard(Gameboard.DEF_CODE_SIZE, Gameboard.DEF_GUESS_SIZE, Gameboard.DEF_COLOR_SIZE, Gameboard.DEF_COLORS);
			return gameboard;
		}
		else {
			System.exit(0);
		}
		return null;
    }
}