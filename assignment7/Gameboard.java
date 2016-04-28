/**
  Gameboard Class
  EE422C Bonus Program
  @author Alvin Tung (ayt243)
  @version 1.00 2016-04-26
 */
 
package assignment7;

import java.util.*;

 public class Gameboard{
     
     public static final int DEF_CODE_SIZE = 4;
     public static final int DEF_GUESS_SIZE = 12;
     public static final int DEF_COLOR_SIZE = 7;
     public static final char[] DEF_COLORS = {'B','G','O','P','R','Y','-'}; 
	 
     private int code_size;
     private int guess_size;
     private int color_size;
     
     private Color colors;
     private ArrayList<Code> code_history;
     private ArrayList<Pegs> peg_history;
     private Code secret_code;
     
     public Gameboard(int code_size, int guess_size, int color_size, char[] color){
    	 this.code_size = code_size;
    	 this.guess_size = guess_size;
    	 this.color_size = color_size;
    	 
    	 this.colors = new Color();
    	 colors.addColors(color);
    	 this.code_history = new ArrayList<Code>();
    	 this.peg_history = new ArrayList<Pegs>();
    	 secret_code = null;
     }
     
     public boolean addHistory(Code code, Pegs peg){
    	 if(code_history.size() < guess_size && peg_history.size() < guess_size){
    		 code_history.add(code);
    		 peg_history.add(peg);
    		 return true;
    	 }
    	 return false;
     }
     
     public void generateCode(){
    	 Random rand = new Random(System.currentTimeMillis());
    	 secret_code = new Code();
    	 for(int i = 0; i < code_size; i++){
    		 secret_code.addCode(colors.getColor(rand.nextInt(color_size - 1)));
    	 }
     }
     
     public Code getSecretCode(){
    	 return secret_code;
     }
     
     public String getSecretCodeString(){
    	 return secret_code.toString();
     }
     
     public int getGuessSize(){
    	 return this.guess_size;
     }
     
     public Color getColor(){
    	 return this.colors;
     }
     
     public int getCodeSize(){
    	 return this.code_size;
     }
     
     public String getHistroyString(){
    	 String str_history = "# : Code  | Feedback\n"; 
    	 String space = ""; 
    	 for(int i = code_history.size() - 1; i >= 0; i--){
    		 if(i < 10){
    			space = " ";  
    		 }
    		 str_history = str_history + i + space + ": " + code_history.get(i).toString() + " | " + peg_history.get(i).toString() + "\n";
    	 }
    	 return str_history;
     }
 }
 