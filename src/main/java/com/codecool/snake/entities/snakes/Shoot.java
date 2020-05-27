package com.codecool.snake.entities.snakes;

import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.enemies.Enemy;
import javafx.geometry.Point2D;

public class Shoot extends GameEntity implements Animatable, Interactable {
    SnakeHead head;
    private Point2D desenat;
    public Shoot() {
        setImage(Globals.getInstance().getImage("Shoot"));

        setX(head.getX());
        setY(head.getY());

        double direction = head.getRotate();
        setRotate(direction);

        int speed = 1;
        desenat = Utils.directionToVector(direction, speed);

    }

    @Override
    public void step() {
        if (isOutOfBounds()) {
            destroy();}

    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof Enemy){
            System.out.println(getMessage());
            destroy();
        }
    }

    @Override
    public String getMessage() {
        return ("!!!!!!SHOOT");
    }
}

