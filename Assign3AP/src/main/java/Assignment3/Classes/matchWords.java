package Assignment3.Classes;

import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;
//MatchWords Class
public class matchWords {

	TreeSet<String> T=new TreeSet<String>();
	Vector<String> v=new Vector<String>();
	String file1;
	
	
 public void matchWords1(Vector<String>v1,TreeSet<String>T1) throws NullPointerException {
    	   v=v1;
    	   T=T1;
    	   
    	   int k=0;
    	   
     try {
    	   String[] match=new String[500];
    	   Map<String, Integer> wor = new HashMap<>();
    	   System.out.print("Matched Words from files with vocabulary= ");
    	 
    	   
    	   for(int i=0;i<T.size();i++) {
    		   for(int j=0;j<v.size();j++) {
    		   if(v.elementAt(j).toString().equalsIgnoreCase(T.toArray()[i].toString())) {
    			   
    			   
    			   if(wor.containsKey(v.elementAt(j))) {
    				   wor.put(v.elementAt(j), 1 + wor.get(v.elementAt(j)));
    			   }
    			   else {
    				   
    			   match[k]=v.elementAt(j).toString();
    			   instanceWord iw=new instanceWord();
    			   iw.setMatchWords(match);
    			   wor.put(iw.getMatchWords()[k], 1);
    			   System.out.print(iw.getMatchWords()[k]+" ");
    			   k++;
    			   }
    			
    
    		   }
    	   }
    	   }
    	  
    	
    	   System.out.println();
    	 
    		   
    	   System.out.println("Frequency of "+wor);
    		
    			  
    		   
    	   }
    	   catch(NullPointerException e) {
    		   System.out.println("NullPointer Exception Catched");
    	   }
    
    	  
       }
       
       
}

