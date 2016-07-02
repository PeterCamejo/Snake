package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

/**
 * Made using resources from CodeNMore (https://www.youtube.com/channel/UCaM7SQvF5q9sz4NgL16PNRA)
 * as a guide.
 */
public class Display {

    private JFrame frame;
    private Canvas canvas;
    private String title;
    private int width, height;

    public Display(String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setVisible(true);
        frame.setSize(width , height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    };

    public Canvas getCanvas(){
        return canvas;
    }

    public BufferStrategy getCanvasBufferStrategy(){
        return canvas.getBufferStrategy();
    }

    public void createCanvasBufferStrategy(int numBuffers){
        canvas.createBufferStrategy(numBuffers);
        return;
    }

    public void addKeyListener(KeyListener keyListener){
        frame.addKeyListener(keyListener);
    }
    public void removeKeyListener(KeyListener keyListener){ frame.removeKeyListener(keyListener);}

}
