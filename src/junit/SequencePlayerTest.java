package junit;

import static org.junit.Assert.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

import org.junit.Test;

import abcGrammars.ABCMusic;
import abcGrammars.Parser;
import abcGrammars.Sequence;
import sound.Pitch;
import sound.SequencePlayer;

public class SequencePlayerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//Parser p = new Parser();
		//p.parseABCFile("sample_abc/piece2.abc");
		//p.parseABCFile("sample_abc/piece1.abc");
		
		testPlay_Piece1();
		testPlay_Piece2();
	}
	
	@Test
	public static void testPlay_Piece1() {
		SequencePlayer player;
		
		try {
			
			player = new SequencePlayer(140, 12);
			 
			// C C C3/4 D/4 E
			
			//System.out.println(new Pitch('C').toMidiNote());
	        player.addNote(new Pitch('C').toMidiNote(), 0, 12);
	        player.addNote(new Pitch('C').toMidiNote(), 12, 12);
	        player.addNote(new Pitch('C').toMidiNote(), 24, 9);
	        player.addNote(new Pitch('D').toMidiNote(), 33, 3);
	        player.addNote(new Pitch('E').toMidiNote(), 36, 12);
	        	
	        // E3/4 D/4 E3/4 F/4 G2 
	        player.addNote(new Pitch('E').toMidiNote(), 48, 9);
	        player.addNote(new Pitch('D').toMidiNote(), 57, 3);
	        player.addNote(new Pitch('E').toMidiNote(), 60, 9);
	        player.addNote(new Pitch('F').toMidiNote(), 69, 3);
	        player.addNote(new Pitch('G').toMidiNote(), 72, 24);
	        
	        // (3c/2c/2c/2 (3G/2G/2G/2 (3E/2E/2E/2 (3C/2C/2C/2 
	        player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 96, 4);
	        player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 100, 4);
	        player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 104, 4);
	        player.addNote(new Pitch('G').toMidiNote(), 108, 4);
	        player.addNote(new Pitch('G').toMidiNote(), 112, 4);
	        player.addNote(new Pitch('G').toMidiNote(), 116, 4);
	        player.addNote(new Pitch('E').toMidiNote(), 120, 4);
	        player.addNote(new Pitch('E').toMidiNote(), 124, 4);
	        player.addNote(new Pitch('E').toMidiNote(), 128, 4);
	        player.addNote(new Pitch('C').toMidiNote(), 132, 4);
	        player.addNote(new Pitch('C').toMidiNote(), 136, 4);
	        player.addNote(new Pitch('C').toMidiNote(), 140, 4);
	        
	        // G3/4 F/4 E3/4 D/4 C2 
	        player.addNote(new Pitch('G').toMidiNote(), 144, 9);
	        player.addNote(new Pitch('F').toMidiNote(), 153, 3);
	        player.addNote(new Pitch('E').toMidiNote(), 156, 9);
	        player.addNote(new Pitch('D').toMidiNote(), 165, 3);
	        player.addNote(new Pitch('C').toMidiNote(), 168, 24);

	        player.play();
	         
	       
		} catch (MidiUnavailableException e) {
            fail(e.toString());
        } catch (InvalidMidiDataException e) {
            fail(e.toString());
        }
	}
	
	@Test
    public static void testPlay_Piece2() {
        SequencePlayer player;
        try {
            
            player = new SequencePlayer(200, 12);
            
            // [^F/2e/2] [^F/2e/2] 
            player.addNote(new Pitch('F').transpose(1).toMidiNote(), 0, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 0, 6);
            player.addNote(new Pitch('F').toMidiNote(), 6, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 6, 6);
            
            // z/2 
            
            // [^F/2e/2] 
            player.addNote(new Pitch('F').toMidiNote(), 18, 6);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 18, 6);
            
            // z/2 
            
            // [^F/2c/2] [^Fe] 
            player.addNote(new Pitch('F').toMidiNote(), 30, 6);
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 30, 6);
            player.addNote(new Pitch('F').toMidiNote(), 36, 12);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 36, 12);
            
            // [GBg]              
            player.addNote(new Pitch('G').toMidiNote(), 48, 12);
            player.addNote(new Pitch('B').toMidiNote(), 48, 12);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(), 48, 12);
            
            // z 
            
            //G 
            player.addNote(new Pitch('G').toMidiNote(), 72, 12);
            
            // z
            
            // c3/8 G/2             
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 96, 18);          
            player.addNote(new Pitch('G').toMidiNote(), 114, 6);
            
            //z 
            
            // E 
            player.addNote(new Pitch('E').toMidiNote(), 132, 12);
                  
            // E/2 A B _B/2 A 
            player.addNote(new Pitch('E').toMidiNote(), 144, 6);
            player.addNote(new Pitch('A').toMidiNote(), 150, 12);
            player.addNote(new Pitch('B').toMidiNote(), 162, 12);
            player.addNote(new Pitch('B').transpose(-1).toMidiNote(), 174, 6);
            player.addNote(new Pitch('A').toMidiNote(), 180, 12);
                       
            // (3Geg a f/2 g/2 
            player.addNote(new Pitch('G').toMidiNote(), 192, 8);
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 200, 8);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(), 208, 8);
            player.addNote(new Pitch('A').transpose(Pitch.OCTAVE).toMidiNote(), 216, 12);
            player.addNote(new Pitch('F').transpose(Pitch.OCTAVE).toMidiNote(), 228, 6);
            player.addNote(new Pitch('G').transpose(Pitch.OCTAVE).toMidiNote(), 234, 6);
            
            // z/2 
            
            // e c/2 d/2 B3/4 
            player.addNote(new Pitch('E').transpose(Pitch.OCTAVE).toMidiNote(), 246, 12);
            player.addNote(new Pitch('C').transpose(Pitch.OCTAVE).toMidiNote(), 258, 6);
            player.addNote(new Pitch('D').transpose(Pitch.OCTAVE).toMidiNote(), 264, 6);
            player.addNote(new Pitch('B').toMidiNote(), 270, 9);           
  
            player.play();
            
        } catch (MidiUnavailableException e) {
            fail(e.toString());
        } catch (InvalidMidiDataException e) {
            fail(e.toString());
        }
    }
}
	

	//public void PlayMe(ABCMusic music) {
		
		//System.out.println("Let's quickly print the details of our abc piece.");
		/*System.out.println("Composer: " + music.getComposer());
		System.out.println("Index: " + music.getIndex());
		System.out.println("Key: " + music.getKey());
		System.out.println("Tempo: " + music.getTempo());
		System.out.println("Title: " + music.getTitle());		
		System.out.println("Length: " + music.getLength().getNumerator() + "/" + music.getLength().getDenominator());
		System.out.println("Meter: " + music.getMeter());
		System.out.println("Notes: " + music.getNotes());*/
		
		//for(String note:music.getNotes())
		//{
			//System.out.println(note);
		//}
		//System.out.println(music.getSequences().size());
		//for(Sequence s:music.getSequences())
		//{
			//System.out.println(s.getPitch());
		//}
		//System.out.println("................");
		
		
	//}
	
