package input;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolverException;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by The Alex on 5/22/2016.
 */
public class KeyManager implements KeyListener {
    /* Attributes */
    protected boolean[] keys;
    public boolean north, south, east, west , TEST;

    /* Constructor */
    public KeyManager(){
        keys = new boolean[256];
    }
    /* Methods */
    public void keyPressed(KeyEvent e){
        keys[e.getKeyCode()] = true;
    }

    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }

    public void keyTyped(KeyEvent e){

    }

    public void tick(){
        north = keys[KeyEvent.VK_W];
        south = keys[KeyEvent.VK_S];
        east = keys[KeyEvent.VK_D];
        west = keys[KeyEvent.VK_A];
        TEST = keys[KeyEvent.VK_ENTER];
    }
}
