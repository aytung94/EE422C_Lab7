/**
  Pegs Class
  EE422C Bonus Program
  @author Alvin Tung (ayt243)
  @version 1.00 2016-04-26
 */

package assignment7;

import java.util.*;

public class Pegs{
	
    public static final int DEF_PEG_SIZE = 4;
    public static final int BLACK = 2;
    public static final int WHITE = 1;
    public static final int EMPTY = 0;
    public static final boolean SEEN = true;
    public static final boolean SKIP  = false;
    
    private ArrayList<Integer> pegs;
    private ArrayList<Boolean> code_ind_seen;
    private int size;
	
	public Pegs(int num){
		this.pegs = new ArrayList<Integer>();
		this.size = num;
		this.code_ind_seen = new ArrayList<Boolean>();
		for(int i = 0; i < size; i++){
			code_ind_seen.add(SKIP);
		}
	}
	
	public boolean addBlack(int color){
		pegs.add(color);
		return true;
	}
	
	public void setSeen(int index){
		code_ind_seen.set(index, SEEN);
	}
	
	public boolean getSeen(int index){
		return code_ind_seen.get(index);
	}
	
	public String toBlackString(){
   	 	String peg_string = new String();
   	 	int num_black = 0;
   	 	for(int i = 0; i < pegs.size(); i++){
   	 		if(pegs.get(i) == BLACK){
   	 			num_black++;
   	 		} 
   	 	}
   	 	if(num_black == 0){
   	 		peg_string = "";
   	 	}else{
   	 		peg_string = num_black + "black peg";
   	 	}
   	 	return peg_string; 
	}

	public String toWhiteString(){
   	 	String peg_string = new String();
   	 	int num_white = 0;
   	 	for(int i = 0; i < pegs.size(); i++){
   	 		if(pegs.get(i) == WHITE){
   	 			num_white++;
   	 		} 
   	 	}
   	 	if(num_white == 0){
   	 		peg_string = "";
   	 	}else{
   	 		peg_string = num_white + "black peg";
   	 	}
   	 	return peg_string; 
	}
}
 