package game.petroff.wumpusgame.utils;
import java.util.Random;

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
    //The additional matrix is used to find a way to the gold
    private int[][] addMatrix;

    private int X;
    private int Y;

    LoadMatrix startPoint;
    LoadMatrix endPoint;

    public LoadMatrix(int x , int y) {
        this.X = x;
        this.Y = y;
    }

    public LoadMatrix() {
        this.matrix = new int[EElements.ARRAY_SIZE.getCode()][EElements.ARRAY_SIZE.getCode()];
        this.addMatrix = new int[EElements.ARRAY_SIZE.getCode()+2][EElements.ARRAY_SIZE.getCode()+2];
        setMatrix();
    }

    public int[][] getMatrix(){
        return this.matrix;
    }

    public void setMatrix(int[][] matrix){
         this.matrix = matrix;
    }

    private void setMatrix(){
        //These variables are used to set starting and ending point, to find a way to the gold
        startPoint = new LoadMatrix(5, 1);
        endPoint = new LoadMatrix(1, 5);

        matrix[4][0] = EElements.PLAYER.getCode();
        matrix[0][4] = EElements.GOLD.getCode();

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

        //Setting walls in the additional array to avoid arrayindexoutofboundsexception
        if(setWallsInAddArray()){
            //If no way to the gold, reset the matrix
            if (!checkWayToGold(startPoint.Y, startPoint.X))
            {
                setMatrix();
            }
        }

        //Setting Wumpus. It must be the last position
        while(!setWumpus(getRNPosition(0, 4), getRNPosition(0, 4))) {}

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


    //Setting the walls in the additional array
    public boolean setWallsInAddArray(){
        //this.addMatrix  this.matrix
        int[] arr = new int[]{0, addMatrix.length-1, 0, addMatrix.length-1};
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < addMatrix[0].length; j++){
                if(i<2){
                    addMatrix[arr[i]][j] = EElements.WALL.getCode();
                }else{
                    addMatrix[j][arr[i]] = EElements.WALL.getCode();
                }
            }
        }
        for(int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                addMatrix[i][j] = matrix[i-1][j-1];
            }
        }
        //Setting the gold cell to 0
        addMatrix[1][5] = EElements.FREE_CELL.getCode();
        return true;
    }


    public boolean checkWayToGold(int y, int x){
         // Make the move
        addMatrix[x][y] = EElements.HAS_PASSED.getCode();

        // Check if we have reached the gold
        if (x == endPoint.X && y == endPoint.Y)
        {
            return true;
        }
        // Recursively search for the gold.
        if (y > 0 && addMatrix[x][y - 1] == EElements.FREE_CELL.getCode() && checkWayToGold(y - 1, x))
        {
            return true;
        }
        if (y < EElements.ARRAY_SIZE.getCode() && addMatrix[x][y + 1] == EElements.FREE_CELL.getCode() && checkWayToGold(y + 1, x))
        {
            return true;
        }
        if (x > 0 && addMatrix[x - 1][y] == EElements.FREE_CELL.getCode() && checkWayToGold(y, x - 1))
        {
            return true;
        }

        if (x < EElements.ARRAY_SIZE.getCode()  && addMatrix[x + 1][y] == EElements.FREE_CELL.getCode() && checkWayToGold(y, x + 1))
        {
            return true;
        }

        addMatrix[x][y] = EElements.FREE_CELL.getCode();

        return false;
    }
}
