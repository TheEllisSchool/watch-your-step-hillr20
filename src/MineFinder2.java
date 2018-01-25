import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

//new
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MineFinder2 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel titlePanel = new JPanel();
	
	public MineFinder2() {
		initGUI();
		
		setTitle("Minefinder");
		setSize(200, 200); //pixels
		setResizable(false);
		pack();
		setLocationRelativeTo(null); //centers on screen, do this after packing but before visible
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void initGUI() {
		JPanel titlePanel = new JPanel();
		add(titlePanel, BorderLayout.PAGE_START);
		//also change background
		titlePanel.setBackground(Color.BLACK);
		JLabel titleLabel = new JLabel("Welcome to Minefinder");
		//JLab = class; titleLabel = instance of the class
		//once you create it, you have to add it to the frame (see below)
		
		titlePanel.add(titleLabel);
		titleLabel.setHorizontalAlignment(JLabel.CENTER); //left or right
		Font titlefont = new Font("Georgia", Font.BOLD, 18);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(titlefont);
		//add panels for different sections
		//center, title, and bottom panels
	}
		
		
		//answer.setForeground(Color.GREEN);
		
		
		
		//below, do a random number that generates an answer
		
		
		//target color
		
		
		/*Font buttonFont = new Font("Roboto", Font.PLAIN, 16);
		
		//Task 2: Create a TerrainButton class
		//1.create a new class called TerrainButton with a superclass JButton
		JButton TerrainButton = new JButton();
		TerrainButton.setFont(buttonFont);
		TerrainButton.setBackground(Color.WHITE);
		centerPanel.add(TerrainButton);
		
		//2. Add a private static final integer instance variable called SIZE, set to 50.
		final int SIZE = 50; //?
		
		//3. Add three private integers variables called row, col, and nextToHoles, all with initial values of 0. 
		final int row = 0;
		final int col = 0;
		final int nextToHoles = 0;
		
		//1) PROBLEM WITH GITHUB!!!
		
		//4. Add two boolean instance variables called hole and revealed, each initialized next to false.
		final boolean hole = false;
		final boolean revealed = false;
		
		//5. The constructor will need to initialize instance variables and set the terrain button's preferred size.
		public class TerrainButton extends JButton (int row, int col){
			super(col, row);
			int row;
			int col;
			Dimension size = new Dimension (SIZE wide, SIZE high);	
			TerrainButton.setPreferredSize(size);
			TerrainButton.setSize(getPreferredSize());
			
		
		
		//6.
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
		
		//7.
			public void setHole(boolean hasHole) {
				hole = hasHole;
			}
		
			public void increaseHoleCount() {
				nextToHoles++;
			}
		
			public boolean isNextToHoles() {
				if (nextToHoles > 1) {
					return true;
				}
				else {
					return false;
				}
			}
		
		}	
		
		
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch ( Exception e) {}
        
        EventQueue.invokeLater(new Runnable (){
            @Override
            public void run() {
                new MineFinder2();
            }   
        });
	}

}

