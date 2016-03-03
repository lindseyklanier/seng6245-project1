package sound;

import abc.ABCMusic;
import abc.Parser;

public class SequencePlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Parser p = new Parser();
		//p.parseABCFile("sample_abc/piece2.abc");
		p.parseABCFile("sample_abc/piece1.abc");
	}
	
	public void PlayMe(ABCMusic music) {
		/*
		System.out.println("Let's quickly print the details of our abc piece.");
		System.out.println("Composer: " + music.getComposer());
		System.out.println("Index: " + music.getIndex());
		System.out.println("Key: " + music.getKey());
		System.out.println("Tempo: " + music.getTempo());
		System.out.println("Title: " + music.getTitle());		
		System.out.println("Length: " + music.getLength());
		System.out.println("Meter: " + music.getMeter());
		System.out.println("Notes: " + music.getNotes());
		System.out.println("................");
		*/
	}

}
