package main;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Card {
	
	private int ImageNumber;
	private int FieldNumber;
	private JButton ImageButton;
	private boolean ActiveCard;
	
	public Card (int FieldNumber, int ImageNumber) {
		
		this.FieldNumber = FieldNumber;
		this.ImageButton = new JButton(Integer.toString(FieldNumber), new ImageIcon(getClass().getResource("/8.jpg")));
		this.ActiveCard = false;
		
		if (ImageNumber>7) {
		this.ImageNumber = ImageNumber - 8;
		}
		
		else {
		this.ImageNumber = ImageNumber;
		}
		
	}
	
	public int getImageNumber() {
		
		return ImageNumber;
	}
	
	public int getFieldNumber() {
		
		return FieldNumber;
	}
	
	public JButton getImageButton() {
		
		return ImageButton;
	}
	
	public boolean getActiveCard() {
		
		return ActiveCard;
	}
	
	public void setJButton(int ImageNumber) {
		ImageButton.setIcon((new ImageIcon(getClass().getResource("/"+ImageNumber+".jpg"))));
	}
	
	public void setActiveCard(boolean Active) {
		
		this.ActiveCard = Active;
	}
}
