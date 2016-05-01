/*
 * Author: Lindsey Lanier
 * Created: February 6, 2016
 * Parser.java
 * 
 * 	There are several additional requirements on the header:
 * 	The first field in the header must be the index number ('X').
 * 	The second field in the header must be the title ('T').
 * 	The last field in the header must be the key ('K').
 * 	Each field in the header occurs on a separate line.
 * 	All fields other than 'X', 'T', and 'K' are optional, and may appear in any order.
 */

package abcGrammars;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Parser {
	
	private ABCMusic myABC = new ABCMusic();
	
	/**
     * @param abcFile
     *            : the name of the abc file to parse
     * @post read in the abcFile using readFile method and then lex it into tokens
     */
	public void parseABCFile(String abcFile) {
		Lexer lex = new Lexer();
		try {			
			String abc = readFile(abcFile);
			int totalLines = abc.split("\n").length;
			//System.out.println("Total number of lines is: " + totalLines);
			int i = 0;
			for (String retval : abc.split("\n")){
				 if(i==0 && retval.contains(":") && !retval.startsWith("X")){ System.out.println("Invalid File. The ABC File's first header token must be X (Index Number)"); break;}
				 if(i==1 && retval.contains(":") && !retval.startsWith("T")){ System.out.println("Invalid File. The ABC File's second header token must be T (Title)"); break;}
				 if(i==totalLines-2 && retval.contains(":") && !retval.startsWith("K")) { System.out.println("Invalid File. The ABC File's last header token must be K (Key)"); break;}
				 
				 lex.LexMe(retval); //Pass values to the lexer				 				 				
		         i++;		         
		    }		
			
			//lex.sendTest();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
	
	public String readFile(String fileName) throws IOException {
		
		String wrapUp = "";
		
		try {
			BufferedReader bReader = 
					new BufferedReader(new FileReader(fileName));
			StringBuilder sBuilder = new StringBuilder();
			String line = bReader.readLine();
			
			while (line!=null) {
				sBuilder.append(line + "\n");
				line = bReader.readLine();
			}
			
			wrapUp = sBuilder.toString();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("The file consists of: " + "\n" + wrapUp);
		return wrapUp;
	}
}
