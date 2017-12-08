package game.petroff.wumpusgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

import game.petroff.wumpusgame.utils.ChangePlayerPosition;
import game.petroff.wumpusgame.utils.LoadMatrix;
import game.petroff.wumpusgame.utils.SetButtons;
import game.petroff.wumpusgame.utils.ShootArrow;
import game.petroff.wumpusgame.enums.EElements;
import game.petroff.wumpusgame.enums.EText;
import android.media.MediaPlayer;

import java.util.Map;

public class WumpusActivity extends AppCompatActivity{

    private int[][] matrix;
    private int positionI;
    private int positionJ;

    private final int SHOOT_LEFT = 1;
    private final int SHOOT_RIGHT = 2;
    private final int SHOOT_UP = 3;
    private final int SHOOT_DOWN = 4;

    private final int WALL = 4;
    private final int PIT = 3;
    private final int WUMPUS = 1;
    private final int HAS_PASSED = 6;
    private int arrow;

    private ChangePlayerPosition changePlayerPosition;

    private Button b, currentButton, leftShoot, rightShoot, downShoot, upShoot,
            w11, w12, w13, w14, w15,
            w21, w22, w23, w24, w25,
            w31, w32, w33, w34, w35,
            w41, w42, w43, w44, w45,
            w51, w52, w53, w54, w55;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wumpus);

        matrix = new LoadMatrix().getMatrix();

        //Initialize buttons
        initialize();
        arrow = EElements.ARROWS.getCode();

        leftShoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoot(SHOOT_LEFT);
            }
        });

        rightShoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoot(SHOOT_RIGHT);
            }
        });

        downShoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoot(SHOOT_DOWN);
            }
        });

        upShoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoot(SHOOT_UP);
            }
        });

        w11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 0, 0);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 0, 0, w11);
                    }else{
                        setNewPosition(0, 0, w11);
                    }
                }
            }
        });

        w12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 0, 1);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 0, 1, w12);
                    }else{
                        setNewPosition(0, 1, w12);
                    }
                }
            }
        });

        w13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 0, 2);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 0, 2, w13);
                    }else{
                        setNewPosition(0, 2, w13);
                    }
                }
            }
        });

        w14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 0,3);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 0, 3, w14);
                    }else{
                        setNewPosition(0, 3, w14);
                    }
                }
            }
        });

        w15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 0, 4);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 0, 4, w15);
                    }else{
                        setNewPosition(0, 4, w15);
                    }
                }
            }
        });

        w21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 1, 0);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 1, 0, w21);
                    }else{
                        setNewPosition(1, 0, w21);
                    }
                }
            }
        });

        w22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 1, 1);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else {
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0
                    if (result != 0 && result != EElements.HAS_PASSED.getCode()) {
                        setActionObstacle(startGameDiallog, 1, 1, w22);
                    } else {
                        setNewPosition(1, 1, w22);
                    }
                }
            }
        });

        w23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 1, 2);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 1, 2, w23);
                    }else{
                        setNewPosition(1, 2, w23);
                    }
                }
            }
        });

        w24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 1, 3);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 1, 3, w24);
                    }else{
                        setNewPosition(1, 3, w24);
                    }
                }
            }
        });

        w25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 1, 4);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0 or != 6, there is obstacle or gold
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 1, 4, w25);
                    }else{
                        setNewPosition(1, 4, w25);
                    }
                }
            }
        });

        w31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 2, 0);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0 or != 6, there is obstacle or gold
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 2, 0, w31);
                    }else{
                        setNewPosition(2, 0, w31);
                    }
                }
            }
        });

        w32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 2, 1);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0 or != 6, there is obstacle or gold
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 2, 1, w32);
                    }else{
                        setNewPosition(2, 1, w32);
                    }
                }
            }
        });

        w33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 2, 2);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0 or != 6, there is obstacle or gold
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 2, 2, w33);
                    }else{
                        setNewPosition(2, 2, w33);
                    }
                }
            }
        });

        w34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 2, 3);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0 or != 6, there is obstacle or gold
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 2, 3, w34);
                    }else{
                        setNewPosition(2, 3, w34);
                    }
                }
            }
        });

        w35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 2, 4);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0 or != 6, there is obstacle or gold
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 2, 4, w35);
                    }else{
                        setNewPosition(2, 4, w35);
                    }
                }
            }
        });

        w41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 3, 0);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0 or != 6, there is obstacle or gold
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 3, 0, w41);
                    }else{
                        setNewPosition(3, 0, w41);
                        w51.setBackgroundResource(R.drawable.door);
                    }
                }
            }
        });

        w42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 3, 1);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    //If result is != 0 or != 6, there is obstacle or gold
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 3, 1, w42);
                    }else{
                        setNewPosition(3, 1, w42);
                    }
                }
            }
        });

        w43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 3, 2);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 3, 2, w43);
                    }else{
                        setNewPosition(3, 2, w43);
                    }
                }
            }
        });

        w44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 3, 3);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 3, 3, w44);
                    }else{
                        setNewPosition(3, 3, w44);
                    }
                }
            }
        });

        w45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 3, 4);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 3, 4, w45);
                    }else{
                        setNewPosition(3, 4, w45);
                    }
                }
            }
        });


        w51.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 4, 0);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 4, 0, w51);
                    }else{
                        setNewPosition(4, 0, w51);
                    }
                    //If a player returns to start point, check for gold
                    if(checkBringGold()) {
                        winGame(startGameDiallog);
                    }
                }
            }
        });

        w52.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 4, 1);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{

                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 4, 1, w52);
                    }else{
                        setNewPosition(4, 1, w52);
                        w51.setBackgroundResource(R.drawable.door);
                    }
                }
            }
        });

        w53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 4, 2);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 4, 2, w53);
                    }else{
                        setNewPosition(4, 2, w53);
                    }
                }
            }
        });

        w54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 4, 3);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 4, 3, w54);
                    }else{
                        setNewPosition(4, 3, w54);
                    }
                }
            }
        });

        w55.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePlayerPosition = new ChangePlayerPosition(matrix, positionI, positionJ, 4, 4);
                if(!changePlayerPosition.isChanged()){
                    Toast.makeText(getApplicationContext(), EText.CANT_GO_THERE.getText(), Toast.LENGTH_SHORT).show();
                }else{
                    int result = changePlayerPosition.getObstacles();
                    AlertDialog startGameDiallog = new AlertDialog.Builder(
                            WumpusActivity.this).create();
                    if(result != 0 && result != EElements.HAS_PASSED.getCode()){
                        setActionObstacle(startGameDiallog, 4, 4, w55);
                    }else{
                        setNewPosition(4, 4, w55);
                    }
                }
            }
        });

        start();
    }

    //Show start message
    private void start(){
        AlertDialog startGameDiallog = new AlertDialog.Builder(
                WumpusActivity.this).create();
        startGameDiallog.setTitle("Wumpus game");
        startGameDiallog.setMessage("You have "+ EElements.ARROWS.getCode()+" arrow. \n" +
                EText.SMELL_BAD.getText()+" - means there is a Wumpus nearby\n" +
                EText.IS_IT_LIGHTING.getText() + " - means there is a well nearby\n" +
                "Are you ready?");

        startGameDiallog.setIcon(R.drawable.wump);
        startGameDiallog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                playerPos(w51, 4, 0);
            }
        });
        // Show Message
        startGameDiallog.show();
    }

    //Initialize the buttons
    private void initialize() {
        w11=(Button)findViewById(R.id.W11);
        w12=(Button)findViewById(R.id.W12);
        w13=(Button)findViewById(R.id.W13);
        w14=(Button)findViewById(R.id.W14);
        w15=(Button)findViewById(R.id.W15);
        w21=(Button)findViewById(R.id.W21);
        w22=(Button)findViewById(R.id.W22);
        w23=(Button)findViewById(R.id.W23);
        w24=(Button)findViewById(R.id.W24);
        w25=(Button)findViewById(R.id.W25);
        w31=(Button)findViewById(R.id.W31);
        w32=(Button)findViewById(R.id.W32);
        w33=(Button)findViewById(R.id.W33);
        w34=(Button)findViewById(R.id.W34);
        w35=(Button)findViewById(R.id.W35);
        w41=(Button)findViewById(R.id.W41);
        w42=(Button)findViewById(R.id.W42);
        w43=(Button)findViewById(R.id.W43);
        w44=(Button)findViewById(R.id.W44);
        w45=(Button)findViewById(R.id.W45);
        w51=(Button)findViewById(R.id.W51);
        w52=(Button)findViewById(R.id.W52);
        w53=(Button)findViewById(R.id.W53);
        w54=(Button)findViewById(R.id.W54);
        w55=(Button)findViewById(R.id.W55);
        leftShoot =(Button)findViewById(R.id.left);
        rightShoot=(Button)findViewById(R.id.right);
        downShoot=(Button)findViewById(R.id.down);
        upShoot=(Button)findViewById(R.id.up);
    }

    //Setting player position
    private void playerPos(Button but, int i, int j){
        SetButtons setButtons =  new SetButtons();
        this.positionI = i;
        this.positionJ = j;
        setButtons.setPlayerButton(but, matrix, i, j);
        currentButton = but;

        //If there is a wumpus nearby, set text
        if(setButtons.isHasWumps()){
            Toast.makeText(getApplicationContext(), EText.SMELL_BAD.getText(), Toast.LENGTH_SHORT).show();
        }
        //If there is a well nearby, set text
        if(setButtons.isHasPit()){
            Toast.makeText(getApplicationContext(), EText.IS_IT_LIGHTING.getText(), Toast.LENGTH_SHORT).show();
        }
        w15.setBackgroundColor(0xFFFFFFAA);
        w15.setHint("GOLD");
    }

    //If bring gold win the game
    private boolean checkBringGold(){
        boolean bringGold = true;
        one: for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == EElements.GOLD.getCode()){
                    bringGold = false;
                    break one;
                }
            }
        }
        return bringGold;
    }

    //Setting motion form obstacles
    private void setActionObstacle(AlertDialog startGameDiallog, int i, int j, Button but){
        switch (matrix[i][j]){
            case 1:
                setLoseMessage(but, startGameDiallog, EText.WUMPUS_EAT_YOU.getText());
                break;
            case 2:
                setNewPosition(i, j, but);
                but.setBackgroundResource(R.drawable.gold);
                w51.setBackgroundResource(R.drawable.door);
                break;
            case 3:
                setLoseMessage(but, startGameDiallog, EText.YOU_FALL.getText());
                break;
            case 4:
                but.setBackgroundResource(R.drawable.wall);
                Toast.makeText(getApplicationContext(), EText.HAS_WALL.getText(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //Setting a new position on the table
    private void setNewPosition(int i, int j, Button but){
        SetButtons setButtons =  new SetButtons();
        matrix[i][j] = matrix[positionI][positionJ];
        matrix[positionI][positionJ] = EElements.HAS_PASSED.getCode();
        positionI = i;
        positionJ = j;
        currentButton.setBackgroundColor(0xFFFFFFFF);
        but.setBackgroundResource(R.drawable.wump);
        currentButton = but;
        setButtons.setEmotion(but, matrix, i,  j);
        if(setButtons.isHasWumps()){
            Toast.makeText(getApplicationContext(), EText.SMELL_BAD.getText(), Toast.LENGTH_SHORT).show();
        }
        if(setButtons.isHasPit()){
            Toast.makeText(getApplicationContext(), EText.IS_IT_LIGHTING.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    //If you win, set message
    private void winGame(AlertDialog startGameDiallog ){
        currentButton.setBackgroundResource(R.drawable.winner);
        startGameDiallog.setTitle(EText.YOU_WIN.getText());
        startGameDiallog.setMessage(EText.TRY_AGAIN.getText());
        startGameDiallog.setIcon(R.drawable.winner);
        startGameDiallog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                matrix = new LoadMatrix().getMatrix();
                setButtonsBackground();
                playerPos(w51, 4, 0);
                arrow = EElements.ARROWS.getCode();
            }
        });
        // Show Message
        startGameDiallog.show();
    }

    //If you are dead, set message
    private void setLoseMessage(Button but, AlertDialog startGameDiallog, String message){
        but.setBackgroundResource(R.drawable.dead);
        currentButton.setBackgroundColor(0xFFFFFFFF);
        startGameDiallog.setTitle(message);
        startGameDiallog.setMessage(EText.TRY_AGAIN.getText());
        startGameDiallog.setIcon(R.drawable.dead);
        startGameDiallog.setButton(EText.OK.getText(), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                matrix = new LoadMatrix().getMatrix();
                setButtonsBackground();
                playerPos(w51, 4, 0);
                arrow = EElements.ARROWS.getCode();
            }
        });
        // Show Message
        startGameDiallog.show();
    }

    // Set buttons background
    private void setButtonsBackground(){
        w11.setBackgroundResource(R.drawable.cartas);
        w12.setBackgroundResource(R.drawable.cartas);
        w13.setBackgroundResource(R.drawable.cartas);
        w14.setBackgroundResource(R.drawable.cartas);
        w15.setBackgroundResource(R.drawable.cartas);
        w21.setBackgroundResource(R.drawable.cartas);
        w22.setBackgroundResource(R.drawable.cartas);
        w23.setBackgroundResource(R.drawable.cartas);
        w24.setBackgroundResource(R.drawable.cartas);
        w25.setBackgroundResource(R.drawable.cartas);
        w31.setBackgroundResource(R.drawable.cartas);
        w32.setBackgroundResource(R.drawable.cartas);
        w33.setBackgroundResource(R.drawable.cartas);
        w34.setBackgroundResource(R.drawable.cartas);
        w35.setBackgroundResource(R.drawable.cartas);
        w41.setBackgroundResource(R.drawable.cartas);
        w42.setBackgroundResource(R.drawable.cartas);
        w43.setBackgroundResource(R.drawable.cartas);
        w44.setBackgroundResource(R.drawable.cartas);
        w45.setBackgroundResource(R.drawable.cartas);
        w51.setBackgroundResource(R.drawable.cartas);
        w52.setBackgroundResource(R.drawable.cartas);
        w53.setBackgroundResource(R.drawable.cartas);
        w54.setBackgroundResource(R.drawable.cartas);
        w55.setBackgroundResource(R.drawable.cartas);
    }


    private void shoot(int direction){
        if(arrow != 0){
            setShootDirection(direction);
            arrow -= 1;
        }else{
            Toast.makeText(getApplicationContext(), EText.NO_MORE_ARROW.getText(), Toast.LENGTH_SHORT).show();
        }
    }


    //Set shoot direction button
    private void setShootDirection(int shotDirection){
        ShootArrow shootArrow = new ShootArrow(matrix, shotDirection, positionI, positionJ);
        matrix = shootArrow.getMatrix();

        //positionI is static
        Map<Integer, Integer> map = shootArrow.getMap();

        StringBuffer strB = new StringBuffer();
        String button;
        switch(shotDirection){
            case SHOOT_LEFT:
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    strB.delete(0, strB.length());
                    int id = Integer.parseInt(strB.append(positionI+1).append(entry.getKey()+1).toString());
                    changeShootFields(id, entry.getValue());
                }
                break;
            case SHOOT_RIGHT:
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    strB.delete(0, strB.length());
                    int id = Integer.parseInt(strB.append(positionI+1).append(entry.getKey()+1).toString());
                    changeShootFields(id, entry.getValue());
                }
                break;
            case SHOOT_DOWN:
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    strB.delete(0, strB.length());
                    int id = Integer.parseInt(strB.append(entry.getKey()+1).append(positionJ+1).toString());
                    changeShootFields(id, entry.getValue());
                }
                break;
            case SHOOT_UP:
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    strB.delete(0, strB.length());
                    int id = Integer.parseInt(strB.append(entry.getKey()+1).append(positionJ+1).toString());
                    changeShootFields(id, entry.getValue());
                }
                break;
        }
    }


    //Change the fields, where arrow passed
    private void changeShootFields(int buttonId, int field){
        switch (buttonId){
            case 11:
                arrowField(w11, field);
                break;
            case 12:
                arrowField(w12, field);
                break;
            case 13:
                arrowField(w13, field);
                break;
            case 14:
                arrowField(w14, field);
                break;
            case 15:
                arrowField(w15, field);
                break;
            case 21:
                arrowField(w21, field);
                break;
            case 22:
                arrowField(w22, field);
                break;
            case 23:
                arrowField(w23, field);
                break;
            case 24:
                arrowField(w24, field);
                break;
            case 25:
                arrowField(w25, field);
                break;
            case 31:
                arrowField(w31, field);
                break;
            case 32:
                arrowField(w32, field);
                break;
            case 33:
                arrowField(w33, field);
                break;
            case 34:
                arrowField(w34, field);
                break;
            case 35:
                arrowField(w35, field);
                break;
            case 41:
                arrowField(w41, field);
                break;
            case 42:
                arrowField(w42, field);
                break;
            case 43:
                arrowField(w43, field);
                break;
            case 44:
                arrowField(w44, field);
                break;
            case 45:
                arrowField(w45, field);
                break;
            case 51:
                arrowField(w51, field);
                break;
            case 52:
                arrowField(w52, field);
                break;
            case 53:
                arrowField(w53, field);
                break;
            case 54:
                arrowField(w54, field);
                break;
            case 55:
                arrowField(w55, field);
                break;
        }
    }

    //Setting fields where arrow passed
    private void arrowField(Button but, int field){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.credulous);
        switch(field){
            case WALL:
                but.setBackgroundResource(R.drawable.wall);
                break;
            case PIT:
                but.setBackgroundResource(R.drawable.well);
                break;
            case WUMPUS:
                but.setBackgroundResource(R.drawable.wumpus_dead);
                currentButton.setBackgroundResource(R.drawable.happy);
                Toast.makeText(getApplicationContext(), EText.SHOUT.getText(), Toast.LENGTH_SHORT).show();
                mp.start();
                break;
            case HAS_PASSED:
                but.setBackgroundColor(0xFFFFFFFF);
                break;
        }
    }
}