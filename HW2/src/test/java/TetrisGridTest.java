import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class TetrisGridTest {
	
	// Provided simple clearRows() test
	// width 2, height 3 grid
	@Test
	public void testClear1() {
		boolean[][] before =
		{	
			{true, true, false, },
			{false, true, true, }
		};
		
		boolean[][] after =
		{	
			{true, false, false},
			{false, true, false}
		};

        boolean[][] truoc = {
                {false, true, true},
                {true,  true, true},
                {true,  true, true}
        };

        boolean[][] sau = {
                {false, false, false},
                {true,  false, false},
                {true,  false, false}
        };
		
		TetrisGrid tetris = new TetrisGrid(before);
        TetrisGrid tetris2 = new TetrisGrid(truoc);

		tetris.clearRows();
        tetris2.clearRows();

		assertTrue( Arrays.deepEquals(after, tetris.getGrid()) );
        assertTrue( Arrays.deepEquals(sau, tetris2.getGrid()) );
	}
	
}
