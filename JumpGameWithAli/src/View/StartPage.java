package View;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class StartPage extends JFrame{
	//처음 시작하는 인트로 부분입니다.
	
	StartPage(){
		setTitle("외계인 집 보내기 게임"); //창 제목을 설정
		JLabel title = new JLabel("Plz Go to Home, Alien!"); //영어 제목 안내
		title.setForeground(Color.red); //영어 제목의 색상 지정
		//게임의 첫 화면을 꾸미기 위해서 이미지를 가져왔습니다.
		ImageIcon titleImage = new ImageIcon("Image/title.png");
		JLabel titleLogo = new JLabel(titleImage);
		//버튼을 넣을 패널을 만들고 레이아웃은 그리드로 해주었습니다.
		JPanel buttonSet = new JPanel(new GridLayout());
		//이 게임을 어떻게 해야하는지 알려주는 버튼을 만들었습니다.
		JButton explainBtn = new JButton("이 게임이 뭐예요...");
		//버튼을 꾸몄습니다.
		explainBtn.setForeground(Color.red);
		explainBtn.setBackground(Color.black);
		//안내 버튼을 누르면 게임을 안내하는 창인 gameIntro가 나오도록 했습니다.
		explainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new GameIntro();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//게임을 시작하는 버튼을 만들고 이 버튼을 누르면 Step1이 나오고
		//현재 화면은 없어지도록 만들었습니다.
		JButton startBtn = new JButton("START");
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Step1();
			}
		});
		//게임을 시작하는 버튼을 만들었습니다.
		startBtn.setBackground(Color.blue);
		startBtn.setForeground(Color.red);
		//버튼을 넣을 패널에 두개의 버튼을 넣어주었습니다.
		buttonSet.add(startBtn);
		buttonSet.add(explainBtn);
		setSize(800, 600);
		//프레임에 영어제목과 게임이미지, 위에서 만든 버튼 패널을 부착해주었습니다.
		add(title, "North");
		add(titleLogo, "Center");
		add(buttonSet, "South");
		setVisible(true); 
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StartPage();

	}

}
