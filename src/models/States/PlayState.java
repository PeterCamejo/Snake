package models.States;

import input.KeyManager;

import models.Map;


import java.awt.*;
import java.util.ArrayList;

/**
 * Created by The Alex on 5/31/2016.
 */
public class PlayState extends State {
    /* Attributes */
    private KeyManager keyManager;
    private Map gameMap;

    private int inputBuffer;


    /* Constructors*/
    public PlayState(){
        keyManager = new KeyManager();
        inputBuffer = 0;


        init();
    }

    public void tick(){
        keyManager.tick();


            if(keyManager.north){
                gameMap.setSnakeDirection("north");
            }else
            if(keyManager.south){
                gameMap.setSnakeDirection("south");
            }else
            if(keyManager.east){
                gameMap.setSnakeDirection("east");
            }else
            if(keyManager.west){
                gameMap.setSnakeDirection("west");
            }

        if(keyManager.TEST){
            gameMap.addSnakePart();
        }

        gameMap.tick();

        if(gameMap.checkGameOver()){
            System.out.println("________________________________ NEW GAME ____________________________");
            GameStateManager.setState(new PlayState());
        }

    }





    public void init(){
        gameMap = new Map();
    }
    public void render(Graphics g){
        gameMap.render(g);

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }


}
