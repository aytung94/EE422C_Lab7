/**
  Color Class
  EE422C Bonus Program
  @author Alvin Tung (ayt243)
  @version 1.00 2016-04-26
 */

package assignment7;

import java.util.*;

 
public class Color{
    
    private ArrayList<Character> colors;
    
    public Color(){
        this.colors = new ArrayList<>();
    }
    
    public char getColor(int index){
    	return this.colors.get(index);
    }
    
    public boolean addColor(char color){
   		colors.add(color);
   		return true;
    }
    
    public boolean addColors(char[] color){
		for(int i = 0; i < color.length; i++){
			this.addColor(color[i]);
   	 	}
   	 	return true;
    }
    
    public int size(){
    	return colors.size();
    }
    
    public boolean validColor(char color){
        return colors.contains(color);
    }
    
    public String toString(){
    	String str_color = new String();
    	for(int i = 0; i < colors.size(); i++){
			str_color += colors.get(i).toString();
   	 	}    	
		return str_color;
    }
    
    public String toPrintString(){
    	String str_color = "{";
    	for(int i = 0; i < colors.size() - 1; i++){
			str_color += colors.get(i).toString() + ",";
   	 	}    	
    	str_color = str_color + colors.get(colors.size() - 1).toString() + "}";
		return str_color;
    }
} 