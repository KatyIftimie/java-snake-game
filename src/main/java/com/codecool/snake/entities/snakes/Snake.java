package com.codecool.snake.entities.snakes;

import com.codecool.snake.DelayedModificationList;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.eventhandler.InputHandler;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;


public class Snake implements Animatable {
    private static float speed =2;
    private int health = 100;
    private  int id;
    private SnakeHead head;
    private DelayedModificationList<GameEntity> body;


    public Snake(Point2D position, int id) {
        switch (id){

            case 0: head = new SnakeHead(this, position, "SnakeHead" );
             break;
            case 1: head = new SnakeHead(this, position, "SnakeHead2" );
                break;
        }

        body = new DelayedModificationList<>();
        this.id = id;
        addPart(4);
    }
    public void changeSpeed(float number){
        speed += number;
    }
    public void step() {

        SnakeControl turnDir = getUserInput2();
        switch (id) {
            case 0:
            turnDir = getUserInput2();
            break;
            case 1:
                turnDir = getUserInput();
                break;

        }


        head.updateRotation(turnDir, speed);

        updateSnakeBodyHistory();
        checkForGameOverConditions();

        body.doPendingModifications();
    }
    public int getHealth(){
        return this.health;
    }

    public SnakeHead getHead() {
        return head;
    }

    public int addHealth(int number){
        if (health + number <= 100){
            return health += number;

        }
        else{
            return health = 100;
        }

    }
    private SnakeControl getUserInput() {
        SnakeControl turnDir = SnakeControl.INVALID;
        if(InputHandler.getInstance().isKeyPressed(KeyCode.LEFT)) turnDir = SnakeControl.TURN_LEFT;
        if(InputHandler.getInstance().isKeyPressed(KeyCode.RIGHT)) turnDir = SnakeControl.TURN_RIGHT;
        if(InputHandler.getInstance().isKeyReleased(KeyCode.SPACE)) turnDir = SnakeControl.SHOOT;
        return turnDir;
    }

    private SnakeControl getUserInput2() {
        SnakeControl turnDir = SnakeControl.INVALID;
        if(InputHandler.getInstance().isKeyPressed(KeyCode.A)) turnDir = SnakeControl.TURN_LEFT;
        if(InputHandler.getInstance().isKeyPressed(KeyCode.D)) turnDir = SnakeControl.TURN_RIGHT;
        if(InputHandler.getInstance().isKeyPressed(KeyCode.Q)) turnDir = SnakeControl.SHOOT;
        return turnDir;
    }

    public void addPart(int numParts) {
        GameEntity parent = getLastPart();
        Point2D position = parent.getPosition();

        for (int i = 0; i < numParts; i++) {
            SnakeBody newBodyPart = new SnakeBody(position, "0");
            switch (id){

                case 0:
                    newBodyPart = new SnakeBody(position, "SnakeBody");
                    body.add(newBodyPart);
                    break;
                case 1:
                    newBodyPart = new SnakeBody(position, "SnakeBody2");
                    body.add(newBodyPart);
                    break;

            }

        }
        Globals.getInstance().display.updateSnakeHeadDrawPosition(head);
    }

    public void changeHealth(int diff) {
        health += diff;
    }

    public void removeHealth(int number){
        health -= number;
    }
    private void checkForGameOverConditions() {
        if (head.isOutOfBounds() || health <= 0) {
            System.out.println("Game Over");
            Globals.getInstance().stopGame();
        }
    }

    private void updateSnakeBodyHistory() {
        GameEntity prev = head;
        for(GameEntity currentPart : body.getList()) {
            currentPart.setPosition(prev.getPosition());
            prev = currentPart;
        }
    }

    private GameEntity getLastPart() {
        GameEntity result = body.getLast();

        if(result != null) return result;
        return head;
    }

//    private get
}
