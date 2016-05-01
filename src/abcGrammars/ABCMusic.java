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
package abcGrammars;

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
	
	public void getTicksPerBeat(List<Integer> allFractions) {
		
	}
}