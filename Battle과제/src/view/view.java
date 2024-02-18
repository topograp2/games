package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import breadBarber.*;

public class view extends JFrame {
	
	public Player p1, p2;
	private Clip bgmClip;
	private Clip trainEffect;
	
	private JPanel contentPane;
	private JLabel playerName;
	private JLabel weapon1;
	private JLabel breadIma;
	private JProgressBar hpBar1;
	private JProgressBar powerBar1;
	private JTextArea textArea;
	private JLabel wilkIma;
	private JLabel playerName2;
	private JLabel weapon2;
	private JProgressBar hpBar2;
	private JProgressBar powerBar2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view frame = new view();
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
	public view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 28, 363, 574);
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		breadIma = new JLabel("");
		breadIma.setIcon(new ImageIcon(getClass().getResource("/images/bread.jpg")));
		breadIma.setBounds(75, 0, 210, 220);
		panel.add(breadIma);
		
		JButton attackBtn1 = new JButton("공격하기");
		attackBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionAttack(p1, p2, hpBar2);
			}
		});
		attackBtn1.setForeground(new Color(255, 255, 255));
		attackBtn1.setBackground(new Color(0, 128, 255));
		attackBtn1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		attackBtn1.setBounds(12, 291, 166, 65);
		panel.add(attackBtn1);
		
		JButton trainBtn1 = new JButton("훈련하기");
		trainBtn1.setBackground(new Color(0, 128, 255));
		trainBtn1.setForeground(new Color(255, 255, 255));
		trainBtn1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		trainBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playTrainEffect();
				actionTrain(p1, powerBar1);
			}
		});
		trainBtn1.setBounds(185, 291, 166, 65);
		panel.add(trainBtn1);
		
		JButton selectBtn1 = new JButton("무기 바꾸기");
		selectBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSelectWp(weapon1, p1);
			}
		});
		selectBtn1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		selectBtn1.setBounds(12, 369, 339, 65);
		panel.add(selectBtn1);
		
		hpBar1 = new JProgressBar();
		hpBar1.setForeground(new Color(0, 128, 255));
		hpBar1.setValue(90);
		hpBar1.setBounds(12, 467, 339, 26);
		panel.add(hpBar1);
		
		powerBar1 = new JProgressBar();
		powerBar1.setForeground(new Color(0, 128, 255));
		powerBar1.setValue(10);
		powerBar1.setBounds(12, 527, 339, 26);
		panel.add(powerBar1);
		
		JLabel hpText = new JLabel("HP");
		hpText.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		hpText.setBounds(22, 444, 54, 26);
		panel.add(hpText);
		
		JLabel powerText = new JLabel("Power");
		powerText.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		powerText.setBounds(12, 492, 112, 26);
		panel.add(powerText);
		
		playerName = new JLabel("Player1");
		playerName.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		playerName.setBounds(22, 267, 52, 15);
		panel.add(playerName);
		
		weapon1 = new JLabel("weapon1");
		weapon1.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		weapon1.setBounds(211, 266, 100, 15);
		panel.add(weapon1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(683, 28, 363, 574);
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		wilkIma = new JLabel("");
		wilkIma.setIcon(new ImageIcon(getClass().getResource("/images/wilk.jpg")));
		wilkIma.setBounds(78, 0, 208, 225);
		panel_1.add(wilkIma);
		
		JButton attackBtn2 = new JButton("공격하기");
		attackBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionAttack(p2, p1, hpBar1);
		}
		});
		attackBtn2.setForeground(Color.WHITE);
		attackBtn2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		attackBtn2.setBackground(new Color(0, 128, 255));
		attackBtn2.setBounds(12, 282, 166, 65);
		panel_1.add(attackBtn2);
		
		JButton trainBtn2 = new JButton("훈련하기");
		trainBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playTrainEffect();
				actionTrain(p2, powerBar2);
			}
		});
		trainBtn2.setForeground(Color.WHITE);
		trainBtn2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		trainBtn2.setBackground(new Color(0, 128, 255));
		trainBtn2.setBounds(185, 282, 166, 65);
		panel_1.add(trainBtn2);
		
		JButton selectBtn2 = new JButton("무기 바꾸기");
		selectBtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSelectWp(weapon2, p2);
			}
		});
		selectBtn2.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		selectBtn2.setBounds(12, 360, 339, 65);
		panel_1.add(selectBtn2);
		
		hpBar2 = new JProgressBar();
		hpBar2.setValue(100);
		hpBar2.setForeground(new Color(0, 128, 255));
		hpBar2.setBounds(12, 458, 339, 26);
		panel_1.add(hpBar2);
		
		powerBar2 = new JProgressBar();
		powerBar2.setValue(10);
		powerBar2.setForeground(new Color(0, 128, 255));
		powerBar2.setBounds(12, 518, 339, 26);
		panel_1.add(powerBar2);
		
		JLabel hpText2 = new JLabel("HP");
		hpText2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		hpText2.setBounds(12, 435, 54, 26);
		panel_1.add(hpText2);
		
		JLabel powerText2 = new JLabel("Power");
		powerText2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		powerText2.setBounds(12, 482, 112, 26);
		panel_1.add(powerText2);
		
		playerName2 = new JLabel("Player2");
		playerName2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		playerName2.setBounds(51, 256, 52, 15);
		panel_1.add(playerName2);
		
		weapon2 = new JLabel("weapon1");
		weapon2.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		weapon2.setBounds(206, 256, 102, 15);
		panel_1.add(weapon2);
		
		JLabel tileImage = new JLabel("");
		tileImage.setBounds(419, 28, 261, 228);
		tileImage.setIcon(new ImageIcon(getClass().getResource("/images/titleimg.png")));
		contentPane.add(tileImage);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(419, 286, 254, 303);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		playBGM();
		this.setVisible(true);
		
	}
	
	public view(Player p1, Player p2)
	{
		this();
		this.p1 = p1;
		this.p2 = p2;
		
		this.setTitle(p1.name +" vs "+p2.name);
		
		breadIma.setIcon(new ImageIcon(getClass().getResource(p1.img)));
		wilkIma.setIcon(new ImageIcon(getClass().getResource(p2.img)));
		
		this.hpBar1.setValue(p1.getHp());
		this.hpBar2.setValue(p2.getHp());
		
		this.powerBar1.setValue(p1.getPower());
		this.powerBar2.setValue(p2.getPower());
		
		this.playerName.setText(p1.name);
		this.playerName2.setText(p2.name);
		
		this.weapon1.setText(p1.getOwnWeapon().weaponName);
		this.weapon2.setText(p2.getOwnWeapon().weaponName);
		
		this.setVisible(true);
		
	}
	
	public void actionAttack(Player p, Player target, JProgressBar target_bar) {
		
		p.attack(target);
		textArea.append(p.name+"이(가)"+target.name+"을(를)\n");
		textArea.append(p.getOwnWeapon().weaponName+"(으)로 공격합니다.\n");
		textArea.append(target.name+":"+target.getHp()+"\n");
		
		target_bar.setValue(target.getHp());
		//target의 hp가 음수 나올경우 방지
		if(target.getHp()<0)
		{
			target.setHp(0);
		}
		p.showState();
		target.showState();
		
		if(target.getHp()<=0)
		{
			System.out.println(p.name + " win");
			textArea.append(p.name + " win\n");
			this.dispose();
			new WinnerView(p);
		}
	}

	public void actionSelectWp(JLabel weapon1, Player p)
	{
		p.selectWeapon();
		weapon1.setText(p.getOwnWeapon().weaponName);
		textArea.append(p.name+ "의 무기가 바뀌었습니다!\n");
	}

	public void actionTrain(Player p, JProgressBar powerBar)
	{
		p.train();
		powerBar.setValue(p.getPower());
		
		if(p.getPower() >=50)
		{
			textArea.append("헉! power가 50이 넘은 플레이어가 있군요!!");
			
			new AllWinnerView();
			dispose();
		}
		
		textArea.append(p.name+" 훈련 중...\n");
		textArea.append(p.name+":"+p.getPower()+"\n");
		
	}
	
	private void playBGM() {
	    try {
	        // Load the audio file
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource("/music/배틀.wav"));

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
	
	private void playTrainEffect() {
	    try {
	        // 효과음 파일 로드
	        AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource("/music/훈련.wav"));

	        // Clip 생성 및 열기
	        trainEffect = AudioSystem.getClip();
	        trainEffect.open(audioStream);

	        // 효과음 재생
	        trainEffect.start();
	    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	        e.printStackTrace();
	    }
	}

}
