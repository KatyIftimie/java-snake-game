package com.codecool.snake;

import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.enemies.SimpleEnemy2;
import com.codecool.snake.entities.powerups.PowerUp2;
import com.codecool.snake.entities.powerups.PowerUp3;
import com.codecool.snake.entities.powerups.SimplePowerUp;
import com.codecool.snake.entities.snakes.Snake;
import com.codecool.snake.eventhandler.InputHandler;

import javafx.geometry.Point2D;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;


public class Game extends Pane {
    private Snake  snake1;
    private Snake  snake2;
    private List <Snake> snakes = new ArrayList<>();
    private GameTimer gameTimer = new GameTimer();
    Rectangle healthBar = new Rectangle();


    public Game() {
        Globals.getInstance().game = this;
        Globals.getInstance().display = new Display(this);
        Globals.getInstance().setupResources();

        init();
    }


    public void handler() {

        Globals.getInstance().stopGame();
        Globals.getInstance().display.clear();
        snakes.clear();
        Globals.getInstance().game.init();
        Globals.getInstance().game.start();

    }


    public void init() {

        spawnSnake();
        spawnEnemies(5);
        spawnEnemies2(1);
        spawnPowerUps(1);
        spawnPowerUp2(3);
        spawnPowerUp3(3);
        GameLoop gameLoop = new GameLoop(snakes);

        Globals.getInstance().setGameLoop(gameLoop);

        gameTimer.setup(gameLoop::step);

        gameTimer.play();
        healthBar.setX(10);
        healthBar.setY(10);
        healthBar.setHeight(25);
        healthBar.setWidth(120);
        getChildren().add(healthBar);

    }


    public void start() {
        setupInputHandling();
        restartButton(Globals.getInstance().game);
        Globals.getInstance().startGame();
        System.out.println("Start");
    }

    private void spawnSnake() {
        snake1 = new Snake(new Point2D(400, 400), 0);
        snake2 = new Snake(new Point2D(500, 500), 1);
        snakes.add(snake1) ;
        snakes.add(snake2) ;

    }


    private void spawnEnemies(int numberOfEnemies) {
        for(int i = 0; i < numberOfEnemies; ++i) new SimpleEnemy();
    }
    private void spawnEnemies2(int numberOfEnemies) {
        for(int i = 0; i < numberOfEnemies; ++i) new SimpleEnemy2();
    }
    private void spawnPowerUps(int numberOfPowerUps) {
        for(int i = 0; i < numberOfPowerUps; ++i) new SimplePowerUp();
    }
    private void spawnPowerUp2(int numberOfPowerUps) {
        for(int i = 0; i < numberOfPowerUps; ++i) new PowerUp2();
    }
    private void spawnPowerUp3(int numberOfPowerUps) {
        for(int i = 0; i < numberOfPowerUps; ++i) new PowerUp3();
    }
    private void setupInputHandling() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> InputHandler.getInstance().setKeyPressed(event.getCode()));
        scene.setOnKeyReleased(event -> InputHandler.getInstance().setKeyReleased(event.getCode()));
    }

    public void restartButton(Game game) {
        Button restartButton = new Button("Restart");
        restartButton.setPrefSize(100, 20);
        restartButton.setLayoutX(880);
        restartButton.setLayoutY(660);
        game.getChildren().add(restartButton);

        restartButton.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                handler();
            }
        });
        game.requestFocus();

    }
}
