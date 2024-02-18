package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import breadBarber.*;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.util.Random;
import java.awt.event.ActionEvent;

public class WinnerView extends JFrame {

	private Player winner;
	private JPanel contentPane;
	private JLabel winnerImage;
	private JLabel winnerName;
	private JButton restartBtn;
	private JLabel 위너표시;
	private JLabel 위너표시_1;
	private JLabel 위너표시_2;
	private JLabel 위너표시_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinnerView frame = new WinnerView();
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
	public WinnerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		위너표시 = new JLabel("WINNER");
		위너표시.setForeground(new Color(0, 128, 255));
		위너표시.setFont(new Font("Algerian", Font.PLAIN, 30));
		위너표시.setBounds(48, 60, 169, 91);
		contentPane.add(위너표시);
		
		winnerImage = new JLabel("New label");
		winnerImage.setBounds(173, 37, 192, 213);
		contentPane.add(winnerImage);
		
		JLabel lblNewLabel = new JLabel("브래드이발소의 주인은???");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(153, 242, 442, 65);
		contentPane.add(lblNewLabel);
		restartBtn = new JButton("restart");
		restartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new 캐릭터선택하기();
			}
		});
		restartBtn.setBackground(new Color(255, 255, 255));
		restartBtn.setForeground(new Color(0, 128, 255));
		restartBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		restartBtn.setBounds(475, 357, 140, 65);
		contentPane.add(restartBtn);
		
		위너표시_1 = new JLabel("WINNER");
		위너표시_1.setForeground(new Color(0, 128, 255));
		위너표시_1.setFont(new Font("Algerian", Font.PLAIN, 30));
		위너표시_1.setBounds(389, 49, 169, 91);
		contentPane.add(위너표시_1);
		
		위너표시_2 = new JLabel("WINNER");
		위너표시_2.setForeground(new Color(0, 128, 255));
		위너표시_2.setFont(new Font("Algerian", Font.PLAIN, 30));
		위너표시_2.setBounds(48, 116, 169, 91);
		contentPane.add(위너표시_2);
		
		위너표시_3 = new JLabel("WINNER");
		위너표시_3.setForeground(new Color(0, 128, 255));
		위너표시_3.setFont(new Font("Algerian", Font.PLAIN, 30));
		위너표시_3.setBounds(389, 116, 169, 91);
		contentPane.add(위너표시_3);

		
		winnerName = new JLabel("New label");
		winnerName.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		winnerName.setBounds(174, 317, 275, 84);
		contentPane.add(winnerName);
		winnerName.setForeground(new Color(34, 31, 212));
		


		
		
	}
	
	public WinnerView(Player winner)
	{
		this();
		this.setTitle(winner.name + "의 승리!");
		winnerName.setText(winner.name);
		winnerImage.setIcon(new ImageIcon(getClass().getResource(winner.img)));
		
		
		this.setVisible(true);
		
	}
}

