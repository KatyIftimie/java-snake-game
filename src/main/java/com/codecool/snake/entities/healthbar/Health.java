package com.codecool.snake.entities.healthbar;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.enemies.Enemy;
import com.codecool.snake.entities.snakes.SnakeHead;

import javafx.geometry.Rectangle2D;

import javax.swing.text.html.parser.Entity;


//public class Health extends Enemy {
//
//
//}
//    private Rectangle2D hBar;
//    public HealthBar() {
//        super(10);
//
//        setImage(Globals.getInstance().getImage("Health1"));
//        setX(10);
//        setY(10);
//    }
//
////    @Override
//    public void apply(GameEntity entity) {
//        if(entity instanceof SnakeHead){
//            System.out.println(getMessage());
//            System.out.println("trerea");
//        }
//    }
//
////    @Override
//    public String getMessage() {
//        return (getDamage() + " damage");
//    }

//}



//public class SimpleEnemy extends Enemy implements Animatable, Interactable {
//
//    private Point2D heading;
//    private static Random rnd = new Random();
//
//    public SimpleEnemy() {
//        super(10);
//
//        setImage(Globals.getInstance().getImage("SimpleEnemy"));
//        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
//        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
//
//        double direction = rnd.nextDouble() * 360;
//        setRotate(direction);
//
//        int speed = 1;
//        heading = Utils.directionToVector(direction, speed);
//    }
//
//    @Override
//    public void step() {
//        if (isOutOfBounds()) {
//            destroy();
//        }
//        setX(getX() + heading.getX());
//        setY(getY() + heading.getY());
//    }
//
//    @Override
//    public void apply(GameEntity entity) {
//        if(entity instanceof SnakeHead){
//            System.out.println(getMessage());
//            destroy();
//        }
//    }
//
//    @Override
//    public String getMessage() {
//        return (getDamage() + " damage");
//    }
//}
