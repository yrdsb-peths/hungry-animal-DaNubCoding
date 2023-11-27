import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public int score;
    public Label scoreLabel;

    public MyWorld()
    {
        super(600, 400, 1, false);
        Main main = new Main();
        addObject(main, -100, -100);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);

        this.score = 0;
        scoreLabel = new Label(this.score, 50);
        this.scoreLabel.setText(this.score);
        addObject(this.scoreLabel, 30, 30);
    }
    
    public void spawnApple() {
        Apple apple = new Apple();
        addObject(apple, Greenfoot.getRandomNumber(600), 0);
    }
}
