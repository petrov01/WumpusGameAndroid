package game.petroff.wumpusgame.utils;
import android.widget.Button;

import org.junit.Test;

import game.petroff.wumpusgame.enums.EElements;

import static org.junit.Assert.assertEquals;

/**
 * Created by petroff on 12/8/17.
 */

public class SetButtonsTest {
    int[][] array;

    private final int START_I = 0;
    private final int START_J = 0;

    private final int MOVE_I = 0;
    private final int MOVE_J = 1;

    @Test
    public void isHasWumpsTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        array[MOVE_I][MOVE_J] = EElements.WUMPUS.getCode();

        SetButtons setButtons = new SetButtons();
        setButtons.setPlayerButton(null, array, START_I, START_J);

        assertEquals(setButtons.isHasWumps(), true);
    }

    @Test
    public void isHasPitTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        array[MOVE_I][MOVE_J] = EElements.PIT.getCode();

        SetButtons setButtons = new SetButtons();
        setButtons.setPlayerButton(null, array, START_I, START_J);

        assertEquals(setButtons.isHasPit(), true);
    }
}
