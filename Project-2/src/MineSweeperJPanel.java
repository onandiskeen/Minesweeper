import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class MineSweeperJPanel extends JPanel{

	private JLabel jlDisplay;
	private JBtnPanel jBtnPanel;
	
	Grid grid = new Grid();
	
	public MineSweeperJPanel() {
		//setLayout(new GridLayout(2,1));
		
		jlDisplay = new JLabel("MINESWEEPER");
		Font bigFont = new Font(Font.SANS_SERIF, Font.BOLD, 24);
		jlDisplay.setFont(bigFont);
		
		//jlDisplay.setSize(500, 10);
		
		jBtnPanel = new JBtnPanel();
		
		
		add(jlDisplay);
		add(jBtnPanel);
	}
	
	
	private class JBtnPanel extends JPanel implements ActionListener{
		
		private static final int NUM_BUTTONS = 10;
		JButton [][] jbtns = new JButton[NUM_BUTTONS][NUM_BUTTONS];
		boolean [][] bombGrid = grid.getBombGrid();
		int [][] countGrid = grid.getCountGrid();
		int winCon = 0;
		
		
		public JBtnPanel(){
			setLayout(new GridLayout(NUM_BUTTONS, NUM_BUTTONS));
			for(int i=0; i< NUM_BUTTONS; i++){
				for (int x = 0; x<NUM_BUTTONS; x++) {
					jbtns[i][x] = new JButton();
					jbtns[i][x].setPreferredSize(new Dimension(47, 47));
					jbtns[i][x].setActionCommand(bombGrid[i][x] + "," + countGrid[i][x] + "," + i + "," + x);
					jbtns[i][x].addActionListener(this);
					add(jbtns[i][x]);
				}
			}
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			ImageIcon bombi = new ImageIcon("images/bomb.png");
			ImageIcon bombIMG = new ImageIcon(bombi.getImage().getScaledInstance(30,30, Image.SCALE_FAST));
			
			JButton button = (JButton)e.getSource();
			
			String gridInfo = e.getActionCommand();
			
			String [] gridValues = gridInfo.split(",");
			
			String bomb = gridValues[0];
			
			String numBombs = gridValues[1];
			
			int xCord = Integer.parseInt(gridValues[2]);
			
			int yCord = Integer.parseInt(gridValues[3]);
			
			boolean isbomb = Boolean.parseBoolean(bomb);
			
			if (isbomb == true) {
				for(int i=0; i< NUM_BUTTONS; i++){
					for (int x = 0; x<NUM_BUTTONS; x++) {
						
						if (bombGrid[i][x] == false) {
							jbtns[i][x].setEnabled(false);
							jbtns[i][x].setText(((Integer)countGrid[i][x]).toString());
						}else {
							jbtns[i][x].setIcon(bombIMG);
							jbtns[i][x].setFocusable(false);
							jbtns[i][x].setBorderPainted(false);
							jbtns[i][x].setBackground(Color.RED);
						}
						
					}
				}
				
				int option  = JOptionPane.showConfirmDialog(null, "Sorry you lost :(, Do you want to play again", "Informtion", JOptionPane.YES_NO_OPTION);
				
				if (option == 0) {
					
					winCon = 0;
					
					Grid gr = new Grid();
					
					bombGrid = gr.getBombGrid();
					countGrid = gr.getCountGrid();
					
					for(int i=0; i< NUM_BUTTONS; i++){
						for (int x = 0; x<NUM_BUTTONS; x++) {
							jbtns[i][x].setEnabled(true);
							jbtns[i][x].setIcon(null);
							jbtns[i][x].setBackground(null);
							jbtns[i][x].setText("");
							jbtns[i][x].setFocusable(true);
							jbtns[i][x].setBorderPainted(true);
							jbtns[i][x].setActionCommand(bombGrid[i][x] + "," + countGrid[i][x] + "," + i + "," + x);
						}
					}
				}else {
					System.exit(0);
				}
				
			}else {
				if (winCon+1 == (NUM_BUTTONS*NUM_BUTTONS)-25) {
					button.setText(numBombs);
					button.setEnabled(false);
					int option  = JOptionPane.showConfirmDialog(null, "You Won :), Do you want to play again", "Informtion", JOptionPane.YES_NO_OPTION);
					
					if (option == 0) {
						
						winCon = 0;
						
						Grid gri = new Grid();
						
						bombGrid = gri.getBombGrid();
						countGrid = gri.getCountGrid();
						
						for(int i=0; i< NUM_BUTTONS; i++){
							for (int x = 0; x<NUM_BUTTONS; x++) {
								jbtns[i][x].setEnabled(true);
								jbtns[i][x].setIcon(null);
								jbtns[i][x].setBackground(null);
								jbtns[i][x].setText("");
								jbtns[i][x].setFocusable(true);
								jbtns[i][x].setBorderPainted(true);
								jbtns[i][x].setActionCommand(bombGrid[i][x] + "," + countGrid[i][x] + "," + i + "," + x);
							}
						}
					}else {
						System.exit(0);
					}
					
					System.out.println(winCon);
				}else {
					if (countGrid[xCord][yCord] == 0) {
						jbtns[xCord][yCord].setEnabled(false);
						jbtns[xCord][yCord].setText("0");
						try {
							jbtns[xCord-1][yCord].doClick();
						}catch(ArrayIndexOutOfBoundsException exp) {

						}
						try {
							jbtns[xCord+1][yCord].doClick();
						}catch(ArrayIndexOutOfBoundsException exp) {

						}
						try {
							jbtns[xCord][yCord-1].doClick();
						}catch(ArrayIndexOutOfBoundsException exp) {

						}
						try {
							jbtns[xCord][yCord+1].doClick();
						}catch(ArrayIndexOutOfBoundsException exp) {

						}
						try {
							jbtns[xCord-1][yCord-1].doClick();
						}catch(ArrayIndexOutOfBoundsException exp) {

						}
						try {
							jbtns[xCord+1][yCord-1].doClick();
						}catch(ArrayIndexOutOfBoundsException exp) {

						}
						try {
							jbtns[xCord-1][yCord+1].doClick();
						}catch(ArrayIndexOutOfBoundsException exp) {

						}
						try {
							jbtns[xCord+1][yCord+1].doClick();
						}catch(ArrayIndexOutOfBoundsException exp) {

						}
					}
				
				
					winCon ++;
					button.setText(numBombs);
					button.setEnabled(false);
				}
	
			}
			
			//System.out.println(bomb + " " + numBombs);
			
			
			
			
		}
		
	}
	
	

}
