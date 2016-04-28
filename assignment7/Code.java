/**
  Code Class
  EE422C Bonus Program
  @author Alvin Tung (ayt243)
  @version 1.00 2016-04-26
 */

package assignment7;

import java.util.ArrayList;

 public class Code{
          
     private ArrayList<Character> code;
     
     public Code(){
         this.code = new ArrayList<Character>();
     }
     
     public Code(String str_code){
    	 code = new ArrayList<Character>();
    	 for(int i = 0; i < str_code.length(); i++){
    		 code.add(str_code.charAt(i));
    	 }
     }
     
     public boolean addCode(char code_entry){
  		 code.add(code_entry);
   		 return true;
     }
     
     public int size(){
    	 return this.code.size();
     }
     
     public int get(int index){
    	 return code.get(index);
     }
     
     public boolean correctCode(Code correct_code){
    	 for(int i = 0; i < this.size(); i++){
    		 if(code.get(i) != correct_code.getCodeInd(i)){
    			 return false;
    		 }
    	 }
    	 return true;
     }
     
     public Pegs getPegs(Code correct_code){
    	 Pegs peg = new Pegs(this.size());
    	 ArrayList<Integer> check_for_white = new ArrayList<Integer>();
    	 // fill pegs with black
    	 for(int i = 0; i < this.code.size(); i++){
    		 if(code.get(i) == correct_code.getCodeInd(i)){
    			 peg.add(Pegs.BLACK);
    			 peg.setSeen(i);
    		 }
    		 else {
    			 check_for_white.add(i);
    		 }
    	 }
    	 // fill pegs with white
    	 for(int i = 0; i < check_for_white.size(); i++){
    		 int index = check_for_white.get(i);
    		 for(int j = 0; j < correct_code.size(); j++){ 
				 // if the color has not been touched before and has the correct color
        	   	 if(this.code.get(index) == correct_code.get(j) && peg.getSeen(j) != Pegs.SEEN){
        	   		 peg.add(Pegs.WHITE);
        	   		 peg.setSeen(j);
        	   		 break;
        	     }
    		 }
    	 }
    	 
    	 return peg;
     }
     
     public char getCodeInd(int index){
    	 return code.get(index);
     }	 
     
     public String toString(){
    	 String code_string = new String();
    	 for(int i = 0; i < code.size(); i++){
    		 code_string += code.get(i).toString();
    	 }
    	 return code_string; 
     }
     
}
     