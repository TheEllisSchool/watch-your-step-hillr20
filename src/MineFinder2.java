import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

//new
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent; 

public class MineFinder2 extends JFrame{
	/**
	 
	 * 
	 */
	
	private static final int GRIDSIZE = 10;
	private static final int NUMBEROFHOLES = 10;
	
	private TerrainButton[][] terrain = new TerrainButton[GRIDSIZE][GRIDSIZE];
	private int totalRevealed = 0;
			
	private static final long serialVersionUID = 1L;
	JPanel titlePanel = new JPanel();
	
	
	public MineFinder2() {
		initGUI();
		setHoles();
		
		
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
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(GRIDSIZE, GRIDSIZE));
		add(centerPanel, BorderLayout.CENTER);
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				terrain[r][c] = new TerrainButton(r, c);
				terrain[r][c].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						TerrainButton button = (TerrainButton) e.getSource();
						int row = button.getRow();
						int col = button.getCol();
						clickedTerrain(row, col);
					}

										
				});
				centerPanel.add(terrain[r][c]);
	
			}
			
		}
		
	}
		
	private void setHoles() {
		Random rand = new Random();
		int pickRow;
		int pickCol;
		for (int i = 0; i < NUMBEROFHOLES; i++) {
			do {
				pickRow = rand.nextInt(GRIDSIZE);
				pickCol = rand.nextInt(GRIDSIZE);
			} while (terrain[pickRow][pickCol]. hasHole());
			terrain [pickRow][pickCol].setHole(true);
			addToNeighborsHoleCount(pickRow, pickCol);
			//terrain[pickRow][pickCol].reveal(true);
			
			//terrain[pickRow][pickCol].setHole(true);
			//addToNeighborsHoleCount(pickRow,pickCol);
			//terrain[pickRow][pickCol].reveal(true);
			//commented out in Task 9: 1
			
					
		}	
	}
	
	private void addToNeighborsHoleCount(int row, int col) {
		addToHoleCount(row-1, col-1);
		addToHoleCount(row-1, col);
		addToHoleCount(row-1, col+1);
		addToHoleCount(row, col-1);
		addToHoleCount(row, col+1);
		addToHoleCount(row+1, col-1);
		addToHoleCount(row+1, col);
		addToHoleCount(row+1, col+1);	
	}
	
	private void addToHoleCount(int row, int col) {
		if (row > -1 && row < GRIDSIZE && col > -1 && col < GRIDSIZE ) {
			terrain[row][col].increaseHoleCount();
			//commented out in Task 9: 1
		}
	}
		
	private void clickedTerrain(int row, int col) {
		// TODO Auto-generated method stub
		if (terrain[row][col].hasHole()){
			String message = "Game over! You stepped on a hole and lost. Do you want to play again?";
			promptForNewGame(message);
		}
		else {
			check(row, col);
			checkNeighbors(row, col);
			if ((GRIDSIZE*GRIDSIZE) - NUMBEROFHOLES == totalRevealed){
				String message = "Yay, you won! You found all the mines. Do you want to play again?";
				promptForNewGame(message);
			}
			
		}
	}
	
	private void check(int row, int col) {
		if (row > -1 && row < GRIDSIZE && col > -1 && col < GRIDSIZE 
				&& !terrain[row][col].hasHole()
				&& !terrain[row][col].isRevealed()) {
			terrain[row][col].reveal(true);
			totalRevealed++;
			if (!terrain[row][col].isNextToHoles()) {
				checkNeighbors(row, col);
			}
		}
	}
	
	private void checkNeighbors(int row, int col) {
		check(row-1, col-1);
		check(row-1, col);
		check(row-1, col+1);
		check(row, col-1);
		check(row, col+1);
		check(row+1, col-1);
		check(row+1, col);
		check(row+1, col+1);
	}
	
	private void promptForNewGame(String message) {
		showHoles();
		int option = JOptionPane.showConfirmDialog(this, message, "Play Again?", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			newGame();
		}
		else {
			System.exit(0);
		}
	}
	
	private void newGame() {
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				terrain[r][c].reset();
				
			}
			
		}
		setHoles();
	}
	
	private void showHoles() {
		for (int r = 0; r < GRIDSIZE; r++) {
			for (int c = 0; c < GRIDSIZE; c++) {
				if (terrain[r][c].hasHole()) {
					terrain[r][c].reveal(true); //i ran it and it totally doesn't do that (doesn't reveal holes)
					
				}
			}
		}
	}
		
	//private void addToNeighborsHoleCount(int pickRow, int pickCol) {
		// TODO Auto-generated method stub
		
	//}
	

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

