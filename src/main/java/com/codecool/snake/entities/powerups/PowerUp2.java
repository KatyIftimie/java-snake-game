package com.codecool.snake.entities.powerups;

import com.codecool.snake.Utils;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import com.codecool.snake.entities.Animatable;
import javafx.geometry.Point2D;
import java.util.Random;


public class PowerUp2 extends GameEntity implements Interactable, Animatable {
    private static Random rnd = new Random();
    private Point2D heading;
    

    public PowerUp2() {
        setImage(Globals.getInstance().getImage("PowerUp2"));

        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);

        double direction =  360  ;
        setRotate(direction);

        int speed = 1;
        heading = Utils.directionToVector(direction, speed);

    }
    @Override
    public void step(){

        if (isOutOfBounds()) {
            destroy();
            new PowerUp2();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());

    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof SnakeHead){
            System.out.println(getMessage());
            destroy();
        }
    }

    @Override
    public String getMessage() {
        return "2 Got power-up 2 :)";
    }
}