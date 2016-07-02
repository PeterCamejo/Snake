package main;

/**
 * Created by The Alex on 6/13/2016.
 */
public class Launcher {
    public static void main (String args[]){
        Game game = new Game("Snake" , 500 , 500);
        game.start();
        return;
    }
}