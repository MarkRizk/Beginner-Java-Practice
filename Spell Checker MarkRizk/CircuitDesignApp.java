import java.io.*;
import java.util.*;


public class CircuitDesignApp {
	 	
	
	public static void main (String[] args ) throws Exception {
	
	BufferedReader bufferRead = null;
	BufferedWriter bufferWrite = null;
	File goodFile = new File("good.txt");
	
//Array list that comprises of all the mathematical data in this code
		ArrayList<String> listAllData = new ArrayList<String>();
//Array list that comprises of the good data that equals to 7.5 after the resistance values are put through the given equation	
		ArrayList<String> goodData = new ArrayList<String>();
//Array list that comprise of the bad data that does not equal 7.5 after going through the given equation
		ArrayList<String> badData = new ArrayList<String>();
				
			 
			 
		     try {
//Initialize the buffer reader variable to buffer the data of the files used in the program
		       bufferRead = new BufferedReader(new java.io.FileReader(args[0]));
		       String readline;
//Condition in the While loop allows the program to analyze the data from all the data found in the listAllData Array List
		     while((readline = bufferRead.readLine()) != null) {
		     listAllData.add(readline);
		     }
		     
		     for(int i = 0; i<listAllData.size(); i++){
		     String[] resistance = listAllData.get(i).split("\t");
		    		
		     double answerResist;
		    	
			 answerResist = (( (Double.parseDouble(resistance[0]) + Double.parseDouble(resistance[1])) * (Double.parseDouble(resistance[3]) * Double.parseDouble(resistance[5])) ) / 
			    			( (Double.parseDouble(resistance[2]) + Double.parseDouble(resistance[3])) * (Double.parseDouble(resistance[0])* Double.parseDouble(resistance[4]) ) ));

//if the answer of the given equation doesn't equals 7.5, the values will be added to the badData Array List 
			    	
			 if(answerResist != 7.5){
			 
		     badData.add(Double.parseDouble(resistance[0]) + "\t" + Double.parseDouble(resistance[1]) + "\t" +  Double.parseDouble(resistance[2])+ "\t"  + Double.parseDouble(resistance[3]) + "\t" + Double.parseDouble(resistance[4]) + "\t" + Double.parseDouble(resistance[5]) + "\n" );		    		

//if the answer of the given equation is 7.5, the values will be added to the goodData Array List    				    				    			
			    	}
			  else{
			  
			  goodData.add(Double.parseDouble(resistance[0]) + "\t" + Double.parseDouble(resistance[1]) + "\t" +  Double.parseDouble(resistance[2])+ "\t"  + Double.parseDouble(resistance[3]) + "\t" + Double.parseDouble(resistance[4]) + "\t" + Double.parseDouble(resistance[5]) + "\n" );
			    		
			    	}
		       }
		      
		         
		       
		     } finally 
		     {
		       bufferRead.close();
		     }
		     
		     for(int i = 0; i< badData.size(); i++){
		    	 System.out.println(badData.get(i));	    	 
		     }
//	     
		     bufferWrite = new BufferedWriter(new FileWriter("good.txt"));
		     for(int j =0; j<goodData.size(); j++){
		    	 bufferWrite.write(goodData.get(j));
		    	 bufferWrite.newLine();
		    	 
		     }
		     bufferWrite.close();
		   }
		}	
	

	
		
	
	
	
