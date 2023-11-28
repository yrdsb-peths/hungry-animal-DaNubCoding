import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int score;
    public Label scoreLabel;
    private long appleTimer;
    private boolean ended = false;

    public MyWorld()
    {
        super(600, 400, 1, false);
        Elephant elephant = new Elephant(this);

        this.score = 0;
        scoreLabel = new Label(this, 30, 30, this.score, 50);
    }
    
    public void act() {
        if (System.currentTimeMillis() - this.appleTimer > 2000) {
            this.spawnApple();
            this.appleTimer = System.currentTimeMillis();
        }
    }
    
    public void spawnApple() {
        if (this.ended) return;
        Apple apple = new Apple(this);
    }

    public void endGame() {
        this.ended = true;
        Label endLabel = new Label(this, getWidth() / 2, getHeight() / 2, "Game Over!", 100);
    }
}
