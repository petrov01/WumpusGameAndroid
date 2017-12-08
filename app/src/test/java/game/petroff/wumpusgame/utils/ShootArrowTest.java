package game.petroff.wumpusgame.utils;

import org.junit.Test;

import game.petroff.wumpusgame.enums.EElements;

import static org.junit.Assert.assertEquals;

/**
 * Created by petroff on 12/8/17.
 */

public class ShootArrowTest {

    int[][] array;

    private final int START_ZERO = 0;
    private final int START_ONE = 1;


    private final int SHOOT_LEFT = 1;
    private final int SHOOT_RIGHT = 2;
    private final int SHOOT_UP = 3;
    private final int SHOOT_DOWN = 4;

    @Test
    public void getMatrixShootLeftTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        //Setting wumpus on 0, 0
        array[START_ZERO][START_ZERO] = EElements.WUMPUS.getCode();

        //Setting player on 0, 1
        ShootArrow shootArrow = new ShootArrow(array, SHOOT_LEFT, START_ZERO, START_ONE);

        //If after shoot wumpus is killed, values must be equals to HAS_PASSED (6)
        assertEquals(shootArrow.getMatrix()[START_ZERO][START_ZERO], EElements.HAS_PASSED.getCode());
    }

    @Test
    public void getMatrixShootDownTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        //Setting wumpus on 1, 1
        array[START_ONE][START_ONE] = EElements.WUMPUS.getCode();

        //Setting player on 0, 1
        ShootArrow shootArrow = new ShootArrow(array, SHOOT_DOWN, START_ZERO, START_ONE);

        //If after shoot wumpus is killed, values must be equals to HAS_PASSED (6)
        assertEquals(shootArrow.getMatrix()[START_ONE][START_ONE], EElements.HAS_PASSED.getCode());
    }

    @Test
    public void getMatrixShootUpTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        //Setting wumpus on 0, 0
        array[START_ZERO][START_ZERO] = EElements.WUMPUS.getCode();

        //Setting player on 1, 0
        ShootArrow shootArrow = new ShootArrow(array, SHOOT_UP, START_ONE, START_ZERO);

        //If after shoot wumpus is killed, values must be equals to HAS_PASSED (6)
        assertEquals(shootArrow.getMatrix()[START_ZERO][START_ZERO], EElements.HAS_PASSED.getCode());
    }


    @Test
    public void getMatrixShootRightTest() throws Exception {
        array = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        //Setting wumpus on 0, 0
        array[START_ONE][START_ONE] = EElements.WUMPUS.getCode();

        //Setting player on 1, 0
        ShootArrow shootArrow = new ShootArrow(array, SHOOT_RIGHT, START_ONE, START_ZERO);

        //If after shoot wumpus is killed, values must be equals to HAS_PASSED (6)
        assertEquals(shootArrow.getMatrix()[START_ONE][START_ONE], EElements.HAS_PASSED.getCode());
    }

}
