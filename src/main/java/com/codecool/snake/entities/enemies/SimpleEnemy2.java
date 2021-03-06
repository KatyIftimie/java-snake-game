package com.codecool.snake.entities.enemies;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.Shoot;
import com.codecool.snake.entities.snakes.SnakeHead;
import java.util.Random;

import javafx.geometry.Point2D;



public class SimpleEnemy2 extends Enemy implements Animatable, Interactable {

    private Point2D heading;
    private static Random rnd = new Random();

    public SimpleEnemy2() {
        super(10);

        setImage(Globals.getInstance().getImage("AngryBird"));
        setX(1250);
        setY(10);
        double direction = 235;
        setRotate(direction);

        int speed = 5;
        heading = Utils.directionToVector(direction, speed);

    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();
            new SimpleEnemy2();
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
