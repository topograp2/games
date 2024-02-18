package View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class LastPage extends JFrame{
	
	LastPage(){
		setSize(500, 500);
		this.setLayout(new BorderLayout());
		//종료를 안내하는 문구를 나타내는 부분을 만들었습니다.
		JPanel firstPanel = new JPanel();
		add(firstPanel, "North");
		JLabel mess = new JLabel("<html>축하합니다! 외계인이 이제 집을 찾아<br>가족들과 즐거운 크리스마스를 보낼 수 있어요^^</html>");
		mess.setForeground(new Color(39, 29, 19));
		mess.setFont(new Font("궁서", Font.BOLD, 20));
		firstPanel.add(mess);
		//기쁨의 눈물을 흘리는 외계인 그림을 넣어주었습니다.
		JPanel secondPanel = new JPanel();
		ImageIcon lastImg = new ImageIcon("Image/bye.png");
		
		JLabel byeLabel = new JLabel(lastImg);
		secondPanel.add(byeLabel);
		//버튼을 부착할 수 있게 패널을 만들었습니다.
		JPanel lastPanel = new JPanel();
		JButton reBtn = new JButton("다시하기");
		//버튼을 누르면 다시 게임을 시작할 수 있습니다.
		reBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StartPage();
			}
			
		});
		lastPanel.add(reBtn);
		
		add(secondPanel, "Center");
		add(lastPanel, "South");
		setVisible(true);
		}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LastPage();
	}

}
