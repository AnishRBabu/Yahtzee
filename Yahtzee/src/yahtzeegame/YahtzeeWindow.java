package yahtzeegame;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YahtzeeWindow implements ActionListener {
	
	JFrame window = new JFrame("Yahtzee Game");
	JPanel mainPanel = new JPanel(new GridLayout(2,1));
	JPanel dicePanel = new JPanel(new GridLayout (1,5,5,5));
	JPanel dbPanel = new  JPanel (new GridLayout(2,1));
	JPanel dbrPanel = new JPanel (new GridLayout(2,1,5,5));
	JPanel northPanel = new JPanel (new BorderLayout());
	JPanel buttonPanel = new JPanel(new GridLayout(1,5,5,5));
	JPanel leftAndRightPanel = new JPanel(new GridLayout(1,3));
	
	JPanel leftScorePanel = new JPanel(new GridLayout (1,2));
	
	JPanel leftLeftPanel = new JPanel (new GridLayout (7,1,5,5));
	
	JPanel leftRightPanel = new JPanel (new GridLayout (7,1,5,5));
	JPanel rightScorePanel = new JPanel(new GridLayout (1,2));
	
	JPanel rightLeftPanel = new JPanel(new GridLayout (7,1,5,5));
	
	JPanel rightRightPanel = new JPanel(new GridLayout(7,1,5,5));
	JLabel[] dice = new JLabel[5];
	int[] parallel = new int[5];
	JButton[] button = new JButton[5];
	JButton roll = new JButton("ROLL");
	JButton[] leftLeftScore = new JButton[7];
	JLabel[] leftRightScore = new JLabel[7];
	JButton[] rightLeftScore = new JButton[7];
	JLabel[] rightRightScore = new JLabel[7];
	boolean rollFirst = true;
	int[] scores = new int[6];
	int[] counts = new int[6];
	int[] diceValue = new int[5];
	int[] dicePrevValue = new int[5];
	boolean[] booleanRoll = new boolean[6];
	int[] temp = new int[5];
	boolean[] clicked = new boolean[6];
	int numsRoll = 0;
	int finalScore = 0;
	int scores1 = 0;
	int scores2 = 0;
	int scores3 = 0;
	int scores4 = 0;
	int scores5 = 0;
	int scores6 = 0;
	int scores7 = 0;
	int scores8 = 0;
	int scores9 = 0;
	int scores10 = 0;
	int scores11= 0;
	int scores12 = 0;
	int scores13 = 0;
	
	

public YahtzeeWindow() {
	
	for (int i = 0; i < dice.length; i++) {
		dice[i] = new JLabel();
		dicePanel.add(dice[i]);
	}
	
	
	for (int j =0; j<button.length; j++) {
		button[j] = new JButton();
		buttonPanel.add(button[j]);
		button[j].addActionListener(this);
		
	}
	
	for(int i =0; i<booleanRoll.length; i++) {
		Arrays.fill(booleanRoll,true);
	}
	
	for(int i =0; i<booleanRoll.length; i++) {
		Arrays.fill(clicked,true);
	}
	
	
	
	String[] namesLeft = {"1's", "2's", "3's","4's","5's","6's", "TOTAL SCORE"};
	
	for(int l = 0; l < leftLeftScore.length; l++) {
		
		leftLeftScore[l] = new JButton(namesLeft[l]);
		leftLeftPanel.add(leftLeftScore[l]);
		leftLeftScore[l].addActionListener(this);
	}
	String[] namesLeft1 = {"10", "20", "30","40","50","60", "1000"};
	
	for(int l = 0; l < leftRightScore.length; l++) {
		
		leftRightScore[l] = new JLabel(namesLeft1[l]);
		leftRightPanel.add(leftRightScore[l], BorderLayout.EAST);
		leftRightScore[l].setVisible(false);
	}

	String[] namesRight = {"3 of a kind", "4 of a kind", "Full House", "Small Straight", "Large Straight", "Yahtzee", "Chance"};
	
	for(int k = 0; k < rightLeftScore.length; k++) {
		
		rightLeftScore[k] = new JButton(namesRight[k]);
		rightLeftPanel.add(rightLeftScore[k], BorderLayout.EAST);
		rightLeftScore[k].addActionListener(this);
	}
	
	
	String[] namesRight1= {"1", "2", "3", "4", "5", "6", "7"};
	
	for(int k = 0; k < rightRightScore.length; k++) {
		
		rightRightScore[k] = new JLabel(namesRight1[k]);
		rightRightPanel.add(rightRightScore[k]);
		rightRightScore[k].setVisible(false);
	}
	
	
	
	
	// build the window
	dbPanel.add(dicePanel, BorderLayout.NORTH);
	dbPanel.add(buttonPanel, BorderLayout.SOUTH);
	mainPanel.add(dbrPanel, BorderLayout.NORTH);
	dbrPanel.add(dbPanel, BorderLayout.NORTH);
	dbrPanel.add(roll, BorderLayout.SOUTH);
	leftScorePanel.add(leftLeftPanel, BorderLayout.WEST);
	leftScorePanel.add(leftRightPanel, BorderLayout.EAST);
	mainPanel.add(leftAndRightPanel, BorderLayout.SOUTH);
	leftAndRightPanel.add(leftScorePanel, BorderLayout.WEST);
	leftAndRightPanel.add(rightScorePanel, BorderLayout.CENTER);
	rightScorePanel.add(rightLeftPanel, BorderLayout.WEST);
	rightScorePanel.add(rightRightPanel, BorderLayout.EAST);
	window.add(mainPanel);
	window.setExtendedState(JFrame.MAXIMIZED_BOTH);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setVisible(true);
	roll.addActionListener(this);
}


@Override
public void actionPerformed(ActionEvent e) {
	
	int[] rand = new int [6];
	
	if(e.getSource() == roll) {
		Random gen = new Random();
		numsRoll++;
		for (int i = 0; i<5; i++) {
			button[i].setEnabled(true);
			if(e.getSource() == button[i]) {
				counts[0] = counts[0];
				counts[1] = counts[1];
				counts[2] = counts[2];
				counts[3] = counts[3];
				counts[4] = counts[4];
				counts[5] = counts[5];
			}
			else {
				counts[0] = 0;
				counts[1] = 0;
				counts[2] = 0;
				counts[3] = 0;
				counts[4] = 0;
				counts[5] = 0;
			}
		}
		
	for(int i = 0; i<6; i++) {
		scores[i] = 0;
	}
	for(int i = 0; i<7; i++) {
		leftLeftScore[i].setEnabled(true);
		rightLeftScore[i].setEnabled(true);
		leftLeftScore[6].setEnabled(false);
	}
	for(int j = 0; j<5; j++) {
		rand[j] = (int)(gen.nextInt(6) + 1);
		diceValue[j]=rand[j];
		if(rollFirst) {
			dicePrevValue[j] = diceValue[j];
			rollFirst = false;	
		}
		else {
		
			if(booleanRoll[j] == false) {
				diceValue[j] = dicePrevValue[j];
				
			}
			else {

				dicePrevValue[j] = diceValue[j];
			}
						
		}  
	}
	
	

	for(int j = 0;j<5; j++) {
		if(diceValue[j] == 1) {
			scores[0] = scores[0]+1;
			counts[0]++;
			
		}
		if(diceValue[j] == 2) {
			scores[1] = scores[1]+2;
			counts[1]++;
		}
		if(diceValue[j] == 3) {
			scores[2] = scores[2]+3;
			counts[2]++;
		}
		if(diceValue[j] == 4) {
			scores[3] = scores[3]+4;
			counts[3]++;
		}
		if(diceValue[j] == 5) {
			scores[4] = scores[4]+5;
			counts[4]++;
		}
		if(diceValue[j] == 6) {
			scores[5] = scores[5]+6;
			counts[5]++;
		}
	}
	
	//dice images
	}
	if(e.getSource() == roll && booleanRoll[0]) {
			dice[0].setIcon(new ImageIcon(new ImageIcon("src//yahtzeegame//" + diceValue[0] + " dice.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		}
		if(e.getSource() == roll && booleanRoll[1]) {
			dice[1].setIcon(new ImageIcon(new ImageIcon("src//yahtzeegame//" + diceValue[1] + " dice.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		}
		if(e.getSource() == roll && booleanRoll[2]) {
			dice[2].setIcon(new ImageIcon(new ImageIcon("src//yahtzeegame//" + diceValue[2] + " dice.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		}
		if(e.getSource() == roll && booleanRoll[3]) {
			dice[3].setIcon(new ImageIcon(new ImageIcon("src//yahtzeegame//" + diceValue[3] + " dice.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		}
		if(e.getSource() == roll && booleanRoll[4]) {
			dice[4].setIcon(new ImageIcon(new ImageIcon("src//yahtzeegame//" + diceValue[4] + " dice.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		}
		
		
		for(int i = 0; i<5; i++) {
			if(e.getSource() == button[i]) {
				if (booleanRoll[i] = true && clicked[i] == true) {
					booleanRoll[i] = false;
					clicked[i] = false;
					
					button[i].setBackground(new Color(0,158,96));
					button[i].setOpaque(true);
					button[i].setBorderPainted(false);
				
			} else {
				booleanRoll[i] = true;
				clicked[i] = true;

				button[i].setBackground(null);
				button[i].setOpaque(false);
				button[i].setBorderPainted(true);
			}
		}
		}
		
		if(numsRoll >= 3) {
			
			roll.setEnabled(false);
			for(int i = 0; i<5; i++) {
				button[i].setEnabled(false);
			}
			
		}
		
		for(int i = 0; i<7; i++) {
			if(e.getSource() == leftLeftScore[i] || e.getSource() == rightLeftScore[i]) {
				roll.setEnabled(true);
				numsRoll = 0;
					dice[0].setIcon(new ImageIcon(new ImageIcon("src//yahtzeegame//" +  "0 dice.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				
					dice[1].setIcon(new ImageIcon(new ImageIcon("src//yahtzeegame//" + "0 dice.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
			
			
					dice[2].setIcon(new ImageIcon(new ImageIcon("src//yahtzeegame//" + "0 dice.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				
				
					dice[3].setIcon(new ImageIcon(new ImageIcon("src//yahtzeegame//" + "0 dice.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				
				
					dice[4].setIcon(new ImageIcon(new ImageIcon("src//yahtzeegame//" + "0 dice.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
				
				for(int j =0; j<5; j++) {
					booleanRoll[j] = true;
					clicked[j] = true;
					button[j].setBackground(null);
					button[j].setOpaque(false);
					button[j].setBorderPainted(true);
					button[j].setEnabled(false);
				}
			}
		}
		
		
			
		//top score & total score
			if(e.getSource() == leftLeftScore[0]) {
				scores1 = scores[0];
				leftRightScore[0].setText(Integer.toString(scores1));
				leftRightScore[0].setVisible(true);
				leftLeftScore[0].removeActionListener(this);
				finalScore++;
				leftLeftScore[0].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
			
			}
			if(e.getSource() == leftLeftScore[1]) {
				scores2 = scores[1];
				leftRightScore[1].setText(Integer.toString(scores2));
				leftRightScore[1].setVisible(true);
				leftLeftScore[1].removeActionListener(this);
				finalScore++;
				leftLeftScore[1].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
			
			}
			
			if(e.getSource() == leftLeftScore[2]) {
				scores3 = scores[2];
				leftRightScore[2].setText(Integer.toString(scores3));
				leftRightScore[2].setVisible(true);
				leftLeftScore[2].removeActionListener(this);
				finalScore++;
				leftLeftScore[2].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
			
			}
			if(e.getSource() == leftLeftScore[3] ) {
				scores4 = scores[3];
				leftRightScore[3].setText(Integer.toString(scores4));
				leftRightScore[3].setVisible(true);
				leftLeftScore[3].removeActionListener(this);
				finalScore++;
				leftLeftScore[3].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
			
			}
			if(e.getSource() == leftLeftScore[4] ) {
				scores5 = scores[4];
				leftRightScore[4].setText(Integer.toString(scores5));
				leftRightScore[4].setVisible(true);
				leftLeftScore[4].removeActionListener(this);
				finalScore++;
				leftLeftScore[4].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
			
			}
			if(e.getSource() == leftLeftScore[5] ) {
				scores6 = scores[5];
				leftRightScore[5].setText(Integer.toString(scores6));
				leftRightScore[5].setVisible(true);
				leftLeftScore[5].removeActionListener(this);
				finalScore++;
				leftLeftScore[5].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
			
			}
			if(finalScore == 13) {
				leftRightScore[6].setText(Integer.toString(scores1 + scores2 + scores3 + scores4 + scores5 + scores6 + scores7 + scores8 +scores9+scores10+scores11+scores12+scores13));
				leftRightScore[6].setVisible(true);
			}
			
			//other score
			
			if(e.getSource() == rightLeftScore[0]) {
				if(counts[0]>=3 || counts[1]>=3 || counts[2]>=3 || counts[3]>=3 || counts[4]>=3 || counts[5]>=3) {
				scores7 = (scores[0] + scores[1] + scores[2] + scores[3] + scores[4] + scores[5]);
				rightRightScore[0].setText(Integer.toString(scores7));
				rightRightScore[0].setVisible(true);
				rightLeftScore[0].removeActionListener(this);
				finalScore++;
				rightLeftScore[0].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
				}
				else {
					rightRightScore[0].setText("0");
					rightRightScore[0].setVisible(true);
					rightLeftScore[0].removeActionListener(this);
					rightLeftScore[0].setEnabled(false);
					finalScore++;
					for(int i = 0; i<7; i++) {
						leftLeftScore[i].setEnabled(false);
						rightLeftScore[i].setEnabled(false);
					}
				}
			
			}
			if(e.getSource() == rightLeftScore[1]) {
				if((counts[0]>=4 || counts[1]>=4 || counts[2]>=4 || counts[3]>=4 || counts[4]>=4 || counts[5] >= 4)) {
				scores8 = (scores[0] + scores[1] + scores[2] + scores[3] + scores[4] + scores[5]);
				rightRightScore[1].setText(Integer.toString(scores8));
				rightRightScore[1].setVisible(true);
				rightLeftScore[1].removeActionListener(this);
				finalScore++;
				rightLeftScore[1].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
				}
				
				else {
					rightRightScore[1].setText("0");
					rightRightScore[1].setVisible(true);
					rightLeftScore[1].removeActionListener(this);
					rightLeftScore[1].setEnabled(false);
					finalScore++;
					for(int i = 0; i<7; i++) {
						leftLeftScore[i].setEnabled(false);
						rightLeftScore[i].setEnabled(false);
					}
				}
			}
			if(e.getSource() == rightLeftScore[2]) {
				if((counts[0]==3 || counts[1]==3 || counts[2]==3 || counts[3]==3 || counts[4]==3 || counts[5]==3) && (counts[0]==2 || counts[1]==2 || counts[2]==2 || counts[3]==2 || counts[4]==2 || counts[5]==2)) {
				scores9 = 25;
				rightRightScore[2].setText(Integer.toString(scores9));
				rightRightScore[2].setVisible(true);
				rightLeftScore[2].removeActionListener(this);
				finalScore++;
				rightLeftScore[2].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
				}
				else {
					rightRightScore[2].setText("0");
					rightRightScore[2].setVisible(true);
					rightLeftScore[2].removeActionListener(this);
					rightLeftScore[2].setEnabled(false);
					finalScore++;
					for(int i = 0; i<7; i++) {
						leftLeftScore[i].setEnabled(false);
						rightLeftScore[i].setEnabled(false);
					}
				}
			}
			if(e.getSource() == rightLeftScore[3]) {
				temp = diceValue;
				Arrays.sort(temp);
				if((((temp[0] +3) == temp[3]) && ((temp[1] + 1) == temp[2])) || (((temp[1] + 3) == temp[4])) && ((temp[2] + 1) == temp[3]) || (((temp[0] + 3) == temp[4])) && ((temp[0] + 2) == temp[3])) {
					scores10 = 30;
					rightRightScore[3].setText(Integer.toString(scores10));
					rightRightScore[3].setVisible(true);
					rightLeftScore[3].removeActionListener(this);
					finalScore++;
					rightLeftScore[3].setEnabled(false);
					for(int i = 0; i<7; i++) {
						leftLeftScore[i].setEnabled(false);
						rightLeftScore[i].setEnabled(false);
					}
				}
				else {
					rightRightScore[3].setText("0");
					rightRightScore[3].setVisible(true);
					rightLeftScore[3].removeActionListener(this);
					rightLeftScore[3].setEnabled(false);
					finalScore++;
					for(int i = 0; i<7; i++) {
						leftLeftScore[i].setEnabled(false);
						rightLeftScore[i].setEnabled(false);
					}
				}
			
			}
			if(e.getSource() == rightLeftScore[4]) {
				temp = diceValue;
				Arrays.sort(temp);
				if(((temp[0] + 4) == temp[4]) && ((temp[1]+2) == temp[3])){
				scores11 = 40;
				rightRightScore[4].setText(Integer.toString(scores11));	
				rightRightScore[4].setVisible(true);
				rightLeftScore[4].removeActionListener(this);
				finalScore++;
				rightLeftScore[4].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
				}
				else {
					rightRightScore[4].setText("0");	
					rightRightScore[4].setVisible(true);
					rightLeftScore[4].removeActionListener(this);
					rightLeftScore[4].setEnabled(false);
					finalScore++;
					for(int i = 0; i<7; i++) {
						leftLeftScore[i].setEnabled(false);
						rightLeftScore[i].setEnabled(false);
					}
				}
			}
			if(e.getSource() == rightLeftScore[5]) {
				if(counts[0]==5 || counts[1]==5 || counts[2]==5 || counts[3]==5 || counts[4]==5 || counts[5]==5) {
				scores12 = 50;
				rightRightScore[5].setText(Integer.toString(scores12));
				rightRightScore[5].setVisible(true);
				rightLeftScore[5].removeActionListener(this);
				finalScore++;
				rightLeftScore[5].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
				}
				else {
					rightRightScore[5].setText("0");
					rightRightScore[5].setVisible(true);
					rightLeftScore[5].removeActionListener(this);
					rightLeftScore[5].setEnabled(false);
					finalScore++;
					for(int i = 0; i<7; i++) {
						leftLeftScore[i].setEnabled(false);
						rightLeftScore[i].setEnabled(false);
					}
				}
			}
			
			if(e.getSource() == rightLeftScore[6]) {
				scores13 = (scores[0] + scores[1] + scores[2] + scores[3] + scores[4] + scores[5]);
				rightRightScore[6].setText(Integer.toString(scores13));
				rightRightScore[6].setVisible(true);
				rightLeftScore[6].removeActionListener(this);
				finalScore++;
				rightLeftScore[6].setEnabled(false);
				for(int i = 0; i<7; i++) {
					leftLeftScore[i].setEnabled(false);
					rightLeftScore[i].setEnabled(false);
				}
					
				}
			}
		}