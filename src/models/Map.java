package models;

import models.Snake.Snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by The Alex on 6/13/2016.
 */
public class Map {
    /* Attributes */
    private Snake snake;
    private int size;
    private int tileSize;
    private boolean[][] tiles;
    private Point food;
    private int score;

    /* Constructors */
    public Map(){
        snake = new Snake();
        size = 50;
        tileSize = 10;
        tiles = new boolean[size][size];
        score = 0;


        init();
    }

    /* Methods */
    private void init(){
        for(int i = 0; i < size; i++){
            for(int j = 0 ; j < size ; j++){
                tiles[i][j] = false;
            }
        }

        newFood();
    }

    // Also prints the score.
    private void newFood(){
        int x  = (int)(Math.random() * size);
        int y  = (int)(Math.random() * size);
        System.out.println("Current Score : " + score);

        food = new Point(x , y);
    }

    public void tick(){
        snake.tick();

        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                if(snake.contains(new Point(i , j))){
                    tiles[i][j] = true;
                }else{
                    tiles[i][j] = false;
                }
            }
        }


        checkFoodCollision();
    }

    public void render(Graphics g){
        for(int i = 0 ; i < size; i++){
            for(int j = 0; j < size; j++){
                if(tiles[i][j]){
                    g.setColor(Color.BLUE);
                }else if(food.x == i && food.y == j){
                    g.setColor(Color.RED);
                }else{
                    g.setColor(Color.ORANGE);
                }

                g.fillRect(i * tileSize , j * tileSize , tileSize , tileSize);
            }
        }

    }

    private void checkFoodCollision(){
        Point head = snake.get(0);

        if(head.x == food.x && head.y == food.y){
            score++;
            newFood();
            addSnakePart();
        }
    }

    public boolean checkGameOver(){
        Point head = snake.get(0);

        //check out of bounds
        if(head.x < 0 || head.x >= size || head.y < 0 || head.y >= size){
            return true;
        }

        //check part collision
        Point temp;
        for(int i = 1 ; i < snake.size(); i++){
            temp = snake.get(i);
            if(temp.x == head.x && temp.y == head.y){
                return true;
            }
        }

        return false;
    }

    public void setSnakeDirection(String direction){
        snake.setDirection(direction);
    }

    //test
    public void addSnakePart(){
        snake.addPart();
    }



}
