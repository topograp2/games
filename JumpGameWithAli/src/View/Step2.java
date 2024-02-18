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

public class Step2 extends Step1 {
	//레벨2에서는 장애물을 생성해서 난이도를 높였습니다.
	ArrayList<JLabel> bars;
	
	Step2(){
		//기존의 step1을 재활용하기 위해 상속받고 생성자도 그대로 불러왔습니다.
		super();
		//레벨2로 넘어갔다는 표시를 하기 위해서 변경했습니다.
		level =2;
		setTitle("Level 2");
		//장애물을 어레이리스트로 만들어주었습니다.
		bars = new ArrayList<>();
		for(int i = 0; i <3; i++) {
			JLabel bar = new JLabel();
			
			bars.add(bar);
		}
		//장애물의 크기와 위치를 설정하고 패널에 부착합니다.
		for(int i= 0; i<bars.size(); i++) {
			bars.get(i).setBounds(80+i*20, 130+i*50, 100, 30);
			contentPane.add(bars.get(i));
		}
		//장애물에 닿으면 유저가 움직이는 않는 설정이기 때문에 리셋버튼이 필요했습니다
		//리셋버튼을 누르면 다시 step2가 켜지도록 했습니다.
		JButton resetBtn = new JButton("reset");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				new Step2();
			}
		});
		//reset버튼을 기존 버튼패널에 부착했습니다.
		southPanel.add(resetBtn);
		//레벨2에 해당하는 안내를 해줍니다.
		explain.setText("<html> Hint : 보이지 않는 장애물을 피해 포탈로 이동하세요!<br> 장애물에 닿으면 외계인은 굳어버려요!</html>");
		//이전과는 다른 부분이 있기에 새 키리스너를 부착했습니다.
		contentPane.addKeyListener(new Moveuser2());
		
		
	}
	//장애물과 닿으면 false, 아니면 true를 리턴하는 함수입니다.
	boolean canMove(int x, int y) {
		 for (JLabel bar : bars) {
              if (isLabelOverlapping(userLabel, bar)) {
            	  
                  return false;
              }
          }
		 
		 
          return true;
		
}
	//여기서는 기존의 무브유저를 이용하되 새부분을 추가할 수 있게 상속 받았습니다.
	class Moveuser2 extends MoveUser{
		public void keyPressed(KeyEvent e) {
			
			int x= userLabel.getX();
			int y= userLabel.getY();
			//변경된 부분인데, 엔터를 누르면 현재창을 종료하고 레벨3으로 넘어갑니다.
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if( isLabelOverlapping(userLabel, portalLabel) )
				{
					dispose();
					new Step3();
				}
			}
			//장애물이 없을 때만 이동할 수 있게 했습니다.
			if(canMove(x, y))
				super.keyPressed(e);
			
				
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Step2();

	}

}
