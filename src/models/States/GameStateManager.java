package models.States;

import input.KeyManager;
import main.Game;

import java.awt.*;

/**
 * Created by The Alex on 5/16/2016.
 */
public class GameStateManager {
    /* Attributes */
    private static State currentState = null;
    private static Game game;

    /* Methods */
    public static void setState(State state){
        currentState = state;
        game.clearKeyListener();
        game.setKeyListener(state.getKeyManager());
    }

    public static State getState(){
        return currentState;
    }

    public static void tickCurrentState(){
        currentState.tick();
    }

    public static void renderCurrentState(Graphics g){
        currentState.render(g);
    }

    public static void setGame(Game newGame){
        game = newGame;
    }

    public static KeyManager getCurrentKeyManager(){
        return currentState.getKeyManager();
    }


}
