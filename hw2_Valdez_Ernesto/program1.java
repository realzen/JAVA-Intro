/**
 * Name: Ernesto Valdez
 * Date: 9/1/16
 * Class: JAVA HOMEWORK 2
 * Description: This program will read through a file and find the typos 
 * within the file. To find the typos a dictionary file will be 
 * used for comparison. The dictionary file will be provided by
 * Dr.Kim on his web site.
 *
 */
// imports to be able to use the scanner and the i/o
import java.io.*;
import java.util.*;
public class program1 {
private static String[] dictionary;



// main function
public static void main(String[] args) throws IOException
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
	
	filename="dictionary.txt";
	filetest="test.txt";
	ifile= new File(filename);
	ifile2= new File(filetest);
	String [] test= new String [1000000]; // 
	String []dictionary = new String[100000000]; // large array just in case there are too many words
	Scanner write= new Scanner(ifile);
	Scanner write2=new Scanner(ifile2);
	 
	// to check if they can be opened if not then don't do anything and tell the user
	int i = 0,x=0; //initialize i and x to zero
	if(ifile.isFile())
	{
	 
		System.out.println("Opening the dictionary file and the test file");
		System.out.println("loading....... please wait");
		//read through the test file until there is nothing next
		while(write2.hasNext())
		{
	 
			test[x]=write2.next();
			x++;
		}
	// read through the dictionary file until the end of the file
		while(write.hasNext())
		{
	 
			dictionary[i]=write.nextLine();
			i++;
		}
		System.out.println("Dictionary load complete");
	 
	}
	
	else
	{
		System.out.println("Error...reading files");
	}  
	 
	 
	// now to make another  array for comparison and to delete unwanted chrs
	String []comparison=new String[10000];
	for(int y=0;y<findLength(test);y++)
	{
		if(test[y].endsWith(".")||test[y].endsWith("."))
		{
			String str=removeCharAt(test[y],test[y].lastIndexOf(test[y]));
			comparison[y]=str;
	 
		}
		else
			comparison[i]=test[i];
	 
		}
	 
		int tlength=x-1;//length of test
		int dlength=i-1;//length of dictionary
		for(int z =0;z<tlength;z++)
		{
			System.out.println(comparison[z]);
		}
		System.out.println("test file size: "+tlength);
		for(int z =0;z<tlength;z++)
		{
			System.out.println(test[z]);
		}
		System.out.println("dictionary file size: "+dlength);
		for(int d=0;d<dlength;d++)
		{
			System.out.println(dictionary[d]);
		}
		System.out.println("************");
		int d=0;
		for(i=0;i<findLength(test);i++)
		{
	 
			for(d=0;d<findLength(dictionary);d++)
			{
				if(dictionary[d].equals(test[i]))
				{
					System.out.println(test[i]+" ");
					break;
				}
				else if(d==findLength(dictionary)-1)
				{
					System.out.println("*"+test[i]+"*");
				}
	 
			}
			
	 
	 
		}
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