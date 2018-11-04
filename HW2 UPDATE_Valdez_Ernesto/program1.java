/**
 * Name: Ernesto Valdez
 * Date: 9/1/16
 * Class: JAVA HOMEWORK 2
 * Description: This program will read through a file and find the typos 
 * within the file. To find the typos a dictionary file will be 
 * used for comparison. The dictionary file will be provided by
 * Dr.Kim on his web site.
 * 
 * 
 * THIS PROGRAM WAS WRITTEN FOR THE SHORT DICTIONARY FILE SO
 * --------------------PLEASE USE THE SHORT DICTIONARY FILE---------- 
 * 	 
 *
 * UPDATE 1: THE WHILE LOOP THAT WAS SUPPOSED THE DELETE PUNCTUATION FROM THE STRINGS IF FINALLY WORKING
 * 			 AS IT WAS INTENTED AND DOES INDEED REMOVE THE PUNCTUATION FROM THE STRINGS
 * 
 * UPDATE 2: THE FINAL LOOP WAS FIXED SO THAT NOW WHEN COMPARING THE WORDS IT MAKES THE TEST ALL LOWERCASE
 * 			BEFORE IT WOULD JUST COMPARE NORMALLY AND THE OUTPUT WOULD NOT BE WHAT IT WAS SUPPOSED TO BE
 */
// imports to be able to use the scanner and the i/o
import java.io.*;
import java.util.*;
public class program1 {
private static String[] dictionary;



// main function
public static void main(String[] args) throws IOException, FileNotFoundException
{
	// output message to the user
	System.out.println("**********|Starting the program|*********");
	/* variables that will be used to open the file and compare the file
	 to the dictionary file
	*/
	String filename="";  // to store user input
	Scanner in= new Scanner(System.in);  // grabs user  input 
	File ifile;   // file class to open file and read
	String filetest="";
	Scanner in2= new Scanner(System.in);
	File ifile2;
	 
	/* loading the dictionary file and the test file into two separate arrays 
	 * using two while loops inserting them into their respective array to use for
	 * comparison.
	 * */
	
	filename="dictionary_short.txt";
	filetest="test.txt";
	ifile= new File(filename);
	ifile2= new File(filetest);
	String [] test= new String [1000000]; //  text array , large just incase there is a lot of words
	String []dictionary = new String[100000000]; // large array just in case there are too many words
	Scanner write= new Scanner(ifile);
	Scanner write2=new Scanner(ifile2);
	 
	
	
	////////////////////////////////////////////
	/// THIS  CHECKS IF THE FILES CAN BE READ///
	/////////////////////////////////////////////	
	// if they can be read then they get inserted into the arrays
		int i = 0, x = 0; // initialize i and x to zero
		if (ifile.isFile()) {

			System.out.println("Opening the dictionary file and the test file");
			System.out.println("loading....... please wait");
			// read through the test file until there is nothing next
			while (write2.hasNext()) {

				test[x] = write2.next();
				x++; // update length
			}
			// read through the dictionary file until the end of the file
			while (write.hasNext()) {

				dictionary[i] = write.nextLine();
				i++;//update length
			}
			System.out.println("Dictionary load complete");

		}

		else {
			System.out.println("Error...reading files");
		}
		
	 // before we can compare the array we want to check all the words that have 
	 // punctuation  next to them and  make sure its not counted in the comparison.
		
		int tlength=x;//length of test
		int dlength=i;//length of dictionary
		
		 // before we can compare the array we want to check all the words that have 
		 // punctuation  next to them and  make sure its not counted in the comparison.
		String word; // used as a variable to change the punctuation
		for( int p=0;p<tlength;p++)
		{
			//for the purpose of this program i will only be checking the punctuation 
			// that the file currently has
			word=test[p];
			//System.out.println("Word:"+word);
			// checks if the word ends with a punctuation and replaces and insets it back into the array
			if(word.endsWith(",") || word.endsWith("?") || word.endsWith("."))
			{
				// the replace function replaces the target chracter and 
				//replaces it with whatever you want in this case we want to replace 
				// it with nothing
				String new_word = null;
				if(word.endsWith(","))
				{
					
					new_word=word.replace(",", "");
				}
				else if(word.endsWith("?"))
				{
					new_word=word.replace("?", "");
				}
				else if(word.endsWith("."))
				{
					new_word=word.replace(".", "");
				}
				
			
				test[p]=new_word;
				System.out.println("After:"+test[p]);
			}
			//System.out.println("After1"+ word);
			
		}
		
		//System.out.println("Removed Punctuation from test file");
		
		System.out.println("test file size: "+tlength);
		////////////////////////
		// TO PRINT THE FILE //
		///////////////////////
		/*for(int z =0;z<tlength;z++)
		{
			System.out.println(test[z]);
		}*/
		System.out.println("dictionary file size: "+dlength);
		/////////////////////////////////
		// TO PRINT THE DICTIONARY FILE//
		/////////////////////////////////
		/*for(int d=0;d<dlength;d++)
		{
			System.out.println(dictionary[d]);
		}
		*/
		System.out.println("READING THE FILE PLEASE WAIT A COUPLE OF SECONDS WHILE THE TEXT GETS EDITTED");
		System.out.println("************");
		int d=0;
		for(i=0;i<findLength(test);i++)
		{
			// we must change the word to lower case beacuse if we dont then
			// we we will not be able to properly compare the two strings
			String compare=test[i].toLowerCase();
	 
			for(d=0;d<findLength(dictionary);d++)
			{
				if(dictionary[d].equals(compare)) // we comapre it to the new string which has the lowercase words
				{
					System.out.println(test[i]+" "); // but still print out the words that we have
					break;
				}
				else if(d==findLength(dictionary)-1)
				{
					
					System.out.println("*"+test[i]+"*");
				}
	 
			}
			
	 
	 
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
	// loop that goes through the text file and for each word checks it with the dictionary file and if the
	// word is not in the dictionary we know that it is wrong
	 
	 
		}
		public static String removeCharAt(String s, int pos) 
		{
			return s.substring(0, pos) + s.substring(pos + 1);
		}
		static int findLength(String[] arr)
		{
			int counter=0;
			for(int i=0;i<arr.length-1;i++)
			{
				if(arr[i]!=null)
				{
					counter++;
				}
			}
		 
		 
			return counter;
		}
 
}
