package Assignment3.Classes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;
//FIleThread Class
public class FileThreads extends Thread {

	String file1;
	Vector<String> v=new Vector<String>();
	boolean flag;

	int freq;
	   public FileThreads(String Filename) {
	       file1=Filename;
	   }

	  synchronized public void run() {
		  Thread.currentThread().setName(file1);

			try {
			FileReader file = new FileReader(file1);
		    Scanner input = new Scanner(file); 
		  
		 
		   
		    while (input.hasNextLine()) {// Tokenizing File Sentences into words and storing in vector
		      
		      String word  = input.nextLine();
		      String []token=word.split(" ");
		      for(String t:token)
		      v.add(t);
		    }
		    
		   
	        
			}
		    catch(IOException e) {
		    	System.out.println("Input Stream Exception Catched");
		    }
		  
		   flag=true;
		   synchronized(this) {
			   this.notify();
		   }
	   }
	  public Vector<String> getVector() throws InterruptedException{
		
		  synchronized(this) {
			  if(!flag)
				  this.wait();
		  }
		  return v;
	  }
	  public int searchFile(String Word) throws IOException, InterruptedException {
		  
		
		 
		  File file = new File(file1);
		    Scanner input = new Scanner(file); 
		  
		      
		
		    while (input.hasNext()) {
		      String word  = input.next();
		      if(Word.equalsIgnoreCase(word)) {
		           freq++;
		          
		      }
		    }
		    return freq;
		
		 
		
		
	  }
	  
	  
	}

