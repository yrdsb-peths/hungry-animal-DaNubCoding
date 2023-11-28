import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int score;
    public Label scoreLabel;
    private boolean ended = false;

    public MyWorld()
    {
        super(600, 400, 1, false);
        Main main = new Main();
        addObject(main, -100, -100);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);

        this.score = 0;
        scoreLabel = new Label(this.score, 50);
        addObject(this.scoreLabel, 30, 30);
    }
    
    public void spawnApple() {
        if (this.ended) return;
        Apple apple = new Apple();
        addObject(apple, Greenfoot.getRandomNumber(600), 0);
    }

    public void endGame() {
        this.ended = true;
        Label endLabel = new Label("Game Over!", 100);
        addObject(endLabel, getWidth() / 2, getHeight() / 2);
    }
}
