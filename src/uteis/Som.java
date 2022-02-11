package uteis;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Som {
	
	private Clip clip;
	private AudioInputStream audioIn; 
	
	public void playwav(File wav){
		try{
			audioIn = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(wav)));
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
