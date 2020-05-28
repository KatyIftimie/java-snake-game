package com.codecool.snake;

import com.codecool.snake.resources.Resources;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

// class for holding all static stuff
public class Globals {
    private static Globals instance = null;

    public static final double WINDOW_WIDTH = 1000;
    public static final double WINDOW_HEIGHT = 700;

    public Display display;
    public Game game;

    private GameLoop gameLoop;
    private Resources resources;


    public static Globals getInstance() {
        if(instance == null) instance = new Globals();
        return instance;
    }

    public void setGameLoop(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public void setupResources() {
        resources = new Resources();
        resources.addImage("SnakeHead", new Image("snake_head.png"));
        resources.addImage("SnakeBody", new Image("snake_body.png"));
        resources.addImage("SnakeHead2", new Image("secondSnake_head.png"));
        resources.addImage("SnakeBody2", new Image("secondSsnake_body.png"));
        resources.addImage("SimpleEnemy", new Image("enemy_confuseAngryBird.png"));
        resources.addImage("PowerUpBerry", new Image("powerup_berry.png"));
        resources.addImage("PowerUp2", new Image("powerup_mario.png"));
        resources.addImage("PowerUp3", new Image("powerup_pokemon.png"));
        resources.addImage("AngryBird", new Image("angry_enemy.png"));
        resources.addImage("Health1", new Image("health-bar1.png"));
        resources.addImage("Shoot", new Image("projectile.png"));
    }

    public Image getImage(String name) { return resources.getImage(name); }

    public void startGame() { gameLoop.start(); }

    public void stopGame() { gameLoop.stop(); }

    private Globals() {
        // singleton needs the class to have private constructor
    }
}
