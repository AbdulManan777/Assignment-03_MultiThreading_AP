package Assignment3.Classes;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;
//Main Class
public class driverClass {

	public static void main(String[] args) throws InterruptedException, IOException, WordException, WrongChoiceException,NullPointerException, EmptyException {
		
	     String voc= args[0];
	     String files;
	     
	     int coun=1;
	     System.out.println("Number of FIles here");
	     for(int i=1;i<args.length;i++) {
	    	 files=args[i];
	    	  coun++;
	    	  System.out.println(files);
	    	  
	     }
	     TreeSet<String>T1=new TreeSet<String>();
	     Vector<String> v1=new Vector<String>();
	     System.out.println("Number of Files including vocabulary="+coun);
	     
	     vocabulary v=new vocabulary(voc);
	      v.setName(voc);
	      System.out.println("Thread running: "+v.getName());
	      v.start();
	     
 	    
 	    T1=v.getTree();
        
 	   for(int i=1;i<args.length;i++) {
	    	  files=args[i];
	    	FileThreads m=new FileThreads(files);
	    	m.setName(files);
	    	System.out.println("Thread running: "+m.getName());
	    	m.start();
	    	
	    		v1.addAll(m.getVector());
	    	
	    	 	    
		   
	    }
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
 	    matchWords B=new matchWords();
	  
	    
 	   
 	    int choice;
 	    while(true) {
 	    System.out.println("----------------Welcome to Multithreaded Command line Arguments Program------------------");
 	    System.out.println("---------------------Main Menu---------------------------------");
 	    System.out.println("Select the Option of your choice");
 	    System.out.println("Press 1 to print full BST Build");
 	    System.out.println("Press 2 to print full Vector Build");
 	    System.out.println("Press 3 to View match words and thier frequency");
 	    System.out.println("Press 4 to Search for a particular word from file");
 	    System.out.println("Press 5 to exit from program");
 	    Scanner inp=new Scanner(System.in);
 	    try {
 	    choice=inp.nextInt();
 	    
 	    
 	    if(choice==1) {
 	    	
 	    	
 	    	 
 		      System.out.println("Printing BST Tree");
 	  	    Iterator<String> iterator = T1.iterator();
 	      
 	          while (iterator.hasNext())
 	              System.out.print(iterator.next() + " ");
 	          System.out.println();
 	   
 	      
 	          if (T1.isEmpty())
 	        	  try {
 	              throw new EmptyException("Tree Empty Exception");
 	        }
 	        catch(EmptyException e) {
 	        	System.out.println("Empty BSt Excption catch");
 	        }
 	          else
 	              System.out.println("BST Size: " + T1.size());
 	    }
 	    
 	    
 	    else if(choice==2) {
 	    	
 	    
 	   System.out.println("Printing vector Temproray Collection");
	    Iterator<String> iterator2 = v1.iterator();
   
       while (iterator2.hasNext())
           System.out.print(iterator2.next() + " ");
       System.out.println();

     
       if (v1.isEmpty())
    	   try {
	              throw new EmptyException("Vector Empty Exception");
	        }
	        catch(EmptyException e) {
	        	System.out.println("Empty Vector Excption catch");
	        }
       else
           System.out.println("Vector size: " + v1.size());
 	    
 	   
 	    
 	    }
 	    
 	    
 	    else if(choice==3) {
 	    
 	    
 	    
 	    	
 	   B.matchWords1(v1, T1);
 	   
 	   
 	   
 	    }
 	    
 	    else if(choice==4) {
 	   
 	   
 	   System.out.println("Enter the Word you want to search from file thread");
 	   
 	   Scanner wo=new Scanner(System.in);
 	   String str=wo.nextLine();
 	   String [] fi=new String[100]; 
 	   int u=0;
 	   int ind = 0;
 	   int mValue=0;
 	   for(int i=1;i<args.length;i++) {
 	  FileThreads m2=new FileThreads(args[i]);
 	  
 	   u+= m2.searchFile(str);
 	   if(u>0) {
 		   
 		   fi[ind]=args[i];
 		   ind++;
 		   mValue+=u;
 		   u=0;
 		
 		  
 	   }
 	   }
 	    
 	    WordsExceptionCatch sc=new WordsExceptionCatch();
 	    try {
 	    sc.search(fi,mValue,str,ind);
 	    }
 	    catch(WordException e) {
 	    	System.out.println("Word not found Exception Custom Exception Catched");
 	    }
 	   
 	    }
 	    
 	    else if(choice==5) {
 	    	System.exit(0);
 	    }
 	    
 	    
 	    else {
 	    	WordsExceptionCatch s=new WordsExceptionCatch();
 	    	try {
 	    	s.WrongChoice();
 	    	}
 	    	catch(WrongChoiceException w) {
 	    		System.out.println("Wrong Choice Custom Exception Catched");
 	    	}
 	    }
 	    }
 	    catch(InputMismatchException e) {
 	    	System.out.println("InputMismatchException Catched");
 	    }
 	    }
 	    
	}

}
