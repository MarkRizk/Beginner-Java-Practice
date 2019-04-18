import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class SpellChecker {

     /**The method spell checks the file name to ensure there are not any spelling errors
     * @param fileName is an input file stream (e.g. bonk.txt)
     * @return ArrayList<String> 
     * returns the words that aren't found in the dictionary
     */

    public ArrayList<String> spell(String fileName) {
        Scanner input = new Scanner(System.in);
        File file = new File(fileName);
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.print("File not found.");
        }
        
//useDelimiter takes the letter values
        input.useDelimiter("[^A-Za-z]+");
        
//Initializing the array list of string values of the "strWord" variable       
        ArrayList<String> arrayListString = new ArrayList<String>();
        String strWord;
//while loop requires the user to input words into the "strWord" variable and ensuring the size of each word is greater than 1 in order to add it to the "arrayListString" array list
        while (input.hasNext()){
            strWord = input.next();
            if (strWord.length() > 1) {
                arrayListString.add(strWord);
        }
        }
        input.close();
//return the array list "arrayListString"
        return arrayListString;
    }

    /**The method uses words that are not found in the dictionary file 
     * and prints a list of words that are not duplicated
     * @param ArrayList<String> List of words not found in dictionary
     */

    public void printNonDuplicates(ArrayList<String> arrayList) {
    	
//Initializing the array list of string values to print words that are not duplicates found in a file stream
        ArrayList<String> notDupliArray = arrayList;
        
//Initializing the array list of string values that are words from the dictionary
        ArrayList<String> wordDiction = new ArrayList<String>();

        Scanner in = new Scanner(System.in);
        File file = new File("dictionary.txt");
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.print("Error: File not found.");
        }

        int count = 0;
        while(in.hasNext()){
            in.next();
            count++;
        }
        in.close();

        String[] dictionary = new String[count];

        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.print("File not found.");
        }

        for (int i = 0; i < count; i++){
            dictionary[i] = in.next();
        }
//for loop governs the "i" variable to be less than the array list "notDupliArray" to begin the if statement of finding a word from the dictionary and adding it to the "notDupliArray" 
//and increments by a value of 1 each time it loops
        for (int i = 0; i < notDupliArray.size(); i++){
            if (inDictionary(notDupliArray.get(i), dictionary)) {
                wordDiction.add(notDupliArray.get(i));
        }
        }
        
//while loop condition is based on the "i" variable being less than the size of the "wordDiction" variable (the word found in the dictionary) and increments by a value of 1 each time it loops
//increments by a value of 1 each time it loops     
        int i = 0;
        while (i < wordDiction.size()) 
        i++;
        {
//for loop governing the words found in the dictionary "wordDiction" and compares the specified String to this String ignoring the case of the characters and answer if they are equal - this is done via "equalsIgnoreCase" method
//decrements the value "j" by 1 each time it loops     
        for (int j = i+1; j < wordDiction.size(); j++) 
        {
             if (wordDiction.get(i).equalsIgnoreCase(wordDiction.get(j))){
                 wordDiction.remove(j);
                 j--;
        }
        }
        }
//while loop will increment if "i" is less than the size of the "wordDiction" array list and using the System.out.println to output the wordDiction varible by getting the "i" value of that current word
//increments by a value of 1 each time it loops
        while ( i < wordDiction.size()){
            System.out.println(wordDiction.get(i));
            i++;
        } 
        
        }

    /**The method returns a true boolean value if a word is found in the input file stream
     * (e.g. bonk.txt) is in the dictionary, and a false boolean value if not found.
     * @param strWord a string that contains a word to be checked by the spell checker
     * @return the boolean value depending on the word being found or not - true/false
     */
    
    public boolean inDictionary(String strWord, String[] dictionary) {
    	
//Initializing a string array called "strDiction" which comprises of words found in the dictionary
        String[] strDiction = dictionary;
        boolean bLean = true;
        
        for (int i = 0; i < strDiction.length; i++)
        
        {
//if the word found in the dictionary matches the array "strDiction", boolean value is false     	
            if (strWord.equalsIgnoreCase(strDiction[i])) 
            
        {
                bLean = false;
                break;
        }
        }
//returns boolean variable "bLean"
        return bLean;
        
        }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String fileName;
        System.out.print("Please enter a fileName: ");
        fileName = in.next();
        in.close();
        
        SpellChecker spellCheck = new SpellChecker();
        spellCheck.printNonDuplicates(spellCheck.spell(fileName));
        
        }

}

