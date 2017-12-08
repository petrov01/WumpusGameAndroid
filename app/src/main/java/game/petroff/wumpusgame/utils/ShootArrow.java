package game.petroff.wumpusgame.utils;

import game.petroff.wumpusgame.enums.EElements;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by petroff on 12/6/17.
 */

public class ShootArrow {

    //SHOOTS
    private final int SHOOT_LEFT = 1;
    private final int SHOOT_RIGHT = 2;
    private final int SHOOT_UP = 3;
    private final int SHOOT_DOWN = 4;

    private int posI;
    private int posJ;

    private int firingDirection;
    private int[][] matrix;
    private Map<Integer, Integer> map;

    //stores the buttons with a position where the arrow has passed
    public ShootArrow(int[][] matrix, int firingDirection, int posI, int posJ){
        this.matrix = matrix;
        this.firingDirection = firingDirection;
        this.posI = posI;
        this.posJ = posJ;
    }

    public int[][] getMatrix(){
        switch(firingDirection){
            case SHOOT_LEFT:
                    shootLeft();
                break;
            case SHOOT_RIGHT:
                    shootRight();
                break;
            case SHOOT_UP:
                    shootUp();
                break;
            case SHOOT_DOWN:
                    shootDown();
                break;
        }
        return matrix;
    }

    public Map<Integer, Integer> getMap(){
        return map;
    }

    private void  shootLeft(){
        //The position of posI is static
       map = new ConcurrentHashMap<Integer, Integer>();
       one: for(int j = posJ-1; j >= 0; j--){
           if(matrix[posI][j] == EElements.WALL.getCode()){
                map.put(j, EElements.WALL.getCode());
                break one;
            }else if(matrix[posI][j] == EElements.WUMPUS.getCode()){
                map.put(j, EElements.WUMPUS.getCode());
                matrix[posI][j] = EElements.HAS_PASSED.getCode();
                break one;
            }else if(matrix[posI][j] == EElements.PIT.getCode()){
                map.put(j, EElements.PIT.getCode());
           }else if(posI == 4 && j == 0){
               //IF IT'S A START POSITION DON'T CHANGE THE VALUE
           }else{
                map.put(j, EElements.HAS_PASSED.getCode());
                matrix[posI][j] = EElements.HAS_PASSED.getCode();
            }
        }
    }

    private void  shootRight(){
        //The position of posI is static
        map = new ConcurrentHashMap<Integer, Integer>();
        one: for(int j = posJ+1; j < matrix[0].length; j++){
            if(matrix[posI][j] == EElements.WALL.getCode()){
                map.put(j, EElements.WALL.getCode());
                break one;
            }else if(matrix[posI][j] == EElements.WUMPUS.getCode()){
                map.put(j, EElements.WUMPUS.getCode());
                matrix[posI][j] = EElements.HAS_PASSED.getCode();
                break one;
            }else if(matrix[posI][j] == EElements.PIT.getCode()){
                map.put(j, EElements.PIT.getCode());
            }else if(matrix[posI][j] == EElements.GOLD.getCode()){
                //IF IT'S A GOLD, DON'T CHANGE VALUE
            }else{
                map.put(j, EElements.HAS_PASSED.getCode());
                matrix[posI][j] = EElements.HAS_PASSED.getCode();
            }
        }
    }

    private void  shootUp(){
        //The position of posJ is static
        map = new ConcurrentHashMap<Integer, Integer>();
        one: for(int i = posI-1; i >= 0; i--){
            if(matrix[i][posJ] == EElements.WALL.getCode()){
                map.put(i, EElements.WALL.getCode());
                break one;
            }else if(matrix[i][posJ] == EElements.WUMPUS.getCode()){
                map.put(i, EElements.WUMPUS.getCode());
                matrix[i][posJ] = EElements.HAS_PASSED.getCode();
                break one;
            }else if(matrix[i][posJ] == EElements.PIT.getCode()){
                map.put(i, EElements.PIT.getCode());
            }else if(matrix[i][posJ] == EElements.GOLD.getCode()){
                //IF IT'S A GOLD, DON'T CHANGE VALUE
            }else{
                map.put(i, EElements.HAS_PASSED.getCode());
                matrix[i][posJ] = EElements.HAS_PASSED.getCode();
            }
        }
    }

    private void shootDown(){
        //The position of posJ is static
        map = new ConcurrentHashMap<Integer, Integer>();
        one: for(int i = posI+1; i < matrix[0].length; i++){
            if(matrix[i][posJ] == EElements.WALL.getCode()){
                map.put(i, EElements.WALL.getCode());
                break one;
            }else if(matrix[i][posJ] == EElements.WUMPUS.getCode()){
                map.put(i, EElements.WUMPUS.getCode());
                matrix[i][posJ] = EElements.HAS_PASSED.getCode();
                break one;
            }else if(matrix[i][posJ] == EElements.PIT.getCode()){
                map.put(i, EElements.PIT.getCode());
            }else if(i == 4 && posJ == 0){
                //IF IT'S A START POSITION DON'T CHANGE THE VALUE
            }else{
                map.put(i, EElements.HAS_PASSED.getCode());
                matrix[i][posJ] = EElements.HAS_PASSED.getCode();
            }
        }
    }
}
