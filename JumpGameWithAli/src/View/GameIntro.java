package View;
import java.awt.*;
import javax.swing.*;

import java.io.*;

public class GameIntro extends JFrame {
	String fullexplain;
	GameIntro() throws IOException, FileNotFoundException {
		FileReader fin = new FileReader("Text/GameExplain.txt");
		TextArea text = new TextArea();
		int ch;
		fullexplain ="";
		System.out.println(fullexplain);
		while((ch=fin.read())!=-1) {
			fullexplain += (char)ch;
		}
		fin.close();
		text.setText(fullexplain);
		Font font = new Font("", Font.BOLD, 13);
		text.setForeground(Color.blue);
		text.setFont(font);
		text.setEditable(false);
		setTitle("게임설명");
		setSize(500, 200);
		add(text, "Center");
		setVisible(true);
		this.setResizable(false);
		
		
		
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		GameIntro frame = new GameIntro();
		

	}

}
