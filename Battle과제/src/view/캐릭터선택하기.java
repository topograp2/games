package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import breadBarber.Player;
import breadBarber.bread;
import breadBarber.choco;
import breadBarber.wilk;
import breadBarber.sosi;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class 캐릭터선택하기 extends JFrame {

	public Player p1, p2;
	private Clip bgmClip;

	
	private JPanel contentPane;
	private JLabel breadImage;
	private JLabel titleText;
	private JLabel breadText;
	private JButton btn1;
	private JLabel chocoImage;
	private JLabel chocoText;
	private JButton btn2;
	private JLabel sosiImage;
	private JLabel sosiText;
	private JButton btn3;
	private JLabel wilkImage;
	private JLabel wilkText;
	private JButton btn4;
	private JLabel playerCau;
	private JPanel panel;
	private JButton startBtn;
	private JLabel back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					캐릭터선택하기 frame = new 캐릭터선택하기();
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
	public 캐릭터선택하기() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//배경넣기 시작
		Image m1 = new ImageIcon(this.getClass().getResource("/images/이발소.jpg")).getImage();
		Image m2 = m1.getScaledInstance(this.getSize().width, this.getSize().height, Image.SCALE_SMOOTH);
		ImageIcon m3 = new ImageIcon(m2);
		
		ImageIcon bread = new ImageIcon(this.getClass().getResource("/images/bread.jpg"));
		
		btn1 = new JButton("선택하기");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(p1 == null)
				{
					p1 = new bread();
					breadImage.setIcon(bread);
					btn1.setText("p1");
				}
				else if( p2 == null)
				{
					p2 = new bread();
					breadImage.setIcon(bread);
					btn1.setText("p2");
				}
				else
				{
					playerCau.setText("더 이상 선택할 수 없습니다.");
				}

				
			}
		});
		btn1.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		btn1.setBounds(117, 542, 145, 42);
		contentPane.add(btn1);
		
		breadImage = new JLabel("New label");
		ImageIcon deadbread = new ImageIcon(this.getClass().getResource("/images/deadbread.jpg"));
		breadImage.setIcon(deadbread);
		breadImage.setBounds(83, 257, 211, 229);
		contentPane.add(breadImage);
		
		chocoImage = new JLabel("New label");
		ImageIcon deadchoco = new ImageIcon(this.getClass().getResource("/images/deadchoco.jpg"));
		chocoImage.setIcon(deadchoco);
		chocoImage.setBounds(325, 257, 204, 229);
		contentPane.add(chocoImage);
		
		ImageIcon choco = new ImageIcon(this.getClass().getResource("/images/choco.jpg"));
		
		
		btn2 = new JButton("선택하기");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p1 == null)
				{
					p1 = new choco();
					chocoImage.setIcon(choco);
					btn2.setText("p1");
				}
				else if( p2 == null)
				{
					p2 = new choco();
					chocoImage.setIcon(choco);
					btn2.setText("p2");
				}
				else
				{
					playerCau.setText("더 이상 선택할 수 없습니다.");
				}
			}
		});
	
		btn2.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		btn2.setBounds(354, 542, 145, 42);
		contentPane.add(btn2);
		
		ImageIcon sosi = new ImageIcon(this.getClass().getResource("/images/sausi.jpg"));
		
		sosiImage = new JLabel("New label");
		ImageIcon deadsosi = new ImageIcon(this.getClass().getResource("/images/deadsausi.jpg"));
		sosiImage.setIcon(deadsosi);
		sosiImage.setBounds(581, 257, 211, 229);
		contentPane.add(sosiImage);
		
		btn3 = new JButton("선택하기");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p1 == null)
				{
					p1 = new sosi();
					sosiImage.setIcon(sosi);
					btn3.setText("p1");
				}
				else if( p2 == null)
				{
					p2 = new sosi();
					sosiImage.setIcon(sosi);
					btn3.setText("p2");
				}
				else
				{
					playerCau.setText("더 이상 선택할 수 없습니다.");
				}
			}
		});
		btn3.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		btn3.setBounds(626, 542, 145, 42);
		contentPane.add(btn3);
		
		
		ImageIcon wilk = new ImageIcon(this.getClass().getResource("/images/wilk.jpg"));
		wilkImage = new JLabel("New label");
		ImageIcon deadwilk = new ImageIcon(this.getClass().getResource("/images/deadwilk.jpg"));
		wilkImage.setIcon(deadwilk);
		wilkImage.setBounds(855, 257, 211, 229);
		contentPane.add(wilkImage);
		
		btn4 = new JButton("선택하기");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(p1 == null)
				{
					p1 = new wilk();
					wilkImage.setIcon(wilk);
					btn4.setText("p1");
				}
				else if( p1 != null && p2 == null)
				{
					p2 = new wilk();
					wilkImage.setIcon(wilk);
					btn4.setText("p2");
				}
				else
				{
					playerCau.setText("더 이상 선택할 수 없습니다.");
				}
			}
				
		});
		btn4.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		btn4.setBounds(879, 542, 145, 42);
		contentPane.add(btn4);
		
		breadText = new JLabel("Bread\r\n");
		breadText.setForeground(new Color(255, 255, 255));
		breadText.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		breadText.setBounds(159, 496, 85, 42);
		contentPane.add(breadText);
		
		chocoText = new JLabel("Choco");
		chocoText.setForeground(new Color(255, 255, 255));
		chocoText.setBackground(new Color(240, 240, 240));
		chocoText.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		chocoText.setBounds(396, 496, 85, 42);
		contentPane.add(chocoText);
		
		sosiText = new JLabel("소시지");
		sosiText.setForeground(new Color(255, 255, 255));
		sosiText.setFont(new Font("HY견고딕", Font.PLAIN, 21));
		sosiText.setBounds(664, 490, 85, 42);
		contentPane.add(sosiText);
		
		wilkText = new JLabel("Wilk");
		wilkText.setForeground(new Color(255, 255, 255));
		wilkText.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		wilkText.setBounds(925, 490, 70, 42);
		contentPane.add(wilkText);
		
		panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(83, 38, 688, 105);
		contentPane.add(panel);
		
		titleText = new JLabel("브래드 이발소 게임\r\n\r\n캐릭터 선택하기");
		panel.add(titleText);
		titleText.setHorizontalAlignment(SwingConstants.CENTER);
		titleText.setBackground(new Color(255, 255, 255));
		titleText.setForeground(new Color(30, 144, 255));
		titleText.setFont(new Font("HY견고딕", Font.BOLD, 41));
		
		playerCau = new JLabel("두 캐릭터를 선택 후 start를 누르면 게임시작!");
		panel.add(playerCau);
		playerCau.setBackground(new Color(255, 255, 255));
		playerCau.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		
		startBtn = new JButton("start!");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(p1 != null && p2 != null)
				{
					dispose();
					new view(p1, p2);
				}
			}
		});
		startBtn.setBackground(new Color(0, 255, 127));
		startBtn.setForeground(new Color(0, 139, 139));
		startBtn.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		startBtn.setBounds(330, 153, 169, 81);
		contentPane.add(startBtn);
		
		
		ImageIcon bread_back = new ImageIcon(this.getClass().getResource("/images/이발소.jpg"));
		back = new JLabel("New label");
		back.setIcon(bread_back);
		back.setBounds(0, 0, 1115, 628);
		contentPane.add(back);
		
		JLabel bg = new JLabel("");
		bg.setBounds(-42, 0, 1185, 584);
		bg.setIcon(m3);
		
		playBGM();
		
		this.setTitle("브래드 이발소 battle : 캐릭터를 선택하세용");
		this.setVisible(true);
	}
	
	private void playBGM() {
	    try {
	        // Load the audio file
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource("/music/love3.wav"));

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
