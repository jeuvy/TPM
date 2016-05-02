import java.util.Arrays;
import javax.sound.midi.*;
public class MusicBox {
  static Synthesizer synthesizer;
  static MidiChannel[] channels;
  static boolean noSound = false;

  public static void initialize() {
    try {
      if (!noSound) {
        synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();

        channels = synthesizer.getChannels();

        Instrument[] instr = synthesizer.getDefaultSoundbank()
          .getInstruments();
        synthesizer.loadInstrument(instr[0]);
        System.out.println(channels.length);
      }
    }
    catch (Exception ex) {
      System.out.println("Could not load the MIDI synthesizer.");
    }
  }

  public static void cleanUp() {
    if (synthesizer != null)
      synthesizer.close();
  }

  public static void playNote(final int note, final int milliseconds) {
    System.out.println("<MusicBox: playNote(" + note + ", " + milliseconds +
      ")>");

    Thread t = new Thread() {
      public void run() {
        try {
          if (!noSound && channels != null && channels.length > 0) {
            channels[0].noteOn(note, 120);
            sleep(milliseconds);
            channels[0].noteOff(note);
          }
        } 
        catch (Exception ex) {
          System.out.println("ERROR: " + ex);
        }
      }
    };
    t.start();
  }

  public static void playChord(int note1, int note2, int note3, int milliseconds) {
    playChord(new int[] {note1, note2, note3}, milliseconds); 
  }
  
  public static void playChord(final int[] notes, final int milliseconds) {
    System.out.println("<MusicBox: playChord(" + Arrays.toString(notes) +
      ", " + milliseconds + ")>");

    Thread t = new Thread() {
      public void run() {
        try {
          if (!noSound && channels != null && channels.length > 0) {
            int channel = 0;
            for (int n : notes) {
              channels[channel++].noteOn(n, 120);
            }
            sleep(milliseconds);
            for (channel = 0; channel < notes.length; channel++) {
              channels[channel].noteOff(notes[channel]);
            }
          }
        }
        catch (Exception ex) {
          System.out.println("ERROR:" + ex);
        }
      }
    };
    t.start();
  }
  
  public static void playScale(int note1, int note2, int note3, int note4, int note5,
    int note6, int note7, int note8, int milliseconds) {
    playScale(new int[] {note1, note2, note3, note4, note5, note6, note7, note8}, milliseconds);      
  }

  public static void playScale(final int[] notes, final int milliseconds) {
    Thread t = new Thread() {
      public void run() {
        try {
          if (!noSound && channels != null && channels.length > 0) {
            for (int n : notes) {
              channels[0].noteOn(n, 120);
              sleep(milliseconds);
              channels[0].noteOff(n);
            }
          }
        }
        catch (Exception ex) {
          System.out.println("ERROR:" + ex);
        }
      }
    };
    t.start();
  }

  private static void sleep(int length) {
    try {
      Thread.sleep(length);
    }
    catch (Exception ex) {
    }
  }
}