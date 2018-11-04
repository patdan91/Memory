package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Window {
	
	JFrame Frame;
	JPanel Panel1;
	JPanel Panel2;
	
	
	JLabel Label = new JLabel("");
	Card[] Cards = new Card[16];
	JButton Button1;
	JButton Button2;
	int ButtomNumber1;
	int ButtomNumber2;
	
	int NumberOfMoves = 0;
	int FirstImage;
	int SecondImage;
	int FirstNumber;
	int SecondNumber;
	int CorrectAswer = 0;
	
	void MixUpTheCards() {		
		int j = 0;
		int k;
		ArrayList<Integer> List = new ArrayList<Integer>();
		
		
		while (j<16) {
			k = (int)(Math.random()*16);
			if (List.contains(k)) {
				}
			else {
				List.add(k);
				j++;
			}
		}
				
		for (int i=0; i<16; i++ ) {
			Card c = new Card(i, List.get(i));
			Cards[i] = c;
		}					
	}	
		
	void CreateaWindow(){
		
		JFrame Frame = new JFrame("Memory");
		JPanel Panel1 = new JPanel();
		JPanel Panel2 = new JPanel();
		
		Frame.getContentPane().add(BorderLayout.NORTH, Panel1);
		Frame.getContentPane().add(BorderLayout.SOUTH, Panel2);
		Panel1.setLayout(new GridLayout(4,4));
		
		int i;
		
		for (i=0; i<16; i++ ) {			
			Panel1.add(Cards[i].getImageButton()); 
			Cards[i].getImageButton().addActionListener(new ClickListener());
		}
		
		Panel2.add(Label);		
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setSize(400, 550);
		Frame.setVisible(true);
		
	}
	
	class ClickListener implements ActionListener {
		public void actionPerformed(ActionEvent Event1) {
			
			//Sprawdzenie który JButton zosta³ klikniêty
			Button1 = (JButton)Event1.getSource();
			int ButtonNumber1 = Integer.valueOf(Button1.getText());
			
			//Jeœli JButton nie zosta³ wczeœniej kliknêty
			if (Cards[ButtonNumber1].getActiveCard()!=true) {
				//Ustawienie obraku karty, jaj aktywacja, naliczenie klikniêcia
				Cards[ButtonNumber1].setJButton(Cards[ButtonNumber1].getImageNumber());
				Cards[ButtonNumber1].setActiveCard(true);					
				NumberOfMoves++;
				
				//Jeœli klikniêcie jest parzyste
				if ((NumberOfMoves%2)==0){
					//zapisanie informacji w polach "drugiej karty"
					SecondImage = Cards[ButtonNumber1].getImageNumber();
					SecondNumber = Cards[ButtonNumber1].getFieldNumber();	
					
					//Jeœli karty s¹ te same 
					if (FirstImage==SecondImage) {
						CorrectAswer++;
						
						//Jeœli osi¹gnelismy 8 poprawnych odpowiedzi to wygrywamy
						if (CorrectAswer==8) {
							Label.setText("You won!!");
							}
					}
							
				}
				//Jeœli klikniêcie nie jest parzyste
				else {
					//Jeœli karty z poprzedniej tury by³y inne to przywracamy obrazek i zmieniamy aktywacje
					if (FirstImage!=SecondImage) {
						Cards[FirstNumber].setJButton(8);
						Cards[SecondNumber].setJButton(8);
						Cards[FirstNumber].setActiveCard(false);
						Cards[SecondNumber].setActiveCard(false);
						}
						//Zapisujemy informacje w polach"pierwszej karty"
						FirstImage = Cards[ButtonNumber1].getImageNumber();
						FirstNumber = Cards[ButtonNumber1].getFieldNumber();	
			
					}
				
			}
		}
	}
	
}