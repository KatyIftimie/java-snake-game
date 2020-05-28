package com.codecool.snake.entities.enemies;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.Shoot;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.geometry.Point2D;

import java.util.Random;


public class SimpleEnemy3 extends Enemy implements Animatable, Interactable {

    private Point2D heading;
    private static Random rnd = new Random();
    double direction = 90;
    int speed = 3;
    public SimpleEnemy3() {

        super(10);


        setImage(Globals.getInstance().getImage("CircleEnemy"));
        setX(810);
        setY(510);

    }

    @Override
    public void step() {
        setRotate(direction);
        heading = Utils.directionToVector(direction, speed);
        if (isOutOfBounds()) {
            destroy();
            new SimpleEnemy3();
        }
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
        direction += 1;
    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof SnakeHead){
            System.out.println(getMessage());
            destroy();
        }
        if(entity instanceof Shoot) {
            System.out.println(getMessage());
            destroy();
        }
    }

    @Override
    public String getMessage() {
        return (getDamage() + " damage");
    }
}
