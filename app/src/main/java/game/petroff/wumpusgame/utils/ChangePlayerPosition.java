package game.petroff.wumpusgame.utils;

/**
 * Created by petroff on 12/6/17.
 */

public class ChangePlayerPosition {
    private int[][] matrix;
    private int posI, posJ;
    private int moveI, moveJ;

    public ChangePlayerPosition(int[][] matrix, int posI, int posJ, int moveI, int moveJ) {
        this.matrix = matrix;
        this.posI = posI;
        this.posJ = posJ;
        this.moveI = moveI;
        this.moveJ = moveJ;
    }

    public boolean isChanged(){
        if(posI == moveI && (moveJ-1) == posJ){
            return true;
        }

        if(posI == moveI && (moveJ+1) == posJ){
            return true;
        }

        if(posI == (moveI-1) && moveJ == posJ){
            return true;
        }

        if(posI == (moveI+1) && moveJ == posJ){
            return true;
        }
        return false;
    }

    public int getObstacles(){
        return matrix[moveI][moveJ];
    }
}