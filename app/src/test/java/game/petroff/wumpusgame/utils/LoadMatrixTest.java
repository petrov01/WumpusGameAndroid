package game.petroff.wumpusgame.utils;

import org.junit.Test;

import game.petroff.wumpusgame.enums.EElements;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by petroff on 12/8/17.
 */

public class LoadMatrixTest {
    int[][] array;

    private final int START_I = 0;
    private final int START_J = 0;

    @Test
    public void setWumpusTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        array[START_I][START_J] = EElements.WUMPUS.getCode();

        LoadMatrix loadMatrix = new LoadMatrix();

        loadMatrix.setMatrix(array);

        assertEquals(loadMatrix.setWumpus(START_I, START_J), false);
    }

    @Test
    public void setPitTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        array[START_I][START_J] = EElements.PIT.getCode();

        LoadMatrix loadMatrix = new LoadMatrix();

        loadMatrix.setMatrix(array);

        assertEquals(loadMatrix.setPit(START_I, START_J), false);
    }

    @Test
    public void setWallTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        array[START_I][START_J] = EElements.WALL.getCode();

        LoadMatrix loadMatrix = new LoadMatrix();

        loadMatrix.setMatrix(array);

        assertEquals(loadMatrix.setPit(START_I, START_J), false);
    }

}
