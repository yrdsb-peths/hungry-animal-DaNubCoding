import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Game extends World
{
    private int score;
    private int timeScore;
    private Label scoreLabel;
    private Label timeScoreLabel;
    private Timer survivalTimer;
    private Timer appleTimer;
    private boolean ended = false;
    private Timer endTimer;

    public Game()
    {
        super(600, 400, 1, false);
        this.setBackground("background.jpg");
        
        new Elephant(this);
        
        this.appleTimer = new Timer(2000);
        this.endTimer = new Timer(3000, true);
        this.survivalTimer = new Timer(1000);

        this.score = 0;
        this.scoreLabel = new Label(this, 30, 30, this.score, 50);
        
        this.timeScore = 0;
        this.timeScoreLabel = new Label(this, 80, 70, "Time: " + this.timeScore, 50);
    }
    
    public void act() {
        if (this.appleTimer.ended()) {
            this.spawnApple();
            this.appleTimer.restart();
        }
        
        if (this.survivalTimer.ended() && !this.ended){
            this.timeScore++;
            this.timeScoreLabel.setText("Time: " + this.timeScore);
            this.survivalTimer.restart();
        }
        
        if (this.endTimer.ended()) {
            Greenfoot.setWorld(new Menu());
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
        this.clearApples();
        Label endLabel = new Label(this, getWidth() / 2, getHeight() / 2, "Game Over!", 100);
        this.endTimer.start();
    }
}
