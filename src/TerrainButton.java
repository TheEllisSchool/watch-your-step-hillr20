import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TerrainButton extends JButton{
	private static final int SIZE = 50;
	
	private int row = 0;
	private int col = 0;
	private int nextToHoles = 0;
	
	private boolean hole = false;
	private boolean revealed = false;
	
	public TerrainButton(int r, int c) {
		row = r;
		col = c;
		
		Dimension size = new Dimension (SIZE, SIZE);
		setPreferredSize(size);
	
		
	}
	
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	public boolean hasHole() {
		return hole;
	}

	public boolean isRevealed() {
		return revealed;
	}
	public void setHole(boolean hasHole) {
		hole = hasHole;
	}

	public void increaseHoleCount() {
		nextToHoles++;
	}
	public boolean isNextToHoles() {
		if (nextToHoles > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void reveal(boolean reveal) {
		revealed = reveal;
		if (revealed = true) {
			if (hasHole() ) {
				setBackground(Color.BLACK);
				//for image:
				//as a member variable
				//private ImageIcon image = new ImageIcon(C:/desing/0.png");
				//setIcon(image);
			}
			if (!hasHole()) {
				setBackground(Color.CYAN);
				if (isNextToHoles()) {
					
					setText("" + nextToHoles); 
				}
			}
			else {
				setBackground(null);
				setText("");
			}
			
			setFocusPainted(false); //i don't know whether it does the thing it's supposed to do
		}
	}
	public void reset() {
		hole = false;
		revealed = false;
		nextToHoles = 0;
		setText("");
		setBackground(null);
	}
}
