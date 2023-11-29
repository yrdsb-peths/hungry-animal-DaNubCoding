import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Game extends World
{
    private int score;
    private Label scoreLabel;
    private long appleTimer;
    private boolean ended = false;

    public Game()
    {
        super(600, 400, 1, false);
        this.setBackground("background.jpg");
        
        Elephant elephant = new Elephant(this);

        this.score = 0;
        this.scoreLabel = new Label(this, 30, 30, this.score, 50);
    }
    
    public void act() {
        if (System.currentTimeMillis() - this.appleTimer > 2000) {
            this.spawnApple();
            this.appleTimer = System.currentTimeMillis();
        }
    }
    
    public void increaseScore(int n) {
        this.score += n;
        this.scoreLabel.setText(this.score);
    }
    
    public void spawnApple() {
        if (this.ended) return;
        Apple apple = new Apple(this);
    }
    
    public void clearApples() {
        this.removeObjects(this.getObjects(Apple.class));
    }

    public void endGame() {
        this.ended = true;
        Label endLabel = new Label(this, getWidth() / 2, getHeight() / 2, "Game Over!", 100);
    }
}
