package com.codecool.snake.entities.snakes;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.enemies.Enemy;
import com.codecool.snake.entities.enemies.SimpleEnemy2;
import com.codecool.snake.entities.powerups.PowerUp2;
import com.codecool.snake.entities.powerups.PowerUp3;
import com.codecool.snake.entities.powerups.SimplePowerUp;

import javafx.geometry.Point2D;


public class SnakeHead extends GameEntity implements Interactable {
    private static final float turnRate = 2;
    private Snake snake;

    public SnakeHead(Snake snake, Point2D position, String name) {
        this.snake = snake;
        setImage(Globals.getInstance().getImage(name));
        setPosition(position);
    }

    public void updateRotation(SnakeControl turnDirection, float speed) {
        double headRotation = getRotate();

        if (turnDirection.equals(SnakeControl.TURN_LEFT)) {
            headRotation = headRotation - turnRate;
        }
        if (turnDirection.equals(SnakeControl.TURN_RIGHT)) {
            headRotation = headRotation + turnRate;
        }

        // set rotation and position
        setRotate(headRotation);
        Point2D heading = Utils.directionToVector(headRotation, speed);
        setX(getX() + heading.getX());
        setY(getY() + heading.getY());
    }

    @Override
    public void apply(GameEntity entity) {
        if(entity instanceof Enemy){
            System.out.println(getMessage());
            snake.removeHealth(((Enemy) entity).getDamage());
            new SimpleEnemy2();
            System.out.println( "This is snake healt: " + snake.getHealth() );
        }
        if(entity instanceof SimplePowerUp){
            System.out.println(getMessage());
            snake.addPart(4);
            System.out.println( "This is snake healt: " + snake.getHealth() );
        }
        if(entity instanceof PowerUp2){
            System.out.println("Snake add new POWERUP2");
            snake.addPart(2);
            snake.changeSpeed(0.25f);
            System.out.println( "This is snake healt: " + snake.getHealth() );
        }
        if(entity instanceof PowerUp3){
            System.out.println("Snake add new POWERUP3");
            snake.addHealth(5);
            System.out.println( "This is snake healt: " + snake.getHealth() );
        }
    }

    @Override
    public String getMessage() {
        return "IMMA SNAEK HED! SPITTIN' MAH WENOM! SPITJU-SPITJU!";
    }
}
