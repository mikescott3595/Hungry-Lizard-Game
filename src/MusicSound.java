import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicSound
{
	private Clip clip;

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

	public void stop() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
			clip.close();
		}
	}
}
