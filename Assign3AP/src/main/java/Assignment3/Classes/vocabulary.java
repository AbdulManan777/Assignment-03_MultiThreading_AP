package Assignment3.Classes;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

//VocabularyThread
public class vocabulary extends Thread{

	String file1;
	TreeSet<String> T=new TreeSet<String>();
	boolean flag;
	   public vocabulary(String Filename) {
	       file1=Filename;
	   }
	   
	  synchronized public void run() {
		  Thread.currentThread().setName(file1);
		  try {  
	    	  File file = new File("vocabulary.txt");
	    	    Scanner input = new Scanner(file); 
	    
	    	 
	    	    
	    	    while (input.hasNext()) {
	    	      String word  = input.next();
	    	      
	    	      T.add(word);
	    	      
	    	      
	    	    }
	    	    
	    	   
	            
	    	
	    	}
	    	    catch(IOException e) {
	    	    	System.out.println("Input Stream Exception Catched");
	    	    }
	    	    
		   flag=true;
		   synchronized(this) {
			   this.notify();
		   }
	
	
	
		
		  // this.notify();
		   
	   }
	  public TreeSet<String> getTree() throws InterruptedException{
		  try {
		  synchronized(this) {
			  if(!flag)
				  this.wait();
		  }
		  }
		  catch(InterruptedException ie) {
			  System.out.println("InterruptedException Catached");
		  }
		  return T;
	  }

}
