package View;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.*;

import View.Step1.MoveUser;
import View.Step2.Moveuser2;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


public class Step3 extends Step1{
	//타이머를 이용해서 포탈이 움직이게 해줍니다.
	Timer portalTimer;
	
	Step3(){
		//스텝1을 재활용합니다.
		super();
		level = 3;
		//레벨3에 맞는 타이틀, 안내문을 변경합니다.
		setTitle("Level 3");
		explain.setText("Hint: 이제는 움직이는 포탈로 들어가야 해요~");
		//포털이 움직일 수 있게 액션리스너를 부착합니다.
		portalTimer = new Timer(100, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movePortal();
			}
		});
		portalTimer.start();
		//기존과 달라진 부분이 있어서 새 키리스너 부착
		contentPane.addKeyListener(new MoveUser3());
	}
	//포털을 움직이는 함수입니다.
	public void movePortal() {
		int speed = 7;
		int x = portalLabel.getX();
		int y = portalLabel.getY();
		//오른쪽으로 움직이도록 했습니다.
		x += speed;
		//화면에서 포털이 벗어나면 안되니까 포털이 화면 내에 있도록 지정했습니다.
		if(x >getWidth()) {
			x = -portalLabel.getWidth();
		}
		portalLabel.setLocation(x, y);
	}
	
	
	class MoveUser3 extends MoveUser{
		public void keyPressed(KeyEvent e) {
			int x= userLabel.getX();
			int y= userLabel.getY();
			//포털에서 엔터를 누르면 최종 창으로 넘어가게 했습니다.
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if( isLabelOverlapping(userLabel, portalLabel) )
				{
					dispose();
					new LastPage();
				}
			}
			super.keyPressed(e);
			}
		}

	public static void main(String [] args) {
		new Step3();
	}
}
