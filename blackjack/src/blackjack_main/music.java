package blackjack_main;

//import java.awt.*;
//import java.awt.event.*;
import java.io.*;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
//import javax.swing.*;

public class music {

	public void bgm() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;

		bgm = new File("C:\\Users\\김경준\\Downloads\\bgm\\black_jack_bgm.wav");

		Clip clip;

		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();

		} catch (Exception e) {
			System.out.println("err : " + e);
		}

	}

}
