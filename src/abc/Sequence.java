package abc;

import java.util.List;

import sound.Pitch;

public class Sequence {
	public List<String> chord; //Notes within a square bracket []
	public String tuplet; //Denoted by the opening of a (, we only handle duplets (groups of 3 notes)
	public char rest; //z
	public char sharp; // ^
	public char doublesharp; // ^^
	public char flat; // _
	public char doubleflat; // __
	public char natural; // =
	public Pitch pitch;
	
	public List<String> getChord() {
		return chord;
	}

	public void setChord(List<String> chord) {
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

}
