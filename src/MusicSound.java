import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Authors:
 * 
 * @author Olivia Tom
 * @author Michael Scott
 * 
 *         References: ChatGPT StackOverflow CISC 190 programming challenges
 * 
 *         Responsibilities of class: Handles background music of the game.
 */
public class MusicSound
{
	// fields
	private Clip clip;

	/*************************************** methods **************************************/
	
	/**
	 * Loops the background audio of the game
	 * @param filePath which file to use
	 */
	public void playLoop(String filePath) {
		try {
			File audioFile = new File("Fushigi Ball Commercial music.wav");
			if (!audioFile.exists()) {
				System.out.println("File not found: " + audioFile.getAbsolutePath());
				return;
			}

			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY); // 🔁 loop forever
			clip.start();

		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stop playing the background music
	 */
	public void stop() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
			clip.close();
		}
	}
}
