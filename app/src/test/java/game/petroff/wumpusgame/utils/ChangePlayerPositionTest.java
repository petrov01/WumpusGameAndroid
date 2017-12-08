package game.petroff.wumpusgame.utils;
import org.junit.Test;

import game.petroff.wumpusgame.enums.EElements;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by petroff on 12/8/17.
 */

public class ChangePlayerPositionTest {
    int[][] array;
    private final int START_I = 0;
    private final int START_J = 0;

    private final int MOVE_I = 0;
    private final int MOVE_J = 1;

    @Test
    public void isChangedTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        array[START_I][START_J] = EElements.WUMPUS.getCode();

        ChangePlayerPosition changePLayer = new ChangePlayerPosition(array, START_I, START_J, MOVE_I, MOVE_J);

        assertEquals(changePLayer.isChanged(), true);
    }

    @Test
    public void getObstaclesTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        array[MOVE_I][MOVE_J] = EElements.WUMPUS.getCode();

        ChangePlayerPosition changePLayer = new ChangePlayerPosition(array, START_I, START_J, MOVE_I, MOVE_J);

        //Assert that is WUMPUS
        assertEquals(changePLayer.getObstacles(), EElements.WUMPUS.getCode());
    }
}
