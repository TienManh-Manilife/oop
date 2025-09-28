// Test cases for CharGrid -- a few basic tests are provided.

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class CharGridTest {
    @Test
    public void testCharArea1() {
        char[][] grid = new char[][]{
                {'a', 'y', ' '},
                {'x', 'a', 'z'},
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(4, cg.charArea('a'));
        assertEquals(1, cg.charArea('z'));
    } // Checked

    @Test
    public void testCharArea2() {
        char[][] grid = new char[][]{
                {'c', 'a', ' '},
                {'b', ' ', 'b'},
                {' ', ' ', 'a'}
        };

        CharGrid cg = new CharGrid(grid);

        assertEquals(6, cg.charArea('a'));
        assertEquals(3, cg.charArea('b'));
        assertEquals(1, cg.charArea('c'));
    } // Checked

    @Test
    public void testCountPlus() {
        char[][] arr1 = {
                {'.', 'x', '.'},
                {'x', 'x', 'x'},
                {'.', 'x', '.'}
        };

        char[][] arr2 = {
                {'.','p','.','.','.','.','.','.'},
                {'.','p','.','.','.','x','.','.'},
                {'p','p','p','p','p','x','x','x'},
                {'.','p','.','.','y','.','x','.'},
                {'.','p','.','y','y','y','.','.'},
                {'z','z','z','z','y','z','z','z'},
                {'.','.','x','x','.','y','.','.'}
        };

        CharGrid cg1 = new CharGrid(arr1);
        CharGrid cg2 = new CharGrid(arr2);

        assertEquals(1, cg1.countPlus());
        assertEquals(2, cg2.countPlus());
    }
}
