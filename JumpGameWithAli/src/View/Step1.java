package View;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class Step1 extends JFrame{
	public JLabel explain;
	public JLabel userLabel;
	public ArrayList<ImageIcon> user;
	public JPanel contentPane;
	public JLabel portalLabel;
	public Clip bgmClip;
	public Clip trainEffect;
	public JPanel southPanel;
	public int level;
	boolean BGMstart = false;
	
	Step1(){
		setSize(400, 600);
		//창을 띄우면 자동으로 비지엠이 출력되도록 했습니다.
		this.playBGM();
		//레벨을 지정했습니다. 이로써 뒤에 있는 화면 넘어가기에서 각각을 구분을 할 수 있게 됩니다.
		level = 1;
		//자주 쓰이는 컬러를 미리 만들어두었습니다.
		Color deepGreen = new Color(39, 112, 58);
		Color paleGreen = new Color(210, 252, 221);
		
		//방향키로 움직일 유저 라벨을 만들어줍니다.
		//메뉴에서 유저 라벨의 이미지를 변경할 수 있도록
		//arrayList을 활용해봤습니다.
		user = new ArrayList<>();
		for(int i = 0; i<3; i++) {
			//총 3개의 이미지가 있어 이를 불러왔습니다.
			ImageIcon userImg = new ImageIcon("Image/alienImg"+i+".png");
			Image img = userImg.getImage();
			//이미지 조절이 필요해서 getScaledInstance를 이용해서 조절해주었습니다.
			img = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
			userImg = new ImageIcon(img);
			//유저 라벨에 이미지를 넣어주었습니다.
			user.add(userImg);
		}
		//borderlayout을 지정했습니다.
		setLayout(new BorderLayout());
		//3개의 panel을 만들어서 구역을 구분해줍니다.
		JPanel northPanel = new JPanel();
		//첫번째 라벨에는 이 레벨에 해당하는 안내를 해주었습니다.
		explain = new JLabel("Hint: 포탈로 이동해서 엔터키를 누르세요~");
		explain.setFont(new Font("", Font.BOLD, 12));
		explain.setForeground(Color.white);
		northPanel.add(explain);
		
		northPanel.setBackground(deepGreen);
		//첫번째 패널을 북쪽에 부착합니디ㅏ.
		add(northPanel, BorderLayout.NORTH);
		//유저 라벨이 움직일 가장 중요한 컨텐트페인을 만들어주었습니다.
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);
		//이 패널은 가장 센터에 부착했습니다!
		add(contentPane, BorderLayout.CENTER);
		//방향키로 움직일 유저 라벨을 만들었습니다.
		//현재는 가장 기본이 되는 이미지로 라벨을 꾸며놓았습니다.
		userLabel = new JLabel(user.get(0));
		//유저라벨의 초기 위치를 지정해주고 컨텐트패널에 놓아주었습니다.
		userLabel.setBounds(50, 50, 50, 50);
		contentPane.add(userLabel);
		//버튼을 놓을 마지막 패널을 생성해줍니다.
		southPanel = new JPanel();
		southPanel.setBackground(deepGreen);
		//센터의 패널에서 유저가 움직여야 하므로
		//포커스를 컨텐트페인에 두었습니다.
		contentPane.setFocusable(true);
		//방향키로 유저라벨이 움직일 수 있게 키리스터를 부착했습니다
		contentPane.addKeyListener(new MoveUser());
		//포탈 이미지를 불러와서 라벨에 부착하고 컨텐트 페인에 놓았습니다.
		ImageIcon portalImg = new ImageIcon("Image/portalImg.png");
		Image porImg = portalImg.getImage();
		porImg = porImg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		portalImg = new ImageIcon(porImg);
		portalLabel = new JLabel(portalImg);
		portalLabel.setBounds(100, 400, 50, 50);
		contentPane.add(portalLabel);
		//비지엠을 재생하는 버튼을 만들었습니다.
		JButton bgmOnBtn = new JButton("bgm on");
		bgmOnBtn.setBackground(paleGreen);
		//비지엠을 끄는 버튼을 만들었습니다.
		JButton bgmOffBtn = new JButton("bgm off");
		//비교적 간단한 부분이라 익명클래스를 이용해 키리스너를 부착했습니다.
		bgmOnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//비지엠 재생버튼을 누르면 유저라벨이 안 움직여서
				//포커스를 조절해주었습니다.
				bgmOnBtn.setFocusable(false);
				bgmOffBtn.setFocusable(false);
				//다시 음악을 켜줍니다.
				if(!BGMstart)
				playBGM();
			}
		});
		
		//마찬가지로 익명클래스를 이용해서 부착합니다.
		bgmOffBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bgmOnBtn.setFocusable(false);
				bgmOffBtn.setFocusable(false);
				//음악을 끄는 함수를 넣었습니다.
				
					stopBGM();
			}
		});
		//버튼 색을 꾸몄습니다.
		bgmOffBtn.setBackground(paleGreen);
		//가장 아래 패널에 버튼 2개를 넣었습니다.
		southPanel.add(bgmOnBtn);
		southPanel.add(bgmOffBtn);
		add(southPanel, BorderLayout.SOUTH);
		
		setTitle("Level  1");
		//메뉴를 부착합니다.
		createMenu();
		 setLocationRelativeTo(null);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		setVisible(true);
	}
	//가장 윗부분에 메뉴를 보여주는 함수입니다.
	public void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		MenuAction act = new MenuAction();
		menuBar.setBackground(Color.pink);
		//메뉴창에서 아이콘을 누르면 유저 라벨의 이미지를 변경할 수 있게 했습니다.
		JMenu iconMenu = new JMenu("아이콘");
		JMenuItem[] userItems = new JMenuItem[user.size()];
		for(int i = 0; i<user.size(); i++) {
			userItems[i] = new JMenuItem("테마"+i);
			userItems[i].addActionListener(act);
			iconMenu.add(userItems[i]);
			//구분선을 넣어주었습니다.
			iconMenu.addSeparator();
		}
		//배경색을 바꿀 수 있는 메뉴를 생성했습니다.
		JMenu backMenu = new JMenu("배경");
		
		String[] items = {"기본", "검정", "녹색"};
		JMenuItem[] bmenuItems = new JMenuItem[3];
		for(int i = 0; i<items.length; i++) {
			bmenuItems[i] = new JMenuItem(items[i]);
			bmenuItems[i].addActionListener(act);
			backMenu.add(bmenuItems[i]);
			backMenu.addSeparator();
		}
		//메뉴바에 두개의 메뉴를 부착했습니다.
		menuBar.add(iconMenu);
		menuBar.add(backMenu);
		setJMenuBar(menuBar);
	}
	//메뉴를 누르면 각각의 기능을 구현할 수 있게 해줍니다.
	
	class MenuAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String command = e.getActionCommand();
			
			switch(command) {
			//배경에서 기본을 누르면 배경색이 하얀색이 됩니다.
			case "기본":
				if(contentPane.getBackground() != Color.white)
					contentPane.setBackground(Color.white);
				break;
				//배경에서 검정을 누르면 배경색이 검은색이 됩니다.
			case "검정":
				if(contentPane.getBackground() != Color.black)
					contentPane.setBackground(Color.black);
				break;
				//배경에서 녹색을 누르면 배경색이 녹색이 됩니다.
			case "녹색":
				if(contentPane.getBackground() != Color.green)
					contentPane.setBackground(Color.green);
				break;
			//유저라벨을 다른 이미지로 변경할 수 있게 했습니다!
			case "테마0":
				userLabel.setIcon(user.get(0));
				break;
			case "테마1":
				userLabel.setIcon(user.get(1));
				break;
			case "테마2":
				userLabel.setIcon(user.get(2));
				break;
			
			}
					
			
			}
			
		
	}
	
	//움직일 수 있는 위치인지 판단해주는 함수입니다.
	//여기선 장애물이 없어 true로 리턴해줍니다.
	
	boolean canMove(int x, int y) {
		return true;
	}
	
	//유저라벨을 방향키로 움직일 수 있게 하는 내부클래스입니다.
	class MoveUser extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			//현재 유저라벨의 위치를 알아냅니다.
			int x = userLabel.getX();
			int y = userLabel.getY();
			//방향키를 누를 때마다 변경할 값을 미리 지정합니다.
			int moveNum = 5;
			//각각의 방향키를 누를때마다 유저라벨의 위치를 변경해줍니다.
			if(canMove(0, 0)) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				userLabel.setLocation(x, Math.max(y - moveNum, 0));
                break;
            case KeyEvent.VK_DOWN:
                userLabel.setLocation(x, Math.min(y + moveNum, getHeight() - userLabel.getHeight()));
                break;
            case KeyEvent.VK_LEFT:
                userLabel.setLocation(Math.max(x - moveNum, 0), y);
                break;
            case KeyEvent.VK_RIGHT:
                userLabel.setLocation(Math.min(x + moveNum, getWidth() - userLabel.getWidth()), y);
                break;
            //포탈 위에서 엔터를 누르면 다음 레벨로 넘어갑니다.
            case KeyEvent.VK_ENTER:
            	if( level ==1 &&isLabelOverlapping(userLabel, portalLabel) ) {
            		JOptionPane.showConfirmDialog(null, "성공", "다음 레벨로 이동합니다!", JOptionPane.PLAIN_MESSAGE);
            		new Step2();
            		dispose();
            		
            		
            	}
			}
			
			
			}
		}
	}
	//포탈에 유저 라벨이 올라가있는지 판단하기 위한 함수를 만들었습니다.
	boolean isLabelOverlapping(JLabel label1, JLabel label2) {
        int x1 = label1.getX();
        int y1 = label1.getY();
        int width1 = label1.getWidth();
        int height1 = label1.getHeight();

        int x2 = label2.getX();
        int y2 = label2.getY();
        int width2 = label2.getWidth();
        int height2 = label2.getHeight();

        return x1 < x2 + width2 && x1 + width1 > x2 && y1 < y2 + height2 && y1 + height1 > y2;
    }
	
	//오디오스트림을 활용해서 bgm을 트는 함수입ㄴ다.
	public void playBGM() {
	    try {
	        // 파일을 불러와줍니다.
	        AudioInputStream audioStream = 
	       AudioSystem.getAudioInputStream(getClass().getResource("/Music/love3.wav"));

	        // 오디오 재생을 위한 클립을 만듭니다.
	        bgmClip = AudioSystem.getClip();
	        bgmClip.open(audioStream);

	        // 무한으로 재생되게 합니다.
	        bgmClip.loop(Clip.LOOP_CONTINUOUSLY);

	        // 이제 진짜로 재생되게 합니다.
	        BGMstart = true;
	        bgmClip.start();
	    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
	        e.printStackTrace();
	    }
	}
	
	//비지엠을 종료하는 함수입니다.
	public void stopBGM() {
	    if (bgmClip != null && bgmClip.isRunning()) {
	    	BGMstart = false;
	        bgmClip.stop();
	        bgmClip.close();
	    }
	}
	//창을 종료할때 기존의 비지엠도 종료해야하므로 이렇게 오버라이딩 시켜주었습니다.
	public void dispose() {
		stopBGM();
		super.dispose();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Step1();
	}

}
