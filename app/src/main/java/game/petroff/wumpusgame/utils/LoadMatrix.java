package game.petroff.wumpusgame.utils;
import java.util.Random;
import android.util.Log;

import game.petroff.wumpusgame.enums.EElements;

/**
 * Created by petroff on 12/6/17.
 * 1 is a wumpus
 * 2 is a gold
 * 3 is a pit
 * 4 is a wall
 * 5 is a player
 */

public class LoadMatrix {
    private static final String TAG = LoadMatrix.class.getSimpleName();

    private int[][] matrix;


    public LoadMatrix() {
        this.matrix = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        setMatrix();
    }

    public int[][] getMatrix(){
        return this.matrix;
    }

    public void setMatrix(int[][] matrix){
         this.matrix = matrix;
    }

    private void setMatrix(){
        Log.d(TAG, "LOAD THE MATRIX");

        matrix[4][0] = EElements.PLAYER.getCode();

        matrix[0][4] = EElements.GOLD.getCode();

        //Setting Wumpus position
        while(!setWumpus(getRNPosition(0, 4), getRNPosition(0, 4))) {}

        //Setting 3 Water Wells position
        for(int i = 0; i<EElements.WATER_WELL_NUMBER.getCode(); i++){
            if(!setPit(getRNPosition(0, 4), getRNPosition(0, 4))){
                i--;
            }
        }

        //Setting 3 Walls position
        for(int i = 0; i<EElements.WALL_NUMBER.getCode(); i++){
            if(!setWall(getRNPosition(0, 4), getRNPosition(0, 4))){
                i--;
            }
        }
    }

    //Setting Wumpus
    public boolean setWumpus(int i, int j){
        if(this.matrix[i][j] != 0){
            return false;
        }
        this.matrix[i][j] = EElements.WUMPUS.getCode();
        return true;
    }

    //Setting pit
    public boolean setPit(int i, int j){
        if(this.matrix[i][j] != 0){
            return false;
        }
        this.matrix[i][j] = EElements.PIT.getCode();
        return true;
    }

    //Setting Walls
    public boolean setWall(int i, int j){
        if(this.matrix[i][j] != 0){
            return false;
        }
        this.matrix[i][j] = EElements.WALL.getCode();
        return true;
    }

    //Returns rnd positions
    private int getRNPosition(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
