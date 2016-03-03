/*
From Project Assignment Doc:

     C: Name of the composer.
	 K: Key, which determines the key signature for the piece.
	 L: Default length or duration of a note.
	 M: Meter. It determines the sum of the durations of all notes within a bar.
	 Q: Tempo. It represents the number of default-length notes per minute.
	 T: Title of the piece.
	 X: Index number, similar to the track number in a recording. In this project, this field does not carry any
	 meaning, as you are required to parse only one abc file at a time. However, the official standard designates
	 this field to be mandatory in every abc file, and therefore, your parser must be able at least to read it (and
	 may then discard it). 	
*/
package abc;

import java.util.ArrayList;
import java.util.List;

import sound.Pitch;
import sound.SequencePlayerTest;

public class Lexer {
	
	SequencePlayerTest t = new SequencePlayerTest();
	private ABCMusic myABC = new ABCMusic();
		
	public void LexMe(String parsedValue)
	{
		int val = checkHeaderValues(parsedValue);
        switch (val) {
        	case 1:  	myABC.composer =  splitString(parsedValue); //C
                     	break;
            case 2:  	myABC.key =  splitString(parsedValue); //K
                     	break;  
            case 3:		myABC.length = splitFraction(parsedValue); //L
            			break;
            case 4:		myABC.meter = splitString(parsedValue); //M
						break;
            case 5:		myABC.tempo = Integer.parseInt(splitString(parsedValue)); //Q
            			break;
            case 6:		myABC.title = splitString(parsedValue); //T
            			break;
            case 7:		myABC.index = splitString(parsedValue); //X
            			break;
            case 8: 	myABC.notes = splitNotes(parsedValue); //Split the notes into sequences within a list
            			getSequences(myABC.notes);
            			break;
            }
        //System.out.println(val);
	}
		
	public int checkHeaderValues(String pv) {
		int i = 0;
		
		if (pv.startsWith("C:")){
			i = 1;			
		}
		else if (pv.startsWith("K:")) {
			i = 2;
		}	
		else if (pv.startsWith("L:")) {
			i = 3;
		}	
		else if (pv.startsWith("M:")) {
			i = 4;
		}	
		else if (pv.startsWith("Q:")) {
			i = 5;
		}	
		else if (pv.startsWith("T:")) {
			i = 6;
		}	
		else if (pv.startsWith("X:")) {
			i = 7;
		}	
		else {			
			i = 8; //Get the notes
		}
		return i;
	}
	
	private String splitString(String x)
	{
		//System.out.println(x);
		String returnString = "Not Specified";
		String[] splitter = x.split(":");
		if(splitter.length > 1)
		{
			returnString = splitter[1];
		}
		return returnString;
		
	}
	
	private List<String> splitNotes(String x)
	{
		List<String> listOfNotes = new ArrayList<String>();
		String[] splitter = x.split("\\|"); //split the notes by a pipe
		//System.out.println("splitNotes" + x);
		if(splitter.length > 1) {			
			for(int k = 0; k < splitter.length; k++) {				
				//System.out.println(splitter[k].trim());
				listOfNotes.add(splitter[k].trim());
			}		
		}
		
		return listOfNotes;		
	}
	
	private Fraction splitFraction(String x)
	{
		Fraction f = null;
		String[] splitter = x.split(":");
		if(splitter.length > 1) {			
			String[] splitAgain = splitter[1].split("/");			
			if(splitAgain.length > 1) {				
				f = new Fraction(Integer.parseInt(splitAgain[0]),Integer.parseInt(splitAgain[1]));
			}
		}
		
		return f;
	}
	
	private void getSequences(List<String> sequence) {
		
		int seqNum = 1;
		for (String s : sequence) {
			System.out.println("****Sequence number: " + seqNum + "****");
			Sequence seq = new Sequence();
			String[] splitSpaces = s.split(" ");
			for(int i = 0; i < splitSpaces.length; i++) {
				if(splitSpaces[i].contains("/"))
				{
					
				}
				else if (splitSpaces[i].startsWith("("))
				{
					
				}
				else if (splitSpaces[i].startsWith("[") || (splitSpaces[i].startsWith("]"))) {
					//do nothing
				}
				else {
					char theChar = splitSpaces[i].toCharArray()[0];					
					//System.out.println(theChar);					
					seq.setPitch(new Pitch(theChar));
					
					
				}
				
				//processMusic(splitSpaces[i]);
			}
			myABC.sequences.add(seq);
			seqNum++;
			//processMusic();
		}
		
		
	}
	
	public void sendTest() {
		t.PlayMe(myABC);
	}
	
}



