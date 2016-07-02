package models.Snake;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by The Alex on 7/1/2016.
 */
public class Snake {
    /* Attributes */
    private ArrayList<Point> parts;
    private String direction;

    /* Constructor */
    public Snake() {
        parts =  new ArrayList<Point>();
        direction = "east";
        init();
    }

    /* Methods */
    private void init(){
        parts.add(new Point(1,1));
        parts.add(new Point(1,0));
        parts.add(new Point(0,0));
    }

    public void tick() {
        Point tempPoint = parts.get(0);
        Point newPoint = new Point(tempPoint.x , tempPoint.y);
        Point nextPoint;

        // Move the head
        tickHead();

        //Move the rest of the snake;
        for (int i = 1; i < parts.size(); i++) {
            tempPoint = parts.get(i);
            nextPoint = new Point(tempPoint.x , tempPoint.y);

            parts.set(i , newPoint);

            newPoint = nextPoint;
        }

    }

    private void tickHead() {
        Point tempPoint = parts.get(0);
        switch (direction) {
            case "east":
                tempPoint.x += 1;
                break;
            case "west":
                tempPoint.x -= 1;
                break;
            case "north":
                tempPoint.y -= 1;
                break;
            case "south":
                tempPoint.y += 1;
                break;
        }

        parts.set(0  , tempPoint);
    }


    public Point get(int index) {
        return parts.get(index);
    }

    public void setDirection(String direction) {
        switch(this.direction){
            case "north":
                if(!direction.equals("south")){
                    this.direction = direction;
                }
                break;
            case "south":
                if(!direction.equals("north")){
                    this.direction = direction;
                }
                break;
            case "east":
                if(!direction.equals("west")){
                    this.direction = direction;
                }
                break;
            case "west":
                if(!direction.equals("east")){
                    this.direction = direction;
                }
                break;
        }

    }

    public void addPart(){
        Point lastPart = parts.get(parts.size() - 1);
        Point secondToLastPart = parts.get(parts.size() - 2);

        lastPart.x += (lastPart.x - secondToLastPart.x);
        lastPart.y += (lastPart.y - secondToLastPart.y);

        parts.add(lastPart);

    }

    public boolean contains(Point point) {
        return parts.contains(point);
    }

    public int size(){
        return parts.size();
    }

    public void print(){
        Point tempPoint;
        for(int i = 0; i < parts.size(); i++){
            tempPoint = parts.get(i);
            System.out.println("Part "+ i + " : ( "+ tempPoint.x + " , " + tempPoint.y + ") ");
        }
    }

}