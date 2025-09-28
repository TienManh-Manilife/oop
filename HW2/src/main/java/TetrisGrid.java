//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
        this.grid = new boolean[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            this.grid[i] = new boolean[grid[i].length];
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                this.grid[i][j] = grid[i][j];
            }
        }
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
    public void clearRows() {
        int height = grid[0].length;
        int width = grid.length;

        for (int y = 0; y < height; y++) {
            boolean full = true;

            for (int x = 0; x < width; x++) {
                if (!grid[x][y]) {
                    full = false;
                    break;
                }
            }
            if (full) {
                for (int yy = y; yy < height - 1; yy++) {
                    for (int x = 0; x < width; x++) {
                        grid[x][yy] = grid[x][yy + 1];
                    }
                }
                for (int x = 0; x < width; x++) {
                    grid[x][height - 1] = false;
                }
                y--;
            }
        }
    }


    /**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
        return this.grid;
    }
}
