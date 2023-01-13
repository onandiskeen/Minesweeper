import java.util.Arrays;
import java.util.Random;

// https://youtu.be/j-IA1dpwqHA

public class Grid {
	
	
	private boolean [][] bombGrid;
	private int [][] countGrid;
	private int numRows;
	private int numColumns;
	private int numBombs;
	
	public Grid() {
		this.numRows = 10;
		this.numColumns = 10;
		this.numBombs = 25;
		createBombGrid();
		createCountGrid();
		
//		for (int x = 0; x< 10; x ++) {
//			for (int y = 0; y<10;y++) {
//				System.out.print(bombGrid[x][y]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println();
//		for (int x = 0; x< 10; x ++) {
//			for (int y = 0; y<10;y++) {
//				System.out.print(countGrid[x][y]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
		
	}
	
	
	public Grid(int rows, int columns) {
		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = 25;
		createBombGrid();
		createCountGrid();
	}
	
	public Grid(int rows, int columns, int numBombs) {
		this.numRows = rows;
		this.numColumns = columns;
		this.numBombs = numBombs;
		createBombGrid();
		createCountGrid();
		
	}
	
	public int getNumRows() {
		return this.numRows;
				
	}
	
	public int getNumColumns() {
		return this.numColumns;
	}
	
	public int getNumBombs() {
		return this.numBombs;
	}
	
	public boolean [][] getBombGrid(){
		
		boolean[][] copy = new boolean[bombGrid.length][];
		
		for (int x = 0; x < bombGrid.length; x++) {
			copy[x] = Arrays.copyOf(bombGrid[x], bombGrid[x].length);
		}
		
		return copy;
	}
	
	public int [][] getCountGrid(){
		
		int[][] copy = new int[countGrid.length][];
		
		for (int x = 0; x < countGrid.length; x++) {
			copy[x] = Arrays.copyOf(countGrid[x], countGrid[x].length);
		}
		
		return copy;
	}
	
	public boolean isBombAtLocation(int row, int column) {
		
		
		try {
			if (bombGrid[row][column] == true) {
				return true;
			}else {
				return false;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}catch(Exception exp) {
			return false;
		}
	}
	
	public int getCountAtLocation(int row, int column) {
		
		int counter = 0;
		
		try {
			counter += countGrid[row][column];
		}catch(ArrayIndexOutOfBoundsException exp) {

		}
		
		
		return counter;
	}
	
	private void createBombGrid() {
		
		Random rd = new Random();
		
		int bombCounter = 0;
		
		int xCord = 0;
		int yCord = 0;
		
		
		this.bombGrid = new boolean[this.getNumRows()][this.getNumColumns()];
		
		 for (int x = 0; x< bombGrid.length; x ++) {
			 for (int y = 0; y<bombGrid[x].length; y ++) {
					 bombGrid[x][y] = false;
				 
			 }
		 }
		 
		while (bombCounter < getNumBombs()) {
			 xCord = rd.nextInt(getNumRows());
			 yCord = rd.nextInt(getNumColumns());
			 
			 
			 if (bombGrid[xCord][yCord] == false) {
				 bombGrid[xCord][yCord] = true;
				 bombCounter ++;
			 }
			 
	  }
		
	}
	
	private void createCountGrid() {
		this.countGrid = new int[this.getNumRows()][this.getNumColumns()];
		
		// cannot be greater than or less than the grid
		
		for (int x = 0; x < bombGrid.length; x ++) {
			for (int y = 0; y<bombGrid[x].length; y ++) {
				int bombCounter = 0;
				try {
					
					if (bombGrid[x][y] == true) {
						bombCounter ++;
					}
				}catch(ArrayIndexOutOfBoundsException exp) {

				}
				
				try {
					
					if (bombGrid[x - 1][y] == true) {
						bombCounter ++;
					}
				}catch(ArrayIndexOutOfBoundsException exp) {

				}
				
				try {
					
					if (bombGrid[x + 1][y] == true) {
						bombCounter ++;
					}
				}catch(ArrayIndexOutOfBoundsException exp) {

				}
				
				try {
					
					if (bombGrid[x][y - 1] == true) {
						bombCounter ++;
					}
				}catch(ArrayIndexOutOfBoundsException exp) {

				}

				try {
					
					if (bombGrid[x][y + 1] == true) {
						bombCounter ++;
					}
				}catch(ArrayIndexOutOfBoundsException exp) {

				}

				try {
					
					if (bombGrid[x - 1][y - 1] == true) {
						bombCounter ++;
					}
				}catch(ArrayIndexOutOfBoundsException exp) {

				}
				
				try {
					
					if (bombGrid[x + 1][y + 1] == true) {
						bombCounter ++;
					}
				}catch(ArrayIndexOutOfBoundsException exp) {

				}
				
				try {
					
					if (bombGrid[x - 1 ][y + 1] == true) {
						bombCounter ++;
					}
				}catch(ArrayIndexOutOfBoundsException exp) {

				}
				
				try {
					
					if (bombGrid[x + 1][y - 1] == true) {
						bombCounter ++;
					}
				}catch(ArrayIndexOutOfBoundsException exp) {

				}
				
				countGrid[x][y] = bombCounter;
				
			}
		}
		
		
		
		
		
	}
}

