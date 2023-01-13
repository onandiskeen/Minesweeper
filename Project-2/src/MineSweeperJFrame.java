
import javax.swing.JFrame; 

public class MineSweeperJFrame extends JFrame{
	
	public MineSweeperJFrame() {
		MineSweeperJPanel jpMine = new MineSweeperJPanel();
		add(jpMine);
		
		
		setTitle("MineSweeper");
		setResizable(false);
		setSize(500, 555);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
