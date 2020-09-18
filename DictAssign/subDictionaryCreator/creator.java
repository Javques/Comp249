/**
 *
 * name and id Alexis Bolduc 40126092
 * Comp249
 * Assignment 4
 * due date April 19th
 * @author alexisbolduc
 *  @version v1
 *  
 * 
 * Welcome,
 * This is the creator class, a dictionary creator that reads a file and creates another one with each word in order
 */

package subDictionaryCreator;
/**
 * imports
 */
import java.util.ArrayList; 
import java.util.Scanner;
import java.io.PrintWriter; 
import java.io.FileOutputStream; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 

public class creator {
	/**
	 * the number of unique word is i
	 */
	static int i = 0;
	/**
	 * initializing the static list
	 */
	static ArrayList<String> wordsArr = new ArrayList<String>();
	
	/**
	 * the method addtoarray compares a word with other words in the array in order  to see if it's unique
	 * @param word
	 */
	public static void addToArray(String word) {
		
		
		int sort = (wordsArr.get(wordsArr.size()-1).compareTo(word));
		if(sort < 0) {
			wordsArr.add(word);
		}
		else if(sort>0) {
			
			for(int a = wordsArr.size()-1; a>=0;a--) {
				if((wordsArr.get(a)).compareTo(word)>0) {
					if(a==0)
						wordsArr.add(a,word);
					else 
						continue;
				}
				else if((wordsArr.get(a)).compareTo(word)<0) {
					
				
					wordsArr.add(a+1, word);
					break;
					
				}
				else {
					break;
				}
			}
		wordsArr.trimToSize();
		}
		
	}
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * array of letters
		 */
		String [] alphabet = { "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };
		
		System.out.println("Please input the name of the file");
		
		Scanner keyboard = new Scanner(System.in);
		String nameOfFile= keyboard.next();
		String [] characters = {"?",".",",","'",";",":","=","!","’"};
		Scanner readable = null;
		
		
		try {
			readable = new Scanner(new FileInputStream(nameOfFile));
			while(readable.hasNext()) {
				String temp = readable.next() ;
				temp.toUpperCase();
				/**
				 * getting ridd of numbers and undesired characters, as well as unique letter words except for A, I
				 */
				if( temp.contains("0")|| temp.contains("1")||temp.contains("2")||temp.contains("3")||temp.contains("4")||temp.contains("5")|| temp.contains("6")||temp.contains("7")||temp.contains("8")||temp.contains("9"))
					continue;
				if (temp.length()==1&&!temp.contains("A")&&!temp.contains("I"))
					continue;
				for(int a=0;a<characters.length;a++) {
					if(temp.contains(characters[a])) {
						temp = temp.substring(0,temp.indexOf(characters[a]));
						break;
					}
						
				}
				temp = temp.toUpperCase();
				
				if(i==0) {
					wordsArr.add(temp);
					
				}
				
				else{
					addToArray(temp);
				}
			
			i++;
			
			}
			keyboard.close();
			readable.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		/**
		 * writing the array to the new file SubDictionary.txt
		 */
		try {
			PrintWriter writefile = new PrintWriter(new FileOutputStream ("SubDictionary.txt"));
			writefile.println("The document produced this sud-dictionary, which includes "+wordsArr.size()+" entries.");
			int e = 0;
				for(int alpha = 0; alpha<alphabet.length;alpha++) {
					if(wordsArr.get(e).startsWith(alphabet[alpha]))
					writefile.println("\n"+alphabet[alpha]+"\n==");
					while((wordsArr.get(e)).startsWith(alphabet[alpha])) {
						writefile.println(wordsArr.get(e));
						e++;
						if(e==wordsArr.size()) {
						break;	
						}
						}
				}
				
			
			writefile.close();
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		
		
	}
/**
 * end of program thanks
 */
}
