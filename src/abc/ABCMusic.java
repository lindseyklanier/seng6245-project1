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

import java.util.*;

import sound.Pitch;

public class ABCMusic {
	
	public String composer;
	public String key;
	public Fraction length;
	public String meter;
	public int tempo;
	public String title;
	public String index;	
	public List<String> notes = new ArrayList<String>();
	public List<Sequence> sequences = new ArrayList<>();
	 

	public String getComposer() {
		return composer;
	}

	public String getKey() {
		return key;
	}

	public Fraction getLength() {
		return length;
	}

	public String getMeter() {
		return meter;
	}

	public int getTempo() {
		return tempo;
	}

	public String getTitle() {
		return title;
	}

	public String getIndex() {
		return index;
	}

	public List<String> getNotes() {
		return notes;
	}

	public List<Sequence> getSequences() {
		return sequences;
	}

	public void setSequences(List<Sequence> sequences) {
		this.sequences = sequences;
	}
	

	
/*
public class ABCSequence {
	
	public String chord; //Notes within a square bracket []
	public String tuplet; //Denoted by the opening of a (, we only handle duplets (groups of 3 notes)
	public char rest; //z
	public char sharp; // ^
	public char doublesharp; // ^^
	public char flat; // _
	public char doubleflat; // __
	public char natural; // =
	public Pitch pitch;
		
	public String getChord() {
		return chord;
	}

	public void setChord(String chord) {
		this.chord = chord;
	}

	public String getTuplet() {
		return tuplet;
	}

	public void setTuplet(String tuplet) {
		this.tuplet = tuplet;
	}

	public char getRest() {
		return rest;
	}

	public void setRest(char rest) {
		this.rest = rest;
	}

	public char getSharp() {
		return sharp;
	}

	public void setSharp(char sharp) {
		this.sharp = sharp;
	}

	public char getDoublesharp() {
		return doublesharp;
	}

	public void setDoublesharp(char doublesharp) {
		this.doublesharp = doublesharp;
	}

	public char getFlat() {
		return flat;
	}

	public void setFlat(char flat) {
		this.flat = flat;
	}

	public char getDoubleflat() {
		return doubleflat;
	}

	public void setDoubleflat(char doubleflat) {
		this.doubleflat = doubleflat;
	}

	public char getNatural() {
		return natural;
	}

	public void setNatural(char natural) {
		this.natural = natural;
	}
			
	public Pitch getPitch() {
		return pitch;
	}

	public void setPitch(Pitch pitch) {
		this.pitch = pitch;
	}
	
	public void test(){
		System.out.println("i'm here.");
	}

	
	/*
	public ABCSequence(String c, String t, char r, char s, char ds, char f, char df, char n) {
		this.chord = c;
		this.tuplet = t;
		this.rest = r;
		this.sharp = s;
		this.doublesharp = ds;
		this.flat = f;
		this.doubleflat = df;
		this.natural = n;
	}
	*/
	
	
}



