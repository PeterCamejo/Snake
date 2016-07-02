package main;

import input.KeyManager;
import models.States.GameStateManager;
import models.States.PlayState;

import views.Assets;
import views.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by The Alex on 5/31/2016.
 */
public class Game implements Runnable {
    /* Attributes */
    private Display display;
    int width , height;
    public String title;

    private Thread thread;
    private boolean running;

    private BufferStrategy bufferStrategy;
    private Graphics g;

    //States
    private PlayState initialState;

    /* Constructors */
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        running = false;
    }

    /* Methods */
    public void init(){
        GameStateManager.setGame(this);
        display = new Display(title , width , height);
        Assets.init();

        initialState = new PlayState();
        GameStateManager.setState(initialState);
    }

    private void tick(){
        if(GameStateManager.getState() != null){
            GameStateManager.tickCurrentState();
        }
    }

    private void render(){
        bufferStrategy = display.getCanvasBufferStrategy();
        if(bufferStrategy == null){
            display.createCanvasBufferStrategy(3);
            return;
        }

        g = bufferStrategy.getDrawGraphics();
        g.clearRect(0 , 0 , width , height);

        if(GameStateManager.getState() != null){
            GameStateManager.renderCurrentState(g);
        }

        bufferStrategy.show();
        g.dispose();



    }

    public void run(){
        init();

        int fps = 30;
        double timePerTick = 1000000000 / fps ; // 1sec / fps
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime)/ timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                //System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    };
    public synchronized void start(){
        if(running){
            return; //do nothing
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop(){
        if(!running){
            return; //do nothing
        }
        running = false;
        try{
            thread.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setKeyListener(KeyManager keyManager){
        display.addKeyListener(keyManager);
    }

    public void clearKeyListener(){
        display.removeKeyListener(GameStateManager.getCurrentKeyManager());
    }


}