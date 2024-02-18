package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AllWinnerView extends JFrame {

	private JPanel contentPane;
	private Clip bgmClip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllWinnerView frame = new AllWinnerView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AllWinnerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon back = new ImageIcon(this.getClass().getResource("/images/우리모두.png"));
		
		JButton restartBtn = new JButton("restart");
		restartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				new 캐릭터선택하기();
			}
		});
		restartBtn.setBackground(new Color(255, 255, 255));
		restartBtn.setForeground(new Color(0, 128, 255));
		restartBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		restartBtn.setBounds(716, 453, 128, 48);
		contentPane.add(restartBtn);
		
		JLabel AllWinner = new JLabel("New label");
		AllWinner.setIcon(back);
		AllWinner.setBounds(0, 0, 878, 536);
		
		contentPane.add(AllWinner);
		
		this.setTitle("우리 모두가 브래드 이발소의 주인!");
		
		playBGM();
		this.setVisible(true);
		
		
	}
	
	private void playBGM() {
	    try {
	        // Load the audio file
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource("/music/승리.wav"));

	        // Create a Clip to play the audio
	        bgmClip = AudioSystem.getClip();
	        bgmClip.open(audioStream);

	        // Loop the BGM indefinitely
	        bgmClip.loop(Clip.LOOP_CONTINUOUSLY);

	        // Start playing the BGM
	        bgmClip.start();
	    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	        e.printStackTrace();
	    }
	}
	
	
	private void stopBGM() {
	    if (bgmClip != null && bgmClip.isRunning()) {
	        bgmClip.stop();
	        bgmClip.close();
	    }
	}
	
	public void dispose() {
		stopBGM();
		super.dispose();
	}
}
