package game.petroff.wumpusgame.utils;

import android.widget.Button;

import game.petroff.wumpusgame.R;
import game.petroff.wumpusgame.enums.EElements;

/**
 * Created by petroff on 12/6/17.
 */

public class SetButtons {

    private boolean hasWumpus = false;
    private boolean hasPit = false;

    public boolean isHasWumps(){
        return this.hasWumpus;
    }

    public boolean isHasPit(){
        return this.hasPit;
    }

    public SetButtons(){
    }

    public void setPlayerButton(Button but, int[][] matrix, int i, int j){
        setEmotion(but, matrix, i,  j);
    }

    public void setEmotion(Button but, int[][] matrix, int i, int j){
        //check down
        if(i > 0){
            if(matrix[i-1][j] == EElements.PIT.getCode()){
                this.hasPit = true;
            }else if(matrix[i-1][j] == EElements.WUMPUS.getCode()){
                this.hasWumpus = true;
            }
        }

        //check up
        if(i < EElements.ARRAY_SIZE.getCode()-1){
            if(matrix[i+1][j] == EElements.PIT.getCode()){
                this.hasPit = true;
            }else if(matrix[i+1][j] == EElements.WUMPUS.getCode()){
                this.hasWumpus = true;
            }
        }

        //check left
        if(j > 0){
            if(matrix[i][j-1] == EElements.PIT.getCode()){
                this.hasPit = true;
            }else if(matrix[i][j-1] == EElements.WUMPUS.getCode()){
                this.hasWumpus = true;
            }
        }

        //check right
        if(j < EElements.ARRAY_SIZE.getCode()-1){
            if(matrix[i][j+1] == EElements.PIT.getCode()){
                this.hasPit = true;
            }else if(matrix[i][j+1] == EElements.WUMPUS.getCode()){
                this.hasWumpus = true;
            }
        }

        if(but != null){
            but.setBackgroundResource(R.drawable.wump);

            //There is a shine
            if(hasPit){
                but.setBackgroundResource(R.drawable.brillo);
            }

            //Smells bad
            if(hasWumpus){
                but.setBackgroundResource(R.drawable.smellbad);
            }

            if(hasWumpus && hasPit){
                but.setBackgroundResource(R.drawable.smellbad);
            }
        }
    }
}