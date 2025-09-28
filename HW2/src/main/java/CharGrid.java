// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid .
	 */
	public CharGrid(char[][] grid) {
        this.grid = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            this.grid[i] = new char[grid[i].length];
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
    } // OK
	
	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
        int minRow = this.grid.length, maxRow = -1;
        int minCol = this.grid[0].length, maxCol = -1;
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                if (this.grid[i][j] == ch) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        if (maxRow == -1) return 0;
        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
	} // OK
	
	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
    public int countPlus() {
        int count = 0;
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                char ch = this.grid[i][j];
                int up    = getArmLength(i, j, -1, 0, ch);
                int down  = getArmLength(i, j,  1, 0, ch);
                int left  = getArmLength(i, j,  0,-1, ch);
                int right = getArmLength(i, j,  0, 1, ch);

                int minLen = Math.min(Math.min(up, down), Math.min(left, right));
                if (minLen >= 1) {
                    count++;
                }
            }
        }
        return count;
    }
    private int getArmLength(int row, int col, int dRow, int dCol, char ch) {
        int length = 0;
        int i = row + dRow;
        int j = col + dCol;
        while (i >= 0 && i < this.grid.length && j >= 0 && j < this.grid[i].length && this.grid[i][j] == ch) {
            length++;
            i += dRow;
            j += dCol;
        }
        return length;
    }

}