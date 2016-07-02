package models.States;

import input.KeyManager;


import java.awt.*;

/**
 * Created by The Alex on 5/16/2016.
 */
public abstract class State {
    /* Attributes */

    /* Constructors */
    public State(){
    }

    /* Methods */
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract KeyManager getKeyManager();
}
