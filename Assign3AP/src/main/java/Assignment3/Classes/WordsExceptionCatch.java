package Assignment3.Classes;

public class WordsExceptionCatch {
	
	//WordCatchException
	String [] s1=new String[400];

	public void search(String [] s,int u,String str,int sValue) throws WordException {
		
		s1=s;
		
		if(u==0) {
	    	throw new WordException("Word Not found Custom Catch");
	    }
	    
	    	
	    else {
	    	System.out.print("Your match word or query found from files Case insensitive: ");
	    	
		    	for(int i=0;i<sValue;i++)
		    	     System.out.print(s1[i]+" ");
		    	System.out.println();
		    	System.out.println("Number of matches of "+str+": "+u);
	    	
	    }
	}
	public void WrongChoice() throws WrongChoiceException {
		
		throw new WrongChoiceException("Wrong Choice Entered");
	}
	
}
